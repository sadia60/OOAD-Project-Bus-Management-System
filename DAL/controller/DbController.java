package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Bus;
import services.Route;
//import DAL.ArrayList;
//import DAL.String;
import services.Schedule;
import users.Bushostess;
import users.Driver;
import users.Receptionist;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DbController
 */

public class DbController {
	//DbHandler dh = new DbHandler();
	//dh.loginConnection(role, uname, pass);
	String userName = "root";

	String password = "Goodluck693";

	String serverName = "localhost";

	int portNumber = 3306;

	String dbName = "aqsa_schema";

	private DbController()
	{
		
	}
	
	private static DbController instance = null;
	
	public static DbController getInstance() {

        if (instance == null) {

            instance = new DbController();
        }
        return instance;
    }

	public boolean logindb_connection(String executeQuery,String uname, String pass, int typ)
	{	
	boolean st = false;
	try {
		
	
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = null;

		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		System.out.println("trying to get connection!! ");
		conn = DriverManager.getConnection("jdbc:mysql://" + serverName
				+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
	Statement stat=	conn.createStatement();
	
	ResultSet rs = null;	
		
	
	PreparedStatement ps = conn.prepareStatement(executeQuery);
                //("select* from Person where username= ? and pass = ?");
		
		ps.setString(1, uname);
		ps.setString(2, pass);
		ps.setInt(3, typ);
		rs =ps.executeQuery();
		if (!rs.isBeforeFirst())
			return false;
		else
			return true;
		
		
		//conn.close();

		
		
	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return st;
	}
	
	public boolean addRoute_connection(Route r)
	{
		{			boolean st = false;
			try {
				
			
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = null;

				Properties connectionProps = new Properties();
				connectionProps.put("user", userName);
				connectionProps.put("password", password);
				System.out.println("trying to get connection!! ");
				conn = DriverManager.getConnection("jdbc:mysql://" + serverName
						+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
			Statement stat=	conn.createStatement();
			
			ResultSet rs = null;	
				
			
			PreparedStatement ps = conn.prepareStatement("insert into Route(arrivalCity, departureDay, departureMonth, departureYear, arrivalDay, arrivalMonth, arrivalYear, departureCity,departureHour, departureMinute, dayd, arrivalHour, arrivalMinute, daya)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					    //("select* from Person where username= ? and pass = ?");
				
			String arrplace = r.getArrivalCity();
			String depplace = r.getDepartureCity();
			String deparDate[] = r.getDepartureDate().split(" ");
			String deparTime[] = r.getDepartureTime().split(" ");
			String arriDate[] = r.getArrivalDate().split(" ");
			String arriTime[] = r.getArrivalTime().split(" ");
			String depday = deparDate[0];  
			String depmonth = deparDate[1];
			String depyear = deparDate[2];
			String arrday = arriDate[0];
			String arrmonth = arriDate[1];
			String arryear = arriDate[2];
			String arrhour = arriTime[0];
			String arrmin = arriTime[1];
			String atime = arriTime[2];
			String dephour = deparTime[0];
			String depmin = deparTime[1];
			String dtime = deparTime[2];
				ps.setString(1, arrplace);
				//ps.setString(2, depplace);
				ps.setString(2, depday);
				ps.setString(3, depmonth);
				ps.setString(4, depyear);
				ps.setString(5, arrday);
				ps.setString(6, arrmonth);
				ps.setString(7, arryear);
				ps.setString(8, depplace);
				
				ps.setString(9, dephour);
				ps.setString(10, depmin);
				ps.setString(11, dtime);
				ps.setString(12, arrhour);
				ps.setString(13, arrmin);
				ps.setString(14, atime);
				
				
				//rs =ps.executeQuery();
				int res=ps.executeUpdate();
				if (res==0)
					return false;
				else
					return true;
				
				
				//conn.close();

				
				
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return st;
		}
	}
	
	
	public boolean addBus_connection(Bus b)
	{
		{			
			boolean st = false;
			String busnum = b.getBusNo();
			String busname = b.getBusName();
			String enginenum = b.getEngineNo();
			String modelnum = b.getModel();
			String totalseat=Integer.toString(b.getTotalSeats());
			try {
				
			
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = null;

				Properties connectionProps = new Properties();
				connectionProps.put("user", userName);
				connectionProps.put("password", password);
				System.out.println("trying to get connection!! ");
				conn = DriverManager.getConnection("jdbc:mysql://" + serverName
						+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
			Statement stat=	conn.createStatement();
			
			ResultSet rs = null;	
				
			
			PreparedStatement ps = conn.prepareStatement("insert into Bus(busNo, busName, engineNo, model, totalSeats)"
					+ "values(?,?,?,?,?)");
					    //("select* from Person where username= ? and pass = ?");
				
			
				ps.setString(1, busnum);
				ps.setString(2, busname);
				ps.setString(3, enginenum);
				ps.setString(4, modelnum);
				ps.setString(5, totalseat);
				
				
				//rs =ps.executeQuery();
				int res=ps.executeUpdate();
				if (res==0)
					return false;
				else
					return true;
				
				
				//conn.close();

				
				
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return st;
		}	
	}
	
	public boolean addFeedback_connection(String com, String sug, String que)
	{
		{			
			boolean st = false;
			try {
				
			
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = null;

				Properties connectionProps = new Properties();
				connectionProps.put("user", userName);
				connectionProps.put("password", password);
				System.out.println("trying to get connection!! ");
				conn = DriverManager.getConnection("jdbc:mysql://" + serverName
						+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
			Statement stat=	conn.createStatement();
			System.out.println(" Connection achieved!! ");
			
			ResultSet rs = null;	
				
			
			PreparedStatement ps = conn.prepareStatement("insert into Feedback(comments, suggestions, questions)"+"values( ?,?,?)");
					    //("select* from Person where username= ? and pass = ?");
				
			
				ps.setString(1, com);
				ps.setString(2, sug);
				ps.setString(3, que);
				
				//rs =ps.executeQuery();
				int res=ps.executeUpdate();
				if (res==0)
					return false;
				else
					return true;
				
				
				//conn.close();

				
				
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return st;
		}	

	}
	
	public boolean adddriver_connection(Driver r)
	{
		String fname = r.getFname();
		String lname = r.getLname();
		String lisc = r.getLiscence();
		String nic = r.getNic();
		String addr = r.getAddress();
		String uname = r.getUsername();
		String pass = r.getPassword();
		
		String sal=Integer.toString(r.getSalary());
		String ag = Integer.toString(r.getAge());
		String phon = r.getPhoneNo();
		String mail = r.getEmail();
		String gen = r.getGender();
		String userName = "root";

		boolean st = false;
		try {
			
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = null;

			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			System.out.println("trying to get connection!! ");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverName
					+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
		Statement stat=	conn.createStatement();
		System.out.println(" Connection achieved!! ");
		
		ResultSet rs = null;	
			
		
		PreparedStatement ps = conn.prepareStatement("insert into Driver(salary, liscence)values (?,?)");
				    
			ps.setString(1, sal);
			ps.setString(2, lisc);
			
			int res=ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("insert into Person(nic, desFK, first_name, last_name, age, username, pass)values ( ?,3,?,?,?,?,?)");

			
			ps2.setString(1, nic);
			ps2.setString(2, fname);
			ps2.setString(3, lname);
			ps2.setString(4, ag);
			ps2.setString(5, uname);
			ps2.setString(6, pass);
			
			int res2 = ps2.executeUpdate();
			
			if (res==1 && res2==1)
				return true;
			else
				return false;
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return st;

	}
	

	
	public boolean addbushostess_connection(Bushostess b)
	{
		String fname = b.getFname();
		String lname = b.getLname();
		String nic = b.getNic();
		String addr = b.getAddress();
		String uname = b.getUsername();
		String pass = b.getPassword();
		
		String sal=Integer.toString(b.getSalary());
		String ag = Integer.toString(b.getAge());
		String phon = b.getPhoneNo();
		String mail = b.getEmail();
		String gen = b.getGender();
		String edu = b.getEducation();
		
		boolean st = false;
		try {
			
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = null;

			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			System.out.println("trying to get connection!! ");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverName
					+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
		Statement stat=	conn.createStatement();
		System.out.println(" Connection achieved!! ");
		
		ResultSet rs = null;	
			
		
		PreparedStatement ps = conn.prepareStatement("insert into Staff(salary, education)values ( ?,?)");
				    
			ps.setString(1, sal);
			ps.setString(2, edu);
			
			int res=ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("insert into Person(nic, desFK, first_name, last_name, age, username, pass)values ( ?,4,?,?,?,?,?)");

			ps2.setString(1, nic);
			ps2.setString(2, fname);
			ps2.setString(3, lname);
			ps2.setString(4, ag);
			ps2.setString(5, uname);
			ps2.setString(6, pass);
			
			int res2 = ps2.executeUpdate();
			
			if (res==1 && res2==1)
				return true;
			else
				return false;
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return st;

	}

	public boolean addReceptionist_connection(Receptionist r)
	{
		String fname = r.getFname();
		String lname = r.getLname();
		String nic = r.getNic();
		String addr = r.getAddress();
		String uname = r.getUsername();
		String pass = r.getPassword();
		
		String sal=Integer.toString(r.getSalary());
		String ag = Integer.toString(r.getAge());
		String phon = r.getPhoneNo();
		String mail = r.getEmail();
		String gen = r.getGender();
		String edu = r.getEducation();
	
		boolean st = false;
		try {
			
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = null;

			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			System.out.println("trying to get connection!! ");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverName
					+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
		Statement stat=	conn.createStatement();
		System.out.println(" Connection achieved!! ");
		
		ResultSet rs = null;	
			
		
		PreparedStatement ps = conn.prepareStatement("insert into Staff(salary, education)values ( ?,?)");
				    
			ps.setString(1, sal);
			ps.setString(2, edu);
			
			int res=ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("insert into Person(nic, desFK, first_name, last_name, age, username, pass)values ( ?,2,?,?,?,?,?)");

			ps2.setString(1, nic);
			ps2.setString(2, fname);
			ps2.setString(3, lname);
			ps2.setString(4, ag);
			ps2.setString(5, uname);
			ps2.setString(6, pass);
			
			int res2 = ps2.executeUpdate();
			
			if (res==1 && res2==1)
				return true;
			else
				return false;
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return st;

	}
	
	public List<Schedule> check_scheduledb(String query)
	{
		{
			List <Schedule> sclist = new ArrayList<Schedule>();
			//rouPk, rouFK, arrivalCity, departureDay, departureMonth, departureYear, arrivalDay, arrivalMonth, arrivalYear, departureCity,departureHour, departureMinute, dayd, arrivalHour, arrivalMinute, daya
			//String query1 = "select Route.arrivalCity, Route.departureDay, Route.departureMonth, Route.departureYear, Route.arrivalDay, Route.arrivalMonth, Route.arrivalYear, Route.departureCity, Route.departureHour, Route.departureMinute, Route.dayd, Route.arrivalHour, Route.arrivalMinute, Route.daya from Route"
				//	+ "inner join Bus on Route.rouFK = Bus.busPK inner join Seat on Bus.busPK= Seat.seaFK where  Route.arrivalCity= '"
					//+ arrivalCity+ "' and departureCity = '"+departCity+"')";
			
			//ResultSet resultSet = _dbConnection.ExecuteSelectQuery(_query);
	        
			try {
				
			
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = null;

				Properties connectionProps = new Properties();
				connectionProps.put("user", userName);
				connectionProps.put("password", password);
				System.out.println("trying to get connection!! ");
				conn = DriverManager.getConnection("jdbc:mysql://" + serverName
						+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
			Statement stat=	conn.createStatement();
			System.out.println(" Connection achieved!! ");
			
			ResultSet rs = stat.executeQuery(query);	
				
			if (rs == null) {
                return null;
            }
			//sclist
			while (rs.next())
			{
				Schedule s = new Schedule();
				Route r = new Route();
				//Route.arrivalCity, Route.departureDay, Route.departureMonth, Route.departureYear, Route.arrivalDay, Route.arrivalMonth, Route.arrivalYear, Route.departureCity, Route.departureHour, Route.departureMinute, Route.dayd, Route.arrivalHour, Route.arrivalMinute, Route.daya from Route
				r.setArrivalCity(rs.getString(1));
				r.setDepartureDate(rs.getString(2)+rs.getString(3)+rs.getString(4));
				r.setArrivalDate(rs.getString(5)+rs.getString(6)+rs.getString(7));
				r.setDepartureCity(rs.getString(8));
				r.setDepartureTime(rs.getString(9)+rs.getString(10)+rs.getString(11)+rs.getString(12));
				r.setArrivalTime(rs.getString(13)+rs.getString(14)+rs.getString(15)+rs.getString(16));
				
				s.setRouteAssigned(r);
				sclist.add(s);
				
			}
			
			return sclist;
			
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return sclist;
			
		}
		}
	
}
