package org.usfirst.frc.team3506.robot.processor;

import java.util.ArrayList;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.processor.Contour.Param;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Processor {
	static CircularFifoQueue<ArrayList<Contour>> frameQueue;
	static NetworkTable table;
	private static final String TABLE_ADDRESS = "GRIP/RetroreflectiveContourReport";
	private static final int CIRCULAR_FIFO_QUEUE_SIZE = 60;
	private static final double[] DEFAULT_VALUE_ARRAY = {0};
	private static final String CAPTURE_MODE_ID = "RetroreflectiveCaptureMode";
	private static final long WAIT_PERIOD_MILLIS = 100;
	private static final String DISTANCE_ID = "Distance";
	private static final String AZIMUTH_ID = "Azimuth";
	static final double IMAGE_WIDTH = 1280;
	static final double HORIZONTAL_FOV = 66*Math.cos(Math.atan(9.0 / 16.0));
	static final double VERTICAL_FOV = 66*Math.sin(Math.atan(9.0 / 16.0));
	static final double GOAL_CENTER_HEIGHT = 97;
	static final double FOCAL_LENGTH = 125;
	static final double TARGET_WIDTH = 20;
	static final double TARGET_HEIGHT = 14;
	static double distance, angle, azimuth;
	
	public static void run(String[] args) {
		table = NetworkTable.getTable(TABLE_ADDRESS);
		frameQueue = new CircularFifoQueue<ArrayList<Contour>>(CIRCULAR_FIFO_QUEUE_SIZE);
		while(!Robot.captureMode){
			runStandbyLoop();
		}
	}
	
	public static void runStandbyLoop() {
		frameQueue.clear();
		while(Robot.captureMode){
			if(/*!frameQueue.isAtFullCapacity()*/ true){
				frameQueue.add(readCurrentContourReport());
				try {
					Thread.sleep(WAIT_PERIOD_MILLIS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Contour findDesignatedContour() {
		Contour designatedContour = new Contour(0, 0, 0, 0, 0, 0);
		for(int i = 0; i < frameQueue.get(CIRCULAR_FIFO_QUEUE_SIZE - 1).size(); i ++){
			if(i == 0){
				designatedContour = frameQueue.get(CIRCULAR_FIFO_QUEUE_SIZE - 1).get(i);
			} else{
				if(frameQueue.get(CIRCULAR_FIFO_QUEUE_SIZE - 1).get(i).getParam(Param.AREA) > designatedContour.getParam(Param.AREA)){
					designatedContour = frameQueue.get(CIRCULAR_FIFO_QUEUE_SIZE - 1).get(i);
				}
			}
		}
		return designatedContour;
	}
	
	public static void publishDistanceAzimuth() {
		double centerX, apparentWidth;
		Contour obj = findDesignatedContour();
		if(obj.getParam(Param.AREA) == 0){
			SmartDashboard.putNumber(DISTANCE_ID, -1);
			SmartDashboard.putNumber(AZIMUTH_ID, 361);
			return;
		}
		centerX = obj.getParam(Param.WIDTH);
		apparentWidth = obj.getParam(Param.WIDTH);
    	distance = (TARGET_WIDTH * FOCAL_LENGTH) / apparentWidth;
    	distance = distance * Math.cos(Math.asin(GOAL_CENTER_HEIGHT / distance));
		azimuth = ((centerX * HORIZONTAL_FOV) / IMAGE_WIDTH) - (.5 * HORIZONTAL_FOV);
		SmartDashboard.putNumber(DISTANCE_ID, distance);
		SmartDashboard.putNumber(AZIMUTH_ID, azimuth);
	}
	
	public static ArrayList<Contour> readCurrentContourReport() {
		ArrayList<Contour> contours = new ArrayList<Contour>();
		for(int i = 0; i < table.getNumberArray("", DEFAULT_VALUE_ARRAY).length; i ++){
			contours.add(new Contour(table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i], table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i], table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i], table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i], table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i], table.getNumberArray("", DEFAULT_VALUE_ARRAY)[i]));
		}
		return contours;
	}
}
