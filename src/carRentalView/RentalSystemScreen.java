package carRentalView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carRentalController.UserController;


//import sun.font.TrueTypeGlyphMapper;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RentalSystemScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;
	private UserController userController = new UserController();

	// function that closing the previous frame while opening new one
	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Create the frame.
	 */

	public RentalSystemScreen(String i_user, String i_pass) throws SQLException {
		this.setLocationRelativeTo(null);
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnVehiclesList = new JButton("Make an order");
		btnVehiclesList.setForeground(Color.BLACK);
		btnVehiclesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeAnOrderScreen list = new MakeAnOrderScreen(m_user, m_pass);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
				dispose();
			}
		});
		btnVehiclesList.setBounds(162, 94, 167, 41);

		contentPane.setLayout(null);

		btnVehiclesList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnVehiclesList);

		JButton btn_Employees = new JButton("Manage orders");
		btn_Employees.setVisible(false);
		btn_Employees.setBounds(162, 220, 167, 38);
		btn_Employees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Employees.setForeground(Color.BLACK);
		contentPane.add(btn_Employees);

		JButton btn_Manager = new JButton("Manager area");
		btn_Manager.setForeground(Color.BLACK);
		btn_Manager.setVisible(false);
		btn_Manager.setBounds(162, 283, 167, 41);
		btn_Manager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btn_Manager);

		btn_Employees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdersScreen es = new OrdersScreen(m_user, m_pass);
				es.setLocationRelativeTo(null);
				es.setVisible(true);
				dispose();
			}
		});
		btn_Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerScreen ms = new ManagerScreen(m_user, m_pass);
				ms.setLocationRelativeTo(null);
				ms.setVisible(true);
				dispose();
			}
		});

		if (userController.checkManager(m_user, m_pass) == true) {
			btn_Employees.setVisible(true);
			btn_Manager.setVisible(true);
		}
		if (userController.checkEmployee(m_user, m_pass) == true) {
			btn_Employees.setVisible(true);
		}

		JButton btnContactUs = new JButton("Contact us");
		btnContactUs.setForeground(Color.BLACK);
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactUsScreen cus = new ContactUsScreen(m_user, m_pass);
				cus.setLocationRelativeTo(null);
				cus.setVisible(true);
				dispose();
			}
		});
		btnContactUs.setBounds(399, 393, 119, 41);
		btnContactUs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnContactUs);

		JButton btnAbous = new JButton("About");
		btnAbous.setForeground(Color.BLACK);
		btnAbous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutScreen as = new AboutScreen(m_user, m_pass);
				as.setLocationRelativeTo(null);
				as.setVisible(true);
				dispose();
			}
		});
		btnAbous.setBounds(162, 393, 167, 41);
		btnAbous.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnAbous);

		JButton btnClients = new JButton("My orders");
		btnClients.setForeground(Color.BLACK);
		btnClients.setBounds(162, 157, 167, 41);
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyOrdersScreen mos = new MyOrdersScreen(m_user, m_pass);
				mos.setLocationRelativeTo(null);
				mos.setVisible(true);
				dispose();
			}
		});
		btnClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnClients);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Goodbye, come back soon!");
				dispose();
				LoginScreen.StartCarRentalSystem();
			}
		});
		btnLogOut.setBounds(10, 393, 90, 41);
		btnLogOut.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnLogOut);

		JLabel lblNewLabel = new JLabel("Welcome to car Rental System");
		lblNewLabel.setBounds(41, 11, 477, 60);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);

		JLabel lblHey = new JLabel("Hey " + m_user + "!");
		lblHey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHey.setForeground(Color.WHITE);
		lblHey.setBounds(41, 57, 167, 26);
		contentPane.add(lblHey);

		JLabel label = new JLabel("");
		label.setBounds(-58, 0, 599, 453);
		label.setIcon(new ImageIcon(RentalSystemScreen.class.getResource("/Image/RentalSystemScreen.jpg")));
		contentPane.add(label);

	}
}
