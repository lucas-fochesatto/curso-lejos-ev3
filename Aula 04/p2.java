//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 04 - p2.java
//MInformações com o sensor de distância
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Stopwatch;

public class p2 {
	// instanciar os sensores
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
	static EV3UltrasonicSensor ultraSensor = new EV3UltrasonicSensor(SensorPort.S4);
	
	public static void main(String[] args) throws Exception{
		LCD.drawString("Aperte para inciar", 0, 0);
		
		// escolher os modos de medida dos sensores
		SampleProvider touchMode = touchSensor.getTouchMode();
		SampleProvider distMode = ultraSensor.getDistanceMode();
		
		// criar o vetor para armazenar as leituras
		float[] vetorSamples = new float[touchMode.sampleSize() + distMode.sampleSize()];
		
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
			// atualizar leitura dos sensores
			// armazenando toque na posição 0 e distância na posição 1
			touchMode.fetchSample(vetorSamples, 0);
			distMode.fetchSample(vetorSamples, 1);
			
			// imprimir as informações
			LCD.drawString("Toque: " + vetorSamples[0], 0, 0);
			LCD.drawString("Dist: " + String.format("%.2f", vetorSamples[1] * 100) + "cm", 0, 1);
			
			// pausar a execução por 100ms
			Thread.sleep(100);
			LCD.clear();
		}
	}
}
