package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.bra.modelo.CaixaHistorico;

public class CaixaHistoricoDAO {

	public CaixaHistorico getCaixaHistorico(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from caixa_historico WHERE historico_id=" + id);

			if(rs.next()) {
				return toCaixaHistorico(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<CaixaHistorico> getCaixaHistorico() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM caixa_historico");
			List<CaixaHistorico> historicos = new ArrayList<CaixaHistorico>();
			while(rs.next()) {
				CaixaHistorico historico = toCaixaHistorico(rs);
				historicos.add(historico);
			}
			return historicos;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int novoCaixaHistorico(CaixaHistorico caixa) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO caixa_historico VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, caixa.getCaixaId());
			ps.setInt(2, caixa.getAtendenteId());
			ps.setDouble(3, caixa.getValorAbertura());
			ps.setDouble(4, caixa.getValorFechamento());
			ps.setDate(5, caixa.getDataAbertura());
			ps.setDate(6, caixa.getDataFechamento());
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

	public boolean modificaCaixaHistorico(CaixaHistorico caixa) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE caixa_historico "
					+ "SET atendente_id=?, valor_abertura=?, valor_fechamento=?"
					+ "data_abertura=?, data_fechamento=? WHERE historico_id=?");
			ps.setInt(1, caixa.getAtendenteId());
			ps.setDouble(2, caixa.getValorAbertura());
			ps.setDouble(3, caixa.getValorFechamento());
			ps.setDate(4, (java.sql.Date) caixa.getDataAbertura());
			ps.setDate(5, (java.sql.Date) caixa.getDataFechamento());
			ps.setInt(6, caixa.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private CaixaHistorico toCaixaHistorico(ResultSet rs) throws SQLException {
		CaixaHistorico historico = new CaixaHistorico();
		historico.setId(rs.getInt("historico_id"));
		historico.setCaixaId(rs.getInt("caixa_id"));
		historico.setAtendenteId(rs.getInt("atendente_id"));
		historico.setValorAbertura(rs.getDouble("valor_abertura"));
		historico.setValorFechamento(rs.getDouble("valor_fechamento"));
		historico.setDataAbertura(rs.getDate("data_abertura"));
		historico.setDataFechamento(rs.getDate("data_fechamento"));
		return historico;
	}
}
