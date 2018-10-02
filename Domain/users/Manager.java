package users;

import java.util.List;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:18:34 PM
 */
public class Manager extends Person  {

	int salary;
	String education;
	public Manager(){
		super();
		salary = 0;
		education = null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public List<Feedback> ViewAllFeedback() {

		Feedback fb = new Feedback();
		return fb.viewAllFeedback();
	}

}