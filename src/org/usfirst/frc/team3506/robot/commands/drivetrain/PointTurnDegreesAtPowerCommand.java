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
    	this.degrees = degrees;
    	this.power = power;
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    	distance = (this.degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI);
    	ticks = Robot.driveTrain.convertFeetToTicks(distance);
    }

    protected void execute() {
    	if(ticks > 0){
    		Robot.driveTrain.moveLeftTrain(power);
    		Robot.driveTrain.moveRightTrain(-power);
    	} else if(ticks < 0){
    		Robot.driveTrain.moveLeftTrain(-power);
    		Robot.driveTrain.moveRightTrain(power);
    	}
    }

    protected boolean isFinished() {
    	return Math.abs(Robot.driveTrain.getRawLeftEncoderPos() - ticks) <= 10;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
