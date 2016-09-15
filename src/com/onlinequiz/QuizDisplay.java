package com.onlinequiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QuizDisplay")
public class QuizDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QuizDisplay() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String num =request.getParameter("Number");
		String num1 =request.getParameter("Number1");
		String subject =request.getParameter("Subject");
		String e =request.getParameter("Easy");
		String m =request.getParameter("Medium");
		String h =request.getParameter("Hard");

//		int Ques_no = 0;
//		try {
//			DBOps db = new DBOps();
//			Connection conn = db.establishDBConnection();
//			Statement stat1 = conn.createStatement();
//			String query = "SELECT  * FROM (SELECT  * FROM   Questions_Database ORDER BY dbms_random.value) WHERE Subject="+ subject ;
//			ResultSet rs = stat1.executeQuery(query);
//			while(rs.next()){ //Giving the info about next row and moving to the next row.
//				Ques_no = Ques_no+1;
//				out.println((Ques_no)+"."+rs.getString(1)+" ");
//				out.println("(a)" + rs.getString(2)+" ");
//				out.println("(b)"+rs.getString(3)+" ");
//				out.println("(c)"+rs.getString(4)+" ");
//				out.println("(d)"+rs.getString(5)+" ");
//			}
			RequestDispatcher rd=request.getRequestDispatcher("/NextPage1.html");  
	        rd.include(request, response); 
			
//		} catch (ClassNotFoundException | SQLException e1) {
//			
//		}
					
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
