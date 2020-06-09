package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import carRentalModel.Client;
import carRentalModel.Employee;
import carRentalModel.Manager;
import carRentalModel.MyConnection;
import carRentalModel.User;
import carRentalModel.UserModel;

public class UserTesting {

	@Test
	public void checkManagerTest() throws SQLException {
		Manager manager = new Manager();
		assertTrue(manager.checkManager("manager1", "1234"), "check manager error");
	}
	
	@Test
	public void checkEmployeeTest() throws SQLException {
		Employee employee = new Employee();
		assertTrue(employee.checkEmployee("employee1", "1234"), "check employee Error");
	}
	
	@Test
	public void checkLoginTest() throws SQLException {
		UserModel user = new UserModel();
		assertTrue(user.checkLogin("client1", "1234"), "check login error");
	}
	
	@Test
	public void addClientTest() throws SQLException {
		User user = new Client();
		user.addClient("Asi", "Chen", "Asi123", "123456", "asi@gmail.com", "0503213215", "123451234512346", "10/2022", "133");
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT * FROM Clients WHERE firstName='Asi' And lastName='Chen' AND username='Asi123' AND password='123456' AND email='asi@gmail.com' AND mobile='0503213215' AND creditCard='123451234512346' AND expired='10/2022' AND CVV='133'");
		assertTrue(result.next(), "Cannot adding new client.");
		if (result.next())
		{
			c.executeUpdate("DELETE FROM Clients WHERE username='Asi123'");
		}
		c.closeConnection();
	}

	
	@Test
	public void addEmployeeTest() throws SQLException {
		User user = new Employee();
		user.addEmployee("Employee", "Avi", "Cohen", "Avi123", "123456", "avi@gmail.com", "0503213213", "2019-07-17");
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT * FROM Employees WHERE firstName='Avi' And lastName='Cohen' AND username='Avi123' AND password='123456' AND email='avi@gmail.com' AND mobile='0503213213' AND dateEntered='2019-07-17'");
		assertTrue(result.next(), "add employee error");
		if (result.next())
		{
			c.executeUpdate("DELETE FROM Employees WHERE username='Avi123'");
		}
		c.closeConnection();
	}
	
	@Test
	public void addManagerTest() throws SQLException {
		User user = new Manager();
		user.addEmployee("Manager", "Yosi", "Levi", "Yosi123", "123456", "yosi@gmail.com", "0503213214", "2019-07-17");
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT * FROM Managers WHERE firstName='Yosi' And lastName='Levi' AND username='Yosi123' AND password='123456' AND email='yosi@gmail.com' AND mobile='0503213214' AND dateEntered='2019-07-17'");
		assertTrue(result.next(), "add employee error");
		if (result.next())
		{
			c.executeUpdate("DELETE FROM Managers WHERE username='Yosi123'");
		}
		c.closeConnection();
	}
	
}
