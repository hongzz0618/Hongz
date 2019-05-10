package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level; 
import java.util.logging.Logger;

//este puto java es para guardar las funciones que vamos a utilizar despues
public class LoginCase {
	
	private LoginCase() { }
	//funcion para insertar
	//parametros de entrada name pass email, (los introducidos por html de login) 
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection con;
		
		con=ConnectionDB.getConnection();
		PreparedStatement ps =null;
		
		try {
			//la tabla que habiamos creado antes de hacer el insert
			String bbdd = "CREATE TABLE USER (\r\n" + 
					" ID varchar(6) PRIMARY KEY,\r\n" + 
					" NICK varchar(20) NOT NULL, \r\n" + 
					" EMAIL varchar(20) NOT NULL,\r\n" + 
					" PASSWORD varchar(20) NOT NULL,\r\n" + 
					");";
			
			String consulta = "insert into USER (NICK,EMAIL,PASSWORD) VALUES(?,?,?);";
			ps=con.prepareStatement(consulta);
			ps.setString(1, uName);
			ps.setString(2, uPass);
			ps.setString(3, uEmail);
			//si todo va bien return true
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

	}
		return false;
}
	
}