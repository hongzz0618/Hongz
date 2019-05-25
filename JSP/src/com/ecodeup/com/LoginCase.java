package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level; 
import java.util.logging.Logger;
/**+
 * esta clase permite  definir metodo
 * para acceder a la bbdd i hacer un insert 
 * @author cf17h
 *
 */
public class LoginCase {
	final static Logger LOGGER = Logger.getLogger("com.ecodeup.com");//variable para hacer print
	/**
	 * Constructor por defento
	 */
	private LoginCase() { }
	/**
	 * metodo que permite hacer un insert de user
	 * @param uName - valor nombre ingresado por el usuario
	 * @param uPass - valor password ingresado por el usuario
	 * @param uEmail - valor email ingresado por el usuario
	 * @return retorna un valor boolean, para ver si inserto o no
	 */
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		//definimos los varibles que necesitaremos para conectar a bbdd
		Connection con;
		con=ConnectionDB.getConnection();
		PreparedStatement ps =null;
		
		
		try {
			// la tabla de bbdd
			String bbdd = "CREATE TABLE USER (\r\n" + 
					" ID varchar(6) PRIMARY KEY,\r\n" + 
					" NICK varchar(20) NOT NULL, \r\n" + 
					" EMAIL varchar(20) NOT NULL,\r\n" + 
					" PASSWORD varchar(20) NOT NULL,\r\n" + 
					");";
			
			//definimos la consulta del insert
			String consulta = "insert into USER (NICK,EMAIL,PASSWORD) VALUES(?,?,?);";
			ps=con.prepareStatement(consulta);
			//cogemos los variables ingresado por el cliente
			ps.setString(1, uName);
			ps.setString(2, uPass);
			ps.setString(3, uEmail);
			//si todo va bien TRUE
			if(ps.executeUpdate()==1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(ps != null) {
					ps.close();
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}

	}//SI no false
		return false;
}
	
}