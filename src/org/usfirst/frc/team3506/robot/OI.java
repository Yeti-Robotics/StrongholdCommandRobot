package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.arm.CalibrateArmCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberUpCommand;
import org.usfirst.frc.team3506.robot.commands.climber.ToggleBrakeCommand;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ManualFireCommandGroup;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ResetDriveTrainEncodersCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ToggleRobotFrontCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftDownCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarReverseCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveDownCommand;
import org.usfirst.frc.team3506.robot.commands.servo.ServoMoveUpCommand;
import org.usfirst.frc.team3506.robot.commands.servo.StopServoCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.CalibrateShooterEncoder;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepShooterStaticCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterDownCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.ResetShooterEncoderCommand;
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
	
	public OI(){
		gamepad = new Joystick(RobotMap.GAMEPAD_PORT);
		leftStick = new Joystick(RobotMap.LEFT_STICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_STICK_PORT);
		
		//Third joystick
		setJoystickButtonWhenPressedCommand(gamepad, 1, new ManualFireCommandGroup());
		setJoystickButtonWhilePressedCommand(gamepad, 2, new HoldRollerBarReverseCommand());
		setJoystickButtonWhilePressedCommand(gamepad, 3, new HoldRollerBarForwardCommand());
		setJoystickButtonWhilePressedCommand(gamepad, 4, new MoveShooterDownCommand());
		setJoystickButtonWhilePressedCommand(gamepad, 5, new MoveShooterUpCommand());
//		setJoystickButtonWhilePressedCommand(gamepad, 6, new KeepShooterStaticCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 7, new CalibrateShooterEncoder());
		setJoystickButtonWhenPressedCommand(gamepad, 8, new CalibrateArmCommand());
//		setJoystickButtonWhenPressedCommand(gamepad, 8, new ServoMoveDownCommand());
//		setJoystickButtonWhenPressedCommand(gamepad, 9, new ServoMoveUpCommand());
//		setJoystickButtonWhenPressedCommand(gamepad, 10, new ToggleFlywheelCommand());
		setJoystickButtonWhenPressedCommand(gamepad, 11, new ResetShooterEncoderCommand());
		
		//Left joystick
		setJoystickButtonWhenPressedCommand(leftStick, 1, new ToggleRobotFrontCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 2, new ToggleBrakeCommand());
		setJoystickButtonWhilePressedCommand(leftStick, 7, new MoveClimberDownCommand());
		setJoystickButtonWhilePressedCommand(leftStick, 6, new MoveClimberUpCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 11, new ResetDriveTrainEncodersCommand());
		
		//Right joystick
		setJoystickButtonWhenPressedCommand(rightStick, 1, new ToggleGearShiftCommand());
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

