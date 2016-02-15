package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class RollerBarSubsystem extends Subsystem {
    public CANTalon rollerBar;
    
    
    public RollerBarSubsystem() {
    	rollerBar = new CANTalon(RobotMap.ROLLER_BAR_TALON_ID);
    }
    
    public void stopRollerBar() {
    	rollerBar.set(0);
    }
    
    public void driveRollerBar() {
    	rollerBar.set(RobotMap.ROLLER_BAR_OPERATOR);
    }

    public void reverseRollerBar() {
    	rollerBar.set(-RobotMap.ROLLER_BAR_OPERATOR);
    }
    
    public void addToLW(){
    	LiveWindow.addActuator("Roller bar", "roll", rollerBar);
    }

	protected void initDefaultCommand() {}

}

