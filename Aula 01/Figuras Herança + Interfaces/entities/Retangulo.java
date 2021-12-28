package entities;

public class Retangulo extends FiguraAbstrata{
	private double comprimento;
	private double altura;
	
	public Retangulo() {
		
	}

	public Retangulo(String cor, double comprimento, double altura) {
		super(cor);
		this.comprimento = comprimento;
		this.altura = altura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	public double area() {
		return comprimento * altura;
	}
}
