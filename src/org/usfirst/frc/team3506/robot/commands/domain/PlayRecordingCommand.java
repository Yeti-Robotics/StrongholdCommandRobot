package org.usfirst.frc.team3506.robot.commands.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.domain.RobotInput.Joysticks;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarForwardCommand;
import org.usfirst.frc.team3506.robot.commands.rollerbar.HoldRollerBarReverseCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class PlayRecordingCommand extends Command {
	private String filename;
	private List<RobotInput> localInputSequence;
	private int parsingIndex;
	private boolean[] activatedButtons = new boolean[33];
    public PlayRecordingCommand(String filename) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.filename = filename;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	for(int i=0; i<33; i++){
    		activatedButtons[i] = false;
    	}
    	parsingIndex = 0;
    	if(!this.filename.equals(new String(""))){
    		try{
        		File file = new File(this.filename);
        		FileInputStream fs = new FileInputStream(file);
        		ObjectInputStream os = new ObjectInputStream(fs);
        		localInputSequence = (List<RobotInput>)os.readObject();
        		os.close();
        	} catch (Exception e){
        		e.printStackTrace();
        	}
    	} else{
    		localInputSequence = Robot.recentInputSequence;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(localInputSequence.size()!=0){
    		Robot.driveTrain.tankDrive(-RobotMap.USER_SPEED_CONTROL_MODIFIER * localInputSequence.get(parsingIndex).getJoysticksYAxisStatus()[0], RobotMap.USER_SPEED_CONTROL_MODIFIER * localInputSequence.get(parsingIndex).getJoysticksYAxisStatus()[1]);
    		Robot.arm.moveBallGrabber(localInputSequence.get(parsingIndex).getJoysticksYAxisStatus()[2]);
    		for(int i=0; i<3; i++){
    			for(int j=1; j<=11; j++){
    				if(parsingIndex != 0 && parsingIndex != 1){
    					for(int a=0; a<33; a++){
    						activatedButtons[a] = false;
    					}
    					if(isButtonPressed(i, j) && !activatedButtons[i*11+j]){
    						switch(i){
    							case 0:
    								RobotInput.elicitCommand(Joysticks.LEFT, j);
    								activatedButtons[i*11+j-1] = true;
    								break;
    							case 1:
    								RobotInput.elicitCommand(Joysticks.RIGHT, j);
    								activatedButtons[i*11+j-1] = true;
    								break;
    							case 2:
    								RobotInput.elicitCommand(Joysticks.ARM, j);
    								activatedButtons[i*11+j-1] = true;
    						}
    					}
    					if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.ARM, 2)==true){
    						Scheduler.getInstance().add(new HoldRollerBarForwardCommand());
    					} else if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.ARM, 3)==true){
    						Scheduler.getInstance().add(new HoldRollerBarReverseCommand());
    					}
    				}
    			}
    		}
    	}
    	parsingIndex++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return parsingIndex >= localInputSequence.size()-1;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private boolean isButtonPressed(int i, int j){
    	switch(i){
    		case 0:
    			if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.LEFT, j)==true && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.LEFT, j)==true && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.LEFT, j)==true){
    				return true;
    			} /*else if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.LEFT, j)==false && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.LEFT, j)==false && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.LEFT, j)==false){
    				return false;
    			} // OBSOLETE*/
    		case 1:
    			if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.RIGHT, j)==true && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.RIGHT, j)==true && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.RIGHT, j)==true){
    				return true;
    			} /*else if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.RIGHT, j)==false && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.RIGHT, j)==false && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.RIGHT, j)==false){
    				return false;
    			}*/
    		case 2:
    			if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.ARM, j)==true && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.ARM, j)==true && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.ARM, j)==true){
    				return true;
    			}/* else if(localInputSequence.get(parsingIndex).getButtonStatus(Joysticks.ARM, j)==false && localInputSequence.get(parsingIndex-1).getButtonStatus(Joysticks.ARM, j)==false && localInputSequence.get(parsingIndex-2).getButtonStatus(Joysticks.ARM, j)==false){
    				return false;
    			}*/
			default:
				return false;
    	}
    	
    }
}
