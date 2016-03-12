package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveShooterToEncoderPositionCommand extends Command {

	private double encoderPosition;
	private double finalPosition;
	public final double THRESHOLD = 5;
	
    public MoveShooterToEncoderPositionCommand(double encoderPosition) {
        requires(Robot.shooter);
        this.encoderPosition = encoderPosition;
    }

    protected void initialize() {
    	finalPosition = Robot.shooter.getRawEncoderPos() + encoderPosition;
    }

    protected void execute() {
    	if (Robot.shooter.getRawEncoderPos() < finalPosition) {
    		Robot.shooter.liftTilt();
    	} else if (Robot.shooter.getRawEncoderPos() > finalPosition) {
    		Robot.shooter.lowerTilt();
    	}
    }

    protected boolean isFinished() {
        return Math.abs(Robot.shooter.getRawEncoderPos() - finalPosition) <= THRESHOLD;
    }

    protected void end() {
    	Robot.shooter.stopTalon();
    }

    protected void interrupted() {
    	Robot.shooter.stopTalon();
    }
}
