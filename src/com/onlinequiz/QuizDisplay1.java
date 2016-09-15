package com.onlinequiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QuizDisplay1")
public class QuizDisplay1 extends HttpServlet {
	
	ArrayList<QuizModel> Quiz = new ArrayList<QuizModel>();
	
	private static final long serialVersionUID = 1L;
    public QuizDisplay1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println("I am here");
		
		String num =request.getParameter("Number");
		String num1 =request.getParameter("Number1");
		String subject =request.getParameter("Subject");
		String[] dn = new String[3];
		String[] d = {"E","M","H"};
		dn[0] =request.getParameter("Easy");
		dn[1] =request.getParameter("Medium");
		dn[2] =request.getParameter("Hard");
		int Ques_no = 0;

		Boolean more = false;
		DBOps db = new DBOps();
		try {
			Connection conn = db.establishDBConnection();		
			
			String query ="SELECT* FROM Questions_Database where subject =? and difficulty_level=? ";
			
			int i=0;
			while(i<3){
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, subject);
				pstmt.setString(2, d[i]);
				ResultSet quest = pstmt.executeQuery();
				
		//		ResultSet quest = stmt.executeQuery(query);
				
				int count = 1;
				while(quest.next()){
					
					Quiz.add(new QuizModel(quest.getString("Question"),
							   quest.getString("option1"),quest.getString("option2"),
							   quest.getString("option3"),quest.getString("option4"),
							   quest.getString("answer")));
					count++;
					if (count>Integer.parseInt(dn[i])) {
						break;
					}
				}
				i++;
			}
		
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Generating Quiz...");
		System.out.println(Quiz.toString());
		
		RequestDispatcher rd=request.getRequestDispatcher("/NextPage1.html");  
        rd.include(request, response); 
        
		for (int j = 0; j < Quiz.size(); j++) {
			Ques_no = Ques_no+1;
			out.println((Ques_no)+"."+Quiz.get(j).getQuestion()+"<br>");
			out.println("<!DOCTYPE html>\n" +"<html>\n"+"<body>\n"+"<form>"+
					"<input type=radio name=option value='A'"+">"+Quiz.get(j).getOption1()+"<br>"+
					"<input type=radio name=option value='B'"+">"+Quiz.get(j).getOption2()+"<br>"+
					"<input type=radio name=option value='C'"+">"+Quiz.get(j).getOption3()+"<br>"+
					"<input type=radio name=option value='D'"+">"+Quiz.get(j).getOption4()+"<br>"+
					 "</form>"+"</body>\n"+"</html>"
					);
		}
		Quiz.clear();
					
	}

}
