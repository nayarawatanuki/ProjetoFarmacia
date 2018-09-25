package br.edu.ifsp.bra.modelo;

public abstract class Pagamento {

	public enum TipoPagamento { NENHUM, DINHEIRO, DEBITO, CREDITO }
	
	private static double TAXA_DESCONTO_APOSENTADO = 0.2;
	private static double TAXA_DESCONTO_DINHEIRO = 0.05;
	
	private Cliente cliente;
	private Pedido pedido;
	private double desconto;
	private double total;
	private double valorFinal;
	private TipoPagamento tipo;
	
	public Pagamento(Cliente cliente, Pedido pedido, double desconto, double total, TipoPagamento tipo) {
		this.cliente = cliente;
		this.pedido = pedido;
		this.desconto = desconto;
		this.total = total;
		this.valorFinal = this.total - this.getTotalDesconto();
		this.tipo = tipo;
	}
	public static double taxaDescontoAposentado() {
		return Pagamento.TAXA_DESCONTO_APOSENTADO;
	}
	public static double taxaDescontoDinheiro() {
		return Pagamento.TAXA_DESCONTO_DINHEIRO;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getVendaId() {
		return vendaId;
	}
	public void setVendaId(int vendaId) {
		this.vendaId = vendaId;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public TipoPagamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}
	
	abstract public double getTotalDesconto();
}
