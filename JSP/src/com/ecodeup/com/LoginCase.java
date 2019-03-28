package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
public class LoginCase {
	
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection con;
		
		con=ConnectionDB.getConnection();
		PreparedStatement ps =null;
		
		try {
			/*
		CREATE TABLE USER (
    NICK varchar(20) PRIMARY KEY,
    EMAIL varchar(20),
    PASSWORD varchar(20)
);

insert into USERS VALUES("hongzxc","zhouzxc","cf17hong.zhon@iesjoandaustria.org");

*/
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
			return false;
	}
}
	public static boolean select(String uName) {
		Connection con;
		con=ConnectionDB.getConnection();
		PreparedStatement ps =null;
		Statement stmt = null;
	    ResultSet result = null;
		
		try {
			stmt = con.createStatement();
	         result = stmt.executeQuery(
	            "SELECT NICK FROM USER Where NICK = '"+uName+"'");
	    
	         while(result.next()){
	            System.out.println(result.getString("NICK"));
	            if(result.getString("NICK") == "ytr") {
	            	System.out.println("El NICK ya existe");
		        	 
		         }else {
		        	 System.out.println("El NICK no existe");
		         }
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
			return false;
	}
}
	
	
}