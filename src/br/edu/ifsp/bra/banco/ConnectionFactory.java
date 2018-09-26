package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/ifsp_farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS = "ifsp";

	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Erro conectando ao banco de dados", ex);
		}
	}
}
