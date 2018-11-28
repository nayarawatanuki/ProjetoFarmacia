package br.edu.ifsp.bra.modelo;

public class Cartao extends Pagamento {

	private String conta;
	private String agencia;
	
	public Cartao() {}
	public Cartao( int pedidoId, double total, TipoPagamento tipo, String conta, String agencia) {
		super(pedidoId, total, tipo);
		this.conta = conta;
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	@Override
	public double getTotalDesconto() {
		if (this.getDesconto() > 0.0)
			return this.getDesconto();
		
		if (this.getClienteId() > 0)
			return this.getTotal() * Pagamento.taxaDescontoAposentado();
		
		return this.getDesconto();
	}
}
