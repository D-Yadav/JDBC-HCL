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
<form method="get" action="DepartmentInsert.jsp">
<center>
Department No :
<input type="text" name="Deptno" /> <br/>
Department Name :
<input type="text" name="Dname" /> <br/>
Location :
<input type="text" name="Loc" /> <br/>
City :
<input type="text" name="City" /> <br/> <br/>
Head :
<input type="text" name="Head" /> <br/><br/>
<input type="submit" value="Insert" />
</center>
</form>
<%
if(request.getParameter("Deptno") !=null )
{
int Deptno=Integer.parseInt(request.getParameter("Deptno"));
Connection con=DaoConnection.getConnection();
String cmd="insert into department values(?,?,?,?,?)";
PreparedStatement pst=con.prepareStatement(cmd);
pst.setInt(1, Deptno);
pst.setString(2, request.getParameter("Dname"));
pst.setString(3, request.getParameter("Loc"));
pst.setString(4, request.getParameter("City"));
pst.setString(5, request.getParameter("Head"));
pst.executeUpdate();
out.println("*** Record Inserted ***");
}
%>
</body>
</html>