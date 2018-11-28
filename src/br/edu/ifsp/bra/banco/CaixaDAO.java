package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.bra.modelo.Caixa;

public class CaixaDAO implements ICaixaDAO {

	@Override
	public Caixa getCaixa(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from caixa c WHERE c.caixa_id=" + id);

			if(rs.next()) {
				return toCaixa(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Caixa> getCaixa() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM caixa");
			List<Caixa> caixas = new ArrayList<Caixa>();
			while(rs.next()) {
				Caixa caixa = toCaixa(rs);
				caixas.add(caixa);
			}
			return caixas;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Caixa toCaixa(ResultSet rs) throws SQLException {
		Caixa caixa = new Caixa();
		caixa.setId(rs.getInt("caixa_id"));
		caixa.setDescricao(rs.getString("descricao"));
		return caixa;
	}
}
