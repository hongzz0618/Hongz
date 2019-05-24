package com.ecodeup.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nameeee
 */
@WebServlet("/nameeee")

public class nameeee extends HttpServlet {
	private nameeee() { }
	//definimos las cosas que vamos a utilizar despues
	final static Logger LOGGER = Logger.getLogger("com.ecodeup.com");
	private static final long serialVersionUID = 1L;
	Properties prop = new Properties();
	InputStream is = null;
	
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    
//para guardar las cosas mas seguramente vamos a utilizar POST
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leemos ese fichero propertie para uzarlo despues
		//guardamos los parametros obtenidos a una variable
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//hacemos el pattern para que compile bien lo que introduce el usuario, mediante el fichero properties obtenemos el pattern
		Pattern pat =Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat=pat.matcher(email);
		Pattern pat1 =Pattern.compile("^[A-Za-z0-9]{1,10}$");
		Matcher mat1=pat1.matcher(user);
		Pattern pat2 =Pattern.compile("^[A-Za-z0-9]{8,}$");
		Matcher mat2=pat2.matcher(password);

	//conjunto redirecciones de ifs, dependiendo del que introdusca el usuario ira a una otra jsp 	
		if (mat1.find()) {
			if (mat.find()) {
				if (mat2.find()) {
				
						LoginCase.insertUser(user,password,email);	
						response.sendRedirect("/JSP/jsp/validar.jsp");
		
			
		}else {
			response.sendRedirect("/JSP/jsp/validarno.jsp");
		}
	}else {
		response.sendRedirect("/JSP/jsp/validarno1.jsp");
	}
		}else {
			response.sendRedirect("/JSP/jsp/validarno2.jsp");
		}
	}

}




