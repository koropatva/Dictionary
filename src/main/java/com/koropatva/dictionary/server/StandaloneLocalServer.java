package com.koropatva.dictionary.server;

import com.koropatva.dictionary.server.interfaces.LocalServer;
import com.koropatva.dictionary.server.services.H2LocalServer;

public class StandaloneLocalServer {

	private static StandaloneLocalServer server;

	private LocalServer localServer;

	private StandaloneLocalServer() {
	}

	public static StandaloneLocalServer getInstance() {
		if (server == null) {
			server = new StandaloneLocalServer();
			server.initLocalServer();
		}
		return server;
	}

	private void initLocalServer() {
		localServer = new H2LocalServer();
	}

	public void startLocalServer() {
		server.getLocalServer().start();
	}

	public void stopLocalServer() {
		server.getLocalServer().stop();
	}

	public LocalServer getLocalServer() {
		return localServer;
	}
}
