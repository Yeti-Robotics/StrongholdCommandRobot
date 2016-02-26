package org.usfirst.frc.team3506.robot.commands.vision;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleCaptureModeCommand extends Command {

    public ToggleCaptureModeCommand() {
    	
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.captureMode = !Robot.captureMode;
    	SmartDashboard.putBoolean(RobotMap.CAPTURE_MODE_ID, Robot.captureMode);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
