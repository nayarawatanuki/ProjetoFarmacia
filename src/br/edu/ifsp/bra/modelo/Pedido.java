package br.edu.ifsp.bra.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Pedido {

	public enum StatusPedido {
		NENHUM, ABERTO, FECHADO, CANCELADO;
		public StatusPedido setTipo(int tipo) {
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
		public static int getTipo(StatusPedido tipo) {
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
	private static Pedido pedidoAtual;

	public static Pedido getPedidoAtual() {
		return pedidoAtual;
	}
	public static void setPedidoAtual(Pedido pedidoAtual) {
		Pedido.pedidoAtual = pedidoAtual;
	}

	private int id;
	private int caixaId;
	private StatusPedido status;
	private List<ItemPedido> itens;
	private double total;
	private Date data;

	public Pedido() {
		this.itens = new LinkedList<ItemPedido>();
	}
	public Pedido(int caixaId, StatusPedido status, double total, Date data) {
		this();
		this.caixaId = caixaId;
		this.status = status;
		this.total = total;
		this.data = data;
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
	
	public StatusPedido getStatus() {
		return status;
	}
	
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
		
	}
	
	public void adicionaItem(ItemPedido item) {
		if(itens.contains(item))
		{
			int quantidade = itens.get(itens.indexOf(item)).getQuantidade();
			itens.get(itens.indexOf(item)).setQuantidade(quantidade + item.getQuantidade());
			this.total += item.getTotal();
		}
		else
		{
			this.itens.add(item);
			this.total += item.getTotal();
		}
	}
	
	public void removeItem(ItemPedido item) {
		if (!this.itens.contains(item))
			return;
		this.total -= item.getPreco();
		this.itens.remove(item);
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
