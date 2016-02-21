package org.usfirst.frc.team3506.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Servo servo1, servo2;
	private double position;
	
	public ServoSubsystem(){
		servo1 = new Servo(0);
		servo2 = new Servo(1);
	
		position = 0;
	}
	
	public void moveServoDown(){
		if(position>=0){
			position-=0.2;
		}
		servo1.set(1);
		servo2.set(0);
	}
	
	public void moveServoUp(){
		if(position<=1){
			position+=0.2;
		}
		servo1.set(.5);
		servo2.set(.5);
	}
	
	public void stopServo(){
		//servo.setRaw(0);
	}
	
	
	public void publishGetServo(){
		SmartDashboard.putNumber("Servo position", servo1.get());
		SmartDashboard.putNumber("Servo 2 position", servo2.get());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

