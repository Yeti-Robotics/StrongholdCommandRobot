package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterToEncoderPositionCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterUpToString;
import org.usfirst.frc.team3506.robot.commands.shooter.ResetShooterEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ToggleFlywheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ReadyToFireCommandGroup extends CommandGroup {
    
    public  ReadyToFireCommandGroup() {
     	addSequential(new ResetShooterEncoderCommand());
    	addSequential(new MoveShooterUpToString());
    	addParallel(new KeepShooterStaticCommand());
    }
}
