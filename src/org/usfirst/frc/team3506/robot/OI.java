package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberUpCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ResetDriveTrainEncodersCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftDownCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.ToggleRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.ToggleRollerBarReverseCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.servo.StopServoCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.CalibrateShooterEncoder;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterDownCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ToggleFlywheelCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick gamepad;
	private Joystick leftStick;
	private Joystick rightStick;
	public boolean rollersOn;
	public boolean rollersForward;
	
	public OI(){
		rollersOn = false;
		rollersForward = false;
		gamepad = new Joystick(RobotMap.GAMEPAD_PORT);
		leftStick = new Joystick(RobotMap.LEFT_STICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_STICK_PORT);
		
		setJoystickButtonWhenPressedCommand(gamepad, 2, new ToggleRollerBarReverseCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 3, new ToggleRollerBarForwardCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 7, new ShiftDownCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 8, new ShiftUpCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 9, new CalibrateShooterEncoder());
		setJoystickButtonWhenPressedCommand(gamepad, 10, new ToggleFlywheelCommand());
		
		setJoystickButtonWhilePressedCommand(leftStick, 6, new MoveClimberDownCommand());
		setJoystickButtonWhilePressedCommand(leftStick, 7, new MoveClimberUpCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 8, new ServoMoveDownCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 9, new ServoMoveUpCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 10, new StopServoCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 11, new ResetDriveTrainEncodersCommand());	
		
		setJoystickButtonWhilePressedCommand(rightStick, 4, new MoveShooterDownCommand());
		setJoystickButtonWhilePressedCommand(rightStick, 5, new MoveShooterUpCommand());
		setJoystickButtonWhenPressedCommand(rightStick, 6, new KeepShooterStaticCommand());
		setJoystickButtonWhenPressedCommand(rightStick, 7, new CalibrateShooterEncoder());
	}
	
	public double getGamepadLeftX(){
		if(!(gamepad == null)){
			return deadZoneMod(gamepad.getRawAxis(RobotMap.GAMEPAD_LEFT_X_AXIS));
		} else{
			return 0;
		}
	}
	
	public double getGamepadLeftY(){
		if(!(gamepad == null)){
			return -deadZoneMod(gamepad.getRawAxis(RobotMap.GAMEPAD_LEFT_Y_AXIS));
		} else{
			return 0;
		}
	}
	
	public double getGamepadRightX(){
		if(!(gamepad == null)){
			return deadZoneMod(gamepad.getRawAxis(RobotMap.GAMEPAD_RIGHT_X_AXIS));
		} else{
			return 0;
		}
	}
	
	public double getGamepadRightY(){
		if(!(gamepad == null)){
			return deadZoneMod(gamepad.getRawAxis(RobotMap.GAMEPAD_RIGHT_Y_AXIS));
		} else{
			return 0;
		}
	}
	
	public double getLeftX(){
		if(!(leftStick == null)){
			return deadZoneMod(leftStick.getX());
		} else{
			return 0;
		}
	}
	
	public double getRightX(){
		if(!(rightStick == null)){
			return deadZoneMod(rightStick.getX());
		} else{
			return 0;
		}
	}
	
	public double getLeftY(){
		if(!(leftStick == null)){
			return deadZoneMod(leftStick.getY());
		} else{
			return 0;
		}
	}
	
	public double getRightY(){
		if(!(rightStick == null)){
			return deadZoneMod(rightStick.getY());
		} else{
			return 0;
		}
	}
	
	private double deadZoneMod(double val){
		if(Math.abs(val) <= RobotMap.DEAD_ZONE_MOD){
			return 0;
		} else{
			return val;
		}
	}
	
	public int getGamepadPOV(){
		return gamepad.getPOV();
	}
	
	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}
	
	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command){
		new JoystickButton(joystick, button).whileHeld(command);
	}
}

