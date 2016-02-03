package org.usfirst.frc.team3506.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int SHOOTER_TILT_CAN_TALON_ID = 5;
	public static final int SPIKE_SHOOTER_RELAY_PORT_LEFT = 4;
	public static final int SPIKE_SHOOTER_RELAY_PORT_RIGHT = 11;
	public static final int[] SHOOTER_TILT_ENCODER_PORTS = {0,1}; // Needs to be updated!
	public static final int ENCODER_DEGREES_PER_PULSE = 10;
	public static final int SHOOTER_LOWER_LIMIT_SWITCH_PORT = 0;
	public static final double SHOOTER_TILT_CAN_TALON_SPEED = 0.2;
	public static int LEFT_1_CAN_TALON_ID = 62;
	public static int LEFT_2_CAN_TALON_ID = 1;
	public static int LEFT_3_CAN_TALON_ID = 2;
	public static int RIGHT_1_CAN_TALON_ID = 5;
	public static int RIGHT_2_CAN_TALON_ID = 6;
	public static int RIGHT_3_CAN_TALON_ID = 7;
	public static int[] LEFT_ENCODER_PORTS = {0,1};
	public static int[] RIGHT_ENCODER_PORTS = {0,1}; //needs to be updated
	public static int DISTANCE_PER_PULSE = 10;
	public static int ROBOT_WHEEL_DIAMETER_FT = 0; //needs adjustment
	public static int[] SOLENOID_PORTS = {0,1};
	public static boolean SHIFT_UP = true;
	public static boolean SHIFT_DOWN = false;
	public static final int BALL_GRABBER_CAN_TALON_ID = 0;
	public static final int ROLLER_BAR_SPIKE_ID = 0;
}
