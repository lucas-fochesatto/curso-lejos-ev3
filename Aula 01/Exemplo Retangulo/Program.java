package application;

import java.util.Scanner;

import entities.Rectangle;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rectangle X, Y;
		
		X = new Rectangle();
		Y = new Rectangle();
		
		System.out.println("Digite o comprimento e a altura do retângulo X:");
		X.comprimento = sc.nextDouble();
		X.altura = sc.nextDouble();
		
		System.out.println("Digite o comprimento e a altura do retângulo Y:");
		Y.comprimento = sc.nextDouble();
		Y.altura = sc.nextDouble();
				
		double areaX = X.comprimento * X.altura;
		double areaY = Y.comprimento * Y.altura;
		
		System.out.println("Área do retângulo X: " + areaX);
		System.out.println("Área do retângulo Y: " + areaY);
		
		if(areaY > areaX) {
			System.out.println("Maior área: Y");
		} else {
			System.out.println("Maior área: X");
		}
	}
}