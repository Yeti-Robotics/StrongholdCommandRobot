package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveShooterUpToString extends Command{

	@Override
	protected void initialize() {
		setTimeout(3);
	}

	@Override
	protected void execute() {
		Robot.shooter.liftTilt();
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}
    
}
