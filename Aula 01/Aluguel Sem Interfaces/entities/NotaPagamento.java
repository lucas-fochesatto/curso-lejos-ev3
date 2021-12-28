package entities;

public class NotaPagamento {
	private double pagamentoBasico;
	private double imposto;
	
	public NotaPagamento() {
		
	}

	public NotaPagamento(double pagamentoBasico, double imposto) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	public double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getPagamentoTotal() {
		return pagamentoBasico + imposto;
	}

}