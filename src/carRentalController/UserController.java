package carRentalController;

import java.sql.SQLException;

import carRentalModel.Employee;
import carRentalModel.Manager;
import carRentalModel.User;
import carRentalModel.UserFactory;

public class UserController {
	private Employee employee = new Employee();
	private Manager manager = new Manager();
	
	public User CreateUser(String str)
	{
		User user = UserFactory.CreateUser(str);
		return user;
	}

	public void addClient(User user, String fName, String lName, String uName, String pass, String email, String mobile,
			String cCard, String expired, String CVV) throws SQLException {
		user.addClient(fName, lName, uName, pass, email, mobile, cCard, expired, CVV);		
	}
	
	public boolean checkEmployee(String username, String password) throws SQLException
	{
		return employee.checkEmployee(username, password);
	}
	
	public boolean checkManager(String username, String password) throws SQLException
	{
		return manager.checkManager(username, password);
	}
	
	public void addEmployee(User user, String permissions, String fName, String lName, String uName, String pass, String email, String mobile, String date) throws SQLException {
		user.addEmployee(permissions, fName, lName, uName, pass, email, mobile,date);		
	}
}
