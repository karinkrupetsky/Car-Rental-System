package testing;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import carRentalModel.MyConnection;
import carRentalModel.OrdersModel;

public class OrdersTesting {

	@Test
	public void DeleteExistingOrderTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		OrdersModel order = new OrdersModel();
		c.executeUpdate("INSERT INTO Orders (username, licenceNumber, startRentDate, endRentDate, vehicleHealth, price)"
							+ "VALUES ('client2', '1111112', '2019-08-01', '2019-09-01', 'Go', '200');");
		assertTrue(order.DeleteExistingOrder("1111112", "client2"), "Cannot delete this existing order.");
		c.closeConnection();
	}
	
	@Test
	public void MakeAnOrderTest() throws SQLException {
		MyConnection c = new MyConnection();
		c.openConnection();
		OrdersModel order = new OrdersModel();
		assertTrue(order.MakeAnOrder("12312312", "employee1", "2019-06-25", "2019-06-30", 150), "Cannot make a new order.");
		c.openConnection();
		if(c.executeQuery("SELECT * FROM Orders WHERE licenceNumber='12312312' AND username='employee1';").next()) {
			c.executeUpdate("DELETE FROM Orders WHERE licenceNumber='12312312' AND username='employee1';");
		}
		c.closeConnection();
	}
	
}
