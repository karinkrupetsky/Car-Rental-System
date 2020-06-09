package carRentalView;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import carRentalController.VehicleController;
import carRentalModel.MyConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ManagerScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;
	private JTextField textField_LicenceNumber;
	private JTextField textField_CompanyName;
	private JTextField textField_ModelName;
	private JTextField textField_YearOfManufacture;
	private JTextField textField_Capacity;
	private JTextField textField_PricePerDay;
	private JTable table;
	private VehicleController vehicleController = new VehicleController();

	/**
	 * Create the frame.
	 */
	public ManagerScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 580, 101, 30);
		contentPane.add(btnNewButton_1);

		JLabel lblManager = new JLabel("Manager");
		lblManager.setForeground(Color.DARK_GRAY);
		lblManager.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 32));
		lblManager.setBounds(421, 11, 199, 37);
		contentPane.add(lblManager);

		JLabel lblLicenceNumber = new JLabel("Licence number:");
		lblLicenceNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLicenceNumber.setBounds(21, 58, 118, 24);
		contentPane.add(lblLicenceNumber);

		JLabel lblCompanyName = new JLabel("Company name:");
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanyName.setBounds(20, 100, 108, 24);
		contentPane.add(lblCompanyName);

		JLabel lblModelName = new JLabel("Model name:");
		lblModelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelName.setBounds(21, 142, 107, 19);
		contentPane.add(lblModelName);

		JLabel lblVehicleColor = new JLabel("Vehicle color:");
		lblVehicleColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVehicleColor.setBounds(21, 181, 103, 24);
		contentPane.add(lblVehicleColor);

		JLabel lblVehicleType = new JLabel("Vehicle type:");
		lblVehicleType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVehicleType.setBounds(21, 226, 90, 24);
		contentPane.add(lblVehicleType);

		JLabel lblYearOfManufacture = new JLabel("Year of manufacture:");
		lblYearOfManufacture.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearOfManufacture.setBounds(21, 271, 147, 24);
		contentPane.add(lblYearOfManufacture);

		JLabel lblStatusOfRent = new JLabel("Status of rent:");
		lblStatusOfRent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatusOfRent.setBounds(21, 316, 136, 14);
		contentPane.add(lblStatusOfRent);

		JLabel lvlFuelType = new JLabel("Fuel type:");
		lvlFuelType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lvlFuelType.setBounds(21, 358, 108, 19);
		contentPane.add(lvlFuelType);

		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCapacity.setBounds(21, 397, 107, 24);
		contentPane.add(lblCapacity);

		JLabel lblVehicleHealth = new JLabel("Vehicle health:");
		lblVehicleHealth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVehicleHealth.setBounds(21, 442, 118, 19);
		contentPane.add(lblVehicleHealth);

		JLabel lblPricePerDay = new JLabel("Price per day:");
		lblPricePerDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPricePerDay.setBounds(21, 483, 101, 24);
		contentPane.add(lblPricePerDay);

		textField_LicenceNumber = new JTextField();
		textField_LicenceNumber.setBounds(176, 62, 96, 20);
		contentPane.add(textField_LicenceNumber);
		textField_LicenceNumber.setColumns(10);

		textField_CompanyName = new JTextField();
		textField_CompanyName.setBounds(176, 104, 96, 20);
		contentPane.add(textField_CompanyName);
		textField_CompanyName.setColumns(10);

		textField_ModelName = new JTextField();
		textField_ModelName.setBounds(176, 143, 96, 20);
		contentPane.add(textField_ModelName);
		textField_ModelName.setColumns(10);

		JComboBox comboBox_VehicleColor = new JComboBox();
		comboBox_VehicleColor.setBounds(176, 184, 96, 22);
		comboBox_VehicleColor.addItem("Yellow");
		comboBox_VehicleColor.addItem("Black");
		comboBox_VehicleColor.addItem("White");
		comboBox_VehicleColor.addItem("Red");
		comboBox_VehicleColor.addItem("Blue");
		comboBox_VehicleColor.addItem("Silver");
		comboBox_VehicleColor.setSelectedItem(null);
		contentPane.add(comboBox_VehicleColor);

		JComboBox comboBox_VehicleType = new JComboBox();
		comboBox_VehicleType.setBounds(176, 229, 96, 22);
		comboBox_VehicleType.addItem("Private");
		comboBox_VehicleType.addItem("Motorcycle");
		comboBox_VehicleType.addItem("Mini");
		comboBox_VehicleType.setSelectedItem(null);
		contentPane.add(comboBox_VehicleType);

		textField_YearOfManufacture = new JTextField();
		textField_YearOfManufacture.setBounds(176, 275, 96, 20);
		contentPane.add(textField_YearOfManufacture);
		textField_YearOfManufacture.setColumns(10);

		JComboBox comboBox_StatusOfRent = new JComboBox();
		comboBox_StatusOfRent.setBounds(176, 314, 96, 22);
		comboBox_StatusOfRent.addItem("Available");
		comboBox_StatusOfRent.addItem("Rented");
		comboBox_StatusOfRent.setSelectedItem(null);
		contentPane.add(comboBox_StatusOfRent);

		JComboBox comboBox_FuelType = new JComboBox();
		comboBox_FuelType.setBounds(176, 358, 96, 22);
		comboBox_FuelType.addItem("Benzene");
		comboBox_FuelType.addItem("Diesel");
		comboBox_FuelType.setSelectedItem(null);
		contentPane.add(comboBox_FuelType);

		textField_Capacity = new JTextField();
		textField_Capacity.setBounds(176, 401, 96, 20);
		contentPane.add(textField_Capacity);
		textField_Capacity.setColumns(10);

		JComboBox comboBox_VehicleHealth = new JComboBox();
		comboBox_VehicleHealth.setBounds(176, 442, 96, 22);
		comboBox_VehicleHealth.addItem("Good");
		comboBox_VehicleHealth.addItem("Broken");
		comboBox_VehicleHealth.setSelectedItem(null);
		contentPane.add(comboBox_VehicleHealth);

		textField_PricePerDay = new JTextField();
		textField_PricePerDay.setBounds(176, 487, 96, 20);
		contentPane.add(textField_PricePerDay);
		textField_PricePerDay.setColumns(10);

		JButton btnNewButton = new JButton("Add to the vehicles list");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lNumber = textField_LicenceNumber.getText();
				String cName = textField_CompanyName.getText();
				String mName = textField_ModelName.getText();
				String vColor = (String) comboBox_VehicleColor.getSelectedItem();
				String vType = (String) comboBox_VehicleType.getSelectedItem();
				String year = textField_YearOfManufacture.getText();
				String sRent = (String) comboBox_StatusOfRent.getSelectedItem();
				String fType = (String) comboBox_FuelType.getSelectedItem();
				String capacity = textField_Capacity.getText();
				String vHealth = (String) comboBox_VehicleHealth.getSelectedItem();
				String pricePerDay = textField_PricePerDay.getText();
				try {
					if ((!(textField_LicenceNumber.getText().equals(""))) && (textField_LicenceNumber.isEditable())
							&& (!(textField_CompanyName.getText().equals(""))) && (textField_CompanyName.isEditable())
							&& (!(textField_ModelName.getText().equals(""))) && (textField_ModelName.isEditable())
							&& (!(textField_YearOfManufacture.getText().equals("")))
							&& (textField_YearOfManufacture.isEditable())
							&& (!(textField_Capacity.getText().equals(""))) && (textField_Capacity.isEditable())
							&& (!((String) comboBox_VehicleColor.getSelectedItem()).equals(""))
							&& (!((String) comboBox_VehicleType.getSelectedItem()).equals(""))
							&& (!((String) comboBox_StatusOfRent.getSelectedItem()).equals(""))
							&& (!((String) comboBox_FuelType.getSelectedItem()).equals(""))) {
						vehicleController.AddVehicle(lNumber, cName, mName, vColor, vType, year, sRent, fType, capacity, vHealth, pricePerDay);
						JOptionPane.showMessageDialog(null, "The vehicle is added to the list!");
					} else {
						JOptionPane.showMessageDialog(null, "Some fields are empty,\nPlease try again!");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(121, 562, 225, 48);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = vehicleController.ExistingVehicles();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					vehicleController.CloseVehicleConnection();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(453, 57, 101, 37);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Delete from the vehicles list");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lNumber = textField_LicenceNumber.getText();
				try {
					if (!(textField_LicenceNumber.getText().equals("")) && textField_LicenceNumber.isEditable()) {
						if (vehicleController.DeleteExistingVehicle(lNumber)) {
							JOptionPane.showMessageDialog(null, "The vehicle is deleted from the list!");
						} else {
							JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
						}
						vehicleController.CloseVehicleConnection();
					} else {
						JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(356, 562, 264, 48);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 107, 762, 433);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

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

		JLabel lblVehiclesList = new JLabel("Vehicles list:");
		lblVehiclesList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVehiclesList.setBounds(298, 65, 160, 29);
		contentPane.add(lblVehiclesList);

		JButton btnNewButton_4 = new JButton("Vehicle got fixed");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyConnection con = new MyConnection();
				con.openConnection();
				String lNumber = textField_LicenceNumber.getText();
				try {
					if (!(textField_LicenceNumber.getText().equals("")) && textField_LicenceNumber.isEditable()) {
						if(vehicleController.VehicleUpdateToGood(lNumber)) {
							JOptionPane.showMessageDialog(null, "The vehicle got fixed!");
						} else {
							if (vehicleController.VehicleAlreadyGood(lNumber)) {
								JOptionPane.showMessageDialog(null,
										"Please try again,\nThe vehicle is already fixed!");
							} else {
								JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
							}
						}
						vehicleController.CloseVehicleConnection();
					} else {
						JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(627, 562, 165, 48);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Vehicle got broken");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MyConnection con = new MyConnection();
				con.openConnection();
				String lNumber = textField_LicenceNumber.getText();
				try {
					if (!(textField_LicenceNumber.getText().equals("")) && textField_LicenceNumber.isEditable()) {
						if(vehicleController.VehicleUpdateToBroken(lNumber)) {
							JOptionPane.showMessageDialog(null, "The vehicle got broken!");
						} else {
							if (vehicleController.VehicleAlreadyBroken(lNumber)) {
								JOptionPane.showMessageDialog(null,
										"Please try again,\nThe vehicle is already broken!");
							} else {
								JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
							}
						}
						vehicleController.CloseVehicleConnection();
					} else {
						JOptionPane.showMessageDialog(null, "Error,\nThe licence number is invalid!");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBounds(798, 562, 186, 48);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Add employee");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterEmployeesScreen res = new RegisterEmployeesScreen(m_user, m_pass);
				res.setLocationRelativeTo(null);
				res.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6.setBounds(745, 57, 198, 37);
		contentPane.add(btnNewButton_6);
	}

}
