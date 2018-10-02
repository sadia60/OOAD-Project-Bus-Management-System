package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectController {

	private SelectController()
	{
		
	}
	
	private static SelectController instance = null;
	
	public static SelectController getInstance() {

        if (instance == null) {

            instance = new SelectController();
        }
        return instance;
    }
	
	public ResultSet SelectAllFeedbacks(String query) 
	{
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
		ResultSet rs = null;	
		
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
		
			
		rs = stat.executeQuery(query);
			
			
		return rs;
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return rs;
		
 	}


}
