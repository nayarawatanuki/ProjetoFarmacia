package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	
	private int produtoId;
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	public ItemPedido(int produtoId, double preco, int quantidade) {
		super();
		this.produtoId = produtoId;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	
	public int getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
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
