//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p2.java
//Teste de inércia de motores
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

public class p2 {
	public static void main(String[] args) {
		EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A); 
		
		// encontra ev3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		// instanciar objetos de botoes e display
		Keys buttons = ev3brick.getKeys();
		TextLCD display = ev3brick.getTextLCD();
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		// atribuir a velocidade do motor para 720º/s
		LEFT_MOTOR.setSpeed(720);
		
		// mover para frente
		LEFT_MOTOR.forward();
		
		// contador para a contagem do número de graus rotacionados
		int count = 0;
		
		// mover até que o motor tenha rotacionado 720º
		while(count < 720) {
			count = LEFT_MOTOR.getTachoCount();
		}
		
		// parar o motor
		LEFT_MOTOR.stop();
		
		// apresentar a leitura do tacômetro
		display.drawString("Leitura tacometro: " + count, 0, 0);
		
		// esperar até que o motor tenha realmente parado e exibir a contagem do tacômetro
		// este número será maior que o anterior devido à inércia do motor
		
		while(LEFT_MOTOR.getRotationSpeed() > 0) {
			
		}
		
		display. drawString("Leitura tacometro: " + LEFT_MOTOR.getTachoCount(), 0, 1); 
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		display.clear();
	}
}