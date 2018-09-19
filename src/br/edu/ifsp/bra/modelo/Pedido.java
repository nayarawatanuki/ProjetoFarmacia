package br.edu.ifsp.bra.modelo;

import java.util.Date;

public class Pedido {
	
	private int numero;
	private ItemPedido[] itens;
	private Date data;
	
	public Pedido() {};
	public Pedido(int numero, ItemPedido[] itens, Date data) {
		super();
		this.numero = numero;
		this.itens = itens;
		this.data = data;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public ItemPedido[] getItens() {
		return itens;
	}
	public void setItens(ItemPedido[] itens) {
		this.itens = itens;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
