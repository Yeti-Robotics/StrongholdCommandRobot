package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
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
	
	public void publishShiftStatus(){
//		SmartDashboard.putData("Shift state", shifter);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

