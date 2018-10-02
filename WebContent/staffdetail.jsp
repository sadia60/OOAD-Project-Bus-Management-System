<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Details </title>
</head>
<body>
<!-- <form action="newpage.jsp">
 --><h1> Enter Details </h1><hr>


 
    <form action="AddServlet" method="post">
<input type="hidden" name="formName" value="staffdetail"  />     
 <p style="text-align:center">
 
	First Name <input type="text" name="fname">
	<br><br>
	<p style="text-align:center">
 
	Last Name  <input type="text" name="lname"> 
	<br><br>
 <p style="text-align:center">

		Age <input type="text" name="age">
		<br><br>
 <p style="text-align:center">
	
	Gender <input type="text" name="gender">
	<br><br>
 <p style="text-align:center">

	Email <input type="text" name="em">
 <p style="text-align:center">

    <br><br>
    Address  <input type="text" name="add">

    <br><br>
 <p style="text-align:center">

    Phone <input type="text" name="phone">
    <br><br>

	
    	<p style="text-align:center">
 
    NIC <input type="text" name="nic">
	<br><br>
	
	
	<p style="text-align:center">
 
    Username <input type="text" name="username">
	<br><br>
	
	
	<p style="text-align:center">
 
    Password <input type="text" name="userpass">
	<br><br>
	
	
	</div>
	
	<p style="text-align:center">
 	
            <select name="source" onchange="" required = "required">
            		<option value="">option</option>
					<option value="Receptionist">Receptionist</option>
					<option value="Driver">Driver</option>
					<option value="Bushostess">Bus hostess</option>
					</select>  
					     
 	<p style="text-align:center">
            
	
	<input type="submit"
		value="submit"><br />
		</form>
</body>
</html>