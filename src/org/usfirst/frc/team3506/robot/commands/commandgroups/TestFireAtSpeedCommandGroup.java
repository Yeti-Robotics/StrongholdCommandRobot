package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.PublishShooterDistanceAzimuthCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnFlywheelAtSpeedCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnOffFlywheelsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TestFireAtSpeedCommandGroup extends CommandGroup {
    
    public  TestFireAtSpeedCommandGroup() {
    	addSequential(new TurnFlywheelAtSpeedCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new PublishShooterDistanceAzimuthCommand());
    	addSequential(new TurnOffFlywheelsCommand());
    }
}
