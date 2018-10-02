package serviceCharges;

import services.Seat;
import users.Passenger;
import users.Receptionist;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:17:21 PM
 */
public class Reservation {

	public Passenger m_Passenger;
	public Receptionist m_Receptionist;
	//private Ticket tick;
	
	public Reservation(){

	}

	public void finalize() throws Throwable {

	}

	public int Calculate_Fair(int total, Seat s,int fare){
		return 0;
	}

	public void Make_Reservation(){

	}

	/*public Ticket getTick() {
		return tick;
	}

	public void setTick(Ticket tick) {
		this.tick = tick;
	}*/

}