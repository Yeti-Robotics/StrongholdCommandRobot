package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepFlywheelsHeldCommand extends Command {

    public KeepFlywheelsHeldCommand() {
    	requires(Robot.flywheels);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	/*Robot.flywheels.isActive = !Robot.flywheels.isActive;
    	if(Robot.flywheels.isActive){
    		Robot.flywheels.activateFlywheels();
    	} else{
    		Robot.flywheels.deactivateFlywheels();
    	}*/
    	Robot.flywheels.activateFlywheels();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	interrupted();
    }

    protected void interrupted() {
    	Robot.flywheels.deactivateFlywheels();
    }
}
