package carRentalModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VehicleModel {
	
	private MyConnection c = new MyConnection();

	public void AddVehicle(String lNumber, String cName, String mName, String vColor, String vType, String year,String sRent, String fType, String capacity, String vHealth, String pricePerDay) throws SQLException {
		c.openConnection();
		c.executeUpdate(
				"INSERT INTO Vehicles (licenceNumber, companyName, modelName, vehicleColor, vehicleType, yearOfManufacture, statusOfRent, fuelType, capacity, vehicleHealth, pricePerDay) VALUES('"
						+ lNumber + "', '" + cName + "', '" + mName + "', '" + vColor + "', '" + vType
						+ "', '" + year + "', '" + sRent + "', '" + fType + "', '" + capacity + "','"
						+ vHealth + "','" + pricePerDay + "')");
		c.closeConnection();
	}
	
	public ResultSet ExistingVehicles() throws SQLException
	{	
		c.openConnection();
		ResultSet rs = c.executeQuery("SELECT * FROM Vehicles");
		return rs;
	}
	
	public void CloseVehicleConnection() throws SQLException
	{
		c.closeConnection();
	}

	public boolean DeleteExistingVehicle(String lNumber) throws SQLException {
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='" + lNumber + "';");
		if (result.next()) {
			c.executeUpdate("DELETE FROM Vehicles WHERE licenceNumber='" + lNumber + "';");			
			return true;
		}
		else
			return false;
	}

	public boolean VehicleUpdateToGood(String lNumber) throws SQLException {
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='" + lNumber + "' AND vehicleHealth='Broken';");
		if (result.next()) {
			c.executeUpdate("UPDATE Vehicles SET vehicleHealth='Good' WHERE licenceNumber='" + lNumber + "';");
			return true;
		}
		else
			return false;
	}

	public boolean VehicleAlreadyGood(String lNumber) throws SQLException {
		ResultSet result = c.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='"
				+ lNumber + "' AND vehicleHealth='Good';");
		if (result.next()) {
			return true;
		}
		else
			return false;
	}

	public boolean VehicleUpdateToBroken(String lNumber) throws SQLException {
		c.openConnection();
		ResultSet result = c.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='" + lNumber + "' AND vehicleHealth='Good';");
		if (result.next()) {
			c.executeUpdate("UPDATE Vehicles SET vehicleHealth='Broken' WHERE licenceNumber='" + lNumber + "';");
			return true;
		}
		else
			return false;
	}

	public boolean VehicleAlreadyBroken(String lNumber) throws SQLException {
		ResultSet result = c.executeQuery("SELECT licenceNumber FROM Vehicles WHERE licenceNumber='"
				+ lNumber + "' AND vehicleHealth='Broken';");
		if (result.next()) {
			return true;
		}
		else
			return false;
	}

	public ResultSet LoadAvailableVehicles() throws SQLException {
		c.openConnection();
		ResultSet rs = c.executeQuery("SELECT * FROM Vehicles where statusOfRent='Available' AND vehicleHealth='Good'");
		return rs;
	}
}
