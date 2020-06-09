package carRentalController;

import java.sql.SQLException;
import carRentalModel.UserModel;

public class LoginScreenController{
	
	private UserModel loginModel = new UserModel();
	
	public boolean checkLoginToController(String user, String pass) throws SQLException {
		return loginModel.checkLogin(user, pass);
	}
}
