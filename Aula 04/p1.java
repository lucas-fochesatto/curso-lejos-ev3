//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 04 - p1.java
//MInformações com o sensor de toque
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Stopwatch;

public class p1 {
	// instanciar o sensor como constante
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);

	public static void main(String[] args) throws Exception {
		System.out.println("Pressione o sensor\npara iniciar");
		
		// pegar o modo de toque
		SensorMode touchMode = touchSensor.getTouchMode();
		
		// criar o vetor para armazenar as leituras
		float[] vetorSamples = new float[touchMode.sampleSize()];
		
		// bloquear a execução enquanto o sensor de toque não retornar 1
		while(vetorSamples[0] != 1) {
			// atualizar a leitura
			touchMode.fetchSample(vetorSamples, 0);
		}
		
		LCD.clear();
		
		// instanciar o cronômetro
		Stopwatch sw = new Stopwatch();
		
		// executar a lógica por 20 segundos
		while(sw.elapsed() <= 20000) {
			// imprimindo a leitura
			LCD.drawString("Leitura: " + vetorSamples[0], 0, 0);
			
			// atualizar a leitura
			touchMode.fetchSample(vetorSamples, 0);
			
			// pausar a execução por 100ms
			Thread.sleep(100);
		}
	}
}