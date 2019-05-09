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
	            	String msn = "El nick ya existe";
		        	 LOGGER.log(Level.INFO,msn);
	            
		        	 
		         }else {
		        	 String msn = "El nick no existe";
		        	 LOGGER.log(Level.INFO,msn);
		        	
		         }
	         }
	         
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		    if (result != null) {
		        try {
		            result.close();
		        } catch (SQLException e) {
		        	e.printStackTrace();
		        	
		        }
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { 
		        	e.printStackTrace();
		        	
		        }
		    }
		    
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { 
		        	e.printStackTrace();
		        	
		        }
		    }
		}
		return false;
}
	
	
}