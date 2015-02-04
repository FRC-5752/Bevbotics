package com.bevbotics.Bevbotics2015;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int XBOX_PORT = 0;
	
	//motors 
	public static final int MOTOR_LEFT_1 = 0;
	public static final int MOTOR_LEFT_2 = 1; 
	
	public static final int MOTOR_RIGHT_1 = 2;
	public static final int MOTOR_RIGHT_2 = 3; 
	
	public static final int MOTOR_WINCH = 4;

	//use which speed to cap the maximum % speed of the which -> Should be in the range of 0.0 to 1.0
	public static final double WINCH_SPEED = 0.5;
}

