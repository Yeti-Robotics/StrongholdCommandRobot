package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftDownCommand extends Command {

    public ShiftDownCommand() {
    	requires(Robot.gearShift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearShift.shiftDown();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
