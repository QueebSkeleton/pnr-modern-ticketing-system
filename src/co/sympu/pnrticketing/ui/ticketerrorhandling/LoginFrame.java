package co.sympu.pnrticketing.ui.ticketerrorhandling;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtfldUsername;
	private JPasswordField jpsswrdfldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Cashier Login ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		GridBagConstraints gbc_jbtnLogin = new GridBagConstraints();
		gbc_jbtnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnLogin.anchor = GridBagConstraints.EAST;
		gbc_jbtnLogin.gridx = 1;
		gbc_jbtnLogin.gridy = 5;
		jpnlLogin.add(jbtnLogin, gbc_jbtnLogin);
		
		
	}

}
