//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - EV3Movement.java
//*************************************************************************
package lejos.botcontroller;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;

public class EV3Movement {
	private EV3LargeRegulatedMotor LEFT_MOTOR;
	private EV3LargeRegulatedMotor RIGHT_MOTOR;

	private double WHEEL_DIAMETER;
	private double OFFSET;
	private Wheel leftWheel;
	private Wheel rightWheel;
	
	private Chassis chassis;
	
	private MovePilot pilot;
	
	private Navigator navigator;

	public EV3Movement(Port PORTT_LEFT, Port PORT_RIGHT, double WHEEL_DIAMETER, double OFFSET) {
		LEFT_MOTOR = new EV3LargeRegulatedMotor(PORTT_LEFT);
		RIGHT_MOTOR = new EV3LargeRegulatedMotor(PORT_RIGHT);
		
		leftWheel = WheeledChassis.modelWheel(LEFT_MOTOR, WHEEL_DIAMETER).offset(-OFFSET);
		rightWheel = WheeledChassis.modelWheel(RIGHT_MOTOR, WHEEL_DIAMETER).offset(OFFSET);
		
		Wheel[] wheelArray = new Wheel[] { leftWheel, rightWheel };
		
		chassis = new WheeledChassis(wheelArray, WheeledChassis.TYPE_DIFFERENTIAL);
		
		pilot = new MovePilot(chassis);
		
		navigator = new Navigator(pilot);
	}
	
	public EV3LargeRegulatedMotor getLEFT_MOTOR() {
		return LEFT_MOTOR;
	}
	
	public EV3LargeRegulatedMotor getRIGHT_MOTOR() {
		return RIGHT_MOTOR;
	}
	
	public double getWHEEL_DIAMETER() {
		return WHEEL_DIAMETER;
	}
	
	public double getOFFSET() {
		return OFFSET;
	}
	
	public Wheel getLeftWheel() {
		return leftWheel;
	}
	
	public Wheel getRightWheel() {
		return rightWheel;
	}
	
	public Chassis getChassis() {
		return chassis;
	}
	
	public MovePilot getPilot() {
		return pilot;
	}
	
	public Navigator getNavigator() {
		return navigator;
	}

	public void travel(double distance) {
		pilot.travel(distance);
	}
	
	public void moveForward() {
		if(!pilot.isMoving()) pilot.forward();
	}
	
	public void moveBackward() {
		if(!pilot.isMoving()) pilot.backward();
	}
	
	public void awaitForStop() {
		pilot.stop();
		while(pilot.isMoving());
	}
	 
	public void rotate(int angle) {
		pilot.rotate(angle);
	}
}