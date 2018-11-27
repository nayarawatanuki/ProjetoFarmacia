package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.bra.modelo.Login;

public class LoginDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public boolean Logar(Login login){
		
		try {
				
				String sql = "SELECT usuario, senha FROM funcionario WHERE usuario=? AND senha=?;";
				PreparedStatement comando = connection.prepareStatement(sql);
				
				comando.setString(1, login.getLogin());
				comando.setString(2, login.getSenha());
				
				ResultSet rs = null;
				rs = comando.executeQuery();
				
				if(rs.next())
				{
					return true;
				}
				return false;
			
		}catch(SQLException e) {
			//e.printStackTrace();
		}
		return false;
		
	}
}
