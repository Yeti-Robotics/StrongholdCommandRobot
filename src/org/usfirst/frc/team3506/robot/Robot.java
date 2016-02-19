
package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.arm.UserOperateArmCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserTankDriveCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.UserOperateRollerBarCommand;
import org.usfirst.frc.team3506.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RollerBarSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ServoSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
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
	public static boolean captureMode;
	public static boolean flywheelsActive;
	
	Command autonomousCommand;
	public static SendableChooser gamepadChooser;
	public static SendableChooser testDriveTalonChooser;
	public static SendableChooser driveTrainFrontSideChooser;
	
    public void robotInit() {
    	captureMode = false;
    	flywheelsActive = false;
    	gamepadChooser = new SendableChooser();
    	testDriveTalonChooser = new SendableChooser();
    	driveTrainFrontSideChooser = new SendableChooser();
    	
    	gamepadChooser.addDefault("Gamepad Activated", new Boolean(true));
    	gamepadChooser.addObject("Joysticks Activated", new Boolean(false));
    	
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
		oi = new OI();
		driveTrain.addToLW();
		driveTrain.publishEncoderValues();
		rollerBar.addToLW();
		arm.addToLW();
		shooter.addToLW();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.publishEncoderValues();
        arm.publishEncoderValues();
        shooter.publishEncoderValues();
       // gearShift.publishShiftStatus();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        Scheduler.getInstance().add(new UserTankDriveCommand());
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.publishEncoderValues();
        arm.publishEncoderValues();
        shooter.publishEncoderValues();
        servo.publishGetServo();
        Scheduler.getInstance().add(new UserOperateRollerBarCommand());
        //gearShift.publishShiftStatus();
        Scheduler.getInstance().add(new UserOperateArmCommand());
        
    }
    
    public void testPeriodic() {
    	LiveWindow.setEnabled(true);
        LiveWindow.run();
    }
}
