
package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.subsystems.BallGrabber;
import org.usfirst.frc.team3506.robot.subsystems.RollerBar;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3506.robot.subsystems.Shooter;
import org.usfirst.frc.team3506.robot.subsystems.GearShift;
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

	public static DriveTrain driveTrain;
	public static GearShift gearShift;
	public static BallGrabber ballGrabber;
	public static RollerBar rollerBar;
	public static Shooter shooter;
	public static OI oi;
	
	Command autonomousCommand;
	
    public void robotInit() {
    	shooter = new Shooter();
    	gearShift = new GearShift();
		driveTrain = new DriveTrain();
    	ballGrabber = new BallGrabber();
    	rollerBar = new RollerBar();
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
