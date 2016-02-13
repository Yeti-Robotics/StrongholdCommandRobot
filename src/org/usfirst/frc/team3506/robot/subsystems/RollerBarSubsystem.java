package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class RollerBarSubsystem extends Subsystem {
    public Relay rollerBar;
    
    public RollerBarSubsystem() {
    	rollerBar = new Relay(RobotMap.ROLLER_BAR_SPIKE_ID);
    }
    
    public void stopRollerBar() {
    	rollerBar.set(Relay.Value.kOff);
    }
    
    public void driveRollerBar() {
    	rollerBar.set(Relay.Value.kForward);
    }

    public void reverseRollerBar() {
    	rollerBar.set(Relay.Value.kReverse);
    }
    
    public void addToLW(){
    	LiveWindow.addActuator("Roller bar", "roll", rollerBar);
    }

	protected void initDefaultCommand() {}

}

