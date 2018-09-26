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
					"SELECT p.pagamento_id, pedido_id, desconto, total, pago, troco "
					+ "FROM pagamento_dinheiro pd JOIN pagamento p ON p.pagamento_id=pd.pagamento_id "
					+ "WHERE pc.pagamento_id=" + id);

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
			ResultSet rs = stmt.executeQuery("SELECT * FROM pagamento_dinheiro pd " +
					"JOIN pagamento p ON p.pagamento_id = pd.pagamento_id");
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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO dinheiro VALUES (?, ?, ?)");
			ps.setInt(1, dinheiro.getId());
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
		dinheiro.setPago(rs.getDouble("pago"));
		dinheiro.setTroco(rs.getDouble("troco"));
		return dinheiro;
	}
}
