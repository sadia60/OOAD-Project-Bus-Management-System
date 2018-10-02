<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>feedback</title>
</head>
<body>

<form action="AddServlet" method="post">
<input type="hidden" name="formName" value="Feedback">        
Comments<input type="text" name="comments"> 
<br/>
Suggestions<input type="text" name="suggestions"> 
<br/>
Questions<input type="text" name="questions"> 
<br/>
<input type="submit" value="Submit"> 
<button onclick="goBack()">Go Back</button>

<script>
function goBack() {
    window.history.go(-2);
}
</script>
    </form>
</body>
</html>