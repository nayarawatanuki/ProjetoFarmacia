package br.edu.ifsp.bra.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido {

	public static enum statusPedido implements Serializable {
		ABERTO, FECHADO, CANCELADO;
		public String toString() {
			switch (this) {
			case ABERTO:
				return "ABERTO";
			case FECHADO:
				return "FECHADO";
			case CANCELADO:
				return "CANCELADO";
			}
			return null;
		}
	};

	private int numero;
	private List<ItemPedido> itens;
	private Date data;
	private statusPedido status;

	public Pedido() {
	};

	public Pedido(int numero, List<ItemPedido> itens, Date data, statusPedido status) {
		super();
		this.numero = numero;
		this.itens = itens;
		this.data = data;
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public statusPedido getStatus() {
		return status;
	}

	public void setStatus(statusPedido status) {
		this.status = status;
	}

	public void setStatus(String status) {
		if (status == statusPedido.ABERTO.toString()) {
			this.status = statusPedido.ABERTO;

		} else if (status == statusPedido.FECHADO.toString()) {
			this.status = statusPedido.FECHADO;

		} else if (status == statusPedido.CANCELADO.toString()) {
			this.status = statusPedido.CANCELADO;
		}
	}
}
