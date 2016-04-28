package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlywheelSubsystem extends Subsystem {
	private CANTalon shooterFlywheelLeft;
	private Talon shooterFlywheelRight;
	public boolean isActive;
	
	public FlywheelSubsystem(){
		shooterFlywheelLeft = new CANTalon(RobotMap.CAN_TALON_SHOOTER_PORT_LEFT);
		shooterFlywheelRight = new Talon(RobotMap.PWM_TALON_SHOOTER_PORT_RIGHT);
		isActive = false;
	}
	
	public void activateFlywheels(){
		shooterFlywheelLeft.set(1);
		shooterFlywheelRight.set(-1);
	}

	public void deactivateFlywheels(){
		shooterFlywheelLeft.set(0);;
		shooterFlywheelRight.set(0);
	}
	
	public void reverseFlywheeels(){
		shooterFlywheelLeft.set(1);
		shooterFlywheelRight.set(-1);
	}

    public void initDefaultCommand() {
    	
    }
}

