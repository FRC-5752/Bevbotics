package com.bevbotics.Bevbotics2015.subsystems;

import com.bevbotics.Bevbotics2015.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final double WINCH_DIAMETER = 2.0; //diameter of the winch shaft, in inches
	
	private TalonSRX winchMotor = new TalonSRX(RobotMap.MOTOR_WINCH);
	private Encoder enc = new Encoder(RobotMap.WINCH_ENC_A,RobotMap.WINCH_ENC_B);
	private AnalogInput upLimitIn = new AnalogInput(RobotMap.LIMIT_SWITCH_IN);
	private AnalogOutput upLimitOut = new AnalogOutput(RobotMap.LIMIT_SWITCH_OUT);
	//private DigitalInput upLimitIn = new DigitalInput(RobotMap.LIMIT_SWITCH_IN);
	//private DigitalOutput upLimitOut = new DigitalOutput(RobotMap.LIMIT_SWITCH_OUT);
	private PowerDistributionPanel powerPanel = new PowerDistributionPanel();
	
	private PIDController controller = new PIDController(0.0, 0.0, 0.0, 0.2, enc, winchMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
        enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        final double distancePerPulse = Math.PI * WINCH_DIAMETER / 497.0;
        
        enc.setDistancePerPulse(distancePerPulse);
    	
    	upLimitOut.setVoltage(5.0);
    	enc.reset();
    	controller.enable();
    }
    
//    public void extendPID(double distance) {
//    	controller.setSetpoint();
//    }
    
    public void extendPID() {
    	controller.setSetpoint(RobotMap.WINCH_SPEED_PID);
    }
    
    /**
     * @deprecated use {@link #extendPID()} instead
     */
    public void extend() {
    	winchMotor.set(RobotMap.WINCH_SPEED);
    }
    
    public void retractPID(){
    	controller.setSetpoint(-RobotMap.WINCH_SPEED_PID);
    }
    
    /**
     * @deprecated use {@link #retractPID()} instead
     */
    @Deprecated 
    public void retract() {
    	winchMotor.set(-RobotMap.WINCH_SPEED);
    }
    
    public void stopPID() {
    	controller.setSetpoint(0.0);
    }
    
    /**
     * @deprecated use {@link #stopPID()} instead
     */
    public void stop() {
    	winchMotor.set(0.0);
    }
    
    public double getMotorCurrent() {
    	return powerPanel.getCurrent(RobotMap.MOTOR_WINCH);
    }
    
    public boolean reachedLimit(){
    	SmartDashboard.putNumber("Volts", upLimitIn.getVoltage());
    	return upLimitIn.getVoltage() > 3.0;
    }
    
    public double getEncoderDistance() {
    	double encDist = enc.getDistance();
    	double rotations = encDist/497.0;
    	double dist = rotations * Math.PI * WINCH_DIAMETER;
    	return dist;
    }
    
    public void resetEncoder(){
    	enc.reset();
    }
    
    public void moveUp(double distance) {
    	
    }
}

