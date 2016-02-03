package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.OperateBallGrabberCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGrabber extends Subsystem {
	private CANTalon ballGrabber;
	
	public BallGrabber() {
		ballGrabber = new CANTalon(RobotMap.BALL_GRABBER_CAN_TALON_ID);
	}

	public void moveBallGrabber(double speed) {
		ballGrabber.set(speed);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new OperateBallGrabberCommand());
	}
	
}

