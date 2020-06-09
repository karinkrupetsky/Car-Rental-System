package carRentalController;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import carRentalModel.VehicleModel;

public class VehicleController {

	private VehicleModel vehicleModel = new VehicleModel();

	public void AddVehicle(String lNumber, String cName, String mName, String vColor, String vType, String year, String sRent, String fType, String capacity, String vHealth, String pricePerDay) throws SQLException {
		vehicleModel.AddVehicle(lNumber, cName, mName, vColor, vType, year, sRent, fType, capacity, vHealth, pricePerDay);
	}

	public ResultSet ExistingVehicles() throws SQLException {
		return vehicleModel.ExistingVehicles();
	}
	
	public void CloseVehicleConnection() throws SQLException{
		vehicleModel.CloseVehicleConnection();
	}
	
	public boolean DeleteExistingVehicle(String lNumber) throws SQLException {
		return vehicleModel.DeleteExistingVehicle(lNumber);
	}
	
	public boolean VehicleUpdateToGood(String lNumber) throws SQLException {
		return vehicleModel.VehicleUpdateToGood(lNumber);
	}
	
	public boolean VehicleUpdateToBroken(String lNumber) throws SQLException {
		return vehicleModel.VehicleUpdateToBroken(lNumber);
	}
	
	public boolean VehicleAlreadyGood(String lNumber) throws SQLException {
		return vehicleModel.VehicleAlreadyGood(lNumber);
	}
	
	public boolean VehicleAlreadyBroken(String lNumber) throws SQLException {
		return vehicleModel.VehicleAlreadyBroken(lNumber);
	}
	
	public ResultSet LoadAvailableVehicles() throws SQLException {
		return vehicleModel.LoadAvailableVehicles();
	}
}
