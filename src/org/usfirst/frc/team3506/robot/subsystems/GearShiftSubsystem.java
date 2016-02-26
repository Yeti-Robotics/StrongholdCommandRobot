package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
    
	private DoubleSolenoid shifter;
	public GearShiftSubsystem(){
		shifter = new DoubleSolenoid(RobotMap.SOLENOID_PORTS[0], RobotMap.SOLENOID_PORTS[1]);
		shifter.set(Value.kOff);
	}
	
	public void shiftUp(){
		System.out.println("Forward");
		shifter.set(Value.kForward);
	}
	
	public void shiftDown(){
		System.out.println("Forward");
		shifter.set(Value.kReverse);
	}
	
	public Value shiftedState(){
		return shifter.get();
	}
	
    public void initDefaultCommand() {
    	
    }
}

