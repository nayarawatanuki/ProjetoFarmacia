package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	public ItemPedido(double preco, int quantidade) {
		super();
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
