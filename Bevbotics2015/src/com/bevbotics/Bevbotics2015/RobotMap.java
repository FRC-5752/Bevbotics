package com.bevbotics.Bevbotics2015;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//XBOX axes
	public static final int XBOX_PORT = 1;
	public static final int XBOX_L_XAXIS = 0;
	public static final int XBOX_L_YAXIS = 1;
	public static final int XBOX_L_TRIGGER = 2;
	public static final int XBOX_R_TRIGGER = 3;
	public static final int XBOX_R_XAXIS = 4;
	public static final int XBOX_R_YAXIS = 5;
	
	//XBOX Buttons
	public static final int XBOX_BUTTON_A = 0;
	public static final int XBOX_BUTTON_B = 1;
	public static final int XBOX_BUTTON_X = 2;
	public static final int XBOX_BUTTON_Y = 3;
	public static final int XBOX_BUTTON_LEFT = 4;
	public static final int XBOX_BUTTON_RIGHT = 5;
	
	//motors 
	public static final int MOTOR_LEFT_1 = 0;
	public static final int MOTOR_LEFT_2 = 1; 
	
	public static final int MOTOR_RIGHT_1 = 2;
	public static final int MOTOR_RIGHT_2 = 3; 
}

