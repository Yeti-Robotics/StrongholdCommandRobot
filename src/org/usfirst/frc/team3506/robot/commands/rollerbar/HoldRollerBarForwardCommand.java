package org.usfirst.frc.team3506.robot.commands.rollerbar;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldRollerBarForwardCommand extends Command {

    public HoldRollerBarForwardCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.rollerBar.setRollerBarForward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.rollerBar.stopRollerBar();
    }

    protected void interrupted() {
    	Robot.rollerBar.stopRollerBar();
    }
}
