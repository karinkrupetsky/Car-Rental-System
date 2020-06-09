package carRentalView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carRentalController.LoginScreenController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;

public class LoginScreen extends JFrame{

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private eUserType m_UserType = null;
	private LoginScreenController loginController = new LoginScreenController();
	private static LoginScreen loginScreen;

	public enum eUserType {
		Client, Employee, Manager
	}

	public eUserType getUserType() {
		return m_UserType;
	}
	
	public static void StartCarRentalSystem() {
		try {
			LoginScreen frame = GetInstance();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LoginScreen GetInstance()
	{
		if(loginScreen == null)
			loginScreen = new LoginScreen();
		loginScreen.userNameField.setText(null);
		loginScreen.passwordField.setText(null);
		return loginScreen;
	}

	/**
	 * Create the frame.
	 */
	private LoginScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRentACar = new JLabel("Rent A Car");
		lblRentACar.setBounds(27, 21, 322, 49);
		lblRentACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentACar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblRentACar);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(15, 81, 97, 49);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(15, 143, 97, 49);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPassword);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(15, 130, 389, 14);
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel);

		userNameField = new JTextField();
		userNameField.setBounds(124, 97, 165, 22);
		userNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s = userNameField.getText();
				int len = s.length();
				if (((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9'))
						|| ((e.getKeyChar() >= 'a') && (e.getKeyChar() <= 'z'))
						|| ((e.getKeyChar() >= 'A') && (e.getKeyChar() <= 'Z'))) {
					if (len <= 15) {
						lblNewLabel.setText("");
						userNameField.setEditable(true);
					} else {
						lblNewLabel.setText("* Please enter letters and numbers, no more than 15 characters");
						userNameField.setEditable(false);
					}
				} else {
					if ((e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
							|| (e.getExtendedKeyCode() == KeyEvent.VK_DELETE)) {
						lblNewLabel.setText("");
						userNameField.setEditable(true);
					} else {
						lblNewLabel.setText("* Please enter letters and numbers, no more than 15 characters");
						userNameField.setEditable(false);
					}
				}
			}
		});
		userNameField.setColumns(10);
		contentPane.add(userNameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(122, 155, 167, 26);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			private Component frame;

			public void actionPerformed(ActionEvent e) {
				try {
					LoginScreen login = new LoginScreen();
					String user = userNameField.getText();
					String pass = passwordField.getText();
					if (loginController.checkLoginToController(user, pass)) {
						JOptionPane.showMessageDialog(null, "You have successfully logged in!");
						dispose();
						RentalSystemScreen rcc = new RentalSystemScreen(user, pass);
						rcc.setLocationRelativeTo(null);
						rcc.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or password!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(15, 239, 120, 40);
		contentPane.add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(174, 239, 120, 40);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				RegisterScreen register = new RegisterScreen();
				register.RegisterScreen();
			}

		});
		contentPane.add(btnRegister);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/Image/LoginScreen.jpg")));
		lblNewLabel_1.setBounds(0, 0, 424, 363);
		contentPane.add(lblNewLabel_1);

	}
}