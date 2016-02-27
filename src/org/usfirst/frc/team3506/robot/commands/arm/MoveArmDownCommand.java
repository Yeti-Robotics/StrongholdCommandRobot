package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmDownCommand extends Command {

    public MoveArmDownCommand() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
		Robot.arm.moveBallGrabberDown();
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
