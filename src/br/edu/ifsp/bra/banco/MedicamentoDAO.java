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

import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Medicamento.TipoMedicamento;

public class MedicamentoDAO {
	
	public Medicamento getMedicamento(String codigo) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from medicamento " +
							"WHERE medicamento_id=" + codigo);

			if(rs.next()) {
				return toMedicamento(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Medicamento getMedicamento(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * from medicamento WHERE medicamento_id=" + id);

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
			ResultSet rs = stmt.executeQuery("SELECT * FROM medicamento where estoque <= " + filtro);
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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO medicamento VALUES (DEFAULT, ?, ?, ?, ?, ?);");
				ps.setInt(1, TipoMedicamento.setTipo(med.getTipo()));
				ps.setString(2, med.getCodigo());
				ps.setString(3, med.getDescricao());
				ps.setDouble(4, med.getPreco());
				ps.setInt(5, med.getEstoque());

			if (ps.executeUpdate() == 1) {
				return true;
			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nMedicamento cadastrado com sucesso.", "Produtos - Estoque", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Cadastro \n\n" + "\nFalha no cadastro de Medicamento.", "Produtos - Estoque", JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}

		return false;
	}

	public boolean modificar(Medicamento med) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE medicamento "
				+ "SET tipo_id=?, codigo=?, "
				+ "descricao=?, preco=?, estoque=? WHERE medicamento_id=?");
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
			PreparedStatement ps = connection.prepareStatement("call RemoveMedicamento(?);" );
			ps.setInt(1, med);

			if (ps.executeUpdate() == 1) {
				return true;
			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Deletar \n\n" + "\nMedicamento deletado com sucesso.", "Produtos - Estoque", JOptionPane.INFORMATION_MESSAGE);
		
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Deletar \n\n" + "\nFalha ao deletar Medicamento.", "Produtos - Estoque", JOptionPane.INFORMATION_MESSAGE);
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
