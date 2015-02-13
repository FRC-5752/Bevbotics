package com.bevbotics.Bevbotics2015.subsystems;

import com.bevbotics.Bevbotics2015.RobotMap;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private TalonSRX armMotor = new TalonSRX(RobotMap.MOTOR_ARMS);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extendArm() {
    	armMotor.set(RobotMap.ARMS_SPEED);
    }
    
    public void retractArm() {
    	armMotor.set(-RobotMap.ARMS_SPEED);
    }
    
    public void stopArm() {
    	armMotor.set(0.0);
    }
}

