package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearShiftCommand extends Command {

    public ToggleGearShiftCommand() {
    	requires(Robot.gearShift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.gearShift.shiftedState() == Value.kForward) {
    		Robot.gearShift.shiftDown();
    	} else {
    		Robot.gearShift.shiftUp();
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
