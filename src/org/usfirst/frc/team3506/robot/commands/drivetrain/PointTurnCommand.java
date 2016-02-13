package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PointTurnCommand extends Command {
	private double turnDistance;
	private double initialPosition;
    public PointTurnCommand(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	turnDistance = Robot.driveTrain.getTotalTurnDistance(degrees);
    	initialPosition = RobotMap.convertEncFeedbackToDriveDistance(Robot.driveTrain.getRawLeftEncoderPos());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(turnDistance > 0){
    		Robot.driveTrain.moveLeftTrain(RobotMap.AUTO_DRIVE_SPEED);
    		Robot.driveTrain.moveRightTrain(-RobotMap.AUTO_DRIVE_SPEED);
    	} else{
    		Robot.driveTrain.moveLeftTrain(-RobotMap.AUTO_DRIVE_SPEED);
    		Robot.driveTrain.moveRightTrain(RobotMap.AUTO_DRIVE_SPEED);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(turnDistance > 0){
        	return !(RobotMap.convertEncFeedbackToDriveDistance(Robot.driveTrain.getRawLeftEncoderPos()) < turnDistance);
        } else{
        	return !(RobotMap.convertEncFeedbackToDriveDistance(Robot.driveTrain.getRawLeftEncoderPos()) > turnDistance);
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
