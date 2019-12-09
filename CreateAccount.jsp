<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="CreateAccount.jsp">
		<center>
			Account No : 
			<input type="text"  readonly="readonly"  name="accountNo" /> <br/><br/> 
			First Name : 
			<input type="text" name="firstName" /> <br/><br/> 
			Last Name : 
			<input type="text" name="lastName" /> <br/><br/> 
			City : 
			<input type="text" name="city" /> <br/><br/> 
			State : 
			<input type="text" name="state" /> <br/><br/> 
			Amount : 
			<input type="text" name="amount" /> <br/><br/> 
			Cheq Facil : 
			<select name="cheqFacil">
				<option value="Yes">Yes</option>
				<option value="No">No</option>
			</select> <br/><br/>
			Account Type : 
			<select name="accountType">
				<option value="Savings">Savings</option>
				<option value="Current">Current</option>
			</select> <br/><br/> 
			<input type="submit" value="Create Account" />
		</center>
	</form>
	
</body>
</html>