package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoSubsystem extends Subsystem {
    
	private Servo servo1;
	
	public ServoSubsystem(){
		servo1 = new Servo(0);
	}
	
	public void moveServoDown(){
		servo1.set(1);
	}
	
	public void moveServoUp(){
		servo1.set(.5);
	}
	
	public void publishGetServo(){
		SmartDashboard.putNumber("Servo position", servo1.get());
	}
	
    public void initDefaultCommand() {
    	
    }
}

