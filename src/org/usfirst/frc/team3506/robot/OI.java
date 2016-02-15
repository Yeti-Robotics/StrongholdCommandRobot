package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.arm.MoveArmDownCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.StopArmCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberUpCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.RunTrainAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftDownCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftUpCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.SetForwardRollerBarCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.SetReverseRollerBarCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.ToggleRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.ToggleRollerBarReverseCommand;
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
		
		//setJoystickButtonWhenPressedCommand(gamepad, 2, new ToggleRollerBarReverseCommand());
		//setJoystickButtonWhenPressedCommand(gamepad, 4, new ToggleRollerBarForwardCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 5, new MoveClimberDownCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 6, new MoveClimberUpCommand());
//		setJoystickButtonWhilePressedCommand(gamepad, 7, new MoveArmDownCommand());
//		new JoystickButton(rightStick, 5).whenPressed(new MoveArmDownCommand());
//		new JoystickButton(rightStick, 6).whenPressed(new MoveArmUpCommand());
//		new JoystickButton(rightStick, 5).whenReleased(new StopArmCommand());
//		new JoystickButton(rightStick, 6).whenReleased(new StopArmCommand());
//		setJoystickButtonWhilePressedCommand(gamepad, 8, new MoveArmUpCommand());
		//setJoystickButtonWhenPressedCommand(gamepad, 9, new CalibrateShooterCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 1, new TestTalonCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 2, new MoveShooterDownCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 4, new MoveShooterUpCommand());
		//setJoystickButtonWhenPressedCommand(gamepad, _, new ToggleRollerBarForwardCommand());
		//setJoystickButtonWhenPressedCommand(gamepad, _, new ToggleRollerBarReverseCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 2, new SetReverseRollerBarCommand());
		//setJoystickButtonWhilePressedCommand(gamepad, 4, new SetForwardRollerBarCommand());
//		setJoystickButtonWhenPressedCommand(rightStick, 2, new ToggleRollerBarReverseCommand());
//		setJoystickButtonWhenPressedCommand(rightStick, 4, new ToggleRollerBarForwardCommand());
		setJoystickButtonWhilePressedCommand(rightStick, 4, new MoveShooterDownCommand());
		setJoystickButtonWhilePressedCommand(rightStick, 5, new MoveShooterUpCommand());
//		setJoystickButtonWhilePressedCommand(leftStick, 6, new MoveClimberDownCommand());
//		setJoystickButtonWhilePressedCommand(leftStick, 7, new MoveClimberUpCommand());
		setJoystickButtonWhilePressedCommand(rightStick, 8, new RunTrainAtPowerCommand(false, 0.25));
		setJoystickButtonWhilePressedCommand(rightStick, 9, new RunTrainAtPowerCommand(false, -0.25));
		setJoystickButtonWhenPressedCommand(leftStick, 2, new ShiftDownCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 3, new ShiftUpCommand());
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

