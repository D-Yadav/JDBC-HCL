package com.hcl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {
public static void main(String[] args) {
	int empno;
	Scanner sc=new Scanner(System.in);
	//System.out.println("Enter Employ No: ");
	System.out.println("Enter AgentId: ");
	empno=sc.nextInt();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/sqlpractice","root","root");
		//String cmd="select * from Employ where Empno=?";
		String cmd="select * from Agent where AgentId=?";
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
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
		}else{
			System.out.println("Record Not Found! ");
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
