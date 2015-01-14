package com.bevbotics.Bevbotics2015;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class LinkedMotors implements SpeedController, PIDOutput {
	
	private SpeedController controllers[];
	private double output = 0.0;
	
	public LinkedMotors(int ports[]) {
		controllers = new SpeedController[ports.length];
		for (int i = 0; i<ports.length; i++){
			controllers[i] = new Talon(ports[i]);
		}
	}
	
	public LinkedMotors(Talon talons[]){
		controllers = new SpeedController[talons.length];
		for (int i = 0; i<talons.length; i++){
			controllers[i] = talons[i];
		}
	}

	@Override
	public void pidWrite(double output) {
		this.output = output;
		for (int i = 0; i<controllers.length; i++){
			controllers[i].pidWrite(output);
		}
	}

	@Override
	public double get() {
		return output;
	}

	@Override
	public void set(double speed, byte syncGroup) {
		for (int i = 0; i<controllers.length; i++){
			controllers[i].set(speed,syncGroup);
		}
	}

	@Override
	public void set(double speed) {
		for (int i = 0; i<controllers.length; i++){
			controllers[i].set(speed);
		}
	}

	@Override
	public void disable() {
		for (int i = 0; i<controllers.length; i++){
			controllers[i].disable();
		}
	}

}
