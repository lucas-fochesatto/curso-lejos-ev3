package application;

import entities.SampleReader;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class Teste {
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
	static EV3UltrasonicSensor ultraSensor = new EV3UltrasonicSensor(SensorPort.S2);
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
	
	public static void main(String[] args) throws Exception {
		// bloquear a execução até que pressione o sensor de toque
		LCD.drawString("Pressione o sensor", 0, 0);
		while(SampleReader.getSampleArray(touchSensor.getTouchMode())[0] == 0);
		
		// limpar a tela
		LCD.clear();
		
		// esperar 1 segundo
		Thread.sleep(1000);
		
		// executar a lógica enquanto o sensor não for pressionado
		while(SampleReader.getSampleArray(touchSensor.getTouchMode())[0] == 0) {
			LCD.drawString("Dist: " + SampleReader.getSampleArray(ultraSensor.getDistanceMode())[0], 0, 0);
			
			LCD.drawString("Cor: " + SampleReader.getSampleArray(colorSensor.getColorIDMode())[0], 0, 2);
		
			// pausar por 100ms
			Thread.sleep(100);
			
			LCD.clear();
		}
	}
}