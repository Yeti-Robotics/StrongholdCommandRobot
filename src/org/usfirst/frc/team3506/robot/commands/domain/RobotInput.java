package org.usfirst.frc.team3506.robot.commands.domain;

import java.io.Serializable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RobotInput implements Serializable {
	private static final long serialVersionUID = 1L;
	public static enum Joysticks {
		LEFT, RIGHT, ARM
	};
	private double leftY, rightY, armY;
	public boolean[] leftButtons = new boolean[11];
	public boolean[] rightButtons = new boolean[11];
	public boolean[] armButtons = new boolean[11];
	public static Command[] leftCommands = new Command[11];
	public static Command[] rightCommands = new Command[11];
	public static Command[] armCommands = new Command[11];
	
	public void setButtonState(Joysticks joystick, int button, boolean state){
		button--;
		switch(joystick){
			case LEFT:
				this.leftButtons[button] = state;
				break;
			case RIGHT:
				this.rightButtons[button] = state;
				break;
			case ARM:
				this.armButtons[button] = state;
				break;
		}
	}
	
	public void setJoystickYAxis(Joysticks joystick, double val){
		switch(joystick){
			case LEFT:
				this.leftY = val;
				break;
			case RIGHT:
				this.rightY = val;
				break;
			case ARM:
				this.armY = val;
				break;
		}
	}
	
	public double[] getJoysticksYAxisStatus(){
		double[] joysticksYAxisStatus = {this.leftY, this.rightY, this.armY};
		return joysticksYAxisStatus;
	}
	
	public boolean getButtonStatus(Joysticks joystick, int button){
		switch(joystick){
			case LEFT:
				return leftButtons[button-1];
			case RIGHT:
				return rightButtons[button-1];
			case ARM:
				return armButtons[button-1];
			default:
				return false;
		}
	}
	
	public static void elicitCommand(Joysticks joystick, int button){
		switch(joystick){
			case LEFT:
				Scheduler.getInstance().add(RobotInput.leftCommands[button-1]);
				break;
			case RIGHT:
				Scheduler.getInstance().add(RobotInput.rightCommands[button-1]);
				break;
			case ARM:
				Scheduler.getInstance().add(RobotInput.armCommands[button-1]);
				break;
		}
	}
}
