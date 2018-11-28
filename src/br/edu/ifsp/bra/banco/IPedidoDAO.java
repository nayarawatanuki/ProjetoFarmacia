package br.edu.ifsp.bra.banco;

import br.edu.ifsp.bra.modelo.Pedido;

public interface IPedidoDAO {
	int adicionar(Pedido pedido);
	Pedido buscarPedido(int idPedido);
}
