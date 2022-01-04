//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - HelloWorld.java
//*************************************************************************
import lejos.botcontroller.EV3Hardware;

public class HelloWorld {

	static EV3Hardware hardware = new EV3Hardware();
	
	public static void main(String[] args) {
		// imprime Hello World
		hardware.getDisplay().drawString("Hello World", 0, 0);
		
		// bloqueia a execução até que um botão seja pressionado
		hardware.getButtons().waitForAnyPress();
	}
}