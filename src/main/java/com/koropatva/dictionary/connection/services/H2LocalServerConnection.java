package com.koropatva.dictionary.connection.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

import com.koropatva.dictionary.connection.interfaces.LocalServerConnection;

public class H2LocalServerConnection implements LocalServerConnection {

	private Connection connection;

	private JdbcConnectionPool cp;

	@Override
	public Connection openConnection() {
		try {
			if (connection == null) {
				cp = JdbcConnectionPool.create("jdbc:h2:~/test", "", "");
				connection = cp.getConnection();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	@Override
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (cp != null) {
				cp.dispose();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
