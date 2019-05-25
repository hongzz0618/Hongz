package com.ecodeup.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nameeee
 * permite conectar entre paginas
 * mediante POST o GET
 *  
 * @author cf17h
 *
 */
@WebServlet("/nameeee")

public class nameeee extends HttpServlet {
	/**
	 * constructor defecto
	 */
	private nameeee() { }
	//definimos los variables que vamos a utilizar
	private static final long serialVersionUID = 1L;
	Properties prop = new Properties();
	InputStream is = null;

	/**
	 * metode con la ayuda del servlet request y reponse 
	 * metode GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * metode con la ayuda del servlet request y reponse 
	 * hara un metode POST , desde el formulario del insert
	 * a una otra pagina dependiento de la informacion introducida
	 * vera si estan en formato esperado
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//abrimos el fichero properties para utilizarlo despues
			is = new FileInputStream("C:\\Users\\cf17h\\git\\Hongz\\JSP\\WebContent\\jsp\\help.properties");
			prop.load(is);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		// hacemos una pruba a ver si las informaciones introducida por el usuario
		//corresponde al pattern de properties
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Pattern pat =Pattern.compile(prop.getProperty("p1"));
		Matcher mat=pat.matcher(email);
		Pattern pat1 =Pattern.compile(prop.getProperty("p2"));
		Matcher mat1=pat1.matcher(user);
		Pattern pat2 =Pattern.compile(prop.getProperty("p3"));
		Matcher mat2=pat2.matcher(password);

		
		// si todo es correcto i sino ira dependiento el error
		if (mat1.find()) {
			if (mat.find()) {
				if (mat2.find()) {
				//hara el insert i ira a la pagina validado
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




