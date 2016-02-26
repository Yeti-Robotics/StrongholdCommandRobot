package org.usfirst.frc.team3506.robot.commands.servo;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoMoveDownCommand extends Command {

    public ServoMoveDownCommand() {
    	requires(Robot.servo);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.servo.moveServoDown();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
