package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon shooterTilt;
	private Relay spikeShooterLeft, spikeShooterRight;
	private DigitalInput lowerLimitSwitch;
	private double currentDegreePosition;
	
	public ShooterSubsystem(){
		this.shooterTilt = new CANTalon(RobotMap.SHOOTER_TILT_CAN_TALON_ID);
		this.spikeShooterLeft = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_LEFT);
		this.spikeShooterRight = new Relay(RobotMap.SPIKE_SHOOTER_RELAY_PORT_RIGHT);
		this.lowerLimitSwitch = new DigitalInput(RobotMap.SHOOTER_LOWER_LIMIT_SWITCH_PORT);
		this.shooterTilt.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	}
	
	public void lowerTilt(){
		this.shooterTilt.set(RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
	}
	
	public void liftTilt(){
		this.shooterTilt.set(-RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
	}
	
	public void stopTalon(){
		this.shooterTilt.set(0);
	}
	
	public double getRawEncoderPos(){
		return this.shooterTilt.getEncPosition();
	}
	
	public double getRawEncoderVel(){
		return this.shooterTilt.getEncVelocity();
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
	
	public boolean getLowerLimitSwitchState(){
		return this.lowerLimitSwitch.get();
	}
	
	public void userControl(double val){
		this.shooterTilt.set(val);
	}
	public void publishEncoderValues(){
		SmartDashboard.putNumber("Shooter encoder position (raw)", getRawEncoderPos());
		SmartDashboard.putNumber("Shooter encoder velocity (raw)", getRawEncoderVel());
	}
	
	public void addToLW(){
		LiveWindow.addActuator("Shooter Subsystem", "Shooter Tilt", shooterTilt);
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

