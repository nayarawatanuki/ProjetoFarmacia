package br.edu.ifsp.bra.banco;

import br.edu.ifsp.bra.modelo.Pedido;

public interface IPedidoDAO {

	public int adicionar(Pedido pedido);
	public Pedido buscarPedido(int idPedido);
	
}
