package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	
	private Medicamento medicamento;
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	public ItemPedido(Medicamento medicamento, int quantidade, double preco) {
		this.medicamento = medicamento;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getTotal() {
		return this.preco * this.quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
