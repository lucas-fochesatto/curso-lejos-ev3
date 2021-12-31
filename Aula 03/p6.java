//*************************************************************************
//Lucas Fochesatto e Victor Oliva - Curso Introdutório de Robótica para OBR
//Aula 03 - p6.java
//Fila de waypoints no navegador
//Créditos ao autor Wei Lu pela criação do código
//Referência: Beginning Robotics Programming in Java with LEGO Mindstorms
//*************************************************************************
package application;

import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;

public class p6 {
	static EV3LargeRegulatedMotor LEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.A);
	static EV3LargeRegulatedMotor RIGHT_MOTOR = new EV3LargeRegulatedMotor(MotorPort.D);
	
	static double WHEEL_DIAMETER = 3.1;
	static double OFFSET = 9;
	
	public static void main(String[] args) {
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		
		Keys buttons = ev3brick.getKeys();
		
		LCD.drawString("Aperte para iniciar", 0, 0);
		buttons.waitForAnyPress();
		
		// instanciar o piloto
		MovePilot pilot = getPilot(LEFT_MOTOR, RIGHT_MOTOR, WHEEL_DIAMETER, OFFSET);

		// instanciar o navegador
		Navigator nav = new Navigator(pilot);
		
		// definindo os waypoints
		// A(0,0) B(50,50) C(-50,50)
		Waypoint A = new Waypoint(0, 0);
		Waypoint B = new Waypoint(50, 50);
		Waypoint C = new Waypoint(-50, 50);
		
		// adicionando na fila
		nav.addWaypoint(B);
		nav.addWaypoint(A);
		nav.addWaypoint(C);
		nav.addWaypoint(A);

		// mandar o robo executar a fila
		nav.followPath();
		
		// instanciar o waypoint atual que o navegador está indo
		Waypoint currWp = new Waypoint(0, 0);
		int x, y;
		
		// travar a execução do algoritmo enquanto estiver se movendo
		while(nav.isMoving()) {
			// obter o waypoint atual que está se dirigindo
			currWp = nav.getWaypoint();
			
			// obter as coordenadas x e y
			x = (int) currWp.getX();
			y = (int) currWp.getY();
			
			// imprimir as coordenadas x e y
			LCD.drawString("Destino: (" + x + "," + y + ")", 0, 1);
		}
	}
	
	public static MovePilot getPilot(EV3LargeRegulatedMotor LEFT_MOTOR, EV3LargeRegulatedMotor RIGHT_MOTOR, double WHEEL_DIAMETER, double OFFSET) {
		Wheel wheel1 = WheeledChassis.modelWheel(LEFT_MOTOR, WHEEL_DIAMETER).offset(-OFFSET);
		Wheel wheel2 = WheeledChassis.modelWheel(RIGHT_MOTOR, WHEEL_DIAMETER).offset(OFFSET);
		
		// declaração do vetor de rodas
		Wheel vetorRodas[] = { wheel1, wheel2 };
		
		// instanciação do chassi
		Chassis chassis = new WheeledChassis(vetorRodas, WheeledChassis.TYPE_DIFFERENTIAL);
		
		// instanciação do piloto
		MovePilot pilot = new MovePilot(chassis);
		
		return pilot;
	}
}