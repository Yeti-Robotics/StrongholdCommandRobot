package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepShooterStaticCommand extends Command {
	
	private double setPosition;
	private double power;
	
    public KeepShooterStaticCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPosition = Robot.shooter.getRawEncoderPos();
    	power = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.getRawEncoderPos() < setPosition - 10){
    		power += 0.02;
    		Robot.shooter.userControl(power);
    	} else if(Robot.shooter.getRawEncoderPos() > setPosition + 10){
    		power -= 0.02;
    		Robot.shooter.userControl(power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
