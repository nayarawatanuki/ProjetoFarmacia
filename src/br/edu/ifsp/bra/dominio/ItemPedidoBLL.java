package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.ItemPedidoDAO;
import br.edu.ifsp.bra.modelo.ItemPedido;

public class ItemPedidoBLL {
	
	ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public boolean adicionaItens(ItemPedido itempedido,int pedidoId) {
		
		return dao.adiciona(itempedido, pedidoId);
	}
	public List<ItemPedido> buscarItens(int idItemPedido)
	{
		 return dao.buscarItens(idItemPedido);
	}

}
