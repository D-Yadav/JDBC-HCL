package com.hcl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployShow
 */
@WebServlet("/EmployShow")
public class EmployShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=DaoConnection.getConnection();
		String cmd="Select * from Employ";
		PrintWriter out=response.getWriter();
		try{
		PreparedStatement pst=conn.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
		out.println("Employ No "+rs.getInt("empno")+"<br/>");
		out.println("Employ Name "+rs.getString("name")+"<br/>");
		out.println("Department "+rs.getString("dept")+"<br/>");
		out.println("Designation "+rs.getString("desig")+"<br/>");
		out.println("salary "+rs.getInt("basic")+"<br/><hr>");
		}
		}catch(SQLException e){
		e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
