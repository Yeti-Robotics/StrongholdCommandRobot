package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmToShootCommand extends Command {

    public MoveArmToShootCommand() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
		Robot.arm.moveBallGrabberUp();
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	Robot.arm.moveBallGrabber(0);
    }

    protected void interrupted() {
    	Robot.arm.moveBallGrabber(0);
    }
}
