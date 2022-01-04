//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - EV3Sensors.java
//*************************************************************************
package lejos.botcontroller;

import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class EV3Sensors {
	// exemplo para 1 sensor de toque, 1 sensor ultrassônico e 2 sensores de cor
	private EV3TouchSensor touchSensor;
	
	private EV3UltrasonicSensor ultraSensor;
	
	private EV3ColorSensor colorSensor1;
	private EV3ColorSensor colorSensor2;
	
	public EV3Sensors(Port touchPort, Port ultraPort, Port color1Port, Port color2Port) {
		Sound.twoBeeps();
		LCD.drawString("Verifique: ", 0, 0);
		if(touchPort != null) LCD.drawString("Toque: " + touchPort.getName(), 0, 1);
		if(ultraPort != null) LCD.drawString("Ultra: " + ultraPort.getName(), 0, 2);
		if(color1Port != null) LCD.drawString("Cor 1: " + color1Port.getName(), 0, 3);
		if(color2Port != null) LCD.drawString("Cor 2: " + color2Port.getName(), 0, 4);
		
		LCD.drawString("Confirma?", 0, 6);
		
		if(Button.waitForAnyPress() == Keys.ID_ENTER) {
			LCD.clear();
			
			try {
				touchSensor = new EV3TouchSensor(touchPort);
			} catch(NullPointerException e) {
				LCD.drawString("Faltando Toque", 0, 0);
			}
			
			try {
				ultraSensor = new EV3UltrasonicSensor(ultraPort);			
			} catch(NullPointerException e) {
				LCD.drawString("Faltando Ultra", 0, 1);
			}
			
			try {			
				colorSensor1 = new EV3ColorSensor(color1Port);
			} catch(NullPointerException e) {
				LCD.drawString("Faltando Cor 1", 0, 2);
			}
			
			try {
				colorSensor2 = new EV3ColorSensor(color2Port);
			} catch(NullPointerException e) {
				LCD.drawString("Faltando Cor 2", 0, 3);
			}
			
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				
			}
			
			LCD.clear();
		} else {
			System.exit(0);
		}
	}
	
	public EV3TouchSensor getTouchSensor() {
		return touchSensor;
	}
	
	public EV3UltrasonicSensor getUltraSensor() {
		return ultraSensor;
	}
	
	public EV3ColorSensor getColorSensor1() {
		return colorSensor1;
	}
	
	public EV3ColorSensor getColorSensor2() {
		return colorSensor2;
	}

	public float getTouchSample() {
		return getSampleArray(touchSensor.getTouchMode())[0];
	}
	
	public float getDistanceSample() {
		return getSampleArray(ultraSensor.getDistanceMode())[0];
	}
	
	public float getLightSample1() {
		return getSampleArray(colorSensor1.getAmbientMode())[0];
	} 
	
	public float getColorIDSample1() {
		return getSampleArray(colorSensor1.getColorIDMode())[0];
	}
	
	public float[] getColorRGBSample1() {
		return getSampleArray(colorSensor1.getRGBMode());
	}
	
	public float getLightSample2() {
		return getSampleArray(colorSensor2.getAmbientMode())[0];
	} 
	
	public float getColorIDSample2() {
		return getSampleArray(colorSensor2.getColorIDMode())[0];
	}
	
	public float[] getColorRGBSample2() {
		return getSampleArray(colorSensor2.getRGBMode());
	}
	
	public static float[] getSampleArray(SampleProvider mode) {
		// declaração do vetor de samples
		float[] vetorSamples = new float[mode.sampleSize()];
	
		// realizar a leitura e armazenar a partir da posição zero do vetor
		mode.fetchSample(vetorSamples, 0);
		
		return vetorSamples;
	}
	
	public String getColorName(int colorID) {
		switch(colorID) {
			case 7:
				return "BLACK";
			case 2:
				return "BLUE";
			case 13:
				return "BROWN";
			case 12:
				return "CYAN";
			case 11:
				return "DARK_GRAY";
			case 9:
				return "GRAY";
			case 1:
				return "GREEN";
			case 10:
				return "LIGHT_GRAY";
			case 4:
				return "MAGENTA";
			case -1:
				return "NONE";
			case 5:
				return "ORANGE";
			case 8:
				return "PINK";
			case 0:
				return "RED";
			case 6:
				return "WHITE";
			case 3:
				return "YELLOW";
			default:
				return "NOT IDENTIFIED";
		}	
	}
}