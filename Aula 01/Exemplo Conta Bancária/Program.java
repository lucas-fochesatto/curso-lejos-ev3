package application;

import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account conta;
		
		System.out.print("Digite o número da conta: ");
		int numero = sc.nextInt();
		
		System.out.print("Digite o nome do proprietário: ");
		sc.nextLine();
		String proprietario = sc.nextLine();
		
		System.out.print("Há deposito inicial (s/n)? ");
		char opcao = sc.nextLine().charAt(0);
		
		if(opcao == 's') {
			System.out.print("Digite o valor do depósito: ");
			double depositoInicial = sc.nextDouble();
			
			conta = new Account(numero, proprietario, depositoInicial);
		} else {
			conta = new Account(numero, proprietario);
		}
		
		System.out.println();
		
		System.out.println("Dados da conta:\n" + conta);
		
		System.out.println();
		
		System.out.print("Digite um valor de depósito: ");
		double valor = sc.nextDouble();
		conta.depositar(valor);
		System.out.println("Dados da conta atualizados:\n" + conta);
		
		System.out.println();
		
		System.out.print("Digite um valor de saque: ");
		valor = sc.nextDouble();
		conta.sacar(valor);
		System.out.println("Dados da conta atualizados:\n" + conta);
		
		sc.close();
	}
}
