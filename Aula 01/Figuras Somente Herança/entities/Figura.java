package entities;

public abstract class Figura {
	private String cor;
	
	public Figura() {
		
	}

	public Figura(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public abstract double area();
}
