package entities;

public class SavingsAccount extends Account{
	private double taxaJuros;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int numero, String proprietario, double saldo, double taxaJuros) {
		super(numero, proprietario, saldo);
		this.taxaJuros = taxaJuros;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public void atualizarSaldo(double saldo) {
		saldo += saldo * taxaJuros;
	}
}