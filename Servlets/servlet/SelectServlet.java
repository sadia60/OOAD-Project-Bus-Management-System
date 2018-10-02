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
import uiController.FacadeController;

@WebServlet(name = "SelectServlet", urlPatterns = {"/SelectServlet"})

public class SelectServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String form = request.getParameter("formName");
        HttpSession session = request.getSession(false);
        switch(form)
        {
        case "View Feedback":
        	
        }
        }
}
