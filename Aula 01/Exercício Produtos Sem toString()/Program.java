package application;

import java.util.Scanner;
import entities.Product;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Product produto = new Product();

        System.out.println("Entre com os dados do produto: ");
        System.out.print("Nome: ");
        produto.nome = sc.nextLine();

        System.out.print("Preço: ");
        produto.preco = sc.nextDouble();

        System.out.print("Quantidade em estoque: ");
        produto.quantidade = sc.nextInt();
        System.out.println();

        System.out.println("Dados do produto: TV, $ " + produto.preco + ", " + produto.quantidade + " unidades, Total: $ " + produto.valorTotalEstoque());
        System.out.println();

        System.out.print("Digite o número de produtos que devem ser adicionados no estoque: ");
        int quantidade = sc.nextInt();
        produto.adicionarProdutos(quantidade);

        System.out.println();
        System.out.println("Dados atualizados: TV, $ " + produto.preco + ", " + produto.quantidade + " unidades, Total: $ " + produto.valorTotalEstoque());
        System.out.println();

        System.out.print("Digite o número de produtos que devem ser retirados no estoque: ");
        quantidade = sc.nextInt();
        produto.retirarProdutos(quantidade);

        System.out.println();
        System.out.println("Dados atualizados: TV, $ " + produto.preco + ", " + produto.quantidade + " unidades, Total: $ " + produto.valorTotalEstoque());
        sc.close();
    }
}