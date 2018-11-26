package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public boolean Logar(Object usuario, String senha){
		
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
				
				comando.setObject(1, usuario);
				comando.setString(2, senha);
				
				ResultSet rs = null;
				rs = comando.executeQuery();
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Permitido.", "FrmFuncionario", JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
				JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Negado.", "FrmFuncionario", JOptionPane.INFORMATION_MESSAGE);
				return false;
			
		}catch(SQLException e) {
			//e.printStackTrace();
		}
		return false;
		
	}
}
