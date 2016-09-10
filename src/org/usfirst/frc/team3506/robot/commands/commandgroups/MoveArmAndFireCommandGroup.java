package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.arm.MoveArmToShootCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnFlywheelAtSpeedCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnOffFlywheelsCommand;
import org.usfirst.frc.team3506.robot.subsystems.FlywheelSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveArmAndFireCommandGroup extends CommandGroup {
    
    public  MoveArmAndFireCommandGroup() {
    	addParallel(new TurnFlywheelAtSpeedCommand());
    	addSequential(new MoveArmToShootCommand());
    	addSequential(new TurnOffFlywheelsCommand());
    }
}
