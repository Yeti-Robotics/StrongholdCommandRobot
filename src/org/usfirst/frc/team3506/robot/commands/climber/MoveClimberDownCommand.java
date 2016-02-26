package org.usfirst.frc.team3506.robot.commands.climber;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveClimberDownCommand extends Command {

    public MoveClimberDownCommand() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
		Robot.climber.climbDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.stopWinch();
    }

    protected void interrupted() {
    	Robot.climber.stopWinch();
    }
}
