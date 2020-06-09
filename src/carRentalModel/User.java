package carRentalModel;

import java.sql.SQLException;

public interface User {
	public void addClient(String fName, String lName, String uName, String pass, String email, String mobile, String cCard,
			String expired, String CVV) throws SQLException;
	
	public void addEmployee(String permissions, String fName, String lName, String uName, String pass, String email, String mobile, String date) throws SQLException;
}
