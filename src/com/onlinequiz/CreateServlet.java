package com.onlinequiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/Create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String p=request.getParameter("param1"); 
		
		if(p.equals("") || p.equals(" ")){  
			out.println("Please enter name of Quiz"); 
	        RequestDispatcher rd=request.getRequestDispatcher("/Welcome.html");  
	        rd.include(request, response);  
	    } 
		else{
			RequestDispatcher rd=request.getRequestDispatcher("/NextPage.html");  
	        rd.forward(request, response);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
