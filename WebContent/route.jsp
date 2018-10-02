<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>route</title>
</head>
<body>
<form action="AddServlet" method="post">
<input type="hidden" name="formName" value="Route" />

				
				Arrival city
				<select name="arriveCity" onchange="" required = "required">
            	<option value="">select city</option>
				<option value="Baha1">Bahawalpur</option>
				<option value="Fais1">Faislabad</option>
				<option value="Kar1">Karachi</option>
				<option value="Lah1">Lahore</option>
				<option value="Isl1">Islamabad</option>
				<option value="Pes1">Peshawar</option>
				
				</select> 
				<br>
				<br>
				
				Departure city      
            	<select name="departCity" onchange="" required = "required">
            	<option value="">select city</option>
				<option value="Baha2">Bahawalpur</option>
				<option value="Fais2">Faislabad</option>
				<option value="Kar2">Karachi</option>
				<option value="Lah2">Lahore</option>
				<option value="Isl2">Islamabad</option>
				<option value="Pes2">Peshawar</option>
	
				</select>       
				<br>
				<br>
				
				Departure date
            	<select name="departDay" onchange="" required = "required">
            	<option value="">select day</option>
				<option value="1d">1</option>
				<option value="2d">2</option>
				<option value="3d">3</option>
				<option value="4d">4</option>
				<option value="5d">5</option>
				<option value="6d">6</option>
				<option value="7d">7</option>
				<option value="8d">8</option>
				<option value="9d">9</option>
				<option value="10d">10</option>
				<option value="11d">11</option>
				<option value="12d">12</option>
				<option value="13d">13</option>
				<option value="14d">14</option>
				<option value="15d">15</option>
				<option value="16d">16</option>
				<option value="17d">17</option>
				<option value="18d">18</option>
				<option value="19d">19</option>
				<option value="20d">20</option>
				<option value="21d">21</option>
				<option value="22d">22</option>
				<option value="23d">23</option>
				<option value="24d">24</option>
				<option value="25d">25</option>
				<option value="26d">26</option>
				<option value="27d">27</option>
				<option value="28d">28</option>
				<option value="29d">29</option>
				<option value="30d">30</option>
				<option value="31d">31</option>
				
				
								
				</select>       
				
				</select>       
            	<select name="departMonth" onchange="" required = "required">
            	<option value="">select month</option>
				<option value="Jan1">January</option>
				<option value="Feb1">February</option>
				<option value="Mar1">March</option>
				<option value="Apr1">April</option>
				<option value="May1">May</option>
				<option value="Jun1">June</option>
				<option value="Jul1">July</option>
				<option value="Aug1">August</option>
				<option value="Sep1">September</option>
				<option value="Oct1">October</option>
				<option value="Nov1">November</option>
				<option value="Dec1">December</option>
				</select>       
				
				
				</select>       
            	<select name="departYear" onchange="" required = "required">
            	<option value="">select year</option>
				<option value="2016d">2016</option>
				<option value="2017d">2017</option>
				<option value="2018d">2018</option>
				</select>       
				
				<br>
				<br>
				
				Arrival date
				<select name="arriveDay" onchange="" required = "required">
				<option value="">select day</option>
				<option value="1a">1</option>
				<option value="2a">2</option>
				<option value="3a">3</option>
				<option value="4a">4</option>
				<option value="5a">5</option>
				<option value="6a">6</option>
				<option value="7a">7</option>
				<option value="8a">8</option>
				<option value="9a">9</option>
				<option value="10a">10</option>
				<option value="11a">11</option>
				<option value="12a">12</option>
				<option value="13a">13</option>
				<option value="14a">14</option>
				<option value="15a">15</option>
				<option value="16a">16</option>
				<option value="17a">17</option>
				<option value="18a">18</option>
				<option value="19a">19</option>
				<option value="20a">20</option>
				<option value="21a">21</option>
				<option value="22a">22</option>
				<option value="23a">23</option>
				<option value="24a">24</option>
				<option value="25a">25</option>
				<option value="26a">26</option>
				<option value="27a">27</option>
				<option value="28a">28</option>
				<option value="29a">29</option>
				<option value="30a">30</option>
				<option value="31a">31</option>
				
				</select>      
				
				<select name="arriveMonth" onchange="" required = "required">
            	<option value="">select month</option>
				<option value="Jan2">January</option>
				<option value="Feb2">February</option>
				<option value="Mar2">March</option>
				<option value="Apr2">April</option>
				<option value="May2">May</option>
				<option value="Jun2">June</option>
				<option value="Jul2">July</option>
				<option value="Aug2">August</option>
				<option value="Sep2">September</option>
				<option value="Oct2">October</option>
				<option value="Nov2">November</option>
				<option value="Dec2">December</option>
				
				</select>      
				
				<select name="arriveYear" onchange="" required = "required">
            	<option value="">select year</option>
				<option value="2016a">2016</option>
				<option value="2017a">2017</option>
				<option value="2018a">2018</option>
				</select>     
				<br> 
				<br>
				
				Arrival time
				<select name="arriveHour" onchange="" required = "required">
            	<option value="">select hour</option>
				<option value="1ar">1</option>
				<option value="2ar">2</option>
				<option value="3ar">3</option>
				<option value="4ar">4</option>
				<option value="5ar">5</option>
				<option value="6ar">6</option>
				<option value="7ar">7</option>
				<option value="8ar">8</option>
				<option value="9ar">9</option>
				<option value="10ar">10</option>
				<option value="11ar">11</option>
				<option value="12ar">12</option>
				
				</select>     
				
				<select name="arriveMinute" onchange="" required = "required">
            	<option value="">select minutes</option>
				<option value="0a">00</option>
				<option value="30a">30</option>
				</select>     
				
				<select name="timea" onchange="" required = "required">
            	<option value="">select</option>
				<option value="ama">AM</option>
				<option value="pma">PM</option>
				</select>     
				<br> 
				<br>
				
				Departure time
				<select name="departHour" onchange="" required = "required">
            	<option value="">select hour</option>
				<option value="1de">1</option>
				<option value="2de">2</option>
				<option value="3de">3</option>
				<option value="4de">4</option>
				<option value="5de">5</option>
				<option value="6de">6</option>
				<option value="7de">7</option>
				<option value="8de">8</option>
				<option value="9de">9</option>
				<option value="10de">10</option>
				<option value="11de">11</option>
				<option value="12de">12</option>
				
				</select>     
				
				<select name="departMinute" onchange="" required = "required">
            	<option value="">select minutes</option>
				<option value="0a">00</option>
				<option value="30a">30</option>
				</select>     
				
				<select name="timed" onchange="" required = "required">
            	<option value=""></option>
				<option value="ama">AM</option>
				<option value="pma">PM</option>
				</select>     
				<br> 
				<br>
				
				<input type="submit" value="Submit"> 
				
      </form>
		      
            
</body>
</html>