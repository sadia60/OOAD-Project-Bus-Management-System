package services;

import controller.DbController;
import serviceCharges.Reservation;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:16:46 PM
 */
public class Bus {

	private String busNo;
	private String busName;
	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Seat getSeats() {
		return seats;
	}

	public void setSeats(Seat seats) {
		this.seats = seats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Reservation getmReservation() {
		return mReservation;
	}

	public void setmReservation(Reservation mReservation) {
		this.mReservation = mReservation;
	}

	public Route getFollowRoute() {
		return followRoute;
	}

	public void setFollowRoute(Route followRoute) {
		this.followRoute = followRoute;
	}

	private String engineNo;
	private String model;
	private Seat seats;
	public int totalSeats;
	public Reservation mReservation;      //how manny seats are booked 
	//public Seat mSeat;
	public Route followRoute;
	public Bus(){
		busNo = null;
		engineNo = null;
		model = null;
		seats = null;
		totalSeats = 0;
		mReservation = null;
		//mSeat = null;
		
	}

	public void finalize() throws Throwable {

	}

	public boolean Add_Bus(String busnum, String busname, String enginenum, String modelnum, String totalseat){

		Bus bu = new Bus();
		bu.setBusNo(busname);
		bu.setBusName(busname);
		bu.setEngineNo(enginenum);
		bu.setModel(modelnum);
		int s = Integer.parseInt(totalseat);
		bu.setTotalSeats(s);
		//boolean check = DbController.getInstance().addBus_connection(busnum, busname, enginenum, modelnum, totalseat);
		boolean check = DbController.getInstance().addBus_connection(bu);
		
		if (check==true)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
		
	}

}