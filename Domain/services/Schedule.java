package services;


import java.util.ArrayList;
import java.util.List;

import controller.DbController;
/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:18:14 PM
 */
public class Schedule {

	//private Route routesAvailable;
	private Route routeAssigned;

	public Route getRouteAssigned() {
		return routeAssigned;
	}

	public void setRouteAssigned(Route routeAssigned) {
		this.routeAssigned = routeAssigned;
	}

	public Schedule(){

	}

	public void finalize() throws Throwable {

	}

	public void Add_schedule(){

	}

	public void delete_schedule(){

	}

	public void view_Schedule(){

	}

	public List<Schedule> schedule_exist(String arrivalCity,String departCity)
	{
			Route ro = new Route();
			List<Schedule> sc =new ArrayList<Schedule>();
			sc = ro.check_scheduleroute(arrivalCity,departCity);
			
			if (sc == null)
			{
				return null;
			}
			else
			{
				return sc;
			}
			
	}
}