package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.shooter.UserOperateShooterCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Servo;
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
		return this.shooterTilt.getEncPosition();
	}
	
	public double getRawEncoderVel(){
		return this.shooterTilt.getEncVelocity();
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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

