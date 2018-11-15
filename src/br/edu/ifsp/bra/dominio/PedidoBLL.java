package br.edu.ifsp.bra.dominio;

import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.banco.PedidoDAO;

public class PedidoBLL {

	PedidoDAO dao = new PedidoDAO();

	public boolean adicionar(Pedido pedido) {
		return dao.adicionar(pedido);
		
	}
}
