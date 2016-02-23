package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserTankDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon left1, left2, left3, right1, right2, right3;
	private RobotDrive robotDrive;
	private Encoder leftEnc, rightEnc;
	public static enum Talons {LEFT1, LEFT2, LEFT3, RIGHT1, RIGHT2, RIGHT3}
	public boolean isArmFront;
	public DriveTrainSubsystem() {
		left1 = new CANTalon(RobotMap.LEFT_1_CAN_TALON_ID);
		left2 = new CANTalon(RobotMap.LEFT_2_CAN_TALON_ID);
		left3 = new CANTalon(RobotMap.LEFT_3_CAN_TALON_ID);
		left1.changeControlMode(CANTalon.TalonControlMode.Follower);
		left3.changeControlMode(CANTalon.TalonControlMode.Follower);
		left1.set(RobotMap.LEFT_2_CAN_TALON_ID);
		left3.set(RobotMap.LEFT_2_CAN_TALON_ID);
		right1 = new CANTalon(RobotMap.RIGHT_1_CAN_TALON_ID);
		right2 = new CANTalon(RobotMap.RIGHT_2_CAN_TALON_ID);
		right3 = new CANTalon(RobotMap.RIGHT_3_CAN_TALON_ID);
		right2.changeControlMode(CANTalon.TalonControlMode.Follower);
		right3.changeControlMode(CANTalon.TalonControlMode.Follower);
		right2.set(RobotMap.RIGHT_1_CAN_TALON_ID);
		right3.set(RobotMap.RIGHT_1_CAN_TALON_ID);
		right3.setInverted(true);
		right2.setInverted(true);
		right1.setInverted(true);
		left1.setInverted(false);
		left2.setInverted(false);
		left3.setInverted(false);
		robotDrive = new RobotDrive(left2, right1);		
		left2.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftEnc = new Encoder(RobotMap.LEFT_ENCODER_PORT[0], RobotMap.LEFT_ENCODER_PORT[1]);
		rightEnc = new Encoder(RobotMap.RIGHT_ENCODER_PORT[0], RobotMap.RIGHT_ENCODER_PORT[1]);
		isArmFront = true;
		// ENCODER ATTACHMENT PORTS: RIGHT1 (5), LEFT2 (1) ----- CATAPULT AIM IS FRONT
	}
	
	public double getRawLeftEncoderPos(){
		return left2.getEncPosition();
	}
	
	public double getRawRightEncoderPos(){
		return right1.getEncPosition();
	}
	
	public double getRawAvgEncoderPos() {
		return (getRawLeftEncoderPos() + getRawRightEncoderPos())/2;
	}
	
	public double getRawLeftEncoderVel(){
		return /*left2.getEncVelocity();*/leftEnc.getRate();
	}
	
	public double getRawRightEncoderVel(){
		return /*right1.getEncVelocity();*/rightEnc.getRate();
	}
	
	public void tankDrive(double left, double right){
		robotDrive.tankDrive(left, right);
	}
	
	public void driveTalon(){
		switch((Talons)Robot.testDriveTalonChooser.getSelected()){
			case LEFT1:
				left1.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
			case LEFT2:
				left2.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
			case LEFT3:
				left3.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
			case RIGHT1:
				right1.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
			case RIGHT2:
				right2.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
			case RIGHT3:
				right3.set(RobotMap.AUTO_DRIVE_SPEED);
				break;
		}
	}
	
	public void driveStraight(double speed){
		moveLeftTrain(speed);
		moveRightTrain(speed);
	}

	public void moveLeftTrain(double speed){
		left2.set(speed);
	}
	
	public void moveRightTrain(double speed){
		right1.set(speed);
	}
	
	public void resetEncoders(){
		leftEnc.reset();
		rightEnc.reset();
	}
	
	public double convertToRadians(double degrees){
		return 2*Math.PI*(degrees/360.0);
	}
	
	public double convertFeetToTicks(double feet) {
		return feet * RobotMap.DRIVE_TRAIN_ENCODER_TO_FEET_MODIFIER;
	}
	
	public double convertTrainVelocityToPower(double velocity){
		return 0.0;
	}
	
	public void publishEncoderValues(){
		SmartDashboard.putNumber("Left drive encoder position (raw)", getRawLeftEncoderPos());
		SmartDashboard.putNumber("Left drive encoder velocity (raw)", getRawLeftEncoderVel());
		SmartDashboard.putNumber("Right drive encoder positon (raw)", getRawRightEncoderPos());
		SmartDashboard.putNumber("Right drive encoder velocity (raw)", getRawRightEncoderVel());
	}
	
	public void addToLW(){
		LiveWindow.addSensor("Drive train", "Left Encoder", left2);
		LiveWindow.addSensor("Drive train", "Right Encoder", right1);
		LiveWindow.addActuator("Drive train", "left side 1", left1);
		LiveWindow.addActuator("Drive train", "left side 2", left2);
		LiveWindow.addActuator("Drive train", "left side 3", left3);
		LiveWindow.addActuator("Drive train", "right side 1", right1);
		LiveWindow.addActuator("Drive train", "right side 2", right2);
		LiveWindow.addActuator("Drive train", "right side 3", right3);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UserTankDriveCommand());
    }
}

