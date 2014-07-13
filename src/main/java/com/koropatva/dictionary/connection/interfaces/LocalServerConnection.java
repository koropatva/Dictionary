package com.koropatva.dictionary.connection.interfaces;

import java.sql.Connection;

public interface LocalServerConnection {
	Connection openConnection();

	void closeConnection();
}
