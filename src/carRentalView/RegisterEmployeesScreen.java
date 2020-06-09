package carRentalView;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import carRentalController.UserController;
import carRentalModel.User;

import javax.swing.JComboBox;

public class RegisterEmployeesScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_Email2;
	private JTextField textField_Mobile;
	private JTextField textField_Email1;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_StartingDate;
	private static String m_user;
	private static String m_pass;
	private UserController userController = new UserController();

	/**
	 * Create the frame.
	 */
	public RegisterEmployeesScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(12, 174, 110, 49);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 229, 97, 49);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPassword);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 289, 75, 44);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmail);

		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(12, 342, 175, 49);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMobile);

		JLabel labelUsername = new JLabel("");
		labelUsername.setBounds(12, 219, 363, 14);
		labelUsername.setForeground(Color.RED);
		contentPane.add(labelUsername);

		JLabel labelPassword = new JLabel("");
		labelPassword.setForeground(Color.RED);
		labelPassword.setBounds(12, 277, 363, 14);
		contentPane.add(labelPassword);

		JLabel labelEmail = new JLabel("");
		labelEmail.setForeground(Color.RED);
		labelEmail.setBounds(12, 325, 363, 14);
		contentPane.add(labelEmail);

		JLabel labelMobile = new JLabel("");
		labelMobile.setBounds(12, 382, 386, 14);
		labelMobile.setForeground(Color.RED);
		contentPane.add(labelMobile);

		textField_Username = new JTextField();
		textField_Username.setBounds(210, 191, 165, 22);
		textField_Username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				String s = textField_Username.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= '0') && (e1.getKeyChar() <= '9'))
						|| ((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z'))
						|| ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 15) {
						labelUsername.setText("");
						textField_Username.setEditable(true);
					} else {
						labelUsername.setText("* Please enter letters and numbers, no more than 15 characters");
						textField_Username.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelUsername.setText("");
						textField_Username.setEditable(true);
					} else {
						labelUsername.setText("* Please enter letters and numbers, no more than 15 characters");
						textField_Username.setEditable(false);
					}
				}
			}
		});
		textField_Username.setColumns(10);
		contentPane.add(textField_Username);

		textField_Password = new JTextField();
		textField_Password.setForeground(Color.BLACK);
		textField_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {

				String s = textField_Password.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= '0') && (e1.getKeyChar() <= '9'))
						|| ((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z'))
						|| ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 16) {
						labelPassword.setText("");
						textField_Password.setEditable(true);
					} else {
						labelPassword.setText("* Please enter letters and numbers, no more than 16 characters");
						textField_Password.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelPassword.setText("");
						textField_Password.setEditable(true);
					} else {
						labelPassword.setText("* Please enter letters and numbers, no more than 16 characters");
						textField_Password.setEditable(false);
					}
				}
			}
		});
		textField_Password.setBounds(210, 244, 165, 22);
		textField_Password.setColumns(10);
		contentPane.add(textField_Password);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(12, 344, 363, 14);
		contentPane.add(lblNewLabel_3);

		textField_Email2 = new JTextField();
		textField_Email2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				String s = textField_Email1.getText();
				int len = s.length();
				if ((e1.getKeyChar() == '.') || ((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z'))
						|| ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 12) {
						lblNewLabel_3.setText("");
						textField_Email2.setEditable(true);
					} else {
						lblNewLabel_3.setText("* Please enter letters or . , no more than 12 characters");
						textField_Email2.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						lblNewLabel_3.setText("");
						textField_Email2.setEditable(true);
					} else {
						lblNewLabel_3.setText("* Please enter letters or . , no more than 12 characters");
						textField_Email2.setEditable(false);
					}
				}
			}
		});
		textField_Email2.setBounds(371, 304, 110, 22);
		textField_Email2.setColumns(10);
		contentPane.add(textField_Email2);

		textField_Mobile = new JTextField();
		textField_Mobile.setBounds(210, 359, 165, 22);
		textField_Mobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = textField_Mobile.getText();
				int len = s.length();
				if ((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) {
					if (len <= 10) {
						labelMobile.setText("");
						textField_Mobile.setEditable(true);
					} else {
						labelMobile.setText("* please enter numbers only, no more than 10 digits");
						textField_Mobile.setEditable(false);
					}
				} else {
					if ((e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelMobile.setText("");
						textField_Mobile.setEditable(true);
					} else {
						labelMobile.setText("* please enter numbers only, no more than 10 digits");
						textField_Mobile.setEditable(false);
					}
				}
			}
		});
		textField_Mobile.setColumns(10);
		contentPane.add(textField_Mobile);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(34, 526, 75, 34);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen menu = LoginScreen.GetInstance();
				menu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnBack);

		JLabel lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setBounds(340, 302, 21, 23);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);

		textField_Email1 = new JTextField();
		textField_Email1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {

				String s = textField_Email1.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= '0') && (e1.getKeyChar() <= '9')) || (e1.getKeyChar() == '_')
						|| ((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z'))
						|| ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 15) {
						labelEmail.setText("");
						textField_Email1.setEditable(true);
					} else {
						labelEmail.setText("* Please enter letters, numbers or _ , no more than 15 characters");
						textField_Email1.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelEmail.setText("");
						textField_Email1.setEditable(true);
					} else {
						labelEmail.setText("* Please enter letters, numbers or _ , no more than 15 characters");
						textField_Email1.setEditable(false);
					}
				}
			}
		});
		textField_Email1.setBounds(210, 304, 120, 22);
		contentPane.add(textField_Email1);
		textField_Email1.setColumns(10);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(10, 79, 125, 34);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(12, 129, 123, 34);
		contentPane.add(lblLastName);

		JLabel labelFirstName = new JLabel("");
		labelFirstName.setForeground(Color.RED);
		labelFirstName.setBounds(12, 116, 363, 14);
		contentPane.add(labelFirstName);

		JLabel labelLastName = new JLabel("");
		labelLastName.setForeground(Color.RED);
		labelLastName.setBounds(12, 165, 363, 14);
		contentPane.add(labelLastName);

		textField_FirstName = new JTextField();
		textField_FirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				String s = textField_FirstName.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z')) || (e1.getKeyChar() == ' ')
						|| (e1.getKeyChar() == '-') || ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 15) {
						labelFirstName.setText("");
						textField_FirstName.setEditable(true);
					} else {
						labelFirstName.setText("* Please enter letters, no more than 15 characters");
						textField_FirstName.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelFirstName.setText("");
						textField_FirstName.setEditable(true);
					} else {
						labelFirstName.setText("* Please enter letters, no more than 15 characters");
						textField_FirstName.setEditable(false);
					}
				}
			}
		});
		textField_FirstName.setBounds(210, 90, 165, 20);
		contentPane.add(textField_FirstName);
		textField_FirstName.setColumns(10);

		textField_LastName = new JTextField();
		textField_LastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {

				String s = textField_LastName.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z')) || (e1.getKeyChar() == ' ')
						|| (e1.getKeyChar() == '-') || ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 15) {
						labelLastName.setText("");
						textField_LastName.setEditable(true);
					} else {
						labelLastName.setText("* Please enter letters, no more than 15 characters");
						textField_LastName.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelLastName.setText("");
						textField_LastName.setEditable(true);
					} else {
						labelLastName.setText("* Please enter letters, no more than 15 characters");
						textField_LastName.setEditable(false);
					}
				}
			}
		});
		textField_LastName.setBounds(210, 140, 165, 20);
		contentPane.add(textField_LastName);
		textField_LastName.setColumns(10);

		JLabel lblIsManager = new JLabel("Permissions:");
		lblIsManager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIsManager.setBounds(12, 402, 135, 34);
		contentPane.add(lblIsManager);

		JComboBox comboBox_Permissions = new JComboBox();
		comboBox_Permissions.setBounds(210, 407, 91, 22);
		contentPane.add(comboBox_Permissions);
		comboBox_Permissions.addItem("Employee");
		comboBox_Permissions.addItem("Manager");
		comboBox_Permissions.setSelectedItem(null);

		JLabel lblRegisterEmployee = new JLabel("Register employee");
		lblRegisterEmployee.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegisterEmployee.setBounds(116, 11, 260, 57);
		contentPane.add(lblRegisterEmployee);

		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(12, 438, 363, 14);
		contentPane.add(label);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerScreen rss = new ManagerScreen(m_user, m_pass);
				rss.setLocationRelativeTo(null);
				rss.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(12, 471, 110, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fName = textField_FirstName.getText();
					String lName = textField_LastName.getText();
					String uName = textField_Username.getText();
					String pass = textField_Password.getText();
					String email = textField_Email1.getText() + "@" + textField_Email2.getText();
					String mobile = textField_Mobile.getText();
					String permissions = (String) comboBox_Permissions.getSelectedItem();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate localDate = LocalDate.now();
					String date = localDate.toString();
					if ((!(textField_FirstName.getText().equals(""))) && (textField_FirstName.isEditable())
							&& (!(textField_LastName.getText().equals(""))) && (textField_LastName.isEditable())
							&& (!(textField_Username.getText().equals(""))) && (textField_Username.isEditable())
							&& (!(textField_Password.getText().equals(""))) && (textField_Password.isEditable())
							&& (!(textField_Email1.getText().equals(""))) && (textField_Email1.isEditable())
							&& (!(textField_Email2.getText().equals(""))) && (textField_Email2.isEditable())
							&& (!(textField_Mobile.getText().equals(""))) && (textField_Mobile.isEditable())
							&& (!((String) comboBox_Permissions.getSelectedItem()).equals(""))) {
						User user = userController.CreateUser(permissions);
						userController.addEmployee(user, permissions, fName, lName, uName, pass, email, mobile, date);
						JOptionPane.showMessageDialog(null, "You have successfully registered");
						dispose();
						ManagerScreen ms = new ManagerScreen(m_user, m_pass);
						ms.setLocationRelativeTo(null);
						ms.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Please try again!\\nSome fileds are empty!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please try again!\nSome fileds are invalid!");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(210, 456, 162, 44);
		contentPane.add(btnNewButton_1);

	}

}
