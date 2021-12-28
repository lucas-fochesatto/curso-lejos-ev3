package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.AluguelCarro;
import entities.Veiculo;
import services.ServicoAluguel;
import services.ServicoImpostoBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados da locação");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Data de retirada (dd/MM/yyyy hh:mm): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Data de devolução (dd/MM/yyyy hh:mm): ");
		Date fim = sdf.parse(sc.nextLine());
		
		AluguelCarro ac = new AluguelCarro(inicio, fim, new Veiculo(modeloCarro), null);
		
		System.out.print("Digite o preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Digite o preço por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoDia, precoHora, new ServicoImpostoBrasil());
		
		servicoAluguel.processarNotaPagamento(ac);
		
		System.out.println("NOTA DE PAGAMENTO:");
		System.out.println("Pagamento básico: " + ac.getNotaPagamento().getPagamentoBasico());
		System.out.println("Imposto: " + ac.getNotaPagamento().getImposto());
		System.out.println("Total do pagamento: " + ac.getNotaPagamento().getPagamentoTotal());
		
		sc.close();
	}
}