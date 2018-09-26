package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;

public class MedicamentoDAO {
	
	public Medicamento getMedicamento(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from medicamento c" +
							"WHERE c.medicamento_id=" + id);

			if(rs.next()) {
				return toMedicamento(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Set<Medicamento> getTodosMedicamento() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM medicamento");
			Set<Medicamento> listaMed = new HashSet<Medicamento>();
			while(rs.next()) {
				Medicamento medicamento = toMedicamento(rs);
				listaMed.add(medicamento);
			}
			return listaMed;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Set<Medicamento> getEstoque(int filtro) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM medicamento m where m.estoque <=" + filtro);
			Set<Medicamento> listaMed = new HashSet<Medicamento>();
			while(rs.next()) {
				Medicamento medicamento = toMedicamento(rs);
				listaMed.add(medicamento);
			}
			return listaMed;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean adicionar(Medicamento med) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO medicamento VALUES (?, ?, ?, ?, ?, ?);");
				ps.setInt(6, med.getId());
				ps.setInt(1, TipoMedicamento.setTipo(med.getTipo()));
				ps.setString(2, med.getCodigo());
				ps.setString(3, med.getDescricao());
				ps.setDouble(4, med.getPreco());
				ps.setInt(5, med.getEstoque());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean modificar(Medicamento med) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE medicamento m "
				+ "SET m.tipo_id=?, m.codigo=?, "
				+ "m.descricao=?, m.preco=?, m.estoque=? WHERE m.medicamento_id=?");
			ps.setInt(1, TipoMedicamento.setTipo(med.getTipo()));
			ps.setString(2, med.getCodigo());
			ps.setString(3, med.getDescricao());
			ps.setDouble(4, med.getPreco());
			ps.setInt(5, med.getEstoque());
			ps.setInt(6, med.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
	
	public boolean remover(int med) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from medicamento where medicamento_id = ?" );
			ps.setInt(1, med);

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private Medicamento toMedicamento(ResultSet rs) throws SQLException {
		Medicamento med = new Medicamento();
		med.setId(rs.getInt("medicamento_id"));
		med.setTipo(TipoMedicamento.getTipo(rs.getInt("tipo_id")));
		med.setCodigo(rs.getString("codigo"));
		med.setDescricao(rs.getString("descricao"));
		med.setPreco(rs.getDouble("preco"));
		med.setEstoque(rs.getInt("estoque"));
		return med;
	}
}
