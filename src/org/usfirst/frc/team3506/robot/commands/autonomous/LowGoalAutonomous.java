package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowGoalAutonomous extends CommandGroup {
    
    public  LowGoalAutonomous() {
    	//Drive to low goal
    	addSequential(new DriveStraightDistanceAtPower(RobotMap.AUTO_DRIVE_SPEED, 0));
    	addSequential(new PointTurnDegreesAtPowerCommand(90, RobotMap.AUTO_DRIVE_SPEED));
    	addSequential(new DriveStraightDistanceAtPower(RobotMap.AUTO_DRIVE_SPEED, 0));
    	addSequential(new PointTurnDegreesAtPowerCommand(45, RobotMap.AUTO_DRIVE_SPEED));
    	addSequential(new DriveStraightDistanceAtPower(RobotMap.AUTO_DRIVE_SPEED, 0));
    	addSequential(new PointTurnDegreesAtPowerCommand(45, RobotMap.AUTO_DRIVE_SPEED));
    	//Score ball
    	
    }
}
