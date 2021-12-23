package entities;

public class Rectangle {
	public double comprimento;
	public double altura;
	
	public double area() {
		double result = comprimento * altura;
		
		return result;
	}
}