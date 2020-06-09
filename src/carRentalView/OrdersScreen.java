package carRentalView;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import carRentalController.OrdersController;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class OrdersScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;
	private String m_userOrder;
	private JTable table;
	private JScrollPane scrollPane;
	private OrdersController ordersController = new OrdersController();
	
	public OrdersScreen(String i_user, String i_pass) {
		m_user = i_user;
		m_pass = i_pass;
		m_userOrder=null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentalSystemScreen rss = null;
				try {
					rss = new RentalSystemScreen(m_user, m_pass);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				rss.setLocationRelativeTo(null);
				rss.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 539, 92, 29);
		contentPane.add(btnNewButton);

		JLabel lblEmployees = new JLabel("Orders");
		lblEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployees.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		lblEmployees.setBounds(296, 11, 184, 70);
		contentPane.add(lblEmployees);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 92, 727, 421);
		contentPane.add(scrollPane);

				
		JButton btnNewButton_1 = new JButton("Send reminder to the client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m_userOrder!=null) {
					JOptionPane.showMessageDialog(null, "A reminder about the order sent to the client: "+m_userOrder+"!");
				}
				else {
					JOptionPane.showMessageDialog(null, "No order was selected!");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(134, 528, 277, 40);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			ResultSet rs = ordersController.AllOrders();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			ordersController.CloseOrdersConnection();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model.isSelectionEmpty()) {
					int index = table.getSelectedRow();
					TableModel mod = table.getModel();
					m_userOrder = mod.getValueAt(index, 0).toString();
				}
			}
		});
	}
}
