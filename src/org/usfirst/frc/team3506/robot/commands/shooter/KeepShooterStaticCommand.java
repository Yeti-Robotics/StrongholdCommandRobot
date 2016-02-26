package org.usfirst.frc.team3506.robot.commands.shooter;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepShooterStaticCommand extends Command {
	
    public KeepShooterStaticCommand() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.shooter.userControl(RobotMap.STATIC_SHOOTER_POWER);
    }

    protected boolean isFinished() {
        return (Robot.shooter.getRawEncoderPos() >= RobotMap.STATIC_SHOOTER_POWER);
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
