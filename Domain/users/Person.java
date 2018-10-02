package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import controller.DbController;


/**
 * @author SadiaTariq
 * @version 1.0
 * @created 23-Nov-2016 3:19:59 PM
 */
public abstract class Person  {

	private String address;
	private int age;
	private String email;                //optional since it might be possible that he/she does not have any email
	private String fname;
	private String lname;
	private String nic;
	private String phoneNo;      
	private String gender;
	private String username;
	private String password;

	public Person (){
		address = null;
		age = 0;
		email = null;
		fname = null;
		lname = null;
		nic = null;
		phoneNo = null;
		gender = null;
		username = null;
		password = null;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void finalize() throws Throwable {

	}

	public void Add_Detail(String addr, int ag, String ema, String fnam, String lnam, String nic, String phone, String gen, String use, String pass){
		
		this.address = addr;
		this.age = ag;
		this.email = ema;        //pass ema = null in case if there is no email id of that person like passenger 
		this.fname = fnam;
		this.lname = lnam;
		this.nic = nic;
		this.phoneNo = phone;
		this.gender = gen;
		this.username = use;
		this.password = pass;
		
	}

	public boolean Authenticate_User(String uname, String pass, int typ){
		//String className = role.getClass().getSimpleName();        //classname means that whether he is manager, receptionist etc
		
		//dh.loginConnection(role, uname, pass);
		/** The name of the MySQL account to use (or empty for anonymous) */
		String userName = "root";

		/** The password for the MySQL account (or empty for anonymous) */
		String password = "Goodluck693";

		/** The name of the computer running MySQL */
		String serverName = "localhost";

		/** The port of the MySQL server (default is 3306) */
		int portNumber = 3306;

		/**
		 * The name of the database we are testing with (this default is
		 * installed with MySQL)
		 */
		String dbName = "aqsa_schema";

		/** The name of the table we are testing with */
		//String tableName = "customer";
		//
		// private Statement stmt;

		boolean st = false;
		try {
			
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = null;
	
			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			System.out.println("trying to get connection!! ");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverName
					+ ":" + portNumber + "/" + dbName+"?useSSL=false", connectionProps);
		Statement stat=	conn.createStatement();
		
		
		ResultSet rs = null;	
		System.out.println("uname: "+uname+ " pass:"+pass);
		if (typ == 1 || typ == 2 || typ == 4)
		{
			String executeQuery="select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Staff on Staff.staFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?";
			//PreparedStatement ps = conn.prepareStatement("select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Staff on Staff.staFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?");
	                //("select* from Person where username= ? and pass = ?");
		
			boolean check = DbController.getInstance().logindb_connection(executeQuery,uname,pass,typ);
			if (check==true)
			{
				return true;
			}
			else
			{
				return false;
			}
			//ps.setString(1, uname);
			//ps.setString(2, pass);
			//ps.setInt(3, typ);
			//rs =ps.executeQuery();
			//if (!rs.isBeforeFirst())
				//return false;
			//else
				//return true;
			
		}
		
		else if (typ == 3)
		{
			String executeQuery="select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Driver on Driver.driFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?";
			//PreparedStatement ps = conn.prepareStatement("select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Staff on Staff.staFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?");
	                //("select* from Person where username= ? and pass = ?");
		
			boolean check = DbController.getInstance().logindb_connection(executeQuery,uname,pass,typ);
			if (check==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		}
		
		else if (typ == 5)
		{
			String executeQuery = "select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Passenger on Passenger.pasFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?";
			boolean check = DbController.getInstance().logindb_connection(executeQuery,uname,pass,typ);
			if (check==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
/*		else if (typ == 3)
		{
			PreparedStatement ps = conn.prepareStatement("select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Driver on Driver.driFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?");
            //("select* from Person where username= ? and pass = ?");
	
	ps.setString(1, uname);
	ps.setString(2, pass);
	ps.setInt(3, typ);
	rs =ps.executeQuery();
	if (!rs.isBeforeFirst())
		return false;
	else
		return true;
	
		}
		
		else if (typ == 5)
		{
			PreparedStatement ps = conn.prepareStatement("select Person.nic, Person.first_name, Person.last_name, Person.age from Person inner join Passenger on Passenger.pasFK = Person.perPk  where Person.username=? and Person.pass=? and Person.desFK=?");
            //("select* from Person where username= ? and pass = ?");
	
	ps.setString(1, uname);
	ps.setString(2, pass);
	ps.setInt(3, typ);
	rs =ps.executeQuery();
	if (!rs.isBeforeFirst())
		return false;
	else
		return true;
	
		}*/
		
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return st;
	}

	public void Modify_Detail(){

	}

}