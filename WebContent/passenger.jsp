<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>passenger</title>
</head>
<body>
<form action="AddServlet" method="post">
<input type="hidden" name="formName" value="Passenger"  />
<a href="reservation.jsp">Make Reservation</a>
<br>
<br>
<a href="feedback.jsp">Give Feedback</a>
<br>
<br>
<a href="viewFeedback.jsp">View Feedback</a>
<br>
<br>
<a href="generateTicket.jsp">Generate Ticket</a>
<br>
<br>
<a href="home.jsp">logout</a>
<br>
<br>             
</form>

</body>
</html>