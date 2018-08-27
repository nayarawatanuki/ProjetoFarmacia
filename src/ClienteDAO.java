import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {
	public Cliente getCliente(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cliente_id, nome, data_nascimento, cpf, data_cadastro FROM cliente " + 
					"JOIN pessoa on cliente.cliente_id = pessoa.pessoa_id " + 
					"WHERE cliente_id=" + id);
			if(rs.next())
			{
				Cliente cliente = new Cliente(
						rs.getInt("cliente_id"),
						rs.getString("nome"),
						rs.getDate("data_nascimento"),
						rs.getString("cpf"),
						rs.getDate("data_cadastro") );

				return cliente;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
