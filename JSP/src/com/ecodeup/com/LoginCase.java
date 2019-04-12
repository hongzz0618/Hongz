package com.ecodeup.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class LoginCase {
	
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection con;
		final Logger LOGGER = Logger.getLogger("com.ecodeup.com");
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
	            	//System.out.println("El NICK ya existe");
		        	 
		         }else {
		        	 //LOGGER.log(Level.SEVERE,"El NICK no existes");
		        	 String msn = "El nick no existe";
		        	//System.out.println("El NICK nox existe");
		        	
		         }
	         }
	         
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		    if (result != null) {
		        try {
		            result.close();
		        } catch (SQLException e) {  }
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) {  }
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {  }
		    }if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) {  }
		    }
		}
		return false;
}
	
	
}