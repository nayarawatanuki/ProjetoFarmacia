package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.bra.modelo.Cartao;

public class CartaoDAO {
	public Cartao getPagamento(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT pagamento_id, pedido_id, desconto, total, conta, agencia "
							+ "FROM pagamento_cartao "
							+ "WHERE pagamento_id=" + id);

			if(rs.next()) {
				return toCartao(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		return null;
	}

	public Set<Cartao> getTodosPagamentos() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pagamento_cartao");
			Set<Cartao> pagamentos = new HashSet<Cartao>();
			while(rs.next()) {
				Cartao cartao = toCartao(rs);
				pagamentos.add(cartao);
			}
			return pagamentos;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean novoPagamento(Cartao cartao) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cartao VALUES (DEFAULT, ?, ?, ?, ?, ?)");
			ps.setInt(1, cartao.getPedido().getId());
			ps.setDouble(2, cartao.getDesconto());
			ps.setDouble(3, cartao.getTotal());
			ps.setString(4, cartao.getConta());
			ps.setString(5, cartao.getAgencia());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private Cartao toCartao(ResultSet rs) throws SQLException {
		Cartao cartao = new Cartao();
		cartao.setId(rs.getInt("pagamento_id"));
		cartao.setDesconto(rs.getDouble("desconto"));
		cartao.setTotal(rs.getDouble("total"));
		cartao.setConta(rs.getString("conta"));
		cartao.setAgencia(rs.getString("agencia"));
		return cartao;
	}
}
