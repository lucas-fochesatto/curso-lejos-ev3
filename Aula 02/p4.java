//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p4.java
//Interromper os motores usando botões
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.Sound;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort; 

public class p4 {

	public static void main(String[] args) {
		EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
		
		// encontra ev3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		TextLCD display = ev3brick.getTextLCD();
		
		// apitar dois beeps antes de iniciar o programa
		Sound.twoBeeps();
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		// rotacionar 7200 graus com o retorno imediato do método
		LEFT_MOTOR.rotate(7200, true);

		// retorna verdadeiro se o motor está em movimento
		while(LEFT_MOTOR.isMoving()) {
			// exibe e atualiza a leitura do tacômetro na tela:
			display.drawString("Leitura 1: " + LEFT_MOTOR.getTachoCount(), 0, 0);
			
			// se qualquer botão for pressionado, parar o motor
			if(buttons.readButtons() > 0) {
				LEFT_MOTOR.stop();
			}
		}
		
		// esperar o motor parar completamente
		while (LEFT_MOTOR.getRotationSpeed() > 0);
		
		// exibe a leitura do tacômetro depois do motor parado completamente
		display.drawString("Leitura 2: " + LEFT_MOTOR.getTachoCount(), 0, 1);
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
	}

}