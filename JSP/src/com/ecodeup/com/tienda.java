package com.ecodeup.com;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/tienda")

public class tienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
	private tienda() { }

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
		
		
		String nick= request.getParameter("nick");
		
		String select = request.getParameter("select");
	
		
		Pattern pat1 =Pattern.compile("^[A-Za-z0-9]{1,10}$");
		Matcher mat1=pat1.matcher(nick);
		
		Pattern pat2 =Pattern.compile("^[0-9]$");
		Matcher mat2=pat2.matcher(select);

		
		if (mat1.find()) {
				if (mat2.find()) {
					
			response.sendRedirect("/JSP/jsp/validar.jsp");
			
			
		}else {
			response.sendRedirect("/JSP/jsp/validarno.jsp");
		}
	}else {
		response.sendRedirect("/JSP/jsp/validarno1.jsp");
	}


	}}
