//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 05 - EV3Hardware.java
//*************************************************************************
package lejos.botcontroller;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.Port;
import lejos.utility.Stopwatch;

public class EV3Hardware {
	private EV3 ev3brick;
	private Keys buttons;
	private TextLCD display;
	private Stopwatch stopwatch;
	
	public EV3Hardware() {
		ev3brick = (EV3) BrickFinder.getLocal();
		buttons = ev3brick.getKeys();
		display = ev3brick.getTextLCD();
		stopwatch = new Stopwatch();
	}
	
	public EV3 getEv3brick() {
		return ev3brick;
	}
	
	public Keys getButtons() {
		return buttons;
	}
	
	public TextLCD getDisplay() {
		return display;
	}
	
	public Stopwatch getStopwatch() {
		return stopwatch;
	}
	
	public void resetStopwatch() {
		stopwatch.reset();
	}	
	
	public int elapsedStopwatch() {
		return stopwatch.elapsed();
	}
	
    public Port getPort(String portName) {
		return ev3brick.getPort(portName);
	}

	public boolean ESCNotPressed() {
		if(buttons.readButtons() != Keys.ID_ESCAPE) {
			return true;
		} else {
			return false;
		}
	}
}