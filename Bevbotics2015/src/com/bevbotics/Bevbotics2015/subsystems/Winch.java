package com.bevbotics.Bevbotics2015.subsystems;

import com.bevbotics.Bevbotics2015.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon winchMotor = new Talon(RobotMap.MOTOR_WINCH);
	private Encoder enc = new Encoder(RobotMap.WINCH_ENC_A,RobotMap.WINCH_ENC_B);
	private PowerDistributionPanel powerPanel = new PowerDistributionPanel();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extend() {
    	winchMotor.set(RobotMap.WINCH_SPEED);
    }
    
    public void retract() {
    	winchMotor.set(-RobotMap.WINCH_SPEED);
    }
    
    public void stop() {
    	winchMotor.set(0.0);
    }
    
    public double getMotorCurrent() {
    	return powerPanel.getCurrent(RobotMap.MOTOR_WINCH);
    }
}

