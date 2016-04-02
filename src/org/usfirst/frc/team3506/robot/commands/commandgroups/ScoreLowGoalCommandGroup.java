package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.autonomous.CrossDefenseAutonomous;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarForwardCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreLowGoalCommandGroup extends CommandGroup {
    
    public  ScoreLowGoalCommandGroup(Robot.AutoModes mode) {
    	addSequential(new CrossDefenseAutonomous());
    	switch(mode){
    		case POS1:
    			addSequential(new PointTurnTimeAtPowerCommand(1, 0.5));
    			break;
    		case POS2:
    			addSequential(new PointTurnTimeAtPowerCommand(0.7, 0.5));
    			break;
    		case POS3:
    			addSequential(new PointTurnTimeAtPowerCommand(0.7, -0.5));
    			break;
    		case POS4:
    			addSequential(new PointTurnTimeAtPowerCommand(1, -0.5));
    			break;
    	}
    	addParallel(new MoveArmTimeAtPowerCommand(1.5, 0.2));
    	addSequential(new DriveStraightTimeAtPowerCommand(0.35, 1.5));
    	addSequential(new HoldRollerBarForwardCommand(), 2);
    }
}
