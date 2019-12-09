<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.jspJdbc.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="EmployInsert.jsp">
		<center>
			Employ No : 
		<input type="text" name="empno" /> <br/> 
		Employ Name : 
		<input type="text" name="name" /> <br/> 
		Department : 
		<input type="text" name="dept" /> <br/> 
		Designation : 
		<input type="text" name="desig" /> <br/> <br/>
		Basic : 
		<input type="text" name="basic" /> <br/><br/> 
		<input type="submit" value="Insert" />
		</center>
	</form>
	<%
		if(request.getParameter("empno") !=null &&
			request.getParameter("basic") !=null
				)
		{
			int empno=Integer.parseInt(request.getParameter("empno"));
			int basic=Integer.parseInt(request.getParameter("basic"));
			Connection con=DaoConnection.getConnection();
			String cmd="insert into Employ values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.setString(2, request.getParameter("name"));
			pst.setString(3, request.getParameter("dept"));
			pst.setString(4, request.getParameter("desig"));
			pst.setInt(5, basic);
			pst.executeUpdate();
			out.println("*** Record Inserted ***");
		}
	%>
</body>
</html>