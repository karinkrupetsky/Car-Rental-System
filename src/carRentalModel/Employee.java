package carRentalModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee implements User {

	@Override
	public void addClient(String fName, String lName, String uName, String pass, String email, String mobile, String cCard,
			String expired, String CVV) throws SQLException {
	}
	
	public boolean checkEmployee(String user, String pass) throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result = c
				.executeQuery("SELECT * FROM Employees WHERE username='" + user + "' AND password='" + pass + "';");
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