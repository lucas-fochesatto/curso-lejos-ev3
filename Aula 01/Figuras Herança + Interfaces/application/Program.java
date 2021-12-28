package application;

import entities.Circulo;
import entities.Figura;
import entities.Retangulo;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura f1 = new Circulo("PRETO", 2.0);
		Figura f2 = new Retangulo("BRANCO", 3.0, 4.0);
		
		System.out.println("Cor do círculo: " + f1.getCor());
		System.out.println("Área do círculo: " + String.format("%.3f", f1.area()));
		System.out.println("Cor do retângulo: " + f2.getCor());
		System.out.println("Área do retângulo: " + String.format("%.3f", f2.area()));
	}

}