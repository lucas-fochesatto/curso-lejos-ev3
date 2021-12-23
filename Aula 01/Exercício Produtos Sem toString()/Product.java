package entities;

public class Product {
	public String nome;
	public double preco;
	public int quantidade;
	
	public double valorTotalEstoque() {
		return preco * quantidade;
	}
	
	public void adicionarProdutos(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void retirarProdutos(int quantidade) {
		this.quantidade -= quantidade;
	}
}