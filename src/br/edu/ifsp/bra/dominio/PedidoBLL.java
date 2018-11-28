package br.edu.ifsp.bra.dominio;

import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.banco.IPedidoDAO;
import br.edu.ifsp.bra.banco.PedidoDAO;

public class PedidoBLL {

	IPedidoDAO dao = new PedidoDAO();

	public int adicionar(Pedido pedido) {
		return dao.adicionar(pedido);
		
	}
	public Pedido buscarPedido(int idPedido)
	{
		return dao.buscarPedido(idPedido);
	}
}
