package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.bra.modelo.Pedido;

public class PedidoDAO {
	
	ItemPedidoDAO ItensDAO = new ItemPedidoDAO();
	
	public Pedido getPedido(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT pedido_id, preco, data_pedido, status_pedido FROM pedido " + 
							"WHERE pedido_id=" + id);

			if(rs.next()) {
				return toPedido(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean adicionar(Pedido pedido) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO pedido VALUES (?, ?, ?)");
			ps.setInt(1, pedido.getId());
			ps.setInt(2, pedido.getCaixaId());
			ps.setString(3, pedido.getStatus().toString()); 
			ps.setDouble(4, pedido.getTotal());
			ps.setDate(5, (Date) pedido.getData());
			
			if (ps.executeUpdate() == 1) {
				// se o pedido for adicionado, adiciona os items ligando o id do mesmo em cada item.
				ItensDAO.adicionaItens(pedido.getItens(), pedido.getId());
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
	
	public void modificar() {
		
	}
	public void remover() {
		
	}
	
	private Pedido toPedido(ResultSet rs) throws SQLException {

		Pedido pedido = new Pedido();
		pedido.setId(rs.getInt("caixa_id"));
		pedido.setItens(ItensDAO.getItens(pedido.getId()));
		pedido.setStatus(pedido.getStatus());
		pedido.setData(rs.getDate("data_pedido"));
		return pedido;
	}
}
