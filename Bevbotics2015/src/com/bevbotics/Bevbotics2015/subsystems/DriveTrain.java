package com.bevbotics.Bevbotics2015.subsystems;

import com.bevbotics.Bevbotics2015.LinkedMotors;
import com.bevbotics.Bevbotics2015.RobotMap;
import com.bevbotics.Bevbotics2015.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
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
	
	
	//private Ultrasonic ultrasend = new Ultrasonic(RobotMap.ULTRASONIC,RobotMap.ULTRASONIC+1);
	//private Ultrasonic ultrareceive = new Ultrasonic(RobotMap.ULTRASONIC+1, RobotMap.ULTRASONIC);
	//
	//private
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//ultrareceive.setAutomaticMode(true);
    	setDefaultCommand(new TankDriveCommand());
    }
    
    private double lastLeftPower = 0.0;
    public void setLeftPower(double power){
    	//leftMotors.set(power);
    	if (Math.abs(lastLeftPower - power) > RobotMap.ACCEL_COEFFICIENT) {
    		if (Math.signum(power-lastLeftPower) == 1) {
    			power = lastLeftPower + RobotMap.ACCEL_COEFFICIENT;
    		}else if (Math.signum(power-lastLeftPower) == -1) {
    			power = lastLeftPower - RobotMap.ACCEL_COEFFICIENT;
    		}
    	}
    	leftMotor1.set(power);
    	leftMotor2.set(power);
    	
    	lastLeftPower = power;
    }
    
    private double lastRightPower = 0.0;
    public void setRightPower(double power){
    	//rightMotors.set(power);
    	if (Math.abs(lastRightPower - power) > RobotMap.ACCEL_COEFFICIENT) {
    		if (Math.signum(power-lastRightPower) == 1) {
    			power = lastRightPower + RobotMap.ACCEL_COEFFICIENT;
    		}else if (Math.signum(power-lastRightPower) == -1) {
    			power = lastRightPower - RobotMap.ACCEL_COEFFICIENT;
    		}
    	}
    	if (power > 1.0) {power = 1.0;}
    	if (power < -1.0) {power = -1.0;}
    	rightMotor1.set(power);
    	rightMotor2.set(power);
    	
    	lastRightPower = power;
    }
    
    public void drive(double leftPower, double rightPower){
    	//TODO: One of these will need to be inverted to make the motors coordinate direction
    	//Also add PIDController integration to allow easy 180 degree rotation
    	setLeftPower(convertPower(leftPower));
    	setRightPower(convertPower(-rightPower));
    	
    }
    
    public void stop(){
    	drive(0.0,0.0);
    }
    
    private double convertPower(double pwr){
    	double difference = 0.104;
    	return pwr > 0.0 ? pwr : (1-difference)*pwr;
    }
    
//    public double getUltrasonicRangeInches() {
//    	DigitalSource io = new DigitalOutput(RobotMap.ULTRASONIC);
//    	Timer t = new Timer();
//    	t.start();
//    	((DigitalOutput)io).pulse(RobotMap.ULTRASONIC, (float)(10.0*1e-6));
//    	io = new DigitalInput(RobotMap.ULTRASONIC);
//    	((DigitalInput)io).waitForInterrupt(1.0);
//    	t.stop();
//    	return t.get()/74.0/2.0;//ultrareceive.getRangeInches();//ultra.getRangeInches();
//    }
}

