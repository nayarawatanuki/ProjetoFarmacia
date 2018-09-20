package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.bra.modelo.Cliente;
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
			ps.setInt(1, pedido.getNumero());
			ps.setString(2, pedido.getStatus().toString()); 
			ps.setDate(3, (Date) pedido.getData());
			
			if (ps.executeUpdate() == 1) {
				// se o pedido for adicionado, adiciona os items ligando o id do mesmo em cada item.
				ItensDAO.adicionaItens(pedido.getItens(), pedido.getNumero());
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
		pedido.setNumero(rs.getInt("pedido_id"));
		pedido.setItens(ItensDAO.getItens(pedido.getNumero()));
		pedido.setData(rs.getDate("data_pedido"));
		pedido.setStatus("pedido_status");
		return pedido;
	}
}
