package co.sympu.pnrticketing.ui.admin;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		setResizable(false);
		setPreferredSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setMaximumSize(new Dimension(1000, 600));
		
		// Initialize currentResult to CANCELLED
		currentResult = PromptResult.CANCELLED;
		
		setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		setTitle("Hello, User!");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		jpnlContentPanel = new JPanel();
		jpnlContentPanel.setBorder(null);
		getContentPane().add(jpnlContentPanel);
		GridBagLayout gbl_jpnlContentPanel = new GridBagLayout();
		gbl_jpnlContentPanel.columnWidths = new int[] {0, 0};
		gbl_jpnlContentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlContentPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_jpnlContentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpnlContentPanel.setLayout(gbl_jpnlContentPanel);
		
		JLabel jlblPnrIcon = new JLabel(new ImageIcon(this.getClass().getResource("/pnr-logo.png")));
		GridBagConstraints gbc_jlblPnrIcon = new GridBagConstraints();
		gbc_jlblPnrIcon.fill = GridBagConstraints.HORIZONTAL;
		gbc_jlblPnrIcon.gridwidth = 2;
		gbc_jlblPnrIcon.insets = new Insets(15, 15, 5, 15);
		gbc_jlblPnrIcon.gridx = 0;
		gbc_jlblPnrIcon.gridy = 0;
		jpnlContentPanel.add(jlblPnrIcon, gbc_jlblPnrIcon);
		
		JLabel jlblHeader = new JLabel("<html><p style=\"text-align: center;\">Philippine National Railways<br>1862</p></html>");
		jlblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		GridBagConstraints gbc_jlblHeader = new GridBagConstraints();
		gbc_jlblHeader.gridwidth = 2;
		gbc_jlblHeader.insets = new Insets(0, 15, 25, 15);
		gbc_jlblHeader.gridx = 0;
		gbc_jlblHeader.gridy = 1;
		jpnlContentPanel.add(jlblHeader, gbc_jlblHeader);
		
		JLabel jlblUsername = new JLabel("Username");
		jlblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblUsername = new GridBagConstraints();
		gbc_jlblUsername.insets = new Insets(0, 15, 10, 10);
		gbc_jlblUsername.anchor = GridBagConstraints.EAST;
		gbc_jlblUsername.gridx = 0;
		gbc_jlblUsername.gridy = 2;
		jpnlContentPanel.add(jlblUsername, gbc_jlblUsername);
		
		jtxtfldUsername = new JTextField();
		jtxtfldUsername.setMargin(new Insets(5, 5, 5, 5));
		jtxtfldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jtxtfldUsername = new GridBagConstraints();
		gbc_jtxtfldUsername.insets = new Insets(0, 0, 10, 15);
		gbc_jtxtfldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldUsername.gridx = 1;
		gbc_jtxtfldUsername.gridy = 2;
		jpnlContentPanel.add(jtxtfldUsername, gbc_jtxtfldUsername);
		jtxtfldUsername.setColumns(10);
		
		JLabel jlblPassword = new JLabel("Password");
		jlblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblPassword = new GridBagConstraints();
		gbc_jlblPassword.anchor = GridBagConstraints.EAST;
		gbc_jlblPassword.insets = new Insets(0, 15, 17, 10);
		gbc_jlblPassword.gridx = 0;
		gbc_jlblPassword.gridy = 3;
		jpnlContentPanel.add(jlblPassword, gbc_jlblPassword);
		
		jpswrdfldPassword = new JPasswordField();
		jpswrdfldPassword.setMargin(new Insets(5, 5, 5, 5));
		jpswrdfldPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jpswrdfldPassword = new GridBagConstraints();
		gbc_jpswrdfldPassword.insets = new Insets(0, 0, 17, 15);
		gbc_jpswrdfldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpswrdfldPassword.gridx = 1;
		gbc_jpswrdfldPassword.gridy = 3;
		jpnlContentPanel.add(jpswrdfldPassword, gbc_jpswrdfldPassword);

		JPanel jpnlButtonPane = new JPanel();
		GridBagConstraints gbc_jpnlButtonPane = new GridBagConstraints();
		gbc_jpnlButtonPane.insets = new Insets(0, 15, 5, 15);
		gbc_jpnlButtonPane.anchor = GridBagConstraints.EAST;
		gbc_jpnlButtonPane.gridwidth = 2;
		gbc_jpnlButtonPane.gridx = 0;
		gbc_jpnlButtonPane.gridy = 4;
		jpnlContentPanel.add(jpnlButtonPane, gbc_jpnlButtonPane);
		jpnlButtonPane.setBorder(null);
		jpnlButtonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

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
		
		JLabel jlblFooter = new JLabel("<html><p style=\"text-align: center;\">PNR Modern Ticketing System is made by<br>SYMPU Co. Ltd. \u00A9 2020. All rights reserved.</p></html>");
		jlblFooter.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		jlblFooter.setForeground(new Color(104, 104, 104));
		jlblFooter.setMinimumSize(new Dimension(55, 200));
		jlblFooter.setMaximumSize(new Dimension(2147483647, 200));
		jlblFooter.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblFooter.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_jlblFooter = new GridBagConstraints();
		gbc_jlblFooter.fill = GridBagConstraints.BOTH;
		gbc_jlblFooter.gridwidth = 2;
		gbc_jlblFooter.insets = new Insets(0, 15, 12, 15);
		gbc_jlblFooter.gridx = 0;
		gbc_jlblFooter.gridy = 5;
		jpnlContentPanel.add(jlblFooter, gbc_jlblFooter);
		
		JLabel jlblImage = new JLabel(new ImageIcon(this.getClass().getResource("/pnr-login-image.png")));
		jlblImage.setPreferredSize(new Dimension(350, 600));
		jlblImage.setMinimumSize(new Dimension(350, 0));
		jlblImage.setMaximumSize(new Dimension(500, 32767));
		getContentPane().add(jlblImage);
	}
	
	public PromptResult prompt() {
		setVisible(true);
		return currentResult;
	}

}
