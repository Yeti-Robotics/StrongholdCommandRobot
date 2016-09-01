package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.arm.UserOperateArmCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	private CANTalon ballGrabber;
	private DigitalInput upperLimit;
	
	public ArmSubsystem() {
		ballGrabber = new CANTalon(RobotMap.BALL_GRABBER_CAN_TALON_ID);
		upperLimit = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH_PORT);
		ballGrabber.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	}
	
	public double getRawEncoderPos(){
		return ballGrabber.getPosition();
	}
	
	public double getRawEncoderVel(){
		return ballGrabber.getEncVelocity();
	}

	public void moveBallGrabber(double speed) {
		ballGrabber.set(-speed);
	}
	
	public void stopBallGrabber() {
		ballGrabber.set(0);
	}
	
	public void moveBallGrabberUp(){
		if (!getUpperLimit()) {
			ballGrabber.set(RobotMap.ARM_SPEED_OPERATOR);
		}
	}
	
	public void moveBallGrabberDown(){
		ballGrabber.set(-RobotMap.ARM_SPEED_OPERATOR);
	}
	
	public void moveBallGrabberToShoot() {
		ballGrabber.set(RobotMap.ARM_SHOOT_SPEED_OPERATOR);
	}
	
	public boolean getUpperLimit(){
		return this.upperLimit.get();
	}
	
	public void publishEncoderValues(){
		SmartDashboard.putNumber("Arm encoder position (raw)", getRawEncoderPos());
		SmartDashboard.putNumber("Arm encoder velocity (raw)", getRawEncoderVel());
		SmartDashboard.putBoolean("Arm upper limit", getUpperLimit());
	}
	
	public void addToLW(){
		LiveWindow.addActuator("Ball Grabber", "Ball Grabber", ballGrabber);
	}
	
	public void resetEncoder(){
		ballGrabber.setPosition(0);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new UserOperateArmCommand());
	}
}

