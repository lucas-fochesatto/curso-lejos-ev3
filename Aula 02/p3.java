//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p3.java
//Teste de precisão dos motores
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class p3 {

	public static void main(String[] args) {
		EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);
		
		// encontra ev3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		TextLCD display = ev3brick.getTextLCD();
		
		display.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		// setar a velocidade do motor em 720
		RIGHT_MOTOR.setSpeed(720);
		
		// rotacionar uma volta completa
		RIGHT_MOTOR.rotate(360);
		
		// apresentar a contagem do tacômetro na linha 1
		display.drawString("Leitura Tacometro: " + RIGHT_MOTOR.getTachoCount(), 0, 0);
		
		// rotacionar para o ângulo de 360
		RIGHT_MOTOR.rotateTo(360);
		
		// apresentar a contagem do tacômetro na linha 2
		display.drawString("Leitura Tacometro: " + RIGHT_MOTOR.getTachoCount(), 0, 1);

		buttons.waitForAnyPress();
		display.clear();
	}
}