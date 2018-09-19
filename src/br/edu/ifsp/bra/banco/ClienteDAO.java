package br.edu.ifsp.bra.banco;

import java.sql.Connection;
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