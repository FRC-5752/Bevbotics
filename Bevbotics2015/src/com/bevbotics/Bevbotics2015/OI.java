package com.bevbotics.Bevbotics2015;

import com.bevbotics.Bevbotics2015.commands.ArmsExtendCommand;
import com.bevbotics.Bevbotics2015.commands.ArmsRetractCommand;
import com.bevbotics.Bevbotics2015.commands.ArmsStopCommand;
import com.bevbotics.Bevbotics2015.commands.DecreaseDriveSpeedCommand;
import com.bevbotics.Bevbotics2015.commands.IncreaseDriveSpeedCommand;
import com.bevbotics.Bevbotics2015.commands.Rotate180Command;
import com.bevbotics.Bevbotics2015.commands.WinchExtendCommand;
import com.bevbotics.Bevbotics2015.commands.WinchRetractCommand;
import com.bevbotics.Bevbotics2015.commands.WinchStopCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public XBoxController XBox;
	public XBoxController XBox2;
	
	public OI() {
		XBox = new XBoxController(RobotMap.XBOX_PORT_DRIVER);
		XBox2 = new XBoxController(RobotMap.XBOX_PORT_OPERATOR);
		
//		XBox.getButtonX().whenReleased(new WinchStopCommand());
//		XBox.getButtonB().whenReleased(new WinchStopCommand());
//		XBox.getButtonX().whileHeld(new WinchExtendCommand());
//		XBox.getButtonB().whileHeld(new WinchRetractCommand());
		
		//operator xbox controller
		//winch commands
		XBox.getButtonX().whenReleased(new WinchStopCommand());
		XBox.getButtonB().whenReleased(new WinchStopCommand());
		XBox.getButtonX().whileHeld(new WinchExtendCommand());
		XBox.getButtonB().whileHeld(new WinchRetractCommand());
		
		//arm commands
		XBox2.getButtonA().whenReleased(new ArmsStopCommand());
		XBox2.getButtonY().whenReleased(new ArmsStopCommand());
		XBox2.getButtonA().whileHeld(new ArmsExtendCommand());
		XBox2.getButtonY().whileHeld(new ArmsRetractCommand());
		
		//driver xbox controller 
		//drive speed commands
		XBox.getButtonY().whenPressed(new IncreaseDriveSpeedCommand());
		XBox.getButtonA().whenPressed(new DecreaseDriveSpeedCommand());
	}
}

