package com.bevbotics.Bevbotics2015.commands;

import com.bevbotics.Bevbotics2015.OI;
import com.bevbotics.Bevbotics2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDriveCommand extends Command {
	
	public static OI oi = new OI();

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
    	double leftPower, rightPower;
    	leftPower = deadBand(oi.getLeftTrigger());
    	rightPower = deadBand(oi.getRightTrigger());
    	//use the left/right buttons to invert driving direction
    	//ie pressing the left button causes the left trigger to control reversing speed instead of forward speed
    	leftPower *= oi.getLeftButton() ? -1 : 1;
    	rightPower *= oi.getRightButton() ? -1 : 1;
    	Robot.driveTrain.drive(leftPower, rightPower);
    }
    
    private double deadBand(double d) {
    	if (Math.abs(d)<.05) {
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
