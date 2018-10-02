package users;

import controller.DbController;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:19:18 PM
 */
public class Receptionist extends Person  {

	int salary;
	String education;
	
	public Receptionist(){
		super();
		salary = 0;
		education = null;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public boolean Add_Receptionist(String s,String us,String ps,String fn,String ln,String ad,
			String nic,String ph,String gender,String email,
			String address,String age){
		Receptionist r = new Receptionist();
		
		int sal = Integer.parseInt(s); 
		int ag = Integer.parseInt(age);
		setSalary( sal);
		r.setFname(fn);
	    r.setAddress(address);
		
		r.setNic(nic);
		r.setUsername(us);
		
		r.setPassword(ps);
		
		r.setPhoneNo(ph);
		r.setAge(ag);
		r.setGender(gender);
		r.setEmail(email);
		r.setNic(nic);
		
		boolean check = DbController.getInstance().addReceptionist_connection(r);
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