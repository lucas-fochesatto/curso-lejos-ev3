//************************************************************ 
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//Exemplo para escrever Hello World no display do EV3 brick
//************************************************************

package application;

//importar pacotes de hardware EV3 para encontrar o brick,
//acessar os botões e o display LCD
import lejos.hardware.ev3.EV3;
import lejos.hardware.BrickFinder; 
import lejos.hardware.Keys;
import lejos.hardware.lcd.TextLCD;

public class HelloWorld {

	public static void main(String[] args) {
		// encontrar o EV3 brick
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		// instanciar a classe LCD para o display
		// instanciar a classe Keys para pegar os botões do brick
		Keys buttons = ev3brick.getKeys();
		TextLCD display = ev3brick.getTextLCD();
		
		// desenhar texto no display baseado nas coordenadas x e y
		display.drawString("Hello World", 2, 4);
		
		// sair do programa após pressionar qualquer botão
		buttons.waitForAnyPress();
	}
}