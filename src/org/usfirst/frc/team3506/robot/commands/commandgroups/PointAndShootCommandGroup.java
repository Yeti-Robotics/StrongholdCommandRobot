package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterToDegreeCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ToggleFlywheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PointAndShootCommandGroup extends CommandGroup {
    
    public  PointAndShootCommandGroup() {
    	addSequential(new PointTurnDegreesAtPowerCommand(Robot.shooter.getAzimuth(), RobotMap.AZIMUTH_TURN_SPEED));
    	addSequential(new MoveShooterToDegreeCommand(Robot.shooter.calculateFiringAngle()));
    	addSequential(new ToggleFlywheelCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ServoMoveUpCommand());
    	addSequential(new ServoMoveDownCommand());
    	addSequential(new ToggleFlywheelCommand());
    }
}
