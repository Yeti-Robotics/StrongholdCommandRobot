package org.usfirst.frc.team3506.robot.commands.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TerminateAndSaveRecordingCommand extends Command {

    public TerminateAndSaveRecordingCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.recording = false;
    	try{
    		File file = new File("/recording/" + new Long(System.currentTimeMillis()).toString() + "recording.txt");
    		FileOutputStream fs = new FileOutputStream(file);
    		ObjectOutputStream os = new ObjectOutputStream(fs);
    		os.writeObject(Robot.inputSequence);
    		os.close();
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	Robot.recentInputSequence = new ArrayList<RobotInput>();
    	for(RobotInput input : Robot.inputSequence){
    		Robot.recentInputSequence.add(input);
    	}
    	Robot.inputSequence.clear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
