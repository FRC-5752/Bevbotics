package com.bevbotics.Bevbotics2015;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XBoxController extends Joystick {
	
	private Button buttonA;
	private Button buttonB;
	private Button buttonX;
	private Button buttonY;
	private Button buttonLeft;
	private Button buttonRight;
	
	//XBOX axes
	public static final int XBOX_L_XAXIS = 0;
	public static final int XBOX_L_YAXIS = 1;
	public static final int XBOX_L_TRIGGER = 2;
	public static final int XBOX_R_TRIGGER = 3;
	public static final int XBOX_R_XAXIS = 4;
	public static final int XBOX_R_YAXIS = 5;
	
	//XBOX Buttons
	public static final int XBOX_BUTTON_A = 1;
	public static final int XBOX_BUTTON_B = 2;
	public static final int XBOX_BUTTON_X = 3;
	public static final int XBOX_BUTTON_Y = 4;
	public static final int XBOX_BUTTON_LEFT = 5;
	public static final int XBOX_BUTTON_RIGHT = 6;
	
	public XBoxController (int port){
		super(port);
		
		buttonA = new JoystickButton(this,XBOX_BUTTON_A);
		buttonB = new JoystickButton(this,XBOX_BUTTON_B);
		buttonX = new JoystickButton(this,XBOX_BUTTON_X);
		buttonY = new JoystickButton(this,XBOX_BUTTON_Y);
		buttonLeft = new JoystickButton(this,XBOX_BUTTON_LEFT);
		buttonRight = new JoystickButton(this,XBOX_BUTTON_RIGHT);
	}
	
	//read axes
	public double getRightTrigger(){
		return getRawAxis(XBOX_R_TRIGGER);
	}
	
	public double getLeftTrigger(){
		return getRawAxis(XBOX_L_TRIGGER);
	}
	
	public double getRightXAxis(){
		return getRawAxis(XBOX_R_XAXIS);
	}
	
	public double getRightYAxis(){
		return getRawAxis(XBOX_R_YAXIS);
	}
	
	public double getLeftXAxis(){
		return getRawAxis(XBOX_L_XAXIS);
	}
	
	public double getLeftYAxis(){
		return getRawAxis(XBOX_L_YAXIS);
	}
	
	//read buttons
	public boolean getRightButton(){
		return getRawButton(XBOX_BUTTON_RIGHT);
	}
	
	public boolean getLeftButton(){
		return getRawButton(XBOX_BUTTON_LEFT);
	}
	
	public boolean getAButton(){
		return getRawButton(XBOX_BUTTON_A);
	}
	
	public boolean getBButton(){
		return getRawButton(XBOX_BUTTON_B);
	}
	
	public boolean getXButton(){
		return getRawButton(XBOX_BUTTON_X);
	}
	
	public boolean getYButton(){
		return getRawButton(XBOX_BUTTON_Y);
	}
	
	//access buttons (for adding commands on button presses etc)
	public Button getButtonA(){
		return buttonA;
	}
	
	public Button getButtonB(){
		return buttonB;
	}
	
	public Button getButtonX(){
		return buttonX;
	}
	
	public Button getButtonY(){
		return buttonY;
	}
	
	public Button getButtonLeft(){
		return buttonLeft;
	}
	
	public Button getButtonRight(){
		return buttonRight;
	}
}
