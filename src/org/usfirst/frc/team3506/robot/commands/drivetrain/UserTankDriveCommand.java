package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem.Front;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserTankDriveCommand extends Command {

    public UserTankDriveCommand() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
		if (Robot.driveTrain.getFront() == Front.SHOOTER) {
			Robot.driveTrain.tankDrive(RobotMap.USER_SPEED_CONTROL_MODIFIER * Robot.oi.getLeftY(),
					-RobotMap.USER_SPEED_CONTROL_MODIFIER * Robot.oi.getRightY());
		} else {
			Robot.driveTrain.tankDrive(-RobotMap.USER_SPEED_CONTROL_MODIFIER * Robot.oi.getRightY(),
					RobotMap.USER_SPEED_CONTROL_MODIFIER * Robot.oi.getLeftY());
		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
