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
	private Servo servo;
	private double position;
	
	public ServoSubsystem(){
		servo = new Servo(0);
		position = 0;
	}
	
	public void moveServoDown(){
		if(position>=0){
			position-=0.05;
		}
		servo.set(position);
	}
	
	public void moveServoUp(){
		if(position<=1){
			position+=0.05;
		}
		servo.set(position);
	}
	
	public void stopServo(){
		//servo.setRaw(0);
	}
	
	
	public void publishGetServo(){
		SmartDashboard.putNumber("Servo position", servo.get());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

