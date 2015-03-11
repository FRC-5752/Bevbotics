package com.bevbotics.Bevbotics2015.commands;

import com.bevbotics.Bevbotics2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoWinchCommand extends Command {

    public AutoWinchCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.winch.reachedLimit()) {
    		Robot.winch.extend();
    	}else{
    		Robot.winch.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winch.reachedLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
