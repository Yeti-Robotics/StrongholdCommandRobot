package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class MoveShooterUpCommand extends Command {

    public MoveShooterUpCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.shooter.liftTilt();
    }

    protected boolean isFinished() {
        return Robot.shooter.getUpperLimitSwitch();
    }

    protected void end() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }

    protected void interrupted() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }
}
