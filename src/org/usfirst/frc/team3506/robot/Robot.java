package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.FlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RollerBarSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ServoSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	public static FlywheelSubsystem flywheels;
	public static boolean captureMode;

	Command autonomousCommand;

	public void robotInit() {
		captureMode = true;

		shooter = new ShooterSubsystem();
		gearShift = new GearShiftSubsystem();
		driveTrain = new DriveTrainSubsystem();
		arm = new ArmSubsystem();
		rollerBar = new RollerBarSubsystem();
		climber = new ClimberSubsystem();
		servo = new ServoSubsystem();
		flywheels = new FlywheelSubsystem();
		oi = new OI();
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}

	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.publishEncoderValues();
		arm.publishEncoderValues();
		shooter.publishEncoderValues();
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
		LiveWindow.run();
	}
}
