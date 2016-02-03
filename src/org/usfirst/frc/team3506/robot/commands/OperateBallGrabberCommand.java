package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateBallGrabberCommand extends Command {

    public OperateBallGrabberCommand() {
        requires(Robot.ballGrabber);
    }
    
    protected void initialize() {}

    protected void execute() {
    	//Robot.rollerBar.moveRollerBar(Robot.oi.getShooterJoyY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
