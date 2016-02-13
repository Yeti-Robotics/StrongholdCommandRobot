package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunTrainAtPowerCommand extends Command {
	private double power;
	private double seconds;
	private boolean left;
    public RunTrainAtPowerCommand(boolean left, double power, double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.power = power;
    	this.left = left;
    	this.seconds = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(left){
    		Robot.driveTrain.moveLeftTrain(this.power);
    	} else{
    		Robot.driveTrain.moveRightTrain(this.power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
