package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RollerBar extends Subsystem {
    public Relay rollerBar;
    
    public RollerBar() {
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

	protected void initDefaultCommand() {}

}

