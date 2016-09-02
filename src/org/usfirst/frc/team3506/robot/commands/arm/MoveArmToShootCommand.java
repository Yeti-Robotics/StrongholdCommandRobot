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
		Robot.arm.moveBallGrabberToShoot();
    }

    protected boolean isFinished() {
    	return Robot.arm.getUpperLimit();
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
