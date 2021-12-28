package services;

public class ServicoImpostoBrasil implements ServicoImposto {
	public double imposto(double valor) {
		//20% até 100 reais
		//15% para valores acima de 100 reais
		
		if(valor <= 100.0) {
			return valor * 0.2;
		} else {
			return valor * 0.15;
		}
	}
}