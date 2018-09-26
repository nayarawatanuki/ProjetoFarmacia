package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	
	private int pedidoId;
	private int produtoId;
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	public ItemPedido(int pedidoId, int produtoId, double preco, int quantidade) {
		this.pedidoId = pedidoId;
		this.produtoId = produtoId;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public int getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
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
