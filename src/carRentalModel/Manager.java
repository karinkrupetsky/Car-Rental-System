package carRentalModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends Employee{
	
	public boolean checkManager(String user, String pass) throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result = c
				.executeQuery("SELECT * FROM Managers WHERE username='" + user + "' AND password='" + pass + "';");
		if (result.next()) {
			c.closeConnection();
			return true;
		} else {
			c.closeConnection();
			return false;
		}
	}
	
	@Override
	public void addEmployee(String permissions, String fName, String lName, String uName, String pass, String email, String mobile,
			String date) throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		c.executeUpdate("INSERT INTO '" + permissions
				+ "s' (firstName, lastName, username, password, email, mobile, dateEntered)"
				+ "VALUES ('" + fName + "', '" + lName + "', '" + uName + "', '" + pass + "', '" + email
				+ "', '" + mobile + "', '" + date + "');");
		c.closeConnection();		
	}
}
