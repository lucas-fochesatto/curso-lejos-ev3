//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//p5.java
//Comparação entre as velocidades dos motores
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.Sound;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Stopwatch;

public class p5 {
	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);

	public static void main(String[] args) {
		// encontra ev3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		
		// apitar dois beeps antes de iniciar o programa
		Sound.twoBeeps();
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
		
		// instanciar uma classe Stopwatch para configurar o cronômetro
		Stopwatch sw = new Stopwatch(); 
		
		// setar a velocidade do motor para 1 volta/s
		LEFT_MOTOR.setSpeed(360);
		RIGHT_MOTOR.setSpeed(360); 
		
		// fazer os motores andarem para frente
		LEFT_MOTOR.forward();
		RIGHT_MOTOR.forward();
		 
		// variáveis para determinar a diferença máxima entre tacômetros
		int maxTachoCountDiff = Integer.MIN_VALUE; 
		int currTachoCountDiff; 
		
		// variável para controlar a linha que deve ser impressa
		int tachoRow = 0;
		
		// realizando as repetições para o teste
		for(int i = 0; i < 4; i++) {
			//reiniciar o relógio
			sw.reset();
			//esperar 2 segundos (ou 2000ms)
			while(sw.elapsed() < 2000) {
				
			}
			
			// variáveis para guardar as contagens dos tacômetros dos dois motores
			int tachoCountLeft = LEFT_MOTOR.getTachoCount();
			int tachoCountRight = RIGHT_MOTOR.getTachoCount();
			
			// exibe as contagens dos tacômetros
			LCD.drawString("M1: " + tachoCountLeft + " M2: " + tachoCountRight, 0, tachoRow);
			
			// retorna a diferença entre as contagens
			currTachoCountDiff = Math.abs(tachoCountLeft - tachoCountRight); 
			
			// se a diferença atual ultrapassar a diferença máxima encontrada
			// até então, atualizar o valor máximo
			if(currTachoCountDiff > maxTachoCountDiff) {
				maxTachoCountDiff = currTachoCountDiff;
			}
			
			// incrementar a contagem da linha
			tachoRow++;
		}
		
		// parar os motores
		LEFT_MOTOR.stop();
		RIGHT_MOTOR.stop();
		
		// exibe a diferença máxima entre as contagens dos tacômetros
		// depois, espera um botão para finalizar
		LCD.drawString("Max diff: " + maxTachoCountDiff, 0, tachoRow);
		buttons.waitForAnyPress(); 
	}
}