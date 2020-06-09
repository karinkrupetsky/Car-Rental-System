package carRentalView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carRentalController.UserController;
import carRentalModel.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class RegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Email2;
	private JTextField textField_Mobile;
	private JTextField textField_CreditCard;
	private JTextField textField_CVV;
	private JTextField textField_Email1;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JPasswordField passwordField;
	private UserController userController = new UserController();

	/**
	 * Launch the application.
	 */
	public static void RegisterScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterScreen frame = new RegisterScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// function that closing the previous frame while opening new one
	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Create the frame.
	 */
	public RegisterScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegister = new JLabel("");
		lblRegister.setIcon(new ImageIcon(RegisterScreen.class.getResource("/Image/RegisterScreen.jpg")));
		lblRegister.setBounds(75, 11, 352, 49);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblRegister);

		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(12, 174, 97, 49);
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

		JLabel labelCreditCard = new JLabel("");
		labelCreditCard.setBounds(12, 481, 386, 14);
		labelCreditCard.setForeground(Color.RED);
		contentPane.add(labelCreditCard);

		JLabel labelCVV = new JLabel("");
		labelCVV.setBounds(400, 409, 251, 14);
		contentPane.add(labelCVV);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setBounds(104, 448, 48, 27);

		comboBox_Month.addItem("01");
		comboBox_Month.addItem("02");
		comboBox_Month.addItem("03");
		comboBox_Month.addItem("04");
		comboBox_Month.addItem("05");
		comboBox_Month.addItem("06");
		comboBox_Month.addItem("07");
		comboBox_Month.addItem("08");
		comboBox_Month.addItem("09");
		comboBox_Month.addItem("10");
		comboBox_Month.addItem("11");
		comboBox_Month.addItem("12");
		comboBox_Month.setSelectedItem(null);
		contentPane.add(comboBox_Month);

		JComboBox comboBox_Year = new JComboBox();
		comboBox_Year.setBounds(162, 448, 48, 27);
		comboBox_Year.addItem("2019");
		comboBox_Year.addItem("2020");
		comboBox_Year.addItem("2021");
		comboBox_Year.addItem("2022");
		comboBox_Year.addItem("2023");
		comboBox_Year.addItem("2024");
		comboBox_Year.addItem("2025");
		comboBox_Year.addItem("2026");
		comboBox_Year.addItem("2027");
		comboBox_Year.addItem("2028");
		comboBox_Year.addItem("2029");
		comboBox_Year.addItem("2030");
		comboBox_Year.setSelectedItem(null);
		contentPane.add(comboBox_Year);

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
		textField_Email2.setBounds(360, 304, 112, 22);
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

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBounds(162, 506, 139, 49);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fName = textField_FirstName.getText();
					String lName = textField_LastName.getText();
					String uName = textField_Username.getText();
					String pass = passwordField.getText();
					String email = textField_Email1.getText() + "@" + textField_Email2.getText();
					String mobile = textField_Mobile.getText();
					String cCard = textField_CreditCard.getText();
					String expired = comboBox_Month.getSelectedItem() + "/" + comboBox_Year.getSelectedItem();
					String CVV = textField_CVV.getText();
					if ((!(textField_FirstName.getText().equals(""))) && (textField_FirstName.isEditable())
							&& (!(textField_LastName.getText().equals(""))) && (textField_LastName.isEditable())
							&& (!(textField_Username.getText().equals(""))) && (textField_Username.isEditable())
							&& (!(passwordField.getText().equals(""))) && (passwordField.isEditable())
							&& (!(textField_Email1.getText().equals(""))) && (textField_Email1.isEditable())
							&& (!(textField_Email2.getText().equals(""))) && (textField_Email2.isEditable())
							&& (!(textField_Mobile.getText().equals(""))) && (textField_Mobile.isEditable())
							&& (!(textField_CreditCard.getText().equals(""))) && (textField_CreditCard.isEditable())
							&& (!((String) comboBox_Month.getSelectedItem()).equals(""))
							&& (!((String) comboBox_Year.getSelectedItem()).equals(""))
							&& (!(textField_CVV.getText().equals(""))) && (textField_CVV.isEditable())) {
						User user = userController.CreateUser("Client");
						userController.addClient(user, fName, lName, uName, pass, email, mobile, cCard, expired, CVV);
						JOptionPane.showMessageDialog(null, "You have successfully registered");
						dispose();
						LoginScreen.StartCarRentalSystem();
					} else {
						JOptionPane.showMessageDialog(null, "Please try again!\nSome fileds are empty!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please try again!\nSome fileds are invalid!");
				}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnSignUp);

		JLabel lblCredirCard = new JLabel("Credit Card:");
		lblCredirCard.setBounds(10, 397, 177, 34);
		lblCredirCard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCredirCard);

		JLabel lblExpired = new JLabel("Expired:");
		lblExpired.setBounds(12, 442, 97, 34);
		lblExpired.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblExpired);

		JLabel lblCVV = new JLabel("CVV:");
		lblCVV.setBounds(220, 447, 48, 24);
		lblCVV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCVV);

		textField_CreditCard = new JTextField();
		textField_CreditCard.setBounds(210, 407, 165, 22);
		textField_CreditCard.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = textField_CreditCard.getText();
				int len = s.length();
				if ((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) {
					if (len <= 16) {
						labelCreditCard.setText("");
						textField_CreditCard.setEditable(true);
					} else {
						labelCreditCard.setText("* please enter numbers only, no more than 16 digits");
						textField_CreditCard.setEditable(false);
					}
				} else {
					if ((e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelCreditCard.setText("");
						textField_CreditCard.setEditable(true);
					} else {
						labelCreditCard.setText("* please enter numbers only, no more than 16 digits");
						textField_CreditCard.setEditable(false);
					}
				}
			}
		});
		contentPane.add(textField_CreditCard);
		textField_CreditCard.setColumns(10);

		textField_CVV = new JTextField();
		textField_CVV.setBounds(271, 451, 59, 20);
		textField_CVV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = textField_CVV.getText();
				int len = s.length();
				if ((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) {
					if (len < 3) {
						textField_CVV.setEditable(true);
					} else {
						textField_CVV.setEditable(false);
					}
				} else {
					if ((e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						textField_CVV.setEditable(true);
					} else {
						textField_CVV.setEditable(false);
					}
				}
			}
		});
		contentPane.add(textField_CVV);
		textField_CVV.setColumns(10);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(34, 526, 75, 34);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen menu = LoginScreen.GetInstance();
				menu.setLocationRelativeTo(null);
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
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				String s = passwordField.getText();
				int len = s.length();
				if (((e1.getKeyChar() >= '0') && (e1.getKeyChar() <= '9'))
						|| ((e1.getKeyChar() >= 'a') && (e1.getKeyChar() <= 'z'))
						|| ((e1.getKeyChar() >= 'A') && (e1.getKeyChar() <= 'Z'))) {
					if (len <= 16) {
						labelPassword.setText("");
						passwordField.setEditable(true);
					} else {
						labelPassword.setText("* Please enter letters and numbers, no more than 16 characters");
						passwordField.setEditable(false);
					}
				} else {
					if ((e1.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e1.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						labelPassword.setText("");
						passwordField.setEditable(true);
					} else {
						labelPassword.setText("* Please enter letters and numbers, no more than 16 characters");
						passwordField.setEditable(false);
					}
				}
			}
		});
		passwordField.setBounds(210, 246, 165, 23);
		contentPane.add(passwordField);

	}
}
