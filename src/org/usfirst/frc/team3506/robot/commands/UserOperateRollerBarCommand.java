package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserOperateRollerBarCommand extends Command {

    public UserOperateRollerBarCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rollerBar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.gamepad.getRawButton(2)){
    		if(!Robot.oi.rollersOn){
    			Robot.oi.rollersOn = true;
    		} else if(!Robot.oi.rollersForward && Robot.oi.rollersOn){
    			Robot.oi.rollersOn = false;
    		} else if(Robot.oi.rollersForward && Robot.oi.rollersOn){
    			Robot.oi.rollersForward = false;
    		}
    	} else if(Robot.oi.gamepad.getRawButton(4)){
    		if(!Robot.oi.rollersOn){
    			Robot.oi.rollersOn = true;
    		} else if(Robot.oi.rollersForward && Robot.oi.rollersOn){
    			Robot.oi.rollersOn = false;
    		} else if(!Robot.oi.rollersForward && Robot.oi.rollersOn){
    			Robot.oi.rollersForward = true;
    		}
    	}
    	if(Robot.oi.rollersOn){
    		if(Robot.oi.rollersForward){
    			Robot.rollerBar.driveRollerBar();
    		} else{
    			Robot.rollerBar.reverseRollerBar();
    		}
    	} else{
    		Robot.rollerBar.stopRollerBar();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
