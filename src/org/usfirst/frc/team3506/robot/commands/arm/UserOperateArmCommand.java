package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserOperateArmCommand extends Command {

    public UserOperateArmCommand() {
        requires(Robot.ballGrabber);
    }
    
    protected void initialize() {}

    protected void execute() {
    	if(Robot.oi.gamepad.getRawButton(7)){
    		Robot.ballGrabber.moveBallGrabber(-RobotMap.ARM_SPEED_OPERATOR);
    	} else if(Robot.oi.gamepad.getRawButton(8)){
    		Robot.ballGrabber.moveBallGrabber(RobotMap.ARM_SPEED_OPERATOR);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
