package com.ecodeup.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger; 
/**
 * Esta clase permite  definir metodo 
 * donde se guarda las informaciones propies, para luego conectarse a la bbdd hsqldb
 * @author cf17h
 *
 */
public class ConnectionDB {
	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:C:\\Users\\cf17h\\eclipse-workspace\\JSP\\WebContent\\WEB-INF\\lib\\srv_db.tmp";
	final static Logger LOGGER = Logger.getLogger("com.ecodeup.com");
	
	/**
	 * Constructor por defento
	 */
	private ConnectionDB() { }
	/**
	 * metode que permite conectar a bbdd
	 * mediante las informaciones definidos anteriormente
	 * @return retorna la conecion a bbdd
	 */
	public static Connection getConnection() {
		Connection conn = null;
		String ps="";
		//intentara conectar, con las datos del DRIVER URL USUARIO Y PASSWORD
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

