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

    // Called just before this Command runs the first time
    protected void initialize() {
    	angleToEncoder = Robot.shooter.degreeToEncoder(angle);
    	distance = angleToEncoder - Robot.shooter.getRawEncoderPos();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (distance > 0) {
    		Robot.shooter.liftTilt();
    	} else if (distance < 0) {
    		Robot.shooter.lowerTilt();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.shooter.getRawEncoderPos() == angleToEncoder);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopTalon();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
}
