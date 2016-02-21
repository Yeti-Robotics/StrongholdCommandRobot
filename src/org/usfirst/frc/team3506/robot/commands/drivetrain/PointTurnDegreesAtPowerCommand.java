package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PointTurnDegreesAtPowerCommand extends Command {
	private double degrees, power, distance, ticks;
    public PointTurnDegreesAtPowerCommand(double degrees, double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.degrees = degrees;
    	this.power = power;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    	distance = (this.degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI);
    	ticks = Robot.driveTrain.convertFeetToTicks(distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(ticks > 0){
    		Robot.driveTrain.moveLeftTrain(power);
    		Robot.driveTrain.moveRightTrain(-power);
    	} else if(ticks < 0){
    		Robot.driveTrain.moveLeftTrain(-power);
    		Robot.driveTrain.moveRightTrain(power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.driveTrain.getRawLeftEncoderPos() - ticks) <= 10;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
