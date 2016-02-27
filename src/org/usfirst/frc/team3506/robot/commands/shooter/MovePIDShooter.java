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

    protected void initialize() {
    	//Robot.shooter.setSetpoint(setpoint);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return /*Math.abs(Robot.shooter.getPosition() - Robot.shooter.getSetpoint()) < 0.1;*/ true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
