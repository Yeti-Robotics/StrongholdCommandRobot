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
	private Compressor compressor;
	public GearShiftSubsystem(){
		shifter = new DoubleSolenoid(RobotMap.SOLENOID_PORTS[0], RobotMap.SOLENOID_PORTS[1]);
		compressor = new Compressor(50);
		compressor.start();
	}
	
	public void shiftUp(){
		shifter.set(Value.kForward);
	}
	
	public void shiftDown(){
		shifter.set(Value.kReverse);
	}
	
	public Value shiftedState(){
		return shifter.get();
	}
	
	public void publishShiftStatus(){
		SmartDashboard.putData("Shift state", shifter);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

