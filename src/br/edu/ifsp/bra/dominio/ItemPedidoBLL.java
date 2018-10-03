package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.ItemPedidoDAO;
import br.edu.ifsp.bra.modelo.ItemPedido;

public class ItemPedidoBLL {
	
	ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public Set<ItemPedido> getItens() {

		return dao.getItens();
	}
	
	public boolean adicionaItens(ItemPedido itempedido) {
		
		return dao.create(itempedido);
	}
	
	public boolean modificar(ItemPedido itempedido) {
		
		return dao.modificar(itempedido);
	}
}
