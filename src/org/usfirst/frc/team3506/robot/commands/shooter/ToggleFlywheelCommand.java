package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleFlywheelCommand extends Command {

    public ToggleFlywheelCommand() {
    	requires(Robot.flywheels);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.flywheels.isActive = !Robot.flywheels.isActive;
    	if(Robot.flywheels.isActive){
    		Robot.flywheels.activateFlywheels();
    	} else{
    		Robot.flywheels.deactivateFlywheels();
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
