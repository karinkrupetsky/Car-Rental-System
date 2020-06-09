package carRentalModel;

import javax.swing.JOptionPane;

public class UserFactory {

	public static User CreateUser(String str)
	{
		User user = null;
		switch(str)
		{
		case "Client":   user = new Client();
					     break;
		case "Employee": user = new Employee();
						 break;
		case "Manager":  user = new Manager();
						 break;
		}
		return user;
	}
	
}
