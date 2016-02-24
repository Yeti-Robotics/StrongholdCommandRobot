package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.FlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RollerBarSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ServoSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ShooterTiltPIDSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriveTrainSubsystem driveTrain;
	public static GearShiftSubsystem gearShift;
	public static ArmSubsystem arm;
	public static RollerBarSubsystem rollerBar;
	public static ShooterSubsystem shooter;
	public static ClimberSubsystem climber;
	public static ServoSubsystem servo;
	public static OI oi;
	public static ShooterTiltPIDSubsystem shooterPID;
	public static FlywheelSubsystem flywheels;
	public static boolean captureMode;
	
	Command autonomousCommand;
	public static SendableChooser gamepadChooser;
	public static SendableChooser testDriveTalonChooser;
	public static SendableChooser driveTrainFrontSideChooser;
	public static SendableChooser driveSchemeChooser;
	
    public void robotInit() {
    	captureMode = true;
    	gamepadChooser = new SendableChooser();
    	testDriveTalonChooser = new SendableChooser();
    	driveTrainFrontSideChooser = new SendableChooser();
    	gamepadChooser.addDefault("Joysticks Activated", new Boolean(false));
    	gamepadChooser.addObject("Gamepad Activated", new Boolean(true));
    	driveSchemeChooser = new SendableChooser();
    	driveSchemeChooser.addDefault("Arcade drive", new Boolean(true));
    	driveSchemeChooser.addObject("Tank drive", new Boolean(false));
    	
    	
    	testDriveTalonChooser.addDefault("Left1", DriveTrainSubsystem.Talons.LEFT1);
    	testDriveTalonChooser.addObject("Left2", DriveTrainSubsystem.Talons.LEFT2);
    	testDriveTalonChooser.addObject("Left3", DriveTrainSubsystem.Talons.LEFT3);
    	testDriveTalonChooser.addObject("Right1", DriveTrainSubsystem.Talons.RIGHT1);
    	testDriveTalonChooser.addObject("Right2", DriveTrainSubsystem.Talons.RIGHT2);
    	testDriveTalonChooser.addObject("Right3", DriveTrainSubsystem.Talons.RIGHT3);
    	
    	driveTrainFrontSideChooser.addDefault("Shooter trajectory is front", new Boolean(true));
    	driveTrainFrontSideChooser.addObject("Ball grabber is front", new Boolean(false));
    	
    	SmartDashboard.putData("Controller Chooser", gamepadChooser);
    	SmartDashboard.putData("Test Drive Talon Chooser", testDriveTalonChooser);
    	SmartDashboard.putData("Front Side Chooser", driveTrainFrontSideChooser);
    	
    	shooter = new ShooterSubsystem();
    	gearShift = new GearShiftSubsystem();
    	driveTrain = new DriveTrainSubsystem();
    	arm = new ArmSubsystem();
    	rollerBar = new RollerBarSubsystem();
    	climber = new ClimberSubsystem();
    	servo = new ServoSubsystem();
    	shooterPID = new ShooterTiltPIDSubsystem();
    	flywheels = new FlywheelSubsystem();
		oi = new OI();
		shooterPID.addToLW();
		LiveWindow.addActuator("Shooter tilt", "ShooterTilt", shooterPID.getPIDController());
		SmartDashboard.putData("PIDSubsystem", shooterPID.getPIDController());
//		Processor.run(null);
    }
	
    public void disabledInit(){
//    	if(climber.hold) {
//    		climber.holdWinch();
//    	}
    }
	
	public void disabledPeriodic() {
//		Scheduler.getInstance().run();
//		driveTrain.publishEncoderValues();
//        arm.publishEncoderValues();
//        shooter.publishEncoderValues();
       // gearShift.publishShiftStatus();
//        if(climber.hold) {
//    		climber.holdWinch();
//    	}
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.publishEncoderValues();
        arm.publishEncoderValues();
        shooter.publishEncoderValues();
//        servo.publishGetServo();
//    	if(climber.hold) {
//    		climber.holdWinch();
//    	}
//        Processor.publishDistanceAzimuth();
    }
    
    public void testPeriodic() {
    	LiveWindow.setEnabled(true);
        LiveWindow.run();
    }
}
