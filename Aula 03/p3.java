//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p3.java
//Traçando um triângulo equilátero com a classe MovePilot
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class p3 {
	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);
	
	static double WHEEL_DIAMETER = 3.1;
	static double OFFSET = 9;
	
	public static void main(String[] args) {
		// encontrar ev3
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		
		LCD.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		MovePilot pilot = getPilot(LEFT_MOTOR, RIGHT_MOTOR, WHEEL_DIAMETER, OFFSET);
		
		// repetir por três vezes
		for(int i = 0; i < 3; i++) {
			// andar 100cm
			pilot.travel(100);
			
			// rotacionar 120º graus
			pilot.rotate(120);
		}
		
		// bloquear a execução até que uma tecla seja pressionada
		buttons.waitForAnyPress();
	}
	
	public static MovePilot getPilot(EV3LargeRegulatedMotor LEFT_MOTOR, EV3LargeRegulatedMotor RIGHT_MOTOR, double WHEEL_DIAMETER, double OFFSET) {
		Wheel wheel1 = WheeledChassis.modelWheel(LEFT_MOTOR, WHEEL_DIAMETER).offset(-OFFSET);
		Wheel wheel2 = WheeledChassis.modelWheel(RIGHT_MOTOR, WHEEL_DIAMETER).offset(OFFSET);
		
		// declaração do vetor de rodas
		Wheel vetorRodas[] = { wheel1, wheel2 };
		
		// instanciação do chassi
		Chassis chassis = new WheeledChassis(vetorRodas, WheeledChassis.TYPE_DIFFERENTIAL);
		
		// instanciação do piloto
		MovePilot pilot = new MovePilot(chassis);
		
		return pilot;
	}

}