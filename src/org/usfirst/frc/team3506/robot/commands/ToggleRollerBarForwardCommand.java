package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleRollerBarForwardCommand extends Command {

    public ToggleRollerBarForwardCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {}

    protected void execute() {
    	if(Robot.rollerBar.rollerBar.get() == Relay.Value.kForward) {
    		Robot.rollerBar.stopRollerBar();
    	} else {
    		Robot.rollerBar.driveRollerBar();
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}