package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.Login;

public class LoginDAO implements ILoginDAO {
	
	Connection connection = ConnectionFactory.getConnection();

	@Override
	public boolean Logar(Login login){
		
		try {
			
			/*ResultSet rs = null;
			
			List<Login> log = new ArrayList<>();
			rs = comando.executeQuery();
			
			while(rs.next()) {
				Login login = new Login();
				login.setLogin(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				log.add(login);*/
				
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
