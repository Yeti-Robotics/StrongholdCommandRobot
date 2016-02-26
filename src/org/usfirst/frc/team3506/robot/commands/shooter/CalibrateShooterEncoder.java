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

    protected void initialize() {
    }

    protected void execute() {
    	Robot.shooter.lowerTilt();
    }

    protected boolean isFinished() {
        return Robot.shooter.getLowerLimitSwitchState();
    }

    protected void end() {
    	Robot.shooter.resetEncoder();
    	Robot.shooter.stopTalon();
    }

    protected void interrupted() {
    	
    }
}
