package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
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
	private DigitalInput lowerLimitSwitch;
	
	public ShooterSubsystem(){
		this.shooterTilt = new CANTalon(RobotMap.SHOOTER_TILT_CAN_TALON_ID);
		this.lowerLimitSwitch = new DigitalInput(RobotMap.SHOOTER_LOWER_LIMIT_SWITCH_PORT);
//		this.shooterTilt.setFeedbackDevice(FeedbackDevice.QuadEncoder);
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
		this.shooterTilt.set(RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
	}
	
	public void liftTilt(){
		this.shooterTilt.set(-RobotMap.SHOOTER_TILT_CAN_TALON_SPEED);
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
	
	public void userControl(double val){
		this.shooterTilt.set(val);
	}
		
	public void publishEncoderValues(){
		SmartDashboard.putNumber("Shooter encoder position (raw)", getRawEncoderPos());
		SmartDashboard.putNumber("Shooter encoder velocity (raw)", getRawEncoderVel());
	}
	
	public void addToLW(){
		LiveWindow.addSensor("Shooter Subsystem", "Shooter Tilt encoder", shooterTilt);
		LiveWindow.addActuator("Shooter Subsystem", "Shooter Tilt", shooterTilt);
	}
	
    public void initDefaultCommand() {
//        setDefaultCommand(new KeepShooterStaticCommand());
    }
    
    public void resetEncoder() {
    	shooterTilt.setEncPosition(0);
    }
}

