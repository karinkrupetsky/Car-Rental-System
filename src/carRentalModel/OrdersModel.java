package carRentalModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OrdersModel {
	
	private MyConnection con = new MyConnection();
	
	public ResultSet AllOrders() throws SQLException
	{	
		con.openConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM Orders;");
		return rs;
	}
	
	public ResultSet MyOrders(String m_user) throws SQLException
	{	
		con.openConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM Orders where username='" + m_user + "';");
		return rs;
	}
	
	public boolean DeleteExistingOrder(String lNumber, String m_user) throws SQLException
	{	
		con.openConnection();
		ResultSet result = con.executeQuery("SELECT * FROM Orders WHERE licenceNumber='" + lNumber
				+ "' AND username='" + m_user + "';");
		if (result.next()) {
			con.executeUpdate("UPDATE Vehicles SET statusOfRent='Available' WHERE licenceNumber='"
					+ lNumber + "';");
			con.executeUpdate("DELETE FROM Orders WHERE licenceNumber='" + lNumber
					+ "' AND username='" + m_user + "';");
			return true;
		}
		else
			return false;
	}
	
	public void CloseOrdersConnection() throws SQLException{
		con.closeConnection();
	}

	public ResultSet LoadPrice(String lNumber) throws SQLException {
		con.openConnection();
		ResultSet rs = con.executeQuery("SELECT pricePerDay FROM Vehicles WHERE licenceNumber='" + lNumber + "';");
		return rs;
	}

	public boolean MakeAnOrder(String lNumber, String m_user, String startDate, String endDate, int multiple) throws SQLException {
		ResultSet result = con.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='" + lNumber + "';");
		if (result.next()) {
			con.executeUpdate(
					"INSERT INTO Orders (username, licenceNumber, startRentDate, endRentDate, vehicleHealth, price)"
							+ "VALUES ('" + m_user + "', '" + lNumber + "', '" + startDate + "', '"
							+ endDate + "', 'Good', '" + multiple + "');");
			con.executeUpdate(
					"UPDATE Vehicles SET statusOfRent='Rented' WHERE licenceNumber='" + lNumber + "'");
			con.closeConnection();
			return true;
		}
		else {
			con.closeConnection();
			return false;
		}
	}
}
