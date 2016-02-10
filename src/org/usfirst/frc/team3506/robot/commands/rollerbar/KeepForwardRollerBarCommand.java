package org.usfirst.frc.team3506.robot.commands.rollerbar;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepForwardRollerBarCommand extends Command {

    public KeepForwardRollerBarCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {
    	Robot.rollerBar.driveRollerBar();
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
