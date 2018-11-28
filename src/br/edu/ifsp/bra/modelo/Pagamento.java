package br.edu.ifsp.bra.modelo;

public abstract class Pagamento implements IPagamento {

	public enum TipoPagamento {
		NENHUM, DINHEIRO, DEBITO, CREDITO;

		public TipoPagamento getTipo(int tipo) {
			switch (tipo) {
			case 1:
				return DINHEIRO;
			case 2:
				return DEBITO;
			case 3:
				return CREDITO;
			default:
				return NENHUM;
			}
		}

		public static int setTipo(TipoPagamento tipo) {
			switch (tipo) {
			case DINHEIRO:
				return 1;
			case DEBITO:
				return 2;
			case CREDITO:
				return 3;
			default:
				return 0;
			}
		}
	}

	private static double TAXA_DESCONTO_APOSENTADO = 0.2;
	private static double TAXA_DESCONTO_DINHEIRO = 0.05;

	private int id;
	private int clienteId;
	private int pedidoId;
	private double desconto;
	private double total;
	private double valorFinal;
	private TipoPagamento tipo;

	public Pagamento() {}
	public Pagamento( int pedidoId, double total, TipoPagamento tipo) {
		this.pedidoId = pedidoId;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public int getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
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
