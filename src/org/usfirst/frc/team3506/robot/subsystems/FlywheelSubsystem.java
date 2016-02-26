package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlywheelSubsystem extends Subsystem {
	private Relay spikeShooterLeft, spikeShooterRight;
	public boolean isActive;
	
	public FlywheelSubsystem(){
		this.spikeShooterLeft = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_LEFT);
		this.spikeShooterRight = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_RIGHT);
		isActive = false;
	}
	
	public void activateFlywheels(){
		this.spikeShooterLeft.set(Value.kForward);
		this.spikeShooterRight.set(Value.kReverse);
	}

	public void deactivateFlywheels(){
		this.spikeShooterLeft.set(Value.kOff);
		this.spikeShooterRight.set(Value.kOff);
	}
	
	public void reverseFlywheeels(){
		this.spikeShooterLeft.set(Value.kReverse);
		this.spikeShooterRight.set(Value.kForward);
	}

    public void initDefaultCommand() {
    	
    }
}

