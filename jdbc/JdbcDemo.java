package com.hcl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/sqlpractice","root","root");
		System.out.println("Connected...");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from Agent");
		while(rs.next()){
			//System.out.println("Employ No " +rs.getInt("empno"));
			//System.out.println("Name " +rs.getString("name"));
			//System.out.println("Department " +rs.getString("dept"));
			//System.out.println("Department " +rs.getString("desig"));
			//System.out.println("salary " +rs.getInt("basic"));
			//System.out.println("-------------------------------------------");
			
			System.out.println("AgentId "+rs.getInt("AgentId"));
			System.out.println("firstname "+rs.getString("firstname"));
			System.out.println("lastname "+rs.getString("lastname"));
			System.out.println("gender "+rs.getString("gender"));
			System.out.println("SSN "+rs.getString("SSN"));
			System.out.println("maritalStatus "+rs.getInt("maritalStatus"));
			System.out.println("address1 "+rs.getString("Address1"));
			
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
