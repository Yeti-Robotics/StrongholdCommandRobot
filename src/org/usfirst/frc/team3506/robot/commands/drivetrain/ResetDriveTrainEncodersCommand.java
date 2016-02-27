package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class ResetDriveTrainEncodersCommand extends Command {

    public ResetDriveTrainEncodersCommand() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.resetEncoders();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Scheduler.getInstance().add(new UserTankDriveCommand());
    }

    protected void interrupted() {
    	Scheduler.getInstance().add(new UserTankDriveCommand());
    }
}
