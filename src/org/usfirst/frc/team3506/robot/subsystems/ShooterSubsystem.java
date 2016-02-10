package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.shooter.UserOperateShooterCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon shooterTilt;
	private Relay spikeShooterLeft, spikeShooterRight;
	//private Encoder tiltEncoder;
	private DigitalInput lowerLimitSwitch;
	private boolean calibrated;
	
	public ShooterSubsystem(){
		this.shooterTilt = new CANTalon(RobotMap.SHOOTER_TILT_CAN_TALON_ID);
		this.spikeShooterLeft = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_LEFT);
		this.spikeShooterRight = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_RIGHT);
		/*this.tiltEncoder = new Encoder(RobotMap.SHOOTER_TILT_ENCODER_PORTS[0], RobotMap.SHOOTER_TILT_ENCODER_PORTS[1]);
		this.tiltEncoder.setDistancePerPulse(RobotMap.ENCODER_DEGREES_PER_PULSE);*/
		this.lowerLimitSwitch = new DigitalInput(RobotMap.SHOOTER_LOWER_LIMIT_SWITCH_PORT);
		this.calibrated = false;
	}
	
	public void lowerTilt(){
		while(!this.lowerLimitSwitch.get()){
			this.shooterTilt.set(-RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
		}
	}
	
	/*public void calibrateShooterTilt(){
		this.lowerTilt();
		this.tiltEncoder.reset();
		this.calibrated = true;
	}*/
	
	/*public void setDegreeValueofTilt(double degrees){
		if(this.tiltEncoder.getDistance()>degrees){
			while(this.tiltEncoder.getDistance()>degrees){
				this.shooterTilt.set(-RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
			}
		} else{
			while(this.tiltEncoder.getDistance()<degrees){
				this.shooterTilt.set(RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
			}
		}
	}*/
	
	public void activateFlywheels(){
		this.spikeShooterLeft.set(Value.kForward);
		this.spikeShooterRight.set(Value.kForward);
	}

	public void deactivateFlywheels(){
		this.spikeShooterLeft.set(Value.kOff);
		this.spikeShooterLeft.set(Value.kOff);
	}
	
	/*public double getCurrentDegreeTilt(){
		return this.tiltEncoder.getDistance();
	}*/
	
	public boolean getLowerLimitSwitchState(){
		return this.lowerLimitSwitch.get();
	}
	
	public boolean getCalibratedState(){
		return this.calibrated;
	}
	
	public void userControl(double val){
		this.shooterTilt.set(val);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UserOperateShooterCommand());
    }
}

