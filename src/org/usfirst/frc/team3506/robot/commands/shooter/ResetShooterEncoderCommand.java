package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetShooterEncoderCommand extends Command {

    public ResetShooterEncoderCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	SmartDashboard.putBoolean("Working", false);
    	Robot.shooter.resetEncoder();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
