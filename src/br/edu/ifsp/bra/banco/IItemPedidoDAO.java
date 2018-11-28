package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.ItemPedido;

public interface IItemPedidoDAO {
	boolean adicionar(ItemPedido itemPedido, int idPedido);
	List<ItemPedido> buscarItens(int idPedido);
}
