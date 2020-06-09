package carRentalController;

import java.sql.ResultSet;
import java.sql.SQLException;

import carRentalModel.OrdersModel;

public class OrdersController {
	
	private OrdersModel order = new OrdersModel();
	
	public ResultSet AllOrders() throws SQLException {
		ResultSet rs = order.AllOrders();
		return rs;
	}
	
	public ResultSet MyOrders(String m_user) throws SQLException {
		ResultSet rs = order.MyOrders(m_user);
		return rs;
	}
	
	public boolean DeleteExistingOrder(String lNumber, String m_user) throws SQLException {
		return order.DeleteExistingOrder(lNumber, m_user);
	}
	
	public void CloseOrdersConnection() throws SQLException{
		order.CloseOrdersConnection();
	}
	
	public ResultSet LoadPrice(String lNumber) throws SQLException {
		ResultSet rs = order.LoadPrice(lNumber);
		return rs;
	}
	
	public boolean MakeAnOrder(String lNumber, String m_user, String startDate, String endDate, int multiple) throws SQLException {
		return order.MakeAnOrder(lNumber, m_user, startDate, endDate, multiple);
	}
}
