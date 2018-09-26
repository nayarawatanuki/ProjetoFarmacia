package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	
	private int pedidoId;
	private int produtoId;
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	public ItemPedido(int pedidoId, int produtoId, int quantidade, double preco) {
		this.pedidoId = pedidoId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.preco = preco;
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
		Medicamento m = new Medicamento();
		preco = m.getPreco();
		this.preco = preco * quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
