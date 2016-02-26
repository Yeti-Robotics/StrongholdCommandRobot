package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoSubsystem extends Subsystem {
    
	private Servo servo1, servo2;
	
	public ServoSubsystem(){
		servo1 = new Servo(0);
		servo2 = new Servo(1);
	}
	
	public void moveServoDown(){
		servo1.set(1);
		servo2.set(0);
	}
	
	public void moveServoUp(){
		servo1.set(.5);
		servo2.set(.5);
	}
	
	public void publishGetServo(){
		SmartDashboard.putNumber("Servo position", servo1.get());
		SmartDashboard.putNumber("Servo 2 position", servo2.get());
	}
	
    public void initDefaultCommand() {
    	
    }
}

