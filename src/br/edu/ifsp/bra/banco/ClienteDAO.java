package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.bra.modelo.Cliente;

public class ClienteDAO {

	public Cliente getCliente(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT cliente_id, nome, endereco, telefone, cpf, data_nascimento, data_cadastro FROM cliente " + 
							"WHERE cliente_id=" + id);

			if(rs.next()) {
				return toCliente(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Cliente> getTodosClientes() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
			List<Cliente> clientes = new ArrayList<Cliente>();
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

	public int novoCliente(Cliente cliente) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getCpf());
			ps.setDate(5, cliente.getDataNascimento());
			ps.setDate(6, cliente.getDataCadastro());
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

	public boolean modificaCliente(Cliente cliente) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE cliente "
					+ "SET nome=?, endereco=?, telefone=?, cpf=?, data_nascimento=?, data_cadastro=? "
					+ "WHERE cliente_id=?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getCpf());
			ps.setDate(5, cliente.getDataNascimento());
			ps.setDate(6, cliente.getDataCadastro());
			ps.setInt(7, cliente.getId());

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
		return cliente;
	}
}
