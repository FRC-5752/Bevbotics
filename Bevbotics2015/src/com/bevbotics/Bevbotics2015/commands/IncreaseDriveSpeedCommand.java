package com.bevbotics.Bevbotics2015.commands;

import com.bevbotics.Bevbotics2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IncreaseDriveSpeedCommand extends Command {

    public IncreaseDriveSpeedCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.speedDivisor > 4.0/3.0) {
    		RobotMap.speedDivisor -= 2.0/3.0;
    	}
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
