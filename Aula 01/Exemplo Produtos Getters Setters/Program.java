package application;

import java.util.Scanner;
import entities.Product;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do produto: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();

		System.out.print("Preço: ");
		double preco = sc.nextDouble();

		System.out.print("Quantidade em estoque: ");
		int quantidade = sc.nextInt();
		System.out.println();

		Product produto = new Product(nome, preco, quantidade);

		System.out.println("Dados do produto: " + produto);
		System.out.println();

		System.out.print("Digite o número de produtos que devem ser adicionados no estoque: ");
		quantidade = sc.nextInt();
		produto.adicionarProdutos(quantidade);

		System.out.println();
		System.out.println("Dados atualizados: " + produto);
		System.out.println();

		System.out.print("Digite o número de produtos que devem ser retirados no estoque: ");
		quantidade = sc.nextInt();
		produto.retirarProdutos(quantidade);

		System.out.println();
		System.out.println("Dados atualizados: " + produto);
		
		produto.setNome("Xbox Series S");
		produto.setPreco(2500);
		
		System.out.println();
		System.out.println("Produto alterado: " + produto);
		
		sc.close();
	}
}