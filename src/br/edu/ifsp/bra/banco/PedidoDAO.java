package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.StatusPedido;

public class PedidoDAO{
	
	ItemPedidoDAO itensDAO = new ItemPedidoDAO();
	
	public int adicionar(Pedido pedido) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO pedido VALUES (DEFAULT,?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pedido.getCaixaId());
			ps.setInt(2, StatusPedido.getTipo(pedido.getStatus()));
			ps.setDouble(3, pedido.getTotal());
			Date utilDate = new Date(1);
			ps.setDate(4, pedido.getData() != null ? (Date) pedido.getData() : new java.sql.Date(utilDate.getTime()));
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				for(ItemPedido item : pedido.getItens()) {
					itensDAO.adiciona(item, id);
				}
				return id;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
