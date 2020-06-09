package carRentalModel;

import java.sql.SQLException;

public class Client implements User{

	@Override
	public void addClient(String fName, String lName, String uName, String pass, String email, String mobile, String cCard, String expired, String CVV) throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		c.executeUpdate(
				"INSERT INTO Clients (firstName, lastName, username, password, email, mobile, creditCard, expired, CVV)"
						+ "VALUES ('" + fName + "', '" + lName + "', '" + uName + "', '" + pass + "', '"
						+ email + "', '" + mobile + "', '" + cCard + "', '" + expired + "', '" + CVV
						+ "');");
		c.closeConnection();
	}

	@Override
	public void addEmployee(String permissions, String fName, String lName, String uName, String pass, String email, String mobile,
			String date) throws SQLException {		
	}
}