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
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class AboutScreen extends JFrame {

	private JPanel contentPane;
	private static String m_user;
	private static String m_pass;

	/**
	 * Create the frame.
	 */
	public AboutScreen(String i_user, String i_pass) {
		setResizable(false);
		m_user = i_user;
		m_pass = i_pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 363);
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
		btnNewButton.setBounds(10, 279, 102, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("About");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		lblNewLabel.setBounds(202, 0, 102, 44);
		contentPane.add(lblNewLabel);

		JTextPane txtpnCopyright = new JTextPane();
		txtpnCopyright.setBackground(SystemColor.control);
		txtpnCopyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnCopyright.setText(
				"\r\nCopyright \u00A9 2019 DENK. All rights reserved.\r\nThe program created by:\r\nDor Shamir,\r\nEliad Gavriel,\r\nNissim Museri,\r\nKarin Krupetsky.");
		txtpnCopyright.setBounds(10, 41, 489, 206);
		contentPane.add(txtpnCopyright);

	}

}
