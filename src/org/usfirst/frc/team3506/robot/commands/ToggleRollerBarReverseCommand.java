package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleRollerBarReverseCommand extends Command {

    public ToggleRollerBarReverseCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {}

    protected void execute() {
    	if(Robot.rollerBar.rollerBar.get() == Relay.Value.kReverse) {
    		Robot.rollerBar.stopRollerBar();
    	} else {
    		Robot.rollerBar.reverseRollerBar();
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
