package com.bevbotics.Bevbotics2015.subsystems;

import com.bevbotics.Bevbotics2015.LinkedMotors;
import com.bevbotics.Bevbotics2015.RobotMap;
import com.bevbotics.Bevbotics2015.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//motors
	//private LinkedMotors leftMotors = new LinkedMotors(new int[]{RobotMap.MOTOR_LEFT_1, RobotMap.MOTOR_LEFT_2});
	//private LinkedMotors rightMotors = new LinkedMotors(new int[]{RobotMap.MOTOR_RIGHT_1, RobotMap.MOTOR_RIGHT_2});
	private Talon leftMotor1 = new Talon(RobotMap.MOTOR_LEFT_1);
	private Talon leftMotor2 = new Talon(RobotMap.MOTOR_LEFT_2);
	private Talon rightMotor1 = new Talon(RobotMap.MOTOR_RIGHT_1);
	private Talon rightMotor2 = new Talon(RobotMap.MOTOR_RIGHT_2);
	//
	//private
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveCommand());
    }
    
    public void setLeftPower(double power){
    	//leftMotors.set(power);
    	leftMotor1.set(power);
    	leftMotor2.set(power);
    }
    
    public void setRightPower(double power){
    	//rightMotors.set(power);
    	rightMotor1.set(power);
    	rightMotor2.set(power);
    }
    
    public void drive(double leftPower, double rightPower){
    	//TODO: One of these will need to be inverted to make the motors coordinate direction
    	//Also add PIDController integration to allow easy 180 degree rotation
    	setLeftPower(leftPower);
    	setRightPower(-rightPower);
    	
    }
    
    public void stop(){
    	drive(0.0,0.0);
    }
}

