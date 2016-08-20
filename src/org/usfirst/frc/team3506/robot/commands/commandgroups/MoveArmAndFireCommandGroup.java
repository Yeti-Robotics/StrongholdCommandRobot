package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.arm.MoveArmToShootCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnFlywheelAtSpeedCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveArmAndFireCommandGroup extends CommandGroup {
    
    public  MoveArmAndFireCommandGroup() {
    	addParallel(new TurnFlywheelAtSpeedCommand());
    	addParallel(new MoveArmToShootCommand());
    }
}
