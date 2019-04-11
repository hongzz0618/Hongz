package com.ecodeup.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:C:\\Users\\cf17h\\eclipse-workspace\\JSP\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	public static Connection getConnection() {
		Connection conn = null;
		String ps="";
		try {
			LoginCase.select(DRIVER);
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,"sa", ps);
		}catch(ClassNotFoundException | SQLException e) {
			System.err.println("Error: "+e);
		}
		return conn;
		
	}
	public ConnectionDB() {
		super();
	}

}
