package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunTrainAtPowerCommand extends Command {
	private double power;
	private boolean left;
    public RunTrainAtPowerCommand(boolean left, double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.power = power;
    	this.left = left;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
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
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.moveLeftTrain(0);
    	Robot.driveTrain.moveRightTrain(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.moveLeftTrain(0);
    	Robot.driveTrain.moveRightTrain(0);
    }
}
