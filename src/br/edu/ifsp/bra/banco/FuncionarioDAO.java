package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Funcionario;

public class FuncionarioDAO {
	public Funcionario getFuncionario(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT funcionario_id, nome, endereco, telefone, cpf, data_nascimento, tipo_id, usuario FROM pessoa p " + 
							"JOIN funcionario f f.funcionario_id = p.pessoa_id " + 
							"WHERE f.funcionario_id=" + id);

			if(rs.next()) {
				return toFuncionario(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Set<Funcionario> getTodosFuncionarios() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa p " +
					"JOIN funcionario f on f.funcionario_id= p.pessoa_id");
			Set<Funcionario> funcionarios = new HashSet<Funcionario>();
			while(rs.next()) {
				Funcionario funcionario = toFuncionario(rs);
				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean novoFuncionario(Funcionario funcionario) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO funcionario VALUES (?, ?, ?, ?)");
			ps.setInt(1, funcionario.getId());
			ps.setInt(2, Integer.parseInt(funcionario.getTipo().toString()));
			ps.setString(3, funcionario.getUsuario());
			ps.setString(4, funcionario.getSenha());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean modificaFuncionario(Funcionario funcionario) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE funcionario f "
				+ "JOIN pessoa p ON p.pessoa_id = f.funcionario_id "
				+ "SET f.tipo_id=?, f.usuario=?, f.senha=?, "
				+ "p.nome=?, p.endereco=?, p.telefone=?, p.cpf=?, p.data_nascimento=? "
				+ "WHERE c.cliente_id=?");
			ps.setInt(1, Integer.parseInt(funcionario.getTipo().toString()));
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3, funcionario.getSenha());
			ps.setString(4, funcionario.getNome());
			ps.setString(5, funcionario.getEndereco());
			ps.setString(6, funcionario.getTelefone());
			ps.setString(7, funcionario.getCpf());
			ps.setDate(8, funcionario.getDataNascimento());
			ps.setInt(5, funcionario.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private Funcionario toFuncionario(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(rs.getInt("funcionario_id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setEndereco(rs.getString("nome"));
		funcionario.setTelefone(rs.getString("nome"));
		funcionario.setCpf(rs.getString("cpf"));
		funcionario.setDataNascimento(rs.getDate("data_nascimento"));
		// funcionario.setTipo(rs.getInt("tipo_id");
		funcionario.setUsuario(rs.getString("usuario"));
		return funcionario;
	}
}
