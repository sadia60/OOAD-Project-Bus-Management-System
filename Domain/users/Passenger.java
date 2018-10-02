package users;

import serviceCharges.Payment;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:19:03 PM
 */
public class Passenger extends Person  {

	public Payment mPayment;
	public Feedback fback;
	
	public Passenger(){
		super();
		mPayment = null;
		fback = null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	

}