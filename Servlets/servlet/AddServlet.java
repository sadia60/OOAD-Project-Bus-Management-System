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

@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String form = request.getParameter("formName");
        HttpSession session = request.getSession(false);
        switch(form)
        {
        case "Route":
        	String arrplace = request.getParameter("arriveCity");
        	String depplace = request.getParameter("departCity");
        	String depday = request.getParameter("departDay");
        	//int depday = Integer.parseInt(request.getParameter("departDay"));
        	String depmonth = request.getParameter("departMonth");
        	String depyear = request.getParameter("departYear");
        	//int depyear = Integer.parseInt(request.getParameter("departYear"));
        	String arrday = request.getParameter("arriveDay");
        	//int arrday = Integer.parseInt(request.getParameter("arriveDay"));
        	String arrmonth = request.getParameter("arriveMonth");
        	String arryear = request.getParameter("arriveYear");
        	//int arryear = Integer.parseInt(request.getParameter("arriveYear"));
        	String arrhour = request.getParameter("arriveHour");
        	//int arrhour = Integer.parseInt(request.getParameter("arriveHour"));
        	String arrmin = request.getParameter("arriveMinute");
        	//int arrmin = Integer.parseInt(request.getParameter("arriveMinute"));
        	String dephour = request.getParameter("departHour");
        	//int dephour = Integer.parseInt(request.getParameter("departHour"));
        	String depmin = request.getParameter("departMinute");
        	//int depmin = Integer.parseInt(request.getParameter("departMinute"));
        	String atime = request.getParameter("timea");
        	String dtime = request.getParameter("timed");
        	
        	System.out.println("");
        	
        	if(FacadeController.route_controller(arrplace, depplace, depday, depmonth, depyear,
        			arrday, arrmonth, arryear, arrhour, arrmin, atime,
        			dephour, depmin, dtime)){  
                RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");  
                rd.forward(request,response);  
            }  
            else{  
                out.print("<p style=\"color:red\">Sorry username or password error</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");  
                rd.include(request,response);  
            }
            break;
            
        case "Feedback":
        
        String com=request.getParameter("comments");  
        String sug=request.getParameter("suggestions"); 
        String que=request.getParameter("questions");
        //System.out.println("option: "+t);
        //HttpSession session = request.getSession(false);
        if(session!=null)
        {
        	session.setAttribute("Comments", com);
        	session.setAttribute("Suggestions", sug);
        	session.setAttribute("Questions", que);

        }
        if(FacadeController.feedback_controller(com,sug,que)){  
            RequestDispatcher rd=request.getRequestDispatcher("feedbackSuccess.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("<p style=\"color:red\">Sorry give feedback again</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");  
            rd.include(request,response);  
        }
        break;
        
        case "feeback success":
        	HttpSession sessionf = request.getSession(false);
        	if (sessionf.getAttribute("Go back")!=null)
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("passenger.jsp");  
                rd.include(request,response); 
        	}
        	else if (sessionf.getAttribute("logout")!=null)
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
                rd.include(request,response); 
        	}
        case "Bus":
        
        	String busnum=request.getParameter("busNo");  
        	String busname=request.getParameter("busName");  
        	String enginenum=request.getParameter("engineNo");
        	String modelnum=request.getParameter("model");
        	String totalseat=request.getParameter("totalSeats");
        	if(FacadeController.bus_controller(busnum, busname, enginenum, modelnum, totalseat)){  
                RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
                rd.forward(request,response);  
            }  
            else{  
                out.print("<p style=\"color:red\">Sorry username or password error</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("bus.jsp");  
                rd.include(request,response);  
            }
        	
        	break;
        	
        case "Passenger":
        	String makereserve=request.getParameter("Make Reservation");  
        	String givefeedback=request.getParameter("Give Feedback");  
        	String viewfeedback=request.getParameter("View Feedback");
        	String logout=request.getParameter("logout");
        	HttpSession Session = request.getSession(false);
        
            if(Session.getAttribute("Give Feedback")!=null)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");  
                rd.include(request,response);  	
            }
            
            else if (Session.getAttribute("View Feedback")!=null)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("viewFeedback.jsp");  
                rd.include(request,response);  	
            }
            else
            {
            	RequestDispatcher rd=request.getRequestDispatcher("passenger.jsp");  
                rd.include(request,response);  
            }
            break;
            
        case "Mananger":
        	Session = request.getSession(false);
            if (Session.getAttribute("Add schedule")!=null)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("addSchedule.jsp");  
                rd.include(request,response);
            }
            else
            {
            	RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");  
                rd.include(request,response);
            }
            break;
            
        case "viewFeedback":
        
        case "Make reservation":
        	String arrivalCity = request.getParameter("arrCity");
        	String departCity = request.getParameter("depCity");
        	Session = request.getSession(false);
        	if(session!=null){
                session.setAttribute("arr", arrivalCity);
                session.setAttribute("dep", departCity);
        	}
            if (Session.getAttribute("arrCity")!=null && Session.getAttribute("depCity")!=null)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("availableReservation.jsp");  
                rd.include(request,response);
            }
        break;
       
        case  "Driver detail":
        	String fnl = request.getParameter("fname");
        	String ln= request.getParameter("lname");
        	String em= request.getParameter("em");
        	String add = request.getParameter("add");
        	String age = request.getParameter("age");
        	String  gen= request.getParameter("gender");
        	String NIC = request.getParameter("nic");
        	String ps = request.getParameter("phone");
        	String uname = request.getParameter("username");
        	String upass = request.getParameter("userpass");
        	String sal = request.getParameter("salary");
        	String lisc = request.getParameter("liscence");

        	if (FacadeController.getInstance().adddriver_fc(sal,lisc, uname, upass, fnl, ln,NIC, ps, gen, em, add, age) == true)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("driverSuccess.jsp");  
                rd.forward(request,response);  
            }

        	else
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("driverdetails.jsp");  
                rd.forward(request,response);  
        	}
            break;

        case  "Bushostess detail":
        	String bfn = request.getParameter("fname");
        	String bln= request.getParameter("lname");
        	String bem= request.getParameter("em");
        	String badd = request.getParameter("add");
        	String bage = request.getParameter("age");
        	String  bgen= request.getParameter("gender");
        	String bNIC = request.getParameter("nic");
        	String bph = request.getParameter("phone");
        	String buname = request.getParameter("username");
        	String bupass = request.getParameter("userpass");
        	String bsal = request.getParameter("salary");
        	String bedu = request.getParameter("education");

        	if (FacadeController.getInstance().addbushostess_fc(bsal, buname, bupass, bfn, bln, bedu, bNIC, bph, bgen, bem, badd, bage)== true)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("hostessSuccess.jsp");  
                rd.forward(request,response);  
            }

        	else
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("bushostessdetails.jsp");  
                rd.forward(request,response);  
        	}
            break;


        case  "Receptionist detail":
        	String rfn = request.getParameter("fname");
        	String rln= request.getParameter("lname");
        	String rem= request.getParameter("em");
        	String radd = request.getParameter("add");
        	String rage = request.getParameter("age");
        	String rgen= request.getParameter("gender");
        	String rNIC = request.getParameter("nic");
        	String rph = request.getParameter("phone");
        	String runame = request.getParameter("username");
        	String rupass = request.getParameter("userpass");
        	String rsal = request.getParameter("salary");
        	String redu = request.getParameter("education");

        	if (FacadeController.getInstance().addreceptionist_fc(rsal, runame, rupass, rfn, rln, redu, rNIC, rph, rgen, rem, radd, rage)== true)
            {
            	RequestDispatcher rd=request.getRequestDispatcher("receptionSuccess.jsp");  
                rd.forward(request,response);  
            }

        	else
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("receptionistdetails.jsp");  
                rd.forward(request,response);  
        	}
            break;


        }
        
        
        
        	
        out.close();  
    }  

}
