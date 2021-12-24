package entities;

public class Account {
	private int numero;
	private String proprietario;
	private double saldo;

	public Account(int numero, String proprietario) {
		this.numero = numero;
		this.proprietario = proprietario;
	}
	
	public Account(int numero, String proprietario, double depositoInicial) {
		this.numero = numero;
		this.proprietario = proprietario;
		depositar(depositoInicial);
	}

	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		this.saldo -= valor + 5.0;
	}
	
	public String toString() {
		return "Conta "
			+ numero
			+ ", Proprietário: "
			+ proprietario
			+ ", Saldo: $ "
			+ saldo;
	}

}