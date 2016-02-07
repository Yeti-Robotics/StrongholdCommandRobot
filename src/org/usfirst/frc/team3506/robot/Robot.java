
package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RollerBarSubsystem;

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
	public static ArmSubsystem ballGrabber;
	public static RollerBarSubsystem rollerBar;
	public static ShooterSubsystem shooter;
	public static ClimberSubsystem climber;
	public static OI oi;
	public static boolean captureMode;
	
	Command autonomousCommand;
	public static SendableChooser gamepadChooser;
	public static SendableChooser tankDriveChooser;
	
    public void robotInit() {
    	captureMode = false;
    	SmartDashboard.putBoolean(RobotMap.CAPTURE_MODE_ID, captureMode);
    	gamepadChooser = new SendableChooser();
    	tankDriveChooser = new SendableChooser();
    	tankDriveChooser.addDefault("Tank Drive", new Boolean(true));
    	tankDriveChooser.addObject("Arcade Drive", new Boolean(false));
    	gamepadChooser.addDefault("Gamepad Activated", new Boolean(true));
    	gamepadChooser.addObject("Joysticks Activated", new Boolean(false));
    	SmartDashboard.putData("Drive Chooser", tankDriveChooser);
    	SmartDashboard.putData("Controller Chooser", gamepadChooser);
    	shooter = new ShooterSubsystem();
    	gearShift = new GearShiftSubsystem();
		driveTrain = new DriveTrainSubsystem();
    	ballGrabber = new ArmSubsystem();
    	rollerBar = new RollerBarSubsystem();
    	climber = new ClimberSubsystem();
		oi = new OI();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
