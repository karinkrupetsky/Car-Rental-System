package carRentalView;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ContactUsScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public ContactUsScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 384);
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
		btnNewButton.setBounds(10, 300, 103, 33);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ContactUsScreen.class.getResource("/Image/ContactUsScreen.jpeg")));
		label.setBounds(-49, -52, 670, 443);
		contentPane.add(label);
	}
}
