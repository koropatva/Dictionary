package com.koropatva.dictionary.server.services;

import java.sql.SQLException;

import org.h2.tools.Server;

import com.koropatva.dictionary.server.interfaces.LocalServer;

public class H2LocalServer implements LocalServer {

	private static Server server;

	public void start() {
		try {
			server = Server.createTcpServer().start();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void stop() {
		server.stop();
	}

}
