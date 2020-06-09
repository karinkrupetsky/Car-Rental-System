package carRentalView;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import carRentalController.OrdersController;
import carRentalController.VehicleController;
import carRentalModel.CalculatorDate;
import carRentalModel.MyConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MakeAnOrderScreen extends JFrame {

	private JPanel contentPane;
	private JButton btnLoadAvailabaleVehicles;
	private JTable table;
	private JTextField textField_LicenceNumber;
	private JTextField textField_NumberDays;
	private static String m_user;
	private static String m_pass;
	private VehicleController vehicleController = new VehicleController();
	private OrdersController ordersController = new OrdersController();

	/**
	 * Create the frame.
	 */
	public MakeAnOrderScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 590);
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
		btnBack.setBounds(10, 510, 89, 32);
		contentPane.add(btnBack);
		
		btnLoadAvailabaleVehicles = new JButton("Refresh");
		btnLoadAvailabaleVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = vehicleController.LoadAvailableVehicles();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					vehicleController.CloseVehicleConnection();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

			}
		});
		
		
		btnLoadAvailabaleVehicles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoadAvailabaleVehicles.setBounds(24, 76, 216, 33);
		contentPane.add(btnLoadAvailabaleVehicles);

		JLabel lblVehiclesList = new JLabel("Make an order");
		lblVehiclesList.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 38));
		lblVehiclesList.setBounds(391, 11, 304, 44);
		contentPane.add(lblVehiclesList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 132, 936, 284);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			ResultSet rs = vehicleController.LoadAvailableVehicles();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			vehicleController.CloseVehicleConnection();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}

		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!model.isSelectionEmpty()) {
					int index = table.getSelectedRow();
					TableModel mod = table.getModel();
					textField_LicenceNumber.setText(mod.getValueAt(index, 0).toString());
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Rent:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(156, 429, 84, 36);
		contentPane.add(lblNewLabel);

		JLabel lblEnterTheLicence = new JLabel("Licence number:");
		lblEnterTheLicence.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheLicence.setBounds(156, 476, 216, 23);
		contentPane.add(lblEnterTheLicence);

		textField_LicenceNumber = new JTextField();
		textField_LicenceNumber.setBounds(385, 480, 117, 20);
		contentPane.add(textField_LicenceNumber);
		textField_LicenceNumber.setColumns(10);

		JLabel lblEnterTheEn = new JLabel("Number of days to rent:");
		lblEnterTheEn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheEn.setBounds(156, 514, 197, 23);
		contentPane.add(lblEnterTheEn);

		textField_NumberDays = new JTextField();
		textField_NumberDays.setBounds(385, 518, 117, 20);
		contentPane.add(textField_NumberDays);
		textField_NumberDays.setColumns(10);

		JButton btnRentNow = new JButton("Rent now!");
		btnRentNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String lNumber = textField_LicenceNumber.getText();
					String NumberDays = textField_NumberDays.getText();
					int nDays = Integer.parseInt(NumberDays);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate localDate = LocalDate.now();
					String startDate = localDate.toString();
					CalculatorDate cd = new CalculatorDate(startDate, nDays);
					String endDate = cd.getM_endDate();
					ResultSet result = ordersController.LoadPrice(lNumber);
					int price = Integer.parseInt(result.getObject(1).toString());
					int multiple = nDays * price;
					if (!(textField_LicenceNumber.getText().equals("")) && textField_LicenceNumber.isEditable()) {
						if(ordersController.MakeAnOrder(lNumber, i_user, startDate, endDate, multiple)) {
							JOptionPane.showMessageDialog(null, "You rented the vehicle.\nEnjoy!");
							dispose();
							RentalSystemScreen rss = new RentalSystemScreen(m_user, m_pass);
							rss.setLocationRelativeTo(null);
							rss.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "The licence number is invalid.\nPlease try again!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "The licence number is invalid.\nPlease try again!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty or\nthis licence number is wrong!");
				}
			}
		});
		btnRentNow.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnRentNow.setBounds(580, 490, 157, 49);
		contentPane.add(btnRentNow);
	}
}
