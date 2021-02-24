package co.sympu.pnrticketing.ui.admin;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginDialog extends JDialog {
	
	public static enum PromptResult {
		LOGGED_IN,
		INVALID_CREDENTIALS,
		CANCELLED;
	}
	
	private PromptResult currentResult;

	private static final long serialVersionUID = 1L;

	private final JPanel jpnlContentPanel;
	private JTextField jtxtfldUsername;
	private JPasswordField jpswrdfldPassword;

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		
		// Initialize currentResult to CANCELLED
		currentResult = PromptResult.CANCELLED;
		
		
		setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		setTitle("Welcome, User!");
		setBounds(100, 100, 309, 228);
		getContentPane().setLayout(new BorderLayout());

		jpnlContentPanel = new JPanel();
		jpnlContentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(jpnlContentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_jpnlContentPanel = new GridBagLayout();
		gbl_jpnlContentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlContentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpnlContentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jpnlContentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlContentPanel.setLayout(gbl_jpnlContentPanel);
		
		JLabel lblNewLabel = new JLabel("Login as Administrator");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 10, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		jpnlContentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel jlblUsername = new JLabel("Username");
		jlblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblUsername = new GridBagConstraints();
		gbc_jlblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jlblUsername.anchor = GridBagConstraints.EAST;
		gbc_jlblUsername.gridx = 0;
		gbc_jlblUsername.gridy = 1;
		jpnlContentPanel.add(jlblUsername, gbc_jlblUsername);
		
		jtxtfldUsername = new JTextField();
		jtxtfldUsername.setMargin(new Insets(5, 5, 5, 5));
		jtxtfldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jtxtfldUsername = new GridBagConstraints();
		gbc_jtxtfldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldUsername.gridx = 1;
		gbc_jtxtfldUsername.gridy = 1;
		jpnlContentPanel.add(jtxtfldUsername, gbc_jtxtfldUsername);
		jtxtfldUsername.setColumns(10);
		
		JLabel jlblPassword = new JLabel("Password");
		jlblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblPassword = new GridBagConstraints();
		gbc_jlblPassword.anchor = GridBagConstraints.EAST;
		gbc_jlblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_jlblPassword.gridx = 0;
		gbc_jlblPassword.gridy = 2;
		jpnlContentPanel.add(jlblPassword, gbc_jlblPassword);
		
		jpswrdfldPassword = new JPasswordField();
		jpswrdfldPassword.setMargin(new Insets(5, 5, 5, 5));
		jpswrdfldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jpswrdfldPassword = new GridBagConstraints();
		gbc_jpswrdfldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpswrdfldPassword.gridx = 1;
		gbc_jpswrdfldPassword.gridy = 2;
		jpnlContentPanel.add(jpswrdfldPassword, gbc_jpswrdfldPassword);

		JPanel jpnlButtonPane = new JPanel();
		jpnlButtonPane.setBorder(new EmptyBorder(0, 10, 10, 10));
		jpnlButtonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtonPane, BorderLayout.SOUTH);

		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(event -> {
			currentResult = PromptResult.CANCELLED;
			setVisible(false);
		});
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnCancel.setActionCommand("Cancel");
		jpnlButtonPane.add(jbtnCancel);
		
		JButton jbtnLogin = new JButton("Login");
		jbtnLogin.addActionListener(event -> {
			currentResult =
					jtxtfldUsername.getText().contentEquals("admin") &&
					String.valueOf(jpswrdfldPassword.getPassword()).contentEquals("admin123") ?
							PromptResult.LOGGED_IN :
								PromptResult.INVALID_CREDENTIALS;
			setVisible(false);
		});
		jbtnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnLogin.setActionCommand("OK");
		jpnlButtonPane.add(jbtnLogin);
		getRootPane().setDefaultButton(jbtnLogin);
	}
	
	public PromptResult prompt() {
		setVisible(true);
		return currentResult;
	}

}
