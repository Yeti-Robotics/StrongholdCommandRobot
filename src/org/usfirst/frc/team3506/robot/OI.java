package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberUpCommand;
import org.usfirst.frc.team3506.robot.commands.climber.ToggleBrakeCommand;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ManualFireCommandGroup;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ToggleRobotFrontCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarReverseCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterDownCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterUpCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick shooterStick;
	private Joystick leftStick;
	private Joystick rightStick;
	
	public OI(){
		shooterStick = new Joystick(RobotMap.SHOOTER_STICK_PORT);
		leftStick = new Joystick(RobotMap.LEFT_STICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_STICK_PORT);
		
		//Shooter joystick
		setJoystickButtonWhenPressedCommand(shooterStick, 1, new ManualFireCommandGroup());
		setJoystickButtonWhilePressedCommand(shooterStick, 2, new HoldRollerBarReverseCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 3, new HoldRollerBarForwardCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 4, new MoveShooterDownCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 5, new MoveShooterUpCommand());
		
		//Left joystick
		setJoystickButtonWhenPressedCommand(leftStick, 1, new ToggleRobotFrontCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 2, new ToggleBrakeCommand());
		setJoystickButtonWhilePressedCommand(leftStick, 7, new MoveClimberDownCommand());
		setJoystickButtonWhilePressedCommand(leftStick, 6, new MoveClimberUpCommand());
		
		//Right joystick
		setJoystickButtonWhenPressedCommand(rightStick, 1, new ToggleGearShiftCommand());
	}
	
	public double getShooterY(){
		if(!(shooterStick == null)){
			return -deadZoneMod(shooterStick.getY());
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
	
	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}
	
	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command){
		new JoystickButton(joystick, button).whileHeld(command);
	}
}

