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
 * Servlet implementation class EmploySearchServlet
 */
@WebServlet("/EmploySearchServlet")
public class EmploySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno=Integer.parseInt(request.getParameter("empno"));
		String cmd="select * from Employ where empno=?";
		Connection con=DaoConnection.getConnection();
		PrintWriter out=response.getWriter();
		try{
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1,empno);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
		out.println("Employ Name "+rs.getString("name")+"<br/>");
		out.println("Department "+rs.getString("dept")+"<br/>");
		out.println("Designation "+rs.getString("desig")+"<br/>");
		out.println("salary "+rs.getInt("basic")+"<br/><hr>");
		}else{
			out.println("Record Not Found...");
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
