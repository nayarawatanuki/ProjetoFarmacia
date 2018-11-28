package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.ItemPedido;

public interface IITemPedidoDAO {
	boolean adiciona(ItemPedido itempedido, int pedidoId);
	List<ItemPedido> buscarItens(int idPedido);
}
