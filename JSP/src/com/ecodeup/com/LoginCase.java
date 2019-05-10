package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level; 
import java.util.logging.Logger;

public class LoginCase {
	final static Logger LOGGER = Logger.getLogger("com.ecodeup.com");
	private LoginCase() { }
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection con;
		
		con=ConnectionDB.getConnection();
		PreparedStatement ps =null;
		
		try {
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