package entities;

public class Circulo extends Figura{
	private double raio;
	
	public Circulo() {
		
	}

	public Circulo(String cor, double raio) {
		super(cor);
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double area() {
		return Math.PI * raio * raio;
	}
}