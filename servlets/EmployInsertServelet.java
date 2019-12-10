package com.hcl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployInsertServelet
 */
@WebServlet("/EmployInsertServelet")
public class EmployInsertServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployInsertServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd="INSERT INTO EMPLOY VALUES(?,?,?,?,?)";
		Connection con=DaoConnection.getConnection();
		PrintWriter out=response.getWriter();
		try{
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
			pst.setString(2, request.getParameter("name"));
			pst.setString(3, request.getParameter("dept"));
			pst.setString(4, request.getParameter("desig"));
			pst.setInt(5, Integer.parseInt(request.getParameter("basic")));
			pst.executeUpdate();
			out.println("*****record inserted******");
			
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