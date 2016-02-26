package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopArmCommand extends Command {

    public StopArmCommand() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.arm.moveBallGrabber(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
