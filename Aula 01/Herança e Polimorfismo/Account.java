package entities;

public class Account {
	private int numero;
	private String proprietario;
	protected double saldo;

	public Account() {
	}
	
	public Account(int numero, String proprietario, double saldo) {
		this.numero = numero;
		this.proprietario = proprietario;
		this.saldo = saldo;
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
		saldo += valor;
	}
	
public void sacar(double valor) {
	saldo -= valor + 5.0;
}
}