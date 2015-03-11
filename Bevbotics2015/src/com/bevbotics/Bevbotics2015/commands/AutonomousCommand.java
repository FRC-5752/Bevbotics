package com.bevbotics.Bevbotics2015.commands;

import com.bevbotics.Bevbotics2015.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
    
    public  AutonomousCommand() {
    	requires(Robot.driveTrain);
    	requires(Robot.winch);
    	//addSequential(new StartDrivingCommand(1.0));
    	//addSequential(new WaitCommand(1.0));
    	//addSequential(new StopDrivingCommand());
    	addSequential(new AutoWinchCommand());
    	//addSequential(new WinchExtendCommand());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
