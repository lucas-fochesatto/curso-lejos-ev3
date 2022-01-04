//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - Quadrado.java
//*************************************************************************
import lejos.botcontroller.EV3Hardware;
import lejos.botcontroller.EV3Movement;

public class Quadrado {
	
	static EV3Hardware hardware = new EV3Hardware();
	static EV3Movement movement = new EV3Movement(hardware.getPort("A"), hardware.getPort("D"), 3.1, 9);

	public static void main(String[] args) {
		// bloquear a execução até que um botão seja pressionado
		hardware.getDisplay().drawString("Aperte para iniciar", 0, 0);
		hardware.getButtons().waitForAnyPress();

		// repetir por quatro vezes
		for(int i = 0; i < 4; i++) {
			// mover 50cm
			movement.travel(50);
			
			// girar 90 graus
			movement.rotate(90);
		}
	}
}