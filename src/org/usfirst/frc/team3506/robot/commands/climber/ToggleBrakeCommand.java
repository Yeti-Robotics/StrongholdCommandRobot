package org.usfirst.frc.team3506.robot.commands.climber;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleBrakeCommand extends Command {

    public ToggleBrakeCommand() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (Robot.climber.getBrakeState() == Value.kForward) {
    		Robot.climber.releaseBrake();
    	} else {
    		Robot.climber.activateBrake();
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
