package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateArmCommand extends Command {

    public CalibrateArmCommand() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.arm.moveBallGrabberUp();
    }

    protected boolean isFinished() {
        return Robot.arm.getUpperLimit();
    }

    protected void end() {
    	Robot.arm.moveBallGrabber(0);
    	Robot.arm.resetEncoder();
    }

    protected void interrupted() {
    	
    }
}
