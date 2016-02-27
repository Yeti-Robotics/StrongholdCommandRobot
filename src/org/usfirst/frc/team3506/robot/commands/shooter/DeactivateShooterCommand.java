package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeactivateShooterCommand extends Command {

    public DeactivateShooterCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.shooter.stopTalon();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
