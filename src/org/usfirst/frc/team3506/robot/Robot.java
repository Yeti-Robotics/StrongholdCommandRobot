package org.usfirst.frc.team3506.robot;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team3506.robot.commands.autonomous.CrossDefenseAutonomous;
import org.usfirst.frc.team3506.robot.commands.commandgroups.ChevalDeFriseBreacherCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.LowBarBreacherCommandGroup;
import org.usfirst.frc.team3506.robot.commands.domain.RobotInput;
import org.usfirst.frc.team3506.robot.commands.domain.RobotInput.Joysticks;
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
	public static FlywheelSubsystem flywheels;
	public static boolean captureMode;
	public static boolean recording;
	public static List <RobotInput> inputSequence = new ArrayList<RobotInput>();
	public static List <RobotInput> recentInputSequence = new ArrayList<RobotInput>();
	
	public SendableChooser autoChooser;
	
	public static enum AutoModes {CROSSABLE_DEFENSE, CHEVAL_DE_FRISE, LOW_BAR};

	public static Command autonomousCommand;

	public void robotInit() {
		captureMode = true;
		recording = false;
		shooter = new ShooterSubsystem();
		gearShift = new GearShiftSubsystem();
		driveTrain = new DriveTrainSubsystem();
		arm = new ArmSubsystem();
		rollerBar = new RollerBarSubsystem();
		climber = new ClimberSubsystem();
		servo = new ServoSubsystem();
		flywheels = new FlywheelSubsystem();
		oi = new OI();
		autonomousCommand = new CrossDefenseAutonomous();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Moat/Rock wall/Rough terrain/Portcullis", AutoModes.CROSSABLE_DEFENSE);
		autoChooser.addObject("Cheval de frise", AutoModes.CHEVAL_DE_FRISE);
		autoChooser.addObject("Low bar", AutoModes.LOW_BAR);
		SmartDashboard.putData("Auto Chooser", autoChooser);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}

	public void autonomousInit() {
		switch((AutoModes)autoChooser.getSelected()){
			case CROSSABLE_DEFENSE:
				autonomousCommand = new CrossDefenseAutonomous();
				break;
			case CHEVAL_DE_FRISE:
				autonomousCommand = new ChevalDeFriseBreacherCommandGroup();
				break;
			case LOW_BAR:
				autonomousCommand = new LowBarBreacherCommandGroup();
				break;
			default:
				autonomousCommand = new CrossDefenseAutonomous();
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		flywheels.isActive = false;
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if(recording){
			RobotInput currentInput = new RobotInput();
			currentInput.setJoystickYAxis(Joysticks.LEFT, oi.getLeftY());
			currentInput.setJoystickYAxis(Joysticks.RIGHT, oi.getRightY());
			currentInput.setJoystickYAxis(Joysticks.ARM, oi.getShooterY());
			for(int i=0; i<3; i++){
				for(int j=1; j<=11; j++){
					if(i==0 && j != 4 && j != 5){
						currentInput.setButtonState(Joysticks.LEFT, j, oi.getButtonStatus(Joysticks.LEFT, j));
					} else if(i==1){
						currentInput.setButtonState(Joysticks.RIGHT, j, oi.getButtonStatus(Joysticks.RIGHT, j));
					} else if(i==2){
						currentInput.setButtonState(Joysticks.ARM, j, oi.getButtonStatus(Joysticks.ARM, j));
					}
				}
			}
			inputSequence.add(currentInput);
		}
//		driveTrain.publishEncoderValues();
//		arm.publishEncoderValues();
//		shooter.publishEncoderValues();
	}

	public void testPeriodic() {
		LiveWindow.setEnabled(true);
		LiveWindow.run();
	}
}
