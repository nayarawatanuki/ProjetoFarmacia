package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/ifsp_farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS = "secret18";

	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "Banco de Dados \n\n" + "\nErro ao conectar.", "Conexão", JOptionPane.INFORMATION_MESSAGE);
			throw new RuntimeException(ex);
		}
	}
}
