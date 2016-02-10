package org.usfirst.frc.team3506.robot.retroreflectivedetection;

public class Contour {
	
	public static enum Param {CENTERX, CENTERY, WIDTH, AREA, HEIGHT, SOLIDITY}
	private double[] params;
	
	public Contour(double centerX, double centerY, double width, double area, double height, double solidity){
		params = new double[6];
		params[0] = centerX;
		params[1] = centerY;
		params[2] = width;
		params[3] = area;
		params[4] = height;
		params[5] = solidity;
	}
	
	public double getParam(Param param){
		return params[paramToIndex(param)];
	}
	
	private int paramToIndex(Param param){
		switch(param){
		case CENTERX:
			return 0;
		case CENTERY:
			return 1;
		case WIDTH:
			return 2;
		case AREA:
			return 3;
		case HEIGHT:
			return 4;
		case SOLIDITY:
			return 5;
		default:
			return 0;
		}
	}
}
