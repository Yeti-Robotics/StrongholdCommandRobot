package org.usfirst.frc.team3506.robot.commands.servo;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoMoveUpCommand extends Command {

    public ServoMoveUpCommand() {
    	requires(Robot.servo);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.servo.moveServoUp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
