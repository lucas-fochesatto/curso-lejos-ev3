package services;

import entities.AluguelCarro;
import entities.NotaPagamento;

public class ServicoAluguel {
	private double precoDia;
	private double precoHora;
	
	private ServicoImposto servicoImposto;

	public ServicoAluguel(double precoDia, double precoHora, ServicoImposto servicoImposto) {
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.servicoImposto = servicoImposto;
	}
	
	public void processarNotaPagamento(AluguelCarro aluguelCarro) {
		long t1 = aluguelCarro.getInicio().getTime();
		long t2 = aluguelCarro.getFim().getTime();
		
		double horas = (double) (t2 - t1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		
		if(horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoHora;
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoDia;
		}
		
		double imposto = servicoImposto.imposto(pagamentoBasico);
		
		aluguelCarro.setNotaPagamento(new NotaPagamento(pagamentoBasico, imposto));
	}
}