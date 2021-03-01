package co.sympu.pnrticketing.ui.cashier;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtfldUsername;
	private JPasswordField jpsswrdfldPassword;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Cashier Login ");
		setBounds(100, 100, 293, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel jpnlLogin = new JPanel();
		jpnlLogin.setBorder(new EmptyBorder(0, 10, 0, 14));
		jpnlLogin.setMaximumSize(new Dimension(16000, 32767));
		contentPane.add(jpnlLogin);
		GridBagLayout gbl_jpnlLogin = new GridBagLayout();
		gbl_jpnlLogin.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlLogin.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlLogin.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jpnlLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlLogin.setLayout(gbl_jpnlLogin);
		
		JLabel jlblUsername = new JLabel("Username:");
		GridBagConstraints gbc_jlblUsername = new GridBagConstraints();
		gbc_jlblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jlblUsername.anchor = GridBagConstraints.EAST;
		gbc_jlblUsername.gridx = 0;
		gbc_jlblUsername.gridy = 2;
		jpnlLogin.add(jlblUsername, gbc_jlblUsername);
		
		jtxtfldUsername = new JTextField();
		jtxtfldUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GridBagConstraints gbc_jtxtfldUsername = new GridBagConstraints();
		gbc_jtxtfldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldUsername.gridx = 1;
		gbc_jtxtfldUsername.gridy = 2;
		jpnlLogin.add(jtxtfldUsername, gbc_jtxtfldUsername);
		jtxtfldUsername.setColumns(10);
		
		JLabel jlblPassword = new JLabel("Password:");
		GridBagConstraints gbc_jlblPassword = new GridBagConstraints();
		gbc_jlblPassword.anchor = GridBagConstraints.EAST;
		gbc_jlblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jlblPassword.gridx = 0;
		gbc_jlblPassword.gridy = 3;
		jpnlLogin.add(jlblPassword, gbc_jlblPassword);
		
		jpsswrdfldPassword = new JPasswordField();
		GridBagConstraints gbc_jpsswrdfldPassword = new GridBagConstraints();
		gbc_jpsswrdfldPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpsswrdfldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpsswrdfldPassword.gridx = 1;
		gbc_jpsswrdfldPassword.gridy = 3;
		jpnlLogin.add(jpsswrdfldPassword, gbc_jpsswrdfldPassword);
		
		JButton jbtnLogin = new JButton("Login");
		jbtnLogin.addActionListener(event -> {
			try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cashier WHERE username = '" + jtxtfldUsername.getText() +
								 "' AND password = '" + String.valueOf(jpsswrdfldPassword.getPassword()) + "'");
			
			if (resultSet.next())
				JOptionPane.showMessageDialog(null, "Login Successfully!");
			else 
				JOptionPane.showMessageDialog(null, "Failed to login. Please double check your credentials and try again.");
			
			resultSet.close();
			statement.close();
			connection.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		GridBagConstraints gbc_jbtnLogin = new GridBagConstraints();
		gbc_jbtnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnLogin.anchor = GridBagConstraints.EAST;
		gbc_jbtnLogin.gridx = 1;
		gbc_jbtnLogin.gridy = 5;
		jpnlLogin.add(jbtnLogin, gbc_jbtnLogin);
		
		
	}

}
