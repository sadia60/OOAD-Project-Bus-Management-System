<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bus</title>
</head>
<body>
<form action="AddServlet" method="post">
<input type="hidden" name="formName" value="Bus"  />
Bus No <input type="text" name="busNo" required="required"/>
<br>
<br>
Bus Name <input type="text" name="busName" required="required"/>
<br>
<br>
Engine No <input type="text" name="engineNo" required="required"/>
<br>
<br>
Model <input type="text" name="model" required="required"/>
<br>
<br>
Total seats <input type="text" name="totalSeats" required="required"/>
<br>
<br>
<input type="submit" value="Add bus">
</form>
</body>
</html>