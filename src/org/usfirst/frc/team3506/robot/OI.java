package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.CalibrateShooterCommand;
import org.usfirst.frc.team3506.robot.commands.ShiftDown;
import org.usfirst.frc.team3506.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/*Gamepad button mapping for user operation commands:
	 * 2 & 4: UserOperateRollerBarCommand
	 * 5 & 6: UserOperateClimberCommand
	 * 7 & 8: UserOperateArmCommand
	 */
	public Joystick gamepad;
	private Joystick leftStick;
	private Joystick rightStick;
	public boolean rollersOn;
	public boolean rollersForward;
	
	public OI(){
		gamepad = new Joystick(RobotMap.GAMEPAD_PORT);
		leftStick = new Joystick(RobotMap.LEFT_STICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_STICK_PORT);
		rollersOn = false;
		rollersForward = false;
		setJoystickButtonCommand(gamepad, 1, new ShiftDown());
		setJoystickButtonCommand(gamepad, 3, new ShiftUp());
		setJoystickButtonCommand(gamepad, 9, new CalibrateShooterCommand());
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
			return deadZoneMod(gamepad.getRawAxis(RobotMap.GAMEPAD_LEFT_Y_AXIS));
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
	
	private void setJoystickButtonCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}
}

