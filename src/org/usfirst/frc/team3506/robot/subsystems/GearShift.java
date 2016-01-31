package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid leftSolenoid, rightSolenoid;
	
	public GearShift(){
		leftSolenoid = new Solenoid(RobotMap.SOLENOID_PORTS[0]);
		rightSolenoid = new Solenoid(RobotMap.SOLENOID_PORTS[1]);
	}
	
	public void shiftUp(){
		leftSolenoid.set(RobotMap.SHIFT_UP);
		rightSolenoid.set(RobotMap.SHIFT_UP);
	}
	
	public void shiftDown(){
		leftSolenoid.set(RobotMap.SHIFT_DOWN);
		rightSolenoid.set(RobotMap.SHIFT_DOWN);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

