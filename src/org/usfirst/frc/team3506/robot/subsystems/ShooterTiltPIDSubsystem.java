package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ShooterTiltPIDSubsystem extends PIDSubsystem {
	
	private CANTalon shooterTilt;
    
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ShooterTiltPIDSubsystem(){
		super("Shooter tilt", RobotMap.SHOOTER_P, RobotMap.SHOOTER_I, RobotMap.SHOOTER_D);
		shooterTilt = new CANTalon(RobotMap.SHOOTER_TILT_CAN_TALON_ID);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	protected double returnPIDInput() {
		return convertRawEncoderPositiontoDegrees();
	}

	protected void usePIDOutput(double output) {
		shooterTilt.pidWrite(output);
	}
	
	private double convertRawEncoderPositiontoDegrees(){
		return shooterTilt.getPosition() * RobotMap.SHOOTER_ENCODER_RAW_TO_DEGREES_MODIFIER;
	}
	
	public void addToLW(){
	}
}

