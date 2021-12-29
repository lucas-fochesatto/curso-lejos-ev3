//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p1.java
//Movimentos básicos da classe de piloto
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

public class p1 {
	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);
	
	public static void main(String[] args) {
		// encontrar ev3
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		
		LCD.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		// instanciar as rodas
		// nesse caso, 3.1cm de diâmetro
		// 9cm da distância da roda ate o eixo central do robô
		Wheel wheel1 = WheeledChassis.modelWheel(LEFT_MOTOR, 3.1).offset(-9);
		Wheel wheel2 = WheeledChassis.modelWheel(RIGHT_MOTOR, 3.1).offset(9);
		
		// declaração do vetor de rodas
		Wheel vetorRodas[] = { wheel1, wheel2 };
		
		// instanciação do chassi
		Chassis chassis = new WheeledChassis(vetorRodas, WheeledChassis.TYPE_DIFFERENTIAL);
		
		// instanciação do piloto
		MovePilot pilot = new MovePilot(chassis);
		
		// andar 100cm
		pilot.travel(100);
		
		// rotacionar 90 graus
		pilot.rotate(90);
		
		// bloquear a execução até que uma tecla seja pressionada
		buttons.waitForAnyPress();
	}

}
