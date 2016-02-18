package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GearShiftTestCommandGroup extends CommandGroup {
    
    public  GearShiftTestCommandGroup() {
        addParallel(new DriveStraightCommand(0.5, 3));
        addSequential(new ShiftUpCommand());
        addSequential(new WaitCommand(2));
        addParallel(new DriveStraightCommand(0.5, 3));
        addSequential(new ShiftDownCommand());
    }
}
