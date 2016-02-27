package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightTimeAtPowerCommand extends Command {

	double power, time;
    public DriveStraightTimeAtPowerCommand(double power, double time) {
    	requires(Robot.driveTrain);
    	this.power = power;
    	this.time = time;
    }

    protected void initialize() {
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.driveTrain.driveStraight(power);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.driveTrain.driveStraight(0);
    }

    protected void interrupted() {
    	
    }
}
