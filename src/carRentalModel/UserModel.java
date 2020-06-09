package carRentalModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel{
	public boolean checkLogin(String username, String password) throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		ResultSet result;
		result = c.executeQuery(
				"SELECT * FROM Managers WHERE username='" + username + "' AND password='" + password + "';");
		if (result.next()) {
			c.closeConnection();
			return true;
		} else {
			result = c.executeQuery(
					"SELECT * FROM Employees WHERE username='" + username + "' AND password='" + password + "';");
			if (result.next()) {
				c.closeConnection();
				return true;
			} else {
				result = c.executeQuery(
						"SELECT * FROM Clients WHERE username='" + username + "' AND password='" + password + "';");
				if (result.next()) {
					c.closeConnection();
					return true;
				} else {
					c.closeConnection();
					return false;
				}
			}
		}
	}
}
