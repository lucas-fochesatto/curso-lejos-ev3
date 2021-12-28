//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p1.java
//Teste simples de motores
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort; 

public class p1 {

	public static void main(String[] args) {
		EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.C);

		//encontra ev3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		// instanciar objetos de botoes e display
		Keys buttons = ev3brick.getKeys();
		TextLCD display = ev3brick.getTextLCD();
		
		// bloquear a execução até que um botão seja pressionado
		display.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		// mover para frente
		LEFT_MOTOR.forward();
		RIGHT_MOTOR.forward();
		display.drawString("FRENTE", 0, 1);
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		// mover para trás
		LEFT_MOTOR.backward();
		RIGHT_MOTOR.backward();
		display.drawString("TRAS", 0, 2);
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		// stop
		LEFT_MOTOR.stop();
		RIGHT_MOTOR.stop();
		display.drawString("STOPPED", 0, 3);
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress(); 
	}
}