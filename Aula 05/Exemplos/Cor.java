//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - Cor.java
//*************************************************************************
import lejos.botcontroller.EV3Hardware;
import lejos.botcontroller.EV3Sensors;

public class Cor {

	static EV3Hardware hardware = new EV3Hardware();
	static EV3Sensors sensors = new EV3Sensors(null, null, hardware.getPort("S1"), null);
	
	public static void main(String[] args) {
		hardware.getDisplay().drawString("Posicione o sensor", 0, 0);
		hardware.getDisplay().drawString("Aperte para ler", 0, 1);
		hardware.getButtons().waitForAnyPress();
		
		float colorID = sensors.getColorIDSample1();
		
		hardware.getDisplay().drawString("Leitura: " + sensors.getColorName((int) colorID), 0, 3);
		
		hardware.getButtons().waitForAnyPress();
	}

}