package services;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import controller.DbController;
/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:17:03 PM
 */
public class Route {

	private String arrivalCity;
	private String departureCity;
	private int routeNo;
	private String arrivalDate;
	//private String arrivalMonth;
	//private String arrivalYear;
	private String departureDate;
	//private String departureMonth;
	//private String departureYear; //departureHour varchar(4), departureMinute varchar(4), dayd, daya, arrivalHour, arrivalMinute
	private String arrivalTime;
	private String departureTime;
	public Route(){
		arrivalCity = null;
		departureCity = null;
		routeNo = 0;
		arrivalDate = null;
		departureDate = null;
		arrivalTime = null;
		departureTime = null;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void finalize() throws Throwable {

	}

	public boolean IsRoute(){
		return false;
	}

	public void Search_Route(String arrival,String Departure,Date date,String Time){

	}
	
	public boolean addRoute(String arrplace, String depplace, String depday, String depmonth,
	String depyear,String arrday, String arrmonth, String arryear, String arrhour, String arrmin, String atime, String dephour, String depmin, String dtime)
	{
		Route r = new Route();
		r.setArrivalCity(arrplace);
		r.setDepartureCity(depplace);
		String depDate = null;
		depDate = depday+" "+depmonth+" "+depyear;
		//depDate = depDate.concat(depday).concat(" ").concat(depmonth).concat(" ").concat(depyear);
		System.out.println("dep date: "+depDate);
		String arrDate = null;
		//arrDate = arrDate.concat(arrday).concat(" ").concat(arrmonth).concat(" ").concat(arryear);
		arrDate = arrday+" "+arrmonth+" "+arryear;
		r.setDepartureDate(depDate);
		r.setArrivalDate(arrDate);
		String depTime = null;
		depTime = dephour+" "+depmin+" "+dtime;
		//depTime.concat(dephour).concat(depmin).concat(dtime);
		String arrTime = null;
		arrTime = arrhour+" "+arrmin+" "+atime;
		//arrTime.concat(arrhour).concat(arrmin).concat(atime);
		r.setDepartureTime(depTime);
		r.setArrivalTime(arrTime);
		//DbController dbc = new DbController();
		//boolean check = DbController.getInstance().addRoute_connection(arrplace, depplace, depday, depmonth, depyear, arrday, arrmonth, arryear, arrhour, arrmin, atime, dephour, depmin, dtime);
		boolean check = DbController.getInstance().addRoute_connection(r);
		
		if (check==true)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public List<Schedule> check_scheduleroute(String arrivalCity, String departCity)
	{
		//this.arrivalCity = arrivalCity;
		//this.departureCity = departCity;
		//List <Schedule> sclist = new ArrayList<Schedule>();
		//rouPk, rouFK, arrivalCity, departureDay, departureMonth, departureYear, arrivalDay, arrivalMonth, arrivalYear, departureCity,departureHour, departureMinute, dayd, arrivalHour, arrivalMinute, daya
		String query1 = "select Route.arrivalCity, Route.departureDay, Route.departureMonth, Route.departureYear, Route.arrivalDay, Route.arrivalMonth, Route.arrivalYear, Route.departureCity, Route.departureHour, Route.departureMinute, Route.dayd, Route.arrivalHour, Route.arrivalMinute, Route.daya from Route"
				+ "inner join Bus on Route.rouFK = Bus.busPK inner join Seat on Bus.busPK= Seat.seaFK where  Route.arrivalCity= '"
				+ arrivalCity+ "' and departureCity = '"+departCity+"')";
		List<Schedule> s =new ArrayList<Schedule>();
		
		s = DbController.getInstance().check_scheduledb(query1);
		
		if (s == null)
		{
			return null;
		}
		
		else
		{
			return s;
		}
		//ResultSet resultSet = _dbConnection.ExecuteSelectQuery(_query);
        
		
	}

}