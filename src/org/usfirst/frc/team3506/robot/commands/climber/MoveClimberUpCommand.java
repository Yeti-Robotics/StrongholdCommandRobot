package org.usfirst.frc.team3506.robot.commands.climber;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveClimberUpCommand extends Command {

    public MoveClimberUpCommand() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
		if (Robot.climber.getBrakeState() != Value.kForward) {
			Robot.climber.climbUp();
		}
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
