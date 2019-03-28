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
@WebServlet("/nameeee")

public class nameeee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nameeee() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Pattern pat =Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat=pat.matcher(email);
		Pattern pat1 =Pattern.compile("^[A-Za-z0-9]{1,10}$");
		Matcher mat1=pat1.matcher(user);
		Pattern pat2 =Pattern.compile("^[A-Za-z0-9]{8,}$");
		Matcher mat2=pat2.matcher(password);

		
		if (mat1.find()) {
			if (mat.find()) {
				if (mat2.find()) {
					/*
					if(LoginCase.select(user)) {
						response.sendRedirect("/JSP/jsp/error.jsp");
					}else {*/
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
