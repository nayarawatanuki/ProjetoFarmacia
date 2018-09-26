package br.edu.ifsp.bra.modelo;

import java.util.Date;
import java.util.List;

public class Pedido {

	public enum StatusPedido {
		NENHUM, ABERTO, FECHADO, CANCELADO;

		public StatusPedido getTipo(int tipo) {
			switch (tipo) {
			case 1:
				return ABERTO;
			case 2:
				return FECHADO;
			case 3:
				return CANCELADO;
			default:
				return NENHUM;
			}
		}

		public static int setTipo(StatusPedido tipo) {
			switch (tipo) {
			case ABERTO:
				return 1;
			case FECHADO:
				return 2;
			case CANCELADO:
				return 3;
			default:
				return 0;
			}
		}
	}

	private int id;
	private int caixaId;
	private StatusPedido status;
	private List<ItemPedido> itens;
	private double total;
	private Date data;

	public Pedido() {}
	public Pedido(int caixaId, List<ItemPedido> itens, Date data, double total, StatusPedido status) {
		this.caixaId = caixaId;
		this.itens = itens;
		this.data = data;
		this.total = total;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCaixaId() {
		return caixaId;
	}
	public void setCaixaId(int caixaId) {
		this.caixaId = caixaId;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void adicionaItem(ItemPedido item) {
		this.itens.add(item);;
	}
	public void removeItem(ItemPedido item) {
		if (!this.itens.contains(item))
			return;

		this.itens.remove(item);
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
