package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterToEncoderPositionCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ResetShooterEncoderCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveShooterToPositionAndFireCommandGroup extends CommandGroup {
    
    public MoveShooterToPositionAndFireCommandGroup() {
     	addSequential(new ResetShooterEncoderCommand());
    	addSequential(new MoveShooterToEncoderPositionCommand(500));
    	addSequential(new ManualFireCommandGroup());
    	addSequential(new MoveShooterToEncoderPositionCommand(0));
    }
}
