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
					"SELECT cliente_id, nome, cpf, data_nascimento, data_cadastro FROM cliente " + 
							"JOIN pessoa on cliente.cliente_id = pessoa.pessoa_id " + 
							"WHERE cliente_id=" + id);

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
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente " +
					"JOIN pessoa on cliente.cliente_id = pessoa.pessoa_id");
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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente VALUES (?, ?)");
			ps.setInt(1, cliente.getId());
			ps.setDate(2, cliente.getDataCadastro());

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
			PreparedStatement ps = connection.prepareStatement("UPDATE cliente AS c "
				+ "JOIN pessoa AS p ON p.pessoa_id=c.cliente_id "
				+ "SET c.data_cadastro=?, p.nome=? WHERE c.cliente_id=?");
			ps.setDate(1, cliente.getDataCadastro());
			ps.setString(2, cliente.getNome());
			ps.setInt(3, cliente.getId());

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
		cliente.setCpf(rs.getString("cpf"));
		cliente.setDataNascimento(rs.getDate("data_nascimento"));
		cliente.setDataCadastro(rs.getDate("data_cadastro"));
		return cliente;
	}
}
