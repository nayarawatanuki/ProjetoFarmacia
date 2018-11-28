package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.Funcionario;

public class FuncionarioDAO implements IFuncionarioDAO {
	
	@Override
	public Funcionario getFuncionario(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT funcionario_id, nome, endereco, telefone, cpf, data_nascimento, tipo_id, usuario FROM funcionario " + 
							"WHERE funcionario_id=" + id);

			if(rs.next()) {
				return toFuncionario(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Funcionario getFuncionario(String usuario, String senha) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			
			String sql = "SELECT funcionario_id, nome, endereco, telefone, cpf, data_nascimento, tipo_id, usuario FROM funcionario WHERE usuario=? AND senha=?";
			PreparedStatement comando = connection.prepareStatement(sql);
			
			comando.setString(1, usuario);
			comando.setString(2, senha);
			
			ResultSet rs = null;
			rs = comando.executeQuery();
			
			if(rs.next())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Permitido.", "FrmFuncionario", JOptionPane.INFORMATION_MESSAGE);
				return toFuncionario(rs);
			}
			//JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Negado.", "FrmFuncionario", JOptionPane.INFORMATION_MESSAGE);
			
			/*Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT funcionario_id, nome, endereco, telefone, cpf, data_nascimento, tipo_id, usuario FROM funcionario " + 
							"WHERE usuario=? AND senha=?");

			if(rs.next()) {
				return toFuncionario(rs);
			}*/
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Funcionario> getTodosFuncionarios() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM funcionario");
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
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

	@Override
	public int novoFuncionario(Funcionario funcionario) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO funcionario VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, Funcionario.TipoFuncionario.setTipo(funcionario.getTipo()));
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3, funcionario.getSenha());
			ps.setString(4, funcionario.getNome());
			ps.setString(5, funcionario.getEndereco());
			ps.setString(6, funcionario.getTelefone());
			ps.setString(7, funcionario.getCpf());
			ps.setDate(8, funcionario.getDataNascimento());
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

	@Override
	public boolean modificaFuncionario(Funcionario funcionario) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE funcionario "
				+ "SET tipo_id=?, usuario=?, senha=?, "
				+ "nome=?, endereco=?, telefone=?, cpf=?, data_nascimento=? "
				+ "WHERE c.cliente_id=?");
			ps.setInt(1, Integer.parseInt(funcionario.getTipo().toString()));
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3, funcionario.getSenha());
			ps.setString(4, funcionario.getNome());
			ps.setString(5, funcionario.getEndereco());
			ps.setString(6, funcionario.getTelefone());
			ps.setString(7, funcionario.getCpf());
			ps.setDate(8, funcionario.getDataNascimento());
			ps.setInt(9, funcionario.getId());

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
		funcionario.setTipo(Funcionario.TipoFuncionario.getTipo(rs.getInt("tipo_id")));
		funcionario.setUsuario(rs.getString("usuario"));
		funcionario.setSenha(null);
		funcionario.setNome(rs.getString("nome"));
		funcionario.setEndereco(rs.getString("endereco"));
		funcionario.setTelefone(rs.getString("telefone"));
		funcionario.setCpf(rs.getString("cpf"));
		funcionario.setDataNascimento(rs.getDate("data_nascimento"));
		return funcionario;
	}
}
