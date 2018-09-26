package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.bra.modelo.Cliente;

public class ClienteDAO {
	
	public Cliente getCliente(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT cliente_id, nome, endereco, telefone, cpf, data_nascimento, is_ativo, data_cadastro FROM pessoa p " + 
							"JOIN cliente c on c.cliente_id = p.pessoa_id " + 
							"WHERE c.cliente_id=" + id);

			if(rs.next()) {
				return toCliente(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Set<Cliente> getTodosClientes() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa p " +
					"JOIN cliente c on c.cliente_id = p.pessoa_id");
			Set<Cliente> clientes = new HashSet<Cliente>();
			while(rs.next()) {
				Cliente cliente = toCliente(rs);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean novoCliente(Cliente cliente) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente VALUES (?, ?, ?)");
			ps.setInt(1, cliente.getId());
			ps.setBoolean(2, cliente.isAtivo());
			ps.setDate(3, cliente.getDataCadastro());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean modificaCliente(Cliente cliente) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE cliente c "
				+ "JOIN pessoa p ON p.pessoa_id = c.cliente_id "
				+ "SET c.is_ativo=?, c.data_cadastro=?, "
				+ "p.nome=?, p.endereco=?, p.telefone=?, p.cpf=?, p.data_nascimento=? "
				+ "WHERE c.cliente_id=?");
			ps.setBoolean(1, cliente.isAtivo());
			ps.setDate(2, cliente.getDataCadastro());
			ps.setString(3, cliente.getNome());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getTelefone());
			ps.setString(6, cliente.getCpf());
			ps.setDate(7, cliente.getDataNascimento());
			ps.setInt(8, cliente.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private Cliente toCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("cliente_id"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEndereco(rs.getString("endereco"));
		cliente.setTelefone(rs.getString("telefone"));
		cliente.setCpf(rs.getString("cpf"));
		cliente.setDataNascimento(rs.getDate("data_nascimento"));
		cliente.setDataCadastro(rs.getDate("data_cadastro"));
		cliente.setAtivo(rs.getBoolean("is_ativo"));
		return cliente;
	}
}
