<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="users.Feedback" %>
    <%@ page import="uiController.FacadeController" %>
     	 <%@	page import= "java.util.List"%>
     	  <%@	page import= "java.util.Collections"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view feedback</title>
<title><%=session.getAttribute("Comments ")%></title>
<title><%=session.getAttribute("Suggestions ")%></title>
<title><%=session.getAttribute("Questions ")%></title>
</head>
<body>
<input type="hidden" name="formName" value="View Feedback"  />

<% FacadeController fc = FacadeController.getInstance();
List<Feedback> feedbacks= fc.viewFeedback();
Collections.reverse(feedbacks);
%>		

<TABLE bordercolor="8989" align="center"  BORDER=2 CELLPADDING=5 CELLSPACING=5 style="text-align:center" >
		
		<TR>
				    <TD> Feedback ID </TD><TD> Comments </TD><TD> Suggestions</TD><TD> Questions</TD>
				    </TR>	
				<% for(Feedback feedback: feedbacks) { %>
				    <TR>
				    <TD><%=feedback.getFeedbackNo() %></TD><TD><%=feedback.getComments() %></TD><TD> <%=feedback.getSuggestions() %></TD><TD> <%=feedback.getQuestions() %></TD>
				    </TR>
				<% } %>
	</TABLE>		
<a href="manager.jsp">back</a>
<br>
<br>
</body>
</html>