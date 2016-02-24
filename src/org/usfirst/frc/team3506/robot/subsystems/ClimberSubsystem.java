package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	public boolean hold;
	private DoubleSolenoid brake;
	
	public ClimberSubsystem(){
		winch = new CANTalon(RobotMap.WINCH_TALON_ID);
		hold = false;
		brake = new DoubleSolenoid(RobotMap.CLIMBER_STOP_SOLENOID_PORTS[0], RobotMap.CLIMBER_STOP_SOLENOID_PORTS[1]);
//		upperLimitSwitch = new DigitalInput(RobotMap.CLIMBER_UPPER_LIMIT_SWITCH_PORT);
//		lowerLimitSwitch = new DigitalInput(RobotMap.CLIMBER_LOWER_LIMIT_SWITCH_PORT);
	}
	
	public void brake() {
		brake.set(Value.kForward);
	}
	
	public void releaseBrake() {
		brake.set(Value.kReverse);
	}
	
	public Value getBrakeState() {
		return brake.get();
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
	
	public void holdWinch() {
		this.winch.set(RobotMap.CLIMBER_HOLD_VOLTAGE);
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

