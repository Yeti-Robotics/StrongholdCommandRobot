package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnFlywheelAtSpeedCommand extends Command {
	private double flywheelSpeed;

    public TurnFlywheelAtSpeedCommand() {
        requires(Robot.flywheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	flywheelSpeed = SmartDashboard.getNumber("flywheel-speed", 0.6d);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flywheels.setFlywheelSpeed(flywheelSpeed);
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
    	Robot.flywheels.deactivateFlywheels();
    }
}
