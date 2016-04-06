package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.arm.MoveArmTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarBreacherCommandGroup extends CommandGroup {
    
    public  LowBarBreacherCommandGroup() {
    	addSequential(new ShiftUpCommand());
        addSequential(new MoveArmTimeAtPowerCommand(0.4, 0.75));
        addSequential(new MoveArmTimeAtPowerCommand(0.2, -0.25));
        addSequential(new DriveStraightTimeAtPowerCommand(0.5, 4));
        addSequential(new MoveArmTimeAtPowerCommand(0.4, -0.75)); // Bring arm up
    }
}
