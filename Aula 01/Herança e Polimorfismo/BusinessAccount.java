package entities;

public class BusinessAccount extends Account{
	private double limiteEmprestimo;
	
	public BusinessAccount() {
		super();
	}
	
	public BusinessAccount(int numero, String proprietario, double saldo, double limiteEmprestimo) {
		super(numero, proprietario, saldo);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	public double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	public void emprestimo(double valor) {
		if(valor <= limiteEmprestimo) {
			saldo += valor - 10.0;
		}
	}
}