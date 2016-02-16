package org.usfirst.frc.team3506.robot.commands.rollerbar;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ToggleRollerBarReverseCommand extends Command {

    public ToggleRollerBarReverseCommand() {
    	requires(Robot.rollerBar);
    }

    protected void initialize() {}

    protected void execute() {
    	if(!Robot.oi.rollersOn){
			Robot.oi.rollersOn = true;
		} else if(!Robot.oi.rollersForward && Robot.oi.rollersOn){
			Robot.oi.rollersOn = false;
		} else if(Robot.oi.rollersForward && Robot.oi.rollersOn){
			Robot.oi.rollersForward = false;
		}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Scheduler.getInstance().add(new UserOperateRollerBarCommand());
    }

    protected void interrupted() {
    	Scheduler.getInstance().add(new UserOperateRollerBarCommand());
    }
}
