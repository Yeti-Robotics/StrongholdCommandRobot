package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.arm.MoveArmTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevalDeFriseBreacherCommandGroup extends CommandGroup {
    
    public  ChevalDeFriseBreacherCommandGroup() {
    	addSequential(new ShiftUpCommand());
    	addSequential(new DriveStraightTimeAtPowerCommand(0.75, 0.8)); //power, time
    	addSequential(new MoveArmTimeAtPowerCommand(0.6, 0.75));
        //addSequential(new MoveArmTimeAtPowerCommand(0.2, -0.25));
    	addParallel(new MoveArmTimeAtPowerCommand(0.75, 0.1));
        addSequential(new DriveStraightTimeAtPowerCommand(0.5, 0.75)); //power, time
        addParallel(new MoveArmTimeAtPowerCommand(0.3, -.75));
        addSequential(new DriveStraightTimeAtPowerCommand(0.5, 3.25));
        addSequential(new MoveArmTimeAtPowerCommand(0.2, -0.75)); // Bring arm up
    }
}
