package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.ItemPedido;

public class ItemPedidoDAO {

	public Set<ItemPedido> getItens() {

		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM itens_pedido;");
			Set<ItemPedido> list = new HashSet<ItemPedido>();
			while(rs.next()) {
				ItemPedido itempedido = toItemPedido(rs);
				list.add(itempedido);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public boolean create(ItemPedido itempedido) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO itens_pedido VALUES (?, ?, ?, ?)");
			ps.setInt(1, itempedido.getPedidoId());
			ps.setInt(2, itempedido.getProdutoId());
			ps.setInt(3, itempedido.getQuantidade());
			ps.setDouble(4, itempedido.getPreco());

			if (ps.executeUpdate() == 1) {
				return true;
			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nProduto incluido com sucesso.", "Venda", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nFalha na inclusão de Produto.", "Venda", JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}

		return false;
	}

	
	public boolean modificar(ItemPedido itempedido) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE itens_pedido itped "
				+ "SET itped.medicamento_id=?, itped.quantidade=?, "
				+ "itped.total=? WHERE itped.pedido_id=?");
			ps.setInt(1, itempedido.getProdutoId());
			ps.setInt(2, itempedido.getQuantidade());
			ps.setDouble(3, itempedido.getPreco());
			ps.setInt(4, itempedido.getPedidoId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
	
	private ItemPedido toItemPedido(ResultSet rs) throws SQLException {
		ItemPedido itped = new ItemPedido();
		itped.setPedidoId(rs.getInt("pedido_id"));
		itped.setProdutoId(rs.getInt("medicamento_id"));
		itped.setQuantidade(rs.getInt("quantidade"));
		itped.setPreco(rs.getDouble("total"));
		return itped;
	}
	
}
