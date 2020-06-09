package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import carRentalModel.MyConnection;
import carRentalModel.VehicleModel;

public class VehicleTesting {

	@Test
	public void AddVehicleTest() throws SQLException
	{
		VehicleModel vehicle = new VehicleModel();
		vehicle.AddVehicle("76543210", "Honda", "Civic", "Silver", "Private", "2018", "Available", "Benzene", "1800", "Good", "450");
		MyConnection c = new MyConnection();
		c.openConnection();
		assertTrue(c.executeQuery("SELECT * FROM Vehicles WHERE licenceNumber='76543210'").next(), "This vehicle is not exists.");
		if(c.executeQuery("SELECT * FROM Vehicles WHERE licenceNumber='76543210';").next()) {
			c.executeUpdate("DELETE FROM Vehicles WHERE licenceNumber='76543210';");
		}
		c.closeConnection();
	}
	
	@Test
	public void DeleteExistingVehicleTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		VehicleModel vehicle = new VehicleModel();
		c.executeUpdate("INSERT INTO Vehicles (licenceNumber, companyName, modelName, vehicleColor, vehicleType, yearOfManufacture, statusOfRent, fuelType, capacity, vehicleHealth, pricePerDay) VALUES('12121212', 'Audi', 'A1', 'Black', 'Private', '2017', 'Available', 'Benzene', '2300', 'Good', '1100');");
		assertTrue(vehicle.DeleteExistingVehicle("12121212"), "Delete existing vehicle error");
		c.closeConnection();
	}
	
	@Test
	public void VehicleUpdateToGoodTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		VehicleModel vehicle = new VehicleModel();
		vehicle.AddVehicle("21212121", "Mazda", "6", "yellow", "Private", "2010", "Available", "Benzene", "1800", "Broken", "800");
		assertTrue(vehicle.VehicleUpdateToGood("21212121"),"Vehicle update to good error");
		c.closeConnection();
		vehicle.DeleteExistingVehicle("21212121");
		c.closeConnection();
	}
	
	@Test
	public void VehicleAlreadyGoodTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		VehicleModel vehicle = new VehicleModel();
		vehicle.AddVehicle("21212121", "Mazda", "6", "yellow", "Private", "2010", "Available", "Benzene", "1800", "Good", "800");
		c.openConnection();
		assertTrue(vehicle.VehicleAlreadyGood("21212121"),"Vehicle already good error");
		c.closeConnection();
		vehicle.DeleteExistingVehicle("21212121");
		c.closeConnection();
	}
	
	@Test
	public void VehicleUpdateToBrokenTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		VehicleModel vehicle = new VehicleModel();
		vehicle.AddVehicle("21212121", "Mazda", "6", "yellow", "Private", "2010", "Available", "Benzene", "1800", "Good", "800");
		assertTrue(vehicle.VehicleUpdateToBroken("21212121"),"Vehicle update to Broken error");
		c.closeConnection();
		vehicle.DeleteExistingVehicle("21212121");
		c.closeConnection();
	}
	
	@Test
	public void VehicleAlreadyBrokenTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		VehicleModel vehicle = new VehicleModel();
		vehicle.AddVehicle("21212121", "Mazda", "6", "yellow", "Private", "2010", "Available", "Benzene", "1800", "Broken", "800");
		c.openConnection();
		assertTrue(vehicle.VehicleAlreadyBroken("21212121"),"Vehicle already broken error");
		c.closeConnection();
		vehicle.DeleteExistingVehicle("21212121");
		c.closeConnection();
	}
	
}
