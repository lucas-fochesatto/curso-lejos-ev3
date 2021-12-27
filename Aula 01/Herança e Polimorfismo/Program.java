package application;

import entities.Account;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.sacar(200.0);
		System.out.println(acc1.getSaldo());
		
		SavingsAccount acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc2.sacar(200.0);
		System.out.println(acc2.getSaldo());
	}
}