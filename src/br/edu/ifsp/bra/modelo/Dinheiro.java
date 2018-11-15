package br.edu.ifsp.bra.modelo;

public class Dinheiro extends Pagamento{

	private double pago;
	private double troco;

	public Dinheiro() {}
	public Dinheiro(int clienteId, int pedidoId, double total, TipoPagamento tipo, double pago, double troco) {
		super(clienteId, pedidoId, total, tipo);
		this.pago = pago;
		this.troco = troco;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public double getTroco() {
		return troco;
	}
	public void setTroco(double troco) {
		this.troco = troco;
	}
	@Override
	public double getTotalDesconto() {
		if (this.getDesconto() > 0.0)
			return this.getDesconto();
		
		if (this.getClienteId() > 0)
			return this.getTotal() * Pagamento.taxaDescontoAposentado();

		return this.getTotal() * Pagamento.taxaDescontoDinheiro();
	}
}
