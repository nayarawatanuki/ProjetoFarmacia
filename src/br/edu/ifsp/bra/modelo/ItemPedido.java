package br.edu.ifsp.bra.modelo;

public class ItemPedido {
	
	private Medicamento medicamento;
	private double preco;
	private int quantidade;
	
	public ItemPedido() {};
	//Pre�o pra mim � desnecessario, ja que temos a quantidade e o preco do Medicamento
	public ItemPedido(Medicamento medicamento, int quantidade) {
		this.medicamento = medicamento;
		this.quantidade = quantidade;
		//this.preco = medicamento.getPreco();
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getTotal() {
		return (this.getPreco() * this.getQuantidade());
	}
}
