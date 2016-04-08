package org.usfirst.frc.team3506.robot;


import org.usfirst.frc.team3506.robot.commands.SetDriveModeToArcadeCommand;
import org.usfirst.frc.team3506.robot.commands.SetDriveModeToTankCommand;
import org.usfirst.frc.team3506.robot.commands.climber.ActivateBrakeCommand;
import org.usfirst.frc.team3506.robot.commands.climber.DeactivateBrakeCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.MoveClimberUpCommand;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ChevalDeFriseBreacherCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.LowBarBreacherCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ManualFireCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.MoveShooterToPositionAndFireCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ReadyToFireCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ShootAfterClimbingCommandGroup;
import org.usfirst.frc.team3506.robot.commands.domain.InitiateRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.domain.PlayRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.domain.RobotInput;
import org.usfirst.frc.team3506.robot.commands.domain.TerminateAndSaveRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.domain.RobotInput.Joysticks;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ToggleRobotFrontCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarReverseCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterDownCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.MoveShooterUpCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.PropShooterDownCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.PropUpShooterCommand;
import org.usfirst.frc.team3506.robot.commands.shooter.KeepFlywheelsHeldCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick shooterStick;
	private Joystick rightStick;
	private Joystick leftStick;
	
	public OI(){
		shooterStick = new Joystick(RobotMap.SHOOTER_STICK_PORT);
		rightStick = new Joystick(RobotMap.LEFT_STICK_PORT);
		leftStick = new Joystick(RobotMap.RIGHT_STICK_PORT);
		
		//Shooter joystick
		setJoystickButtonWhilePressedCommand(shooterStick, 1, new KeepFlywheelsHeldCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 2, new HoldRollerBarForwardCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 3, new HoldRollerBarReverseCommand());
		//setJoystickButtonWhilePressedCommand(shooterStick, 4, new MoveShooterDownCommand());
		//setJoystickButtonWhilePressedCommand(shooterStick, 5, new ReadyToFireCommandGroup());
		setJoystickButtonWhenPressedCommand(shooterStick, 4, new PropUpShooterCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 5, new PropShooterDownCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 6, new MoveClimberUpCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 7, new MoveClimberDownCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 8, new ShootAfterClimbingCommandGroup());
		setJoystickButtonWhenPressedCommand(shooterStick, 9, new DeactivateBrakeCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 10, new ActivateBrakeCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 11, new KeepFlywheelsHeldCommand());
		
		//Right joystick
		setJoystickButtonWhenPressedCommand(rightStick, 1, new ToggleRobotFrontCommand());
		setJoystickButtonWhenPressedCommand(rightStick, 4, new SetDriveModeToTankCommand());
		setJoystickButtonWhenPressedCommand(rightStick, 5, new SetDriveModeToArcadeCommand());
		//setJoystickButtonWhenPressedCommand(rightStick, 10, new MoveShooterToPositionAndFireCommandGroup());
		
		//Left joystick
		setJoystickButtonWhenPressedCommand(leftStick, 1, new ToggleGearShiftCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 3, new PlayRecordingCommand(""));
		setJoystickButtonWhenPressedCommand(leftStick, 4, new InitiateRecordingCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 5, new TerminateAndSaveRecordingCommand());
		
	}
	
	public double getShooterY(){
		if(!(shooterStick == null)){
			return -deadZoneMod(shooterStick.getY());
		} else{
			return 0;
		}
	}
	
	public double getLeftX(){
		if(!(rightStick == null)){
			return deadZoneMod(rightStick.getX());
		} else{
			return 0;
		}
	}
	
	public double getRightX(){
		if(!(leftStick == null)){
			return deadZoneMod(leftStick.getX());
		} else{
			return 0;
		}
	}
	
	public double getLeftY(){
		if(!(rightStick == null)){
			return deadZoneMod(rightStick.getY());
		} else{
			return 0;
		}
	}
	
	public double getRightY(){
		if(!(leftStick == null)){
			return deadZoneMod(leftStick.getY());
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
	
	public boolean getButtonStatus(Joysticks joystick, int button){
		switch(joystick){
			case LEFT:
				return leftStick.getRawButton(button);
			case RIGHT:
				return rightStick.getRawButton(button);
			case ARM: 
				return shooterStick.getRawButton(button);
			default:
				return false; 
		}
	}
	
	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
		if(joystick == this.rightStick){
			RobotInput.rightCommands[button-1] = command;
		} else if(joystick == this.leftStick){
			RobotInput.leftCommands[button-1] = command;
		} else if(joystick == this.shooterStick){
			RobotInput.armCommands[button-1] = command;
		}
	}
	
	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command){
		new JoystickButton(joystick, button).whileHeld(command);
		if(joystick == this.rightStick){
			RobotInput.rightCommands[button-1] = command;
		} else if(joystick == this.leftStick){
			RobotInput.leftCommands[button-1] = command;
		} else if(joystick == this.shooterStick){
			RobotInput.armCommands[button-1] = command;
		}
	}
}

