package com.bevbotics.Bevbotics2015.commands;

import com.bevbotics.Bevbotics2015.OI;
import com.bevbotics.Bevbotics2015.Robot;
import com.bevbotics.Bevbotics2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDriveCommand extends Command {
	public int i = 0;
//	public static OI oi = new OI();

    public TankDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("LIMIT",Robot.winch.reachedLimit());
    	SmartDashboard.putString("distance", "me");
    	//SmartDashboard.putNumber("POV", Robot.oi.XBox.getPOV());
    	double leftPower, rightPower;
    	
    	//tom drive
    	if (RobotMap.TomDrive) {
    		leftPower = deadBand(-1*Robot.oi.XBox.getLeftYAxis());
    		rightPower = deadBand(-1*Robot.oi.XBox.getRightYAxis());
    	}else {
    	//andrew drive
    		leftPower = deadBand(Robot.oi.XBox.getLeftTrigger());
    		rightPower = deadBand(Robot.oi.XBox.getRightTrigger());
    		//use the left/right buttons to invert driving direction
    		//ie pressing the left button causes the left trigger to control reversing speed instead of forward speed
    		leftPower *= Robot.oi.XBox.getLeftButton() ? -1 : 1;
    		rightPower *= Robot.oi.XBox.getRightButton() ? -1 : 1;
    	}
    	//if (leftPower != 0.0 || rightPower != 0.0) {
    	    Robot.driveTrain.drive(leftPower/RobotMap.speedDivisor, rightPower/RobotMap.speedDivisor);
//    	}else{
//    		//SmartDashboard.putString("where","")
//    		
//    		//forward backward speed will be equal - steering is corrected to each power setting using the right stick
//    		leftPower = rightPower = -1*deadBand(Robot.oi.XBox.getLeftYAxis())/RobotMap.speedDivisor;
//    		double angle = deadBand(Robot.oi.XBox.getRightXAxis()) * leftPower/RobotMap.speedDivisor;
//    		leftPower += angle;
//    		rightPower -= angle;
//    		
//    		//this may need modification if the robot turns too slowly
//    		if (leftPower > 1.0) {
//    			leftPower = 1.0;
//    		}else if(leftPower < -1.0) {
//    			leftPower = -1.0;
//    		}else if(rightPower > 1.0){
//    			rightPower = 1.0;
//    		}else if(rightPower < -1.0){
//    			rightPower = -1.0;
//    		}
//    		Robot.driveTrain.drive(leftPower, rightPower);
//    	}
    }
    
    private double deadBand(double d) {
    	if (Math.abs(d)<.1) {
    		return 0.0;
    	}else{
    		return d;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
