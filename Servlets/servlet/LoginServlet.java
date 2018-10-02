package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.*;
import uiController.FacadeController;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        String t=request.getParameter("source");
        System.out.println("option: "+t);
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);

        //FacadeController fc = new FacadeController();
        boolean check = FacadeController.getInstance().login_controller(n,p,t);
        System.out.println(check);
        /*if(check){  
        	System.out.println("in wwelcome page now");
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
            rd.forward(request,response);  
        } */ 
        if (check == true && t.equals("Passenger"))
        {
        	RequestDispatcher rd=request.getRequestDispatcher("passenger.jsp");  
            rd.forward(request,response);  
        }
        else if (check == true && t.equals("Manager"))
        {
        	RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");  
            rd.forward(request,response);  
        }
        else if (check == true && t.equals("Receptionist"))
        {
        	RequestDispatcher rd=request.getRequestDispatcher("receptionist.jsp");  
            rd.forward(request,response);  
        }
        else if (check == true && t.equals("Bushostess"))
        {
        	RequestDispatcher rd=request.getRequestDispatcher("bushostess.jsp");  
            rd.forward(request,response);  
        }
        else if (check == true && t.equals("Driver"))
        {
        	RequestDispatcher rd=request.getRequestDispatcher("driver.jsp");  
            rd.forward(request,response);  
        }
        else{
        	System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    }  
    }
