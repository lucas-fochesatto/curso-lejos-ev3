//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 04 - p4.java
//Informações com o sensor de cor
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class p4 {
	// instanciar o sensor de luz ligado na porta 3
	static EV3ColorSensor lightSensor = new EV3ColorSensor(SensorPort.S3);

	public static void main(String[] args) {
		// instanciar brick e botoes
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		Keys buttons = ev3brick.getKeys();

		// declarar os tipos de ID e RGB
		SensorMode colorIDMode = lightSensor.getColorIDMode();
		SensorMode colorRGBMode = lightSensor.getRGBMode();
		
		// declaração do vetor de samples
		float[] vetorSamples = new float[colorIDMode.sampleSize() + colorRGBMode.sampleSize()];
		
		// bloquear a execução até que um botão seja pressionado
		LCD.drawString("Aperte para medir", 0, 0);
		buttons.waitForAnyPress();
		
		// realizar a medida por ID
		colorIDMode.fetchSample(vetorSamples, 0);
		LCD.drawString("Medida realizada", 0, 1);
		
		// bloquear a execução até que um botão seja pressionado
		LCD.drawString("Aperte para medir", 0, 3);
		buttons.waitForAnyPress();
		
		// realizar a medida por RGB
		colorIDMode.fetchSample(vetorSamples, 1);
		LCD.drawString("Medida realizada", 0, 4);
		
		// bloquear a execução até que um botão seja pressionado
		LCD.drawString("Aperte para", 0, 6);
		LCD.drawString("continuar", 0, 7);
		buttons.waitForAnyPress();
		
		// limpar a tela
		LCD.clear();
		
		// imprimir as leituras
		LCD.drawString("Leitura 1: " + vetorSamples[0], 0, 0);
		LCD.drawString("Leitura 2: ", 0, 2);
		LCD.drawString("R: " + vetorSamples[1], 0, 3);
		LCD.drawString("G: " + vetorSamples[2], 0, 4);
		LCD.drawString("B: " + vetorSamples[3], 0, 5);
		
		// bloquear a execução até que um botão seja pressionado
		buttons.waitForAnyPress();
	}

}