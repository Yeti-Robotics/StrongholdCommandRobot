package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon winch;
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	
	public ClimberSubsystem(){
		winch = new CANTalon(RobotMap.WINCH_TALON_ID);
		upperLimitSwitch = new DigitalInput(RobotMap.CLIMBER_UPPER_LIMIT_SWITCH_PORT);
		lowerLimitSwitch = new DigitalInput(RobotMap.CLIMBER_LOWER_LIMIT_SWITCH_PORT);
	}
	
	public void moveWinchForward(){
		this.winch.set(RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
	public void moveWinchBackwards(){
		this.winch.set(-RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
	public void stopWinch(){
		this.winch.set(0);
	}
	
	public boolean getUpperLimit(){
		return this.upperLimitSwitch.get();
	}
	
	public boolean getLowerLimit(){
		return this.lowerLimitSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

