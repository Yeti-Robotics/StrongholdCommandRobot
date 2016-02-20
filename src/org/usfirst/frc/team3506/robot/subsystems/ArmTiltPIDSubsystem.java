package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmTiltPIDSubsystem extends PIDSubsystem {
    
	private CANTalon ballGrabber;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ArmTiltPIDSubsystem(){
		super("Arm tilt", RobotMap.ARM_P, RobotMap.ARM_I, RobotMap.ARM_D);
		ballGrabber = new CANTalon(RobotMap.BALL_GRABBER_CAN_TALON_ID);
		ballGrabber.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	}

    public void initDefaultCommand() {}

	protected double returnPIDInput() {
		return getEncoderPositionDegrees();
	}

	protected void usePIDOutput(double output) {
		ballGrabber.pidWrite(output);
	}
	
	private double getEncoderPositionDegrees(){
		return ballGrabber.getEncPosition() * RobotMap.ARM_ENCODER_RAW_TO_DEGREES_MODIFIER;
	}

	public void publishEncoderValues(){
		SmartDashboard.putNumber("Arm encoder position (raw)", ballGrabber.getEncPosition());
		SmartDashboard.putNumber("Arm encoder velocity (raw)", ballGrabber.getEncVelocity());
	}
	
	public void resetEncoderValues() {
		ballGrabber.setPosition(0);
	}
	
}

