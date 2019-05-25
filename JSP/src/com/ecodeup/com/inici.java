
package com.ecodeup.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inicio
 * permite conectar entre pagina index.jsp mediante GET o POST
 * @author cf17h
 *
 */
@WebServlet("/inici")
public class inici extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    /**
     * constructor defecto
     */
    public inici() {
        super();
        // Auto-generated constructor stub
    }
 
    

	/**
	 * metode con la ayuda del servlet request y reponse 
	 * hara un metode GET
	 * Utilizamos este metodo
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//si todo va bien ira al index.jsp
		getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	/**
	 * metode con la ayuda del servlet request y reponse 
	 * hara un metode POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
