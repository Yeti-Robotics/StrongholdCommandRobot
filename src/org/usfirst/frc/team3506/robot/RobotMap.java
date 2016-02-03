package org.usfirst.frc.team3506.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final int SHOOTER_TILT_CAN_TALON_ID = 5;
	public static final int SPIKE_SHOOTER_RELAY_PORT_LEFT = 4;
	public static final int SPIKE_SHOOTER_RELAY_PORT_RIGHT = 11;
	public static final int[] SHOOTER_TILT_ENCODER_PORTS = {0,1}; // Needs to be updated!
	public static final int ENCODER_DEGREES_PER_PULSE = 10;
	public static final int SHOOTER_LOWER_LIMIT_SWITCH_PORT = 0;
	public static final double SHOOTER_TILT_CAN_TALON_SPEED = 0.2;
}
