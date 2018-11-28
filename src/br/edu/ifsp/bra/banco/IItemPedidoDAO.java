package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.ItemPedido;

public interface IItemPedidoDAO {

	public boolean adicionar(ItemPedido itemPedido, int idPedido);
	public List<ItemPedido> buscarItens(int idPedido);
}
