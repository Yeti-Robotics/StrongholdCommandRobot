package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterToEncoderPositionCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.TurnOnFlywheelsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PointAndShootCommandGroup extends CommandGroup {
    
    public  PointAndShootCommandGroup() {
    	addSequential(new PointTurnDegreesAtPowerCommand(Robot.shooter.getAzimuth(), RobotMap.AZIMUTH_TURN_SPEED));
    	addSequential(new MoveShooterToEncoderPositionCommand(Robot.shooter.calculateFiringAngle()));
    	addSequential(new TurnOnFlywheelsCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ServoMoveUpCommand());
    	addSequential(new ServoMoveDownCommand());
    	addSequential(new TurnOnFlywheelsCommand());
    }
}
