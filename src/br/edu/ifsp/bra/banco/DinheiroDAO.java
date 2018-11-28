package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.bra.modelo.Dinheiro;

public class DinheiroDAO implements IDinheiroDAO {
	
	@Override
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

	@Override
	public List<Dinheiro> getTodosPagamentos() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pagamento_dinheiro");
			List<Dinheiro> pagamentos = new ArrayList<Dinheiro>();
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

	@Override
	public int novoPagamento(Dinheiro dinheiro) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO pagamento_dinheiro VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dinheiro.getClienteId());
			ps.setInt(2, dinheiro.getPedidoId());
			ps.setDouble(3, dinheiro.getTotalDesconto());
			ps.setDouble(4, dinheiro.getTotal());
			ps.setDouble(5, dinheiro.getPago());
			ps.setDouble(6, dinheiro.getTroco());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return -1;
	}

	private Dinheiro toDinheiro(ResultSet rs) throws SQLException {
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setId(rs.getInt("pagamento_id"));
		dinheiro.setClienteId(rs.getInt("cliente_id"));
		dinheiro.setPedidoId(rs.getInt("pedido_id"));
		dinheiro.setDesconto(rs.getDouble("desconto"));
		dinheiro.setTotal(rs.getDouble("total"));
		dinheiro.setPago(rs.getDouble("pago"));
		return dinheiro;
	}
}
