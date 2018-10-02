package services;


/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:17:48 PM
 */
public class Seat {

	private String seatType;             //vip or normal
	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Seat(){
		seatType = null;
	}

	public void finalize() throws Throwable {

	}

	public boolean IsSeat(){
		return false;
	}

}