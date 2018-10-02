package users;

import controller.DbController;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:18:54 PM
 */
public class Bushostess extends Person  {

	int salary;
	String education;
	public Bushostess(){
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
	public boolean Add_Bushostess(String s,String us,String ps,String fn,String ln,String edu,
			String nic,String ph,String gender,String email,
			String address,String age){
		Bushostess b = new Bushostess();
		
		int sal = Integer.parseInt(s); 
		int ag = Integer.parseInt(age);
		setSalary( sal);
		b.setFname(fn);
	    b.setAddress(address);
		
		b.setNic(nic);
		b.setUsername(us);
		b.setEducation(edu);
		b.setPassword(ps);
		
		b.setPhoneNo(ph);
		b.setAge(ag);
		b.setGender(gender);
		b.setEmail(email);
		b.setNic(nic);
		
		boolean check = DbController.getInstance().addbushostess_connection(b);
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