package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserOperateArmCommand extends Command {

    public UserOperateArmCommand() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
//    	if (!Robot.arm.getUpperLimit()) {
			Robot.arm.moveBallGrabber(Robot.oi.getGamepadLeftY());
//		} else if (Robot.oi.getGamepadLeftY() > 0) {
//			Robot.arm.moveBallGrabber(Robot.oi.getGamepadLeftY());
//		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
