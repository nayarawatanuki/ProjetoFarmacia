package br.edu.ifsp.bra.modelo;

import br.edu.ifsp.bra.modelo.Pagamento.TipoPagamento;

public interface IPagamento {
	double getTotalDesconto();
	TipoPagamento getTipo();
	int getPedidoId();
	void setDesconto(double desconto);
}
