package users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import controller.DbController;
import controller.SelectController;

/**
 * @author SadiaTariq
 * @version 1.0
 * @created 10-Nov-2016 4:44:56 PM
 */
public class Feedback {

	private String comments;
	private String suggestions;
	private String questions;
	private int feedbackNo;

	public int getFeedbackNo() {
		return feedbackNo;
	}

	public void setFeedbackNo(int feedbackNo) {
		this.feedbackNo = feedbackNo;
	}

	public Feedback(){

	comments = null;
	suggestions = null;
	questions = null;
		
	}

	public Feedback(int num,String com, String sugg, String que)
	{
		this.comments = com;
		this.suggestions = sugg;
		this.questions = que;
		this.feedbackNo = num;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public void finalize() throws Throwable {

	}

	public void takeFeedback()
	{
		Scanner in = new Scanner(System.in);
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			/*System.out.println("Do you want to give any comments? type 1 for yes and 2 for no ");
			int input1 = br.read();
			int opt1 = Character.getNumericValue(input1);    //as br takes ascii value so convert t into integer
			br.readLine();*/                                 //will read that null at end otherwise input will jot be taken
			boolean opt1Check = false;
			while(opt1Check != true)
			{	
				System.out.println("Do you want to give any comments? type 1 for yes and 2 for no ");
				int input1 = br.read();
				int opt1 = Character.getNumericValue(input1);    //as br takes ascii value so convert t into integer
				br.readLine();
				if (opt1 == 1)
				{
					System.out.println("Type your comments ");
					//String temp2 = br.readLine();	
					comments = br.readLine();
						//in.nextLine();
						//System.out.println(comments);
						
						opt1Check = true;
				}
			else if (opt1 == 2)
			{
				opt1Check = true;
			}
			else
			{
				System.out.println("Wrong option chosen please try again.");
			}
			}
			
//			in.nextLine();
			//br.readLine();
			boolean opt2Check = false;
			while(opt2Check != true)
			{	System.out.println("Do you want to give any suggestions? type 1 for yes and 2 for no ");
				int input2 = br.read();
				int opt2 = Character.getNumericValue(input2);
				br.readLine();
			
				if (opt2 == 1)
				{
					System.out.println("Type your suggestions ");
						suggestions = br.readLine();
						opt2Check = true;
				}
				else if (opt2 == 2)
				{
					opt2Check = true;
				}
				else
				{
					System.out.println("Wrong option chosen please try again.");
				}
			}
			//in.nextLine();
			//br.readLine();
			boolean opt3Check = false;
			
			while(opt3Check != true)
			{	
				System.out.println("Do you want to ask any questions? type 1 for yes and 2 for no ");
				int input3 = br.read();
				int opt3 = Character.getNumericValue(input3);
				//int opt3 = in.nextInt();
				br.readLine();
				
				if (opt3 == 1)
				{
					System.out.println("Type your questions ");
						questions = br.readLine();
						opt3Check = true;
				}
			else if (opt3 == 2)
			{
				opt3Check = true;
			}
				else
				{
					System.out.println("Wrong option chosen please try again.");
				}
			}


			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
/*		System.out.println("Do you want to give any comments? type 1 for yes and 2 for no ");
		int opt1 = in.nextInt();
		boolean opt1Check = false;
		while(opt1Check != true)
		{	if (opt1 == 1)
			{
				System.out.println("Type your comments ");
					comments = in.nextLine();
					//in.nextLine();
					System.out.println(comments);
					
					opt1Check = true;
			}
		else if (opt1 == 2)
		{
			opt1Check = true;
		}
			else
			{
				System.out.println("Wrong option chosen please try again.");
			}
		}
		
		in.nextLine();
		
		System.out.println("Do you want to give any suggestions? type 1 for yes and 2 for no ");
		int opt2 = in.nextInt();
		boolean opt2Check = false;
		while(opt2Check != true)
		{	if (opt2 == 1)
			{
				System.out.println("Type your suggestions ");
					suggestions = in.nextLine();
					opt2Check = true;
			}
			else if (opt2 == 2)
			{
				opt2Check = true;
			}
			else
			{
				System.out.println("Wrong option chosen please try again.");
			}
		}
		in.nextLine();
		
		System.out.println("Do you want to ask any questions? type 1 for yes and 2 for no ");
		int opt3 = in.nextInt();
		boolean opt3Check = false;
		while(opt3Check != true)
		{	if (opt3 == 1)
			{
				System.out.println("Type your questions ");
					questions = in.nextLine();
					opt3Check = true;
			}
		else if (opt3 == 2)
		{
			opt3Check = true;
		}
			else
			{
				System.out.println("Wrong option chosen please try again.");
			}
		}
		
		in.nextLine();*/
		
	}
	public void viewFeedback(){
		System.out.println("Comments: "+comments);
		System.out.println("Suggestions: "+suggestions);
		System.out.println("Questions: "+questions);
	}

	
	
	
	public List<Feedback> viewAllFeedback() {
		
		String query = "Select * from Feedback";
		 ResultSet resultSet = SelectController.getInstance().SelectAllFeedbacks(query);
   	 try {
	    		 List<Feedback> allFeedbacks = new ArrayList<Feedback>();
				while (resultSet.next()) 
	    		 {
	    			 int feedbackID = resultSet.getInt("fdkPK");
	                 String comm = resultSet.getString("comments");
	                 String sugg = resultSet.getString("suggestions");
	                 String que = resultSet.getString("questions");
	                 
	            	 allFeedbacks .add(new Feedback(feedbackID,comm,sugg,que));
				 }
	    		 return allFeedbacks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
   	
   	
   	return null;
	}

	
	
	
	
	
	public boolean giveFeedback(String com, String sug, String que){
		
		
boolean check = DbController.getInstance().addFeedback_connection(com, sug, que);
		
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