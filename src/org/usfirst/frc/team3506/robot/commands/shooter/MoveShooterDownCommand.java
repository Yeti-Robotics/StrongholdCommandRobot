package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class MoveShooterDownCommand extends Command {

    public MoveShooterDownCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (!Robot.shooter.getLowerLimitSwitchState()) {
			Robot.shooter.lowerTilt();
		}
    }

    protected boolean isFinished() {
        return Robot.shooter.getLowerLimitSwitchState();
    }

    protected void end() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }

    protected void interrupted() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }
}
