package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Feedback {
	
	
	
	
	//A common method to connect to the DB
			private Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");

			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer","root", "Root@123");
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 } 

			
			
			
			public String insertfd(String pcode, String description)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 // create a prepared statement
			 String query = " insert into feedback (`fbid`,`pcode`,`description`)"
			 + " values (?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, pcode);
			 preparedStmt.setString(3, description);
		
			// execute the statement
			
			 preparedStmt.execute();
			 con.close();
			 output = "Inserted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while inserting the item.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }

			

			
			public String readfd()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>feedback ID</th><th>Product Code</th><th>Description</th></tr>";

			 String query = "select * from feedback";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
			 String fbid = Integer.toString(rs.getInt("fbid"));
			 String pcode = rs.getString("pcode");
			 String description = rs.getString("description");
		
		
			 // Add into the html table
			 output += "<tr><td>" + fbid + "</td>";
			 output += "<td>" + pcode + "</td>";
			 output += "<td>" + description + "</td>";
		
			 // buttons
		
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
			 }
			 catch (Exception e)
			 {
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			

}
