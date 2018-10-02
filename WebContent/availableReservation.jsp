<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="controller.FacadeController" %>
    <%@ page import ="services.Schedule" %>
   	<%@ page import ="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddServlet" method="post">
<input type="hidden" name="formName" value="Available reservation"  />
Choose Arrival city
				<select name="arrCity" onchange="" required = "required">
            	<option value="">select city</option>
				<option value="Baha1">Bahawalpur</option>
				<option value="Fais1">Faislabad</option>
				<option value="Kar1">Karachi</option>
				<option value="Lah1">Lahore</option>
				<option value="Isl1">Islamabad</option>
				<option value="Pes1">Peshawar</option>				
				</select> 
				<br>
				<br>
				Choose Departure city
				<select name="depCity" onchange="" required = "required">
            	<option value="">select city</option>
				<option value="Baha1">Bahawalpur</option>
				<option value="Fais1">Faislabad</option>
				<option value="Kar1">Karachi</option>
				<option value="Lah1">Lahore</option>
				<option value="Isl1">Islamabad</option>
				<option value="Pes1">Peshawar</option>				
				</select> 
				<br>
				<br>
				
<%
session.getAttribute("arr");
session.getAttribute("dep");
 FacadeController fc = FacadeController.getInstance();
				
				List <Schedule> schedule = fc.check_schedule(arr, dep);
%>
</form>				
</body>
</html>