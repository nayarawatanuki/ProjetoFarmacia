package br.edu.ifsp.bra.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/ifsp_farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS = "";

	/**
	 * Get a connection to database
	 */
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}

	/**
	 * Test Connection
	 */
	public static void main(String[] args) {
		try {
			Connection connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
