package entities;

public abstract class FiguraAbstrata implements Figura{
	private String cor;

	public FiguraAbstrata() {
		
	}
	
	public FiguraAbstrata(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}