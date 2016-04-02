package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmTimeAtPowerCommand extends Command {

	private double time, power;
	
    public MoveArmTimeAtPowerCommand(double time, double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    	this.power = power;
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.moveBallGrabber(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stopBallGrabber();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
