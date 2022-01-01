//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 04 - p3.java
//Informações com o sensor de luz
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class p3 {
	// instanciar o sensor de luz ligado na porta 3
	static EV3ColorSensor lightSensor = new EV3ColorSensor(SensorPort.S3);
	
	public static void main(String[] args) throws Exception {
		// instanciar brick e botoes
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		Keys buttons = ev3brick.getKeys();

		// ativar o modo de medir luz ambiente
		SensorMode ambientMode = lightSensor.getAmbientMode();
		
		// criação do vetor de samples, no qual a leitura do sensor será armazenada
		float[] vetorSamples = new float[ambientMode.sampleSize()];
		
		// bloquear a execução enquanto o usuário não pressionar nenhum botão
		while(buttons.readButtons() == 0) {
			// armazenar a leitura do sensor no vetorSamples, posição zero
			ambientMode.fetchSample(vetorSamples, 0);
			
			// apresentar a leitura
			LCD.drawString("Luz: " + vetorSamples[0], 0, 0);
		
			// pausar a execução por 100ms
			Thread.sleep(100);
		}
	}
}
