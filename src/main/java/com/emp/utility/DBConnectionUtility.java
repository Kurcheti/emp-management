package com.emp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtility {

	private static Connection connection = null;

	public static Connection getDBConnection() {

		try {

			// load the class name
			Class.forName("oracle.jdbc.driver.OracleDriver");

			if (connection == null)
				// get the connection
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "EMPMNG", "EMPMNG");
			

		} catch (ClassNotFoundException cne) {
			System.out.println("Class missed/NotFound");
			cne.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
