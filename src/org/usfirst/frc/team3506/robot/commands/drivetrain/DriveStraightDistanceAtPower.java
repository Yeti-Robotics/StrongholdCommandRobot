package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightDistanceAtPower extends Command{

	double power, distance, ticks;
	
	public DriveStraightDistanceAtPower(double power, double distance) {
		this.power = power;
		this.distance = distance;
	}
	
	protected void initialize() {
		Robot.driveTrain.resetEncoders();
		ticks = Robot.driveTrain.convertFeetToTicks(distance);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.driveStraight(power);
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getRawAvgEncoderPos() >= ticks;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
