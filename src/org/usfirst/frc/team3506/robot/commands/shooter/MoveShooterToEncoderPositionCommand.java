package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveShooterToEncoderPositionCommand extends Command {

	private double desiredPosition;
	public final double THRESHOLD = 15;
	
    public MoveShooterToEncoderPositionCommand(double encoderPosition) {
        requires(Robot.shooter);
        this.desiredPosition = encoderPosition;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.shooter.getRawEncoderPos() < desiredPosition) {
    		Robot.shooter.liftTilt();
    	} else if (Robot.shooter.getRawEncoderPos() > desiredPosition) {
    		Robot.shooter.lowerTilt();
    	}
    }

    protected boolean isFinished() {
        return Math.abs(Robot.shooter.getRawEncoderPos() - desiredPosition) <= THRESHOLD;
    }

    protected void end() {
    	Robot.shooter.stopTalon();
    }

    protected void interrupted() {
    	Robot.shooter.stopTalon();
    }
}
