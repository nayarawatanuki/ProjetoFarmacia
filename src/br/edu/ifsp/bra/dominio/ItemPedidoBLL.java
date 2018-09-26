package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.ItemPedidoDAO;
import br.edu.ifsp.bra.modelo.ItemPedido;

public class ItemPedidoBLL {
	
	ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public List<ItemPedido> getItens(int idPedido) {

		return dao.getItens(idPedido);
	}

	public boolean adicionaItens(List<ItemPedido> list, int idPedido) {
		
		return dao.adicionaItens(list, idPedido);
	}
}
