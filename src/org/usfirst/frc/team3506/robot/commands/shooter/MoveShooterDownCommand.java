package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class MoveShooterDownCommand extends Command {

    public MoveShooterDownCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.shooter.getLowerLimitSwitchState()) {
			Robot.shooter.lowerTilt();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.getLowerLimitSwitchState();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Scheduler.getInstance().add(new KeepShooterStaticCommand());
    }
}
