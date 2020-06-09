package carRentalView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import carRentalController.OrdersController;
import carRentalModel.MyConnection;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MyOrdersScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;
	private JTable table;
	private JTextField textField_LicenceNumber;
	private OrdersController ordersController = new OrdersController();

	/**
	 * Create the frame.
	 */
	public MyOrdersScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(10, 467, 99, 33);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("My orders");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 32));
		lblNewLabel.setBounds(304, 11, 146, 51);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 98, 711, 358);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			ResultSet rs = ordersController.MyOrders(m_user);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			ordersController.CloseOrdersConnection();

			ListSelectionModel model = table.getSelectionModel();
			model.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!model.isSelectionEmpty()) {
						int index = table.getSelectedRow();
						TableModel mod = table.getModel();
						textField_LicenceNumber.setText(mod.getValueAt(index, 1).toString());
					}
				}
			});

			JLabel lblLicenceNumber = new JLabel("Licence number:");
			lblLicenceNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLicenceNumber.setBounds(132, 467, 126, 33);
			contentPane.add(lblLicenceNumber);

			textField_LicenceNumber = new JTextField();
			textField_LicenceNumber.setBounds(268, 475, 96, 20);
			contentPane.add(textField_LicenceNumber);
			textField_LicenceNumber.setColumns(10);

			JButton btnNewButton = new JButton("Finish rent");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyConnection con = new MyConnection();
					con.openConnection();
					String lNumber = textField_LicenceNumber.getText();
					try {
						if (!(textField_LicenceNumber.getText().equals("")) && textField_LicenceNumber.isEditable()) {
							    if(ordersController.DeleteExistingOrder(lNumber, i_user)) {
							    	JOptionPane.showMessageDialog(null, "You finish the rent!\nCome back soon! :)");
							    }
							    else {
							    	JOptionPane.showMessageDialog(null, "Error,\nThe order doesn't exist! :)");
							    }
							    ordersController.CloseOrdersConnection();
							} else {
								JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!)");
							}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(385, 467, 126, 33);
			contentPane.add(btnNewButton);

			JButton btnRefresh = new JButton("Refresh");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ResultSet rs = ordersController.MyOrders(m_user);						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						ordersController.CloseOrdersConnection();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			});
			btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnRefresh.setBounds(37, 58, 99, 29);
			contentPane.add(btnRefresh);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}

	}

}
