package br.edu.ifsp.bra.modelo;

public class Cartao extends Pagamento {

	private String conta;
	private String agencia;
	
	public Cartao(Cliente cliente, Pedido pedido, double desconto, double total, TipoPagamento tipo, String conta, String agencia) {
		super(cliente, pedido, desconto, total, tipo);
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
		
		if (this.getCliente() != null && this.getCliente().isAtivo())
			return this.getTotal() * Pagamento.taxaDescontoAposentado();
		
		return this.getDesconto();
	}
}
