//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p6.java
//Fazer o robo andar para frente por 10s e medir o quão longe ele andou
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
import lejos.utility.Stopwatch; 

public class p6 {
	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);
	
	public static void main(String[] args) {
		// encontrar ev3
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		
		LCD.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		// instanciar cronômetro
		Stopwatch sw = new Stopwatch();
		
		// setar velocidade 360º/s
		LEFT_MOTOR.setSpeed(360);
		RIGHT_MOTOR.setSpeed(360);
		
		// mover motores para frente
		LEFT_MOTOR.forward();
		RIGHT_MOTOR.forward();
		
		// zerar o cronômetro
		sw.reset();
		
		// travar a execução até passar 10s
		while(sw.elapsed() < 10000) {
			LCD.drawString("" + sw.elapsed(), 0, 1);
		}
		
		// parar os motores
		LEFT_MOTOR.stop();
		RIGHT_MOTOR.stop();
		
		// esperar pararem completamente
		while(LEFT_MOTOR.isMoving());
		while(RIGHT_MOTOR.isMoving());
		
		// calcular o comprimento da circunferência
		double circumferenceLength = 3.1 * Math.PI;
		// calcular a velocidade média:
		// comprimento da circunferência dividido pelo número de rotações por segundo
		// podemos calcular o numero de rotações por segundo dividindo a velocidade atual por 360
		double averageSpeed = circumferenceLength / (LEFT_MOTOR.getSpeed() / 360);
		// calcular a distância:
		// distância = velocidade * tempo
		double distance = averageSpeed * sw.elapsed() / 1000;
		 
		// imprimir a distância e depois esperar um botão para finalizar
		LCD.drawString("Dist: " + String.format("%.2f", distance) + "cm", 0, 2);
		
		buttons.waitForAnyPress();
	}

}
