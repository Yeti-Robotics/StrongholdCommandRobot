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
    
	private CANTalon winch;
	private DigitalInput upperLimitSwitch;
	public boolean hold;
	private DoubleSolenoid brake;
	
	public ClimberSubsystem(){
		winch = new CANTalon(RobotMap.WINCH_TALON_ID);
		hold = false;
		brake = new DoubleSolenoid(RobotMap.CLIMBER_STOP_SOLENOID_PORTS[0], RobotMap.CLIMBER_STOP_SOLENOID_PORTS[1]);
		upperLimitSwitch = new DigitalInput(RobotMap.CLIMBER_UPPER_LIMIT_SWITCH_PORT);
	}
	
	public void activateBrake() {
		brake.set(Value.kForward);
	}
	
	public void releaseBrake() {
		brake.set(Value.kReverse);
	}
	
	public Value getBrakeState() {
		return brake.get();
	}
	
	public void climbUp(){
		this.winch.set(RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
	public void climbDown(){
		this.winch.set(-RobotMap.CLIMBER_SPEED_OPERATOR);
	}
	
	public void stopWinch(){
		this.winch.set(0);
	}
	
	public boolean getUpperLimit(){
		return this.upperLimitSwitch.get();
	}
	
    public void initDefaultCommand() {
    	
    }
}

