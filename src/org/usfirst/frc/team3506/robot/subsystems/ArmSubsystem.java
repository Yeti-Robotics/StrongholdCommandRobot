package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.arm.UserOperateArmCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	private CANTalon ballGrabber;
	private DigitalInput lowerLimit;
	private DigitalInput upperLimit;
	
	public ArmSubsystem() {
		ballGrabber = new CANTalon(RobotMap.BALL_GRABBER_CAN_TALON_ID);
		lowerLimit = new DigitalInput(RobotMap.ARM_LOWER_LIMIT_SWITCH_PORT);
		upperLimit = new DigitalInput(RobotMap.ARM_UPPER_LIMIT_SWITCH_PORT);
	}

	public void moveBallGrabber(double speed) {
		ballGrabber.set(speed);
	}
	
	public void moveBallGrabberUp(){
		ballGrabber.set(RobotMap.ARM_SPEED_OPERATOR);
	}
	
	public void moveBallGrabberDown(){
		ballGrabber.set(-RobotMap.ARM_SPEED_OPERATOR);
	}
	
	public boolean getLowerLimit(){
		return this.lowerLimit.get();
	}
	
	public boolean getUpperLimit(){
		return this.upperLimit.get();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new UserOperateArmCommand());
	}
	
}

