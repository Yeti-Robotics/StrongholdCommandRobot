package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateShooterEncoder extends Command {

    public CalibrateShooterEncoder() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*Robot.shooter.resetEncoders();*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.lowerTilt();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.getLowerLimitSwitchState();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.resetEncoder();
    	Robot.shooter.stopTalon();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
