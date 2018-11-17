package br.edu.ifsp.bra.modelo;

public class Dinheiro extends Pagamento{

	private double pago;

	public Dinheiro() {}
	public Dinheiro(int clienteId, int pedidoId, double total, TipoPagamento tipo, double pago) {
		super(clienteId, pedidoId, total, tipo);
		this.pago = pago;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public double getTroco() {
		return this.getPago() - this.getTotal();
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
