package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveShooterToDegreeCommand extends Command {

	private double angle;
	private double angleToEncoder;
	private double distance;
	
    public MoveShooterToDegreeCommand(double angle) {
        requires(Robot.shooter);
        this.angle = angle;
    }

    protected void initialize() {
    	angleToEncoder = Robot.shooter.degreeToEncoder(angle);
    	distance = angleToEncoder - Robot.shooter.getRawEncoderPos();
    }

    protected void execute() {
    	if (distance > 0) {
    		Robot.shooter.liftTilt();
    	} else if (distance < 0) {
    		Robot.shooter.lowerTilt();
    	}
    }

    protected boolean isFinished() {
        return (Robot.shooter.getRawEncoderPos() == angleToEncoder);
    }

    protected void end() {
    	Robot.shooter.stopTalon();
    }

    protected void interrupted() {
    	
    }
}
