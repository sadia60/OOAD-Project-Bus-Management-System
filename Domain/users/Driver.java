package users;

import controller.DbController;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:18:44 PM
 */
public class Driver extends Person  {

	private int salary;
	private String liscence;
	
	public Driver(){
		super();
		salary = 0;
		liscence = null;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLiscence() {
		return liscence;
	}

	public void setLiscence(String liscence) {
		this.liscence = liscence;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public boolean Add_Driver(String s,String L,String us,String ps,String fn,String ln,
			String nic,String ph,String gender,String email,
			String address,String age){
		Driver d = new Driver();
		
		int sal = Integer.parseInt(s); 
		int ag = Integer.parseInt(age);
		setSalary( sal);
		 setLiscence( L);
		d.setFname(fn);
	    d.setLname(ln);;
	    d.setAddress(address);
		
		d.setNic(nic);
		d.setUsername(us);
		d.setSalary(sal);
		d.setPassword(ps);
		
		d.setPhoneNo(ph);
		d.setAge(ag);
		d.setGender(gender);
		d.setEmail(email);
		d.setNic(nic);
		
		boolean check = DbController.getInstance().adddriver_connection(d);
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