package entities;

import java.util.Date;

public class AluguelCarro {
	private Date inicio;
	private Date fim;
	
	private Veiculo veiculo;
	private NotaPagamento notaPagamento;
	
	public AluguelCarro() {
	}

	public AluguelCarro(Date inicio, Date fim, Veiculo veiculo, NotaPagamento notaPagamento) {
		this.inicio = inicio;
		this.fim = fim;
		this.veiculo = veiculo;
		this.notaPagamento = notaPagamento;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaPagamento getNotaPagamento() {
		return notaPagamento;
	}

	public void setNotaPagamento(NotaPagamento notaPagamento) {
		this.notaPagamento = notaPagamento;
	}
}