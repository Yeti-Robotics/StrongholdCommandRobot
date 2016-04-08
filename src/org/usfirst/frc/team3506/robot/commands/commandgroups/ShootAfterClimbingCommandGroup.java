package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.climber.ActivateBrakeCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterToEncoderPositionCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ResetShooterEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepFlywheelsHeldCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShootAfterClimbingCommandGroup extends CommandGroup {
    
    public  ShootAfterClimbingCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ActivateBrakeCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ResetShooterEncoderCommand());
    	addSequential(new MoveShooterToEncoderPositionCommand(380));
    	addParallel(new KeepShooterStaticCommand());
    	addParallel(new KeepFlywheelsHeldCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ServoMoveUpCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new ServoMoveDownCommand());
    	addSequential(new KeepFlywheelsHeldCommand());
    }
}
