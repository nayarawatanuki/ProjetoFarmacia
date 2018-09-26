package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Caixa.StatusCaixa;

public class CaixaDAO {
	
	public Caixa getCaixa(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from caixa c" +
							"WHERE c.caixa_id=" + id);

			if(rs.next()) {
				return toCaixa(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Set<Caixa> getCaixa() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM caixa");
			Set<Caixa> listCaixa = new HashSet<Caixa>();
			while(rs.next()) {
				Caixa caixa = toCaixa(rs);
				listCaixa.add(caixa);
			}
			return listCaixa;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean caixaAberto(Caixa caixa) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO caixa VALUES (funcionario.funcionario_id, DEFAULT, ?, ?, ?)");
				ps.setInt(1, caixa.getAtendenteId());
				ps.setInt(2, StatusCaixa.setStatus(caixa.getStatus()));
				ps.setDate(3, caixa.getDataAbertura());
				ps.setDate(4, caixa.getDataFechamento());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean modificar(Caixa caixa) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE caixa c "
				+ "SET c.atendente_id=?, c.is_aberto=?, "
				+ "c.data_abertura=?, c.data_fechamento=? WHERE c.caixa_id=?");
			ps.setInt(1, caixa.getAtendenteId());
			ps.setInt(2, StatusCaixa.setStatus(caixa.getStatus()));
			ps.setDate(3, caixa.getDataAbertura());
			ps.setDate(4, caixa.getDataFechamento());
			ps.setInt(5, caixa.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private Caixa toCaixa(ResultSet rs) throws SQLException {
		Caixa caixa = new Caixa();
		caixa.setId(rs.getInt("caixa_id"));
		caixa.setAtendenteId(rs.getInt("funcionario.funcionario_id"));
		caixa.setStatus(StatusCaixa.getStatus(rs.getInt("is_aberto")));
		caixa.setDataAbertura(rs.getDate("data_abertura"));
		caixa.setDataFechamento(rs.getDate("data_fechamento"));
		return caixa;
	}

}
