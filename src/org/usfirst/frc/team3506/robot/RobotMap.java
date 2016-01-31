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
}
