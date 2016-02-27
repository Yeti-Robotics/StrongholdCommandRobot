package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetShooterEncoderCommand extends Command {

    public ResetShooterEncoderCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.shooter.resetEncoder();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
