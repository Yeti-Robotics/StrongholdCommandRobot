package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
	private CANTalon shooterTilt;
	private DigitalInput lowerLimitSwitch, upperLimitSwitch;
	
	public ShooterSubsystem(){
		this.shooterTilt = new CANTalon(RobotMap.SHOOTER_TILT_CAN_TALON_ID);
		this.lowerLimitSwitch = new DigitalInput(RobotMap.SHOOTER_LOWER_LIMIT_SWITCH_PORT);
		this.shooterTilt.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		upperLimitSwitch = new DigitalInput(RobotMap.SHOOTER_UPPER_LIMIT_SWITCH_PORT);
		resetEncoder();
	}
	
	public double calculateFiringAngle() {
		double x = getDistance();
		return 45;
	}
	
	public double getDistance() {
		return SmartDashboard.getNumber(RobotMap.DISTANCE_ID);
	}
	
	public double getAzimuth() {
		return SmartDashboard.getNumber(RobotMap.AZIMUTH_ID);
	}
	
	public void lowerTilt(){
		this.shooterTilt.set(-RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
	}
	
	public void liftTilt(){
		this.shooterTilt.set(RobotMap.SHOOTER_TILT_CAN_TALON_SPEED/2.0);
	}
	
	public void stopTalon(){
		this.shooterTilt.set(0.0);
	}
	
	public double getRawEncoderPos(){
		return this.shooterTilt.getPosition();
	}
	
	public double getRawEncoderVel(){
		return this.shooterTilt.getEncVelocity();
	}
	
    public double encoderToDegree(double encoderValue) {
    	return encoderValue * RobotMap.SHOOTER_ENCODER_RAW_TO_DEGREES_MODIFIER;
    }
    
    public double degreeToEncoder(double angle) {
    	return angle * RobotMap.SHOOTER_DEGREES_TO_ENCODER_RAW_MODIFIER;
    }
	
	public boolean getLowerLimitSwitchState(){
		return this.lowerLimitSwitch.get();
	}
	
	public boolean getUpperLimitSwitch() {
		return upperLimitSwitch.get();
	}
	
	public void userControl(double val){
		this.shooterTilt.set(val);
	}
		
	public void publishEncoderValues(){
		SmartDashboard.putNumber("Shooter encoder position (raw)", getRawEncoderPos());
		SmartDashboard.putNumber("Shooter encoder velocity (raw)", getRawEncoderVel());
		SmartDashboard.putBoolean("Shooter Limit", getLowerLimitSwitchState());
		SmartDashboard.putBoolean("Shooter upper limit", getUpperLimitSwitch());
	}
	
	public void addToLW(){
		LiveWindow.addSensor("Shooter Subsystem", "Shooter Tilt encoder", shooterTilt);
		LiveWindow.addActuator("Shooter Subsystem", "Shooter Tilt", shooterTilt);
	}
    
    public void resetEncoder() {
    	shooterTilt.setPosition(0);
    }
    
    public void initDefaultCommand() {
    	
    }
}

