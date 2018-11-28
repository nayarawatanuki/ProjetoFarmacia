package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.ItemPedido;

public class ItemPedidoDAO implements IItemPedidoDAO{


	
	public boolean adicionar(ItemPedido itempedido, int pedidoId) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO itens_pedido VALUES (?, ?, ?, ?)");
			ps.setInt(1, pedidoId);	
			ps.setInt(2, itempedido.getMedicamento().getId());
			ps.setInt(3, itempedido.getQuantidade());
			ps.setDouble(4, itempedido.getPreco());

			if (ps.executeUpdate() == 1) {
				return true;
			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nProduto incluido com sucesso.", "FrmVenda", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nFalha na inclusão de Produto.", "FrmVenda", JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}

		return false;
	}
	
	public List<ItemPedido> buscarItens(int idPedido) {

		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM itens_pedido where pedido_id = " + idPedido + ";");
			List<ItemPedido> list = new LinkedList<ItemPedido>();
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
	
	private ItemPedido toItemPedido(ResultSet rs) throws SQLException {
		MedicamentoDAO med = new MedicamentoDAO();
		ItemPedido itped = new ItemPedido();
		itped.setMedicamento(med.getMedicamento(rs.getInt("medicamento_id")));
		itped.setQuantidade(rs.getInt("quantidade"));
		itped.setPreco(rs.getDouble("valor_pago"));
		return itped;
	}
}
