package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.UserOperateClimberCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon winch;
	
	public ClimberSubsystem(){
		winch = new CANTalon(RobotMap.WINCH_TALON_ID);
	}
	
	public void moveWinchForward(){
		this.winch.set(RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
	public void moveWinchBackwards(){
		this.winch.set(-RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UserOperateClimberCommand());
    }
}

