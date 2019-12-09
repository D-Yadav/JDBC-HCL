<%@page import="com.hcl.jspJdbc.DaoConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.jspJdbc.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="EmploySearch.jsp">
<center>
Employ No:
<input type="text" name="empno"/><br/><br/>
<input type="submit" value="search"/>
</center>
</form>
<%
if(request.getParameter("empno")!=null){
int empno=Integer.parseInt(request.getParameter("empno"));
String cmd="select * from Employ where empno=?";
Connection con=DaoConnection.getConnection();
PreparedStatement pst=con.prepareStatement(cmd);
pst.setInt(1, empno);
ResultSet rs=pst.executeQuery();
if(rs.next()){
out.println("Name"+rs.getString("name")+"<br/>");
out.println("Dept"+rs.getString("dept")+"<br/>");
out.println("Designation"+rs.getString("desig")+"<br/>");
out.println("salary"+rs.getString("basic")+"<br/>");
}else{
out.println("********record not found**********");
}
}
%>

</body>
</html>