package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.bra.modelo.Dinheiro;

public class DinheiroDAO {
	public Dinheiro getPagamento(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT pagamento_id, pedido_id, desconto, total, pago, troco "
							+ "FROM pagamento_dinheiro "
							+ "WHERE pagamento_id=" + id);

			if(rs.next()) {
				return toDinheiro(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		return null;
	}

	public Set<Dinheiro> getTodosPagamentos() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pagamento_dinheiro");
			Set<Dinheiro> pagamentos = new HashSet<Dinheiro>();
			while(rs.next()) {
				Dinheiro dinheiro = toDinheiro(rs);
				pagamentos.add(dinheiro);
			}
			return pagamentos;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean novoPagamento(Dinheiro dinheiro) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO dinheiro VALUES (DEFAULT, ?, ?, ?, ?)");
			ps.setInt(1, dinheiro.getPedido().getId());
			ps.setDouble(2, dinheiro.getDesconto());
			ps.setDouble(3, dinheiro.getTotal());
			ps.setDouble(2, dinheiro.getPago());
			ps.setDouble(3, dinheiro.getTroco());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private Dinheiro toDinheiro(ResultSet rs) throws SQLException {
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setId(rs.getInt("pagamento_id"));
		dinheiro.setDesconto(rs.getDouble("desconto"));
		dinheiro.setTotal(rs.getDouble("total"));
		dinheiro.setPago(rs.getDouble("pago"));
		dinheiro.setTroco(rs.getDouble("troco"));
		return dinheiro;
	}
}
