package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem.Front;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRobotFrontCommand extends Command {

    public ToggleRobotFrontCommand() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.driveTrain.getFront() == Front.ARM) {
    		Robot.driveTrain.setFront(Front.SHOOTER);
    	} else {
    		Robot.driveTrain.setFront(Front.ARM);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
