package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserTankDriveCommand extends Command {

    public UserTankDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!(Boolean)Robot.gamepadChooser.getSelected()){
    		if(!Robot.driveTrain.isArmFront){
    			Robot.driveTrain.tankDrive(RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getLeftY(), -RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getRightY());
    		} else{
    			Robot.driveTrain.tankDrive(-RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getRightY(), RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getLeftY());
    		}
    	} else{
    		if(Robot.driveTrain.isArmFront){
    			Robot.driveTrain.tankDrive(-RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getGamepadRightY(), -RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getGamepadLeftY());
    		} else{
    			Robot.driveTrain.tankDrive(RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getGamepadLeftY(), RobotMap.USER_SPEED_CONTROL_MODIFIER*Robot.oi.getGamepadRightY());
    		}
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
