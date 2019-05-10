package com.ecodeup.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class ConnectionDB {
	
//este punto java es donde se guarda las informaciones propies, para luego conectarse a la bbdd hsqldb
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:C:\\Users\\cf17h\\eclipse-workspace\\JSP\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	
	//el driver y la Url, definimos lloguer para imprimir por pantalla
	final static Logger LOGGER = Logger.getLogger("com.ecodeup.com");
	private ConnectionDB() { }
	public static Connection getConnection() {
		Connection conn = null;
		String ps="";
		
		//Connectamos con el nombre sa y el password  
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,"sa", ps);
		}catch(ClassNotFoundException | SQLException e) {
			String msn = "la exception es ";
	       	 LOGGER.log(Level.INFO,msn, e);
		}
		return conn;
		
	}
	

}

