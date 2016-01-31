package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon left1, left2, left3, right1, right2, right3;
	private Encoder leftEncoder, rightEncoder;
	
	public DriveTrain() {
		left1 = new CANTalon(RobotMap.LEFT_1_CAN_TALON_ID);
		left2 = new CANTalon(RobotMap.LEFT_2_CAN_TALON_ID);
		left3 = new CANTalon(RobotMap.LEFT_3_CAN_TALON_ID);
		right1 = new CANTalon(RobotMap.RIGHT_1_CAN_TALON_ID);
		right2 = new CANTalon(RobotMap.RIGHT_2_CAN_TALON_ID);
		right3 = new CANTalon(RobotMap.RIGHT_3_CAN_TALON_ID);
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_PORTS[0], RobotMap.LEFT_ENCODER_PORTS[1]);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_PORTS[0], RobotMap.RIGHT_ENCODER_PORTS[1]);
		leftEncoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
	}
	
	public void joystickDrive(double left, double right){
		moveLeftTrain(left);
		moveRightTrain(right);
	}
	
	public void driveStraight(double speed){
		moveLeftTrain(speed);
		moveRightTrain(speed);
	}

	public void moveLeftTrain(double speed){
		left1.set(speed);
		left2.set(speed);
		left3.set(speed);
	}
	
	public void moveRightTrain(double speed){
		right1.set(speed);
		right2.set(speed);
		right3.set(speed);
	}
	
	public void resetEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public Encoder getLeftEncoder(){
		return leftEncoder;
	}
	
	public Encoder getRightEncoder(){
		return rightEncoder;
	}
	
	public double getLeftEncoderDistance(){
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoderDistance(){
		return rightEncoder.getDistance();
	}
	
	public double getLeftEncoderRate(){
		return leftEncoder.getRate();
	}
	
	public double getRightEncoderRate(){
		return rightEncoder.getRate();
	}
	
	public double getTotalTurnDistance(double degrees){
		double rad = convertToRadians(degrees);
		return rad*(RobotMap.ROBOT_WHEEL_DIAMETER_FT)/2.0;
	}
	
	public double convertToRadians(double degrees){
		return 2*Math.PI*(degrees/360.0);
	}
	
	public void logEncoder(){
		SmartDashboard.putData("Left Encoder", leftEncoder);
		SmartDashboard.putData("Right Encoder", rightEncoder);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UserDriveCommand());
    }
}

