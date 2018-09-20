package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Pedido;

public class ItemPedidoDAO {

	public List<ItemPedido> getItens(int idPedido) {

		return null;
	}

	public boolean adicionaItens(List<ItemPedido> list, int idPedido) {
		
		if(list.isEmpty()) {
			return false;
		}
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO itemPedido VALUES (?, ?, ?, ?)");

			Iterator<ItemPedido> it = list.iterator();
			while (it.hasNext()) {
				ItemPedido item = it.next();
				ps.setInt(1, idPedido);
				ps.setInt(2, item.getProdutoId());
				ps.setDouble(3, item.getPreco());
				ps.setInt(4, item.getQuantidade());
				ps.addBatch();
			}
			connection.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
