package org.usfirst.frc.team3506.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// DriveTrain
	public static final int LEFT_1_CAN_TALON_ID = 62;  // ORIENTATION: DEFAULT FORWARD IS DIRECTION OF SHOOTER FIRING
	public static final int LEFT_2_CAN_TALON_ID = 1;
	public static final int LEFT_3_CAN_TALON_ID = 2;
	public static final int RIGHT_1_CAN_TALON_ID = 5;
	public static final int RIGHT_2_CAN_TALON_ID = 6;
	public static final int RIGHT_3_CAN_TALON_ID = 7;
	public static final double AUTO_DRIVE_SPEED = 0.3;
	public static final double USER_SPEED_CONTROL_MODIFIER = 0.8;
	public static final int GYRO_PORT = 0; // UPDATE
	public static final double DRIVE_TRAIN_ENCODER_TO_FEET_MODIFIER = 0.0; //CALCULATE
	
	//Arm
	public static final int BALL_GRABBER_CAN_TALON_ID = 3;
	public static final double ARM_SPEED_OPERATOR = 0.7;
	public static final int ARM_UPPER_LIMIT_SWITCH_PORT = 3; //UPDATE
	public static final int ARM_LOWER_LIMIT_SWITCH_PORT = 4; //UPDATE
	public static final double ARM_ENCODER_RAW_TO_DEGREES_MODIFIER = 0.0; //UPDATE
	
	public static final double ARM_P = 0.0; //CALCULATE;
	public static final double ARM_I = 0.0; //CALCULATE;
	public static final double ARM_D = 0.0; //CALCULATE;
	
	//Climber
	public static final int WINCH_TALON_ID = 8; 
	public static final double CLIMBER_SPEED_OPERATOR = 1.0;
	public static final int CLIMBER_UPPER_LIMIT_SWITCH_PORT = 1; //UPDATE
	public static final int CLIMBER_LOWER_LIMIT_SWITCH_PORT = 2; //UPDATE
	
	//Shooter
	public static final int SHOOTER_TILT_CAN_TALON_ID = 4;
	public static final int SPIKE_SHOOTER_RELAY_PORT_LEFT = 0;
	public static final int SPIKE_SHOOTER_RELAY_PORT_RIGHT = 1;
	public static final int SHOOTER_LOWER_LIMIT_SWITCH_PORT = 5; // Needs to be updated
	public static final double SHOOTER_TILT_CAN_TALON_SPEED = 0.1;
	public static final double SHOOTER_ENCODER_RAW_TO_DEGREES_MODIFIER = 0.0; //UPDATE
	
	public static final double SHOOTER_P = 0.0; // CALCULATE
	public static final double SHOOTER_I = 0.0; // CALCULATE
	public static final double SHOOTER_D = 0.0; // CALCULATE
	
	//GearShift
	public static final int[] SOLENOID_PORTS = {0,1};
	public static final boolean SHIFT_UP = true;
	public static final boolean SHIFT_DOWN = false;
	
	//RollerBar
	public static final int ROLLER_BAR_TALON_ID = 9;
	public static final double ROLLER_BAR_OPERATOR = 1.0;
	
	//Vision
	public static final String CAPTURE_MODE_ID = "RetroreflectiveCaptureMode";
	public static final String TABLE_ADDRESS = "GRIP/RetroreflectiveContourReport";
	public static final int CIRCULAR_FIFO_QUEUE_SIZE = 60;
	public static final double[] DEFAULT_VALUE_ARRAY = {0};
	public static final String DISTANCE_ID = "Distance";
	public static final String AZIMUTH_ID = "Azimuth";
	
	//Robot and controller constants
	public static final double ROBOT_WHEEL_DIAMETER_FT = 0.75; //needs adjustment ---------------
	public static final int GAMEPAD_PORT = 0;
	public static final int LEFT_STICK_PORT = 1;
	public static final int RIGHT_STICK_PORT = 2;
	public static final double DEAD_ZONE_MOD = 0.15;
	public static final int GAMEPAD_LEFT_X_AXIS = 0;
	public static final int GAMEPAD_LEFT_Y_AXIS = 1;
	public static final int GAMEPAD_RIGHT_X_AXIS = 2;
	public static final int GAMEPAD_RIGHT_Y_AXIS = 3;
	public static final double ROBOT_TRACK_WIDTH_FT = 25.165 / 12.0;
	
	public static double encoderPositionDegreesModifierShooter; // subtract from actual encoder position to get calibrated encoder position
	public static double encoderPositionDegreesModifierArm; // subtract from actual encoder position to get calibrated encoder position
	
}
