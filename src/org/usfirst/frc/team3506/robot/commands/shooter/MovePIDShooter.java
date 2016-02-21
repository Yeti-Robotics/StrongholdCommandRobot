package org.usfirst.frc.team3506.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MovePIDShooter extends Command {
	double setpoint;
    public MovePIDShooter(double setpoint) {
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.shooter.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return /*Math.abs(Robot.shooter.getPosition() - Robot.shooter.getSetpoint()) < 0.1;*/ true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
