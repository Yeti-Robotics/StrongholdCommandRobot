package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.DeactivateShooterCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ToggleFlywheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ManualFireCommandGroup extends CommandGroup {
    
    public  ManualFireCommandGroup() {
    	addParallel(new KeepShooterStaticCommand());
    	addSequential(new ToggleFlywheelCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ServoMoveUpCommand());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new ServoMoveDownCommand());
    	addSequential(new ToggleFlywheelCommand());
    	addSequential(new DeactivateShooterCommand());
    }
}
