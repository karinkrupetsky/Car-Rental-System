package carRentalModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MyConnection {
	static Connection connection=null;
	public MyConnection() {
		
	}

	public void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection=DriverManager.getConnection("jdbc:sqlite:res\\CarRentalSystem.db");
			
			}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	//ÈFor select query
	public ResultSet executeQuery(String query) throws SQLException {
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(query);
	return resultSet;
	}
	
	//For delete, insert and set query
	public int executeUpdate(String query) throws SQLException {
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(query);
		return r;
	}
}