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
	public static final int SHOOTER_LOWER_LIMIT_SWITCH_PORT = 0; // Needs to be updated
	public static final double SHOOTER_TILT_CAN_TALON_SPEED = 0.2;
	public static final int LEFT_1_CAN_TALON_ID = 62;
	public static final int LEFT_2_CAN_TALON_ID = 1;
	public static final int LEFT_3_CAN_TALON_ID = 2;
	public static final int RIGHT_1_CAN_TALON_ID = 5;
	public static final int RIGHT_2_CAN_TALON_ID = 6;
	public static final int RIGHT_3_CAN_TALON_ID = 7;
	public static final int[] LEFT_ENCODER_PORTS = {0,1}; // needs to be updated
	public static final int[] RIGHT_ENCODER_PORTS = {0,1}; //needs to be updated
	public static final int DISTANCE_PER_PULSE = 10;
	public static final int ROBOT_WHEEL_DIAMETER_FT = 0; //needs adjustment
	public static final int[] SOLENOID_PORTS = {0,1}; //update?
	public static final boolean SHIFT_UP = true;
	public static final boolean SHIFT_DOWN = false;
	public static final int BALL_GRABBER_CAN_TALON_ID = 0; //UPDATE
	public static final int ROLLER_BAR_SPIKE_ID = 0;
	public static final int GAMEPAD_PORT = 0;
	public static final int LEFT_STICK_PORT = 1;
	public static final int RIGHT_STICK_PORT = 2;
	public static final double DEAD_ZONE_MOD = 0.15;
	public static final int GAMEPAD_LEFT_X_AXIS = 0;
	public static final int GAMEPAD_LEFT_Y_AXIS = 1;
	public static final int GAMEPAD_RIGHT_X_AXIS = 2;
	public static final int GAMEPAD_RIGHT_Y_AXIS = 3;
	public static final String CAPTURE_MODE_ID = "RetroreflectiveCaptureMode";
	public static final double AUTO_DRIVE_SPEED = 0.3;
	public static final int WINCH_TALON_ID = 0; // update
	public static final double USER_SPEED_CONTROL_MODIFIER = 0.5;
	public static final double CLIMBER_SPEED_OPERATOR = 1.0;
	public static final double ROLLER_BAR_LIFT_SPEED = 0.3;
}
