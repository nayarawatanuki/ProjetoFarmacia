package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.Login;

public class LoginDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public List<Login> Logar(){
		try {
			
			String sql = "SELECT * FROM funcionario";
			PreparedStatement comando = connection.prepareStatement(sql);
			
			
			ResultSet rs = null;
			
			List<Login> log = new ArrayList<>();
			rs = comando.executeQuery();
			
			while(rs.next()) {
				Login login = new Login();
				login.setLogin(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				log.add(login);
				
				sql = "SELECT * FROM funcionario WHERE usuario=? AND senha=?";
				comando = connection.prepareStatement(sql);
				
				comando.setString(1, login.getLogin());
				comando.setString(2, login.getSenha());
				
				if(login.getLogin().equals(rs.getString("usuario")) && login.getSenha().equals(rs.getString("senha")))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Permitido.", "Funcionario", JOptionPane.INFORMATION_MESSAGE);
				}
				
				return log;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
