package uiController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import services.Bus;
import services.Route;
import services.Schedule;
import services.Seat;
import users.Bushostess;
import users.Driver;
import users.Feedback;
import users.Manager;
import users.Passenger;
import users.Person;
import users.Receptionist;

public class FacadeController {

	private FacadeController()
	{
		
	}
	
	private static FacadeController instance = null;
	
	public static FacadeController getInstance() {
		

        if (instance == null) {

            instance = new FacadeController();
        }
        return instance;
    }


	public boolean login_controller(String u, String n, String typ){
		
		System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		boolean status = false;
		/*int t = 1;     //for manager in db table 
		Manager m = new Manager();
		if (m.Authenticate_User(u, n, t) == true)
		{
			status = true;
		}
		else
		{
			status = false;
		}*/
		System.out.println(typ);
		if (typ.equals("Manager"))
		{
			int t = 1;     //for manager in db table 
			Manager m = new Manager();
			if (m.Authenticate_User(u, n, t) == true)
			{
				System.out.println("its true now");
				status = true;
			}
			else
			{System.out.println("its false now");
				status = false;
			}
			System.out.println("this is facade controller");
		}
		
		else if (typ.equals("Receptionist"))
		{
			int t = 2;     //for receptionist in db table 
			Receptionist r = new Receptionist();
			if (r.Authenticate_User(u, n, t) == true)
			{
				status = true;
			}
			else
			{
				status = false;
			}
		}
		
		else if (typ.equals("Driver"))
		{
			int t = 3;     //for Driver in db table 
			Driver d = new Driver();
			if (d.Authenticate_User(u, n, t) == true)
			{
				status = true;
			}
			else
			{
				status = false;
			}
		}
		
		else if (typ.equalsIgnoreCase("Bushostess"))
		{
			int t = 4;     //for bushostess in db table 
			Bushostess b = new Bushostess();
			if (b.Authenticate_User(u, n, t) == true)
			{
				status = true;
				System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
				return true;
			}
			else
			{
				status = false;
			}
		}
		
		else if (typ.equals("Passenger"))
		{
			int t = 5;     //for passenger in db table 
			Passenger p = new Passenger();
			if (p.Authenticate_User(u, n, t) == true)
			{
				status = true;
			}
			else
			{
				status = false;
			}
		}
		
		else
		{
			status = false;
		}
	
		return status;
	}
	
	
	public static boolean feedback_controller(String com, String sug, String que)
	{
		Feedback f = new Feedback();
		boolean status = false;
		if (f.giveFeedback(com, sug, que))
		{
			status = true;
		}
		else
		{
			status = false;
		}
		
		return status;
	}
	
	public static boolean route_controller(String arrplace, String depplace, String depday,String depmonth,
			String depyear,String arrday,String arrmonth,String arryear, String arrhour, String arrmin, String atime,
			String dephour, String depmin, String dtime)
	{
		Route r = new Route();
		//int depDayy = Integer.parseInt(depday.trim());

		boolean status = r.addRoute(arrplace, depplace, depday, depmonth, depyear, arrday, arrmonth, arryear, arrhour, arrmin, atime, dephour, depmin, dtime);
	
		if (status == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean bus_controller(String busnum,String busname, String enginenum, String modelnum, String totalseat)
	{
		Bus b = new Bus();
		boolean status = b.Add_Bus(busnum, busname, enginenum, modelnum, totalseat);
		if (status == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<Feedback> viewFeedback()
	{
			Manager manager = new Manager();
			return manager.ViewAllFeedback();		
	}
	public List<Schedule> check_schedule(String arrivalCity,String departCity)
	{
		List<Schedule> cs =new ArrayList<Schedule>();

		Schedule s = new Schedule();
			cs = s.schedule_exist(arrivalCity, departCity);
		if 	(cs.isEmpty())
		{
			return null;
		}
		System.out.println(cs);
		
		for (int i =0; i < cs.size();i++)
		{
			System.out.println();
		}
		return cs;
	}
	
	public static boolean adddriver_fc(String s,String L,String us,String ps,String fn,String ln,
			String nic,String ph,String gender,String email,
			String address,String age)
	{
		Driver d = new Driver();
		boolean status = d.Add_Driver(s, L, us, ps, fn, ln,nic, ph, gender, email, address, age);
		if (status == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean addbushostess_fc(String s,String us,String ps,String fn,String ln,String edu,
			String nic,String ph,String gender,String email,
			String address,String age)
	{
		Bushostess b = new Bushostess();
		boolean status = b.Add_Bushostess(s,us, ps, fn, ln, edu, nic, ph, gender, email, address, age);
		if (status == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean addreceptionist_fc(String s,String us,String ps,String fn,String ln,String ad,
			String nic,String ph,String gender,String email,
			String address,String age)
	{
		Receptionist r = new Receptionist();
		boolean status = r.Add_Receptionist(s, us, ps, fn, ln, ad, nic, ph, gender, email, address, age);
		if (status == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
