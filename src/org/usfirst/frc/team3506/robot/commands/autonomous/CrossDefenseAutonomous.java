package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossDefenseAutonomous extends CommandGroup {
    
    public  CrossDefenseAutonomous() {
    	addSequential(new ShiftUpCommand());
    	/*addSequential(new DriveStraightDistanceAtPower(.5, 10));
    	addSequential(new PointTurnDegreesAtPowerCommand(180, .5));
    	addSequential(new DriveStraightDistanceAtPower(.5, 9));*/
    	addSequential(new DriveStraightTimeAtPowerCommand(0.75, 6));
    }
}
