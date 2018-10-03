package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.ifsp.bra.modelo.Login;

public class LoginDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public Login logar(String usuario, String senha) {

		try {
			
			Login log = null;
			String sql = "SELECT * FROM funcionario WHERE usuario=? AND senha=?";
			
			PreparedStatement comando = connection.prepareStatement(sql);
			//Statement stmt = connection.createStatement();
			
			comando.setString(1, usuario);
			comando.setString(2, senha);
			
			ResultSet rs = comando.executeQuery(sql);
		
			
			if(rs.next()) {
				Login l = new Login();
				l.setLogin(rs.getString(usuario));
				l.setSenha(rs.getString(senha));
				
				if(l.getLogin().equals(rs.getString(usuario)) && l.getSenha().equals(rs.getString(senha)))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Permitido.", "Funcionario", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nAcesso Permitido.", "Funcionario", JOptionPane.INFORMATION_MESSAGE);
			}
			
			return log;
			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Login \n\n" + "\nLogin e/ou senha invalidos.", "Funcionario", JOptionPane.INFORMATION_MESSAGE);
			ex.printStackTrace();
		}
		return null;
	}

}
