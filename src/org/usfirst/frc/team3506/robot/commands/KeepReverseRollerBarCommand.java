package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepReverseRollerBarCommand extends Command {

    public KeepReverseRollerBarCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {
    	Robot.rollerBar.reverseRollerBar();
    }

    protected void execute() {}
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	Robot.rollerBar.stopRollerBar();
    }
    
    protected void interrupted() {
    	end();
    }
}
