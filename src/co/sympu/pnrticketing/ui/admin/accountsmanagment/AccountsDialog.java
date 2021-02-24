package co.sympu.pnrticketing.ui.admin.accountsmanagment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;

/**
 * Add form dialog for Accounts management.
 * 
 * @author Bismillah C. Constantino
 *
 */
public class AccountsDialog extends JDialog{

	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	/**
	 * Accounts Management Panel that owns this dialog box.
	 */
	protected ManagementPanel accountsManagementPanel;
	
	//form components
	private JTextField jtxtfldUsername;
	private JPasswordField jpwdPassword;
	private JLabel lblNewLabel;
	private JPasswordField jpwdRePassword;
	private JLabel jlblFullName;
	private JTextField jtxtfldFullName;
	private JLabel jlblSex;
	private JRadioButton jrdbtnMale;
	private JRadioButton jrdbtnFemale;
	private JLabel jlblContactNumber;
	private JTextField jtxtfldContactNumber;
	private JLabel jlblResidentialAddress;
	private JTextArea jtxtareaResidentialAddress;
	private JLabel jlblEmployeeNumber;
	private JTextField jtxtfldEmployeeNumber;
	private JLabel jlblSSSNumber;
	private JTextField jtxtfldSSSNumber;
	private JLabel jlblTIN;
	private JTextField jtxtfldTIN;
	private JPanel panel;
	private JButton jbtnSave;
	
	
	public AccountsDialog() {
		//prevent user to resize the dialog
		setResizable(false);
				
		//set window size
		setMinimumSize(new Dimension(600, 460));
				
		//set title
		setTitle("Accounts Management");
				
		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
				
		// Create the main content pane of this frame
		setContentPane(jpnlContentPane);
				
		// Use GridBagLayout for an eye-friendly form
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{120, 71, 62, 82, 0, 106};
		gridBagLayout.rowHeights = new int[] {30, 30, 22, 30, 30, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpnlContentPane.setLayout(gridBagLayout);
		
		/*  jlblUsername  Name of Visitor Label      */
		JLabel jlblUsername = new JLabel("Username:");
		jlblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblUsername = new GridBagConstraints();
		gbc_jlblUsername.anchor = GridBagConstraints.EAST;
		gbc_jlblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jlblUsername.gridx = 0;
		gbc_jlblUsername.gridy = 0;
		jpnlContentPane.add(jlblUsername, gbc_jlblUsername);
		
		jtxtfldUsername = new JTextField();
		GridBagConstraints gbc_jtxtfldUsername = new GridBagConstraints();
		gbc_jtxtfldUsername.gridwidth = 5;
		gbc_jtxtfldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldUsername.gridx = 1;
		gbc_jtxtfldUsername.gridy = 0;
		jpnlContentPane.add(jtxtfldUsername, gbc_jtxtfldUsername);
		jtxtfldUsername.setColumns(10);
		
		JLabel jlblPassword = new JLabel("Password:");
		jlblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblPassword = new GridBagConstraints();
		gbc_jlblPassword.anchor = GridBagConstraints.EAST;
		gbc_jlblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jlblPassword.gridx = 0;
		gbc_jlblPassword.gridy = 1;
		jpnlContentPane.add(jlblPassword, gbc_jlblPassword);
		
		jpwdPassword = new JPasswordField();
		GridBagConstraints gbc_jpwdPassword = new GridBagConstraints();
		gbc_jpwdPassword.gridwidth = 5;
		gbc_jpwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpwdPassword.gridx = 1;
		gbc_jpwdPassword.gridy = 1;
		jpnlContentPane.add(jpwdPassword, gbc_jpwdPassword);
		
		lblNewLabel = new JLabel("Re-type Password:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		jpnlContentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jpwdRePassword = new JPasswordField();
		GridBagConstraints gbc_jpwdRePassword = new GridBagConstraints();
		gbc_jpwdRePassword.gridwidth = 5;
		gbc_jpwdRePassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpwdRePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpwdRePassword.gridx = 1;
		gbc_jpwdRePassword.gridy = 2;
		jpnlContentPane.add(jpwdRePassword, gbc_jpwdRePassword);
		
		jlblFullName = new JLabel("Full Name:");
		jlblFullName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblFullName = new GridBagConstraints();
		gbc_jlblFullName.anchor = GridBagConstraints.EAST;
		gbc_jlblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblFullName.gridx = 0;
		gbc_jlblFullName.gridy = 4;
		jpnlContentPane.add(jlblFullName, gbc_jlblFullName);
		
		jtxtfldFullName = new JTextField();
		GridBagConstraints gbc_jtxtfldFullName = new GridBagConstraints();
		gbc_jtxtfldFullName.gridwidth = 5;
		gbc_jtxtfldFullName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldFullName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldFullName.gridx = 1;
		gbc_jtxtfldFullName.gridy = 4;
		jpnlContentPane.add(jtxtfldFullName, gbc_jtxtfldFullName);
		jtxtfldFullName.setColumns(10);
		
		jlblSex = new JLabel("Sex:");
		jlblSex.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSex = new GridBagConstraints();
		gbc_jlblSex.anchor = GridBagConstraints.EAST;
		gbc_jlblSex.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSex.gridx = 0;
		gbc_jlblSex.gridy = 5;
		jpnlContentPane.add(jlblSex, gbc_jlblSex);
		
		jrdbtnMale = new JRadioButton("Male");
		jrdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jrdbtnMale = new GridBagConstraints();
		gbc_jrdbtnMale.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnMale.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnMale.gridx = 1;
		gbc_jrdbtnMale.gridy = 5;
		jpnlContentPane.add(jrdbtnMale, gbc_jrdbtnMale);
		
		jrdbtnFemale = new JRadioButton("Female");
		jrdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jrdbtnFemale = new GridBagConstraints();
		gbc_jrdbtnFemale.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnFemale.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnFemale.gridx = 2;
		gbc_jrdbtnFemale.gridy = 5;
		jpnlContentPane.add(jrdbtnFemale, gbc_jrdbtnFemale);
		
		jlblContactNumber = new JLabel("Contact number:");
		jlblContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblContactNumber = new GridBagConstraints();
		gbc_jlblContactNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblContactNumber.gridx = 0;
		gbc_jlblContactNumber.gridy = 6;
		jpnlContentPane.add(jlblContactNumber, gbc_jlblContactNumber);
		
		jtxtfldContactNumber = new JTextField();
		jtxtfldContactNumber.setText("");
		GridBagConstraints gbc_jtxtfldContactNumber = new GridBagConstraints();
		gbc_jtxtfldContactNumber.gridwidth = 2;
		gbc_jtxtfldContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldContactNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldContactNumber.gridx = 1;
		gbc_jtxtfldContactNumber.gridy = 6;
		jpnlContentPane.add(jtxtfldContactNumber, gbc_jtxtfldContactNumber);
		jtxtfldContactNumber.setColumns(10);
		
		jlblResidentialAddress = new JLabel("Residential Address:");
		jlblResidentialAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblResidentialAddress = new GridBagConstraints();
		gbc_jlblResidentialAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jlblResidentialAddress.gridx = 0;
		gbc_jlblResidentialAddress.gridy = 7;
		jpnlContentPane.add(jlblResidentialAddress, gbc_jlblResidentialAddress);
		
		jtxtareaResidentialAddress = new JTextArea();
		jtxtareaResidentialAddress.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_jtxtareaResidentialAddress = new GridBagConstraints();
		gbc_jtxtareaResidentialAddress.gridheight = 3;
		gbc_jtxtareaResidentialAddress.gridwidth = 5;
		gbc_jtxtareaResidentialAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtareaResidentialAddress.fill = GridBagConstraints.BOTH;
		gbc_jtxtareaResidentialAddress.gridx = 1;
		gbc_jtxtareaResidentialAddress.gridy = 7;
		jpnlContentPane.add(jtxtareaResidentialAddress, gbc_jtxtareaResidentialAddress);
		
		jlblEmployeeNumber = new JLabel("Employee number:");
		jlblEmployeeNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblEmployeeNumber = new GridBagConstraints();
		gbc_jlblEmployeeNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblEmployeeNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblEmployeeNumber.gridx = 0;
		gbc_jlblEmployeeNumber.gridy = 10;
		jpnlContentPane.add(jlblEmployeeNumber, gbc_jlblEmployeeNumber);
		
		jtxtfldEmployeeNumber = new JTextField();
		GridBagConstraints gbc_jtxtfldEmployeeNumber = new GridBagConstraints();
		gbc_jtxtfldEmployeeNumber.gridwidth = 3;
		gbc_jtxtfldEmployeeNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldEmployeeNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldEmployeeNumber.gridx = 1;
		gbc_jtxtfldEmployeeNumber.gridy = 10;
		jpnlContentPane.add(jtxtfldEmployeeNumber, gbc_jtxtfldEmployeeNumber);
		jtxtfldEmployeeNumber.setColumns(10);
		
		jlblSSSNumber = new JLabel("SSS number:");
		jlblSSSNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSSSNumber = new GridBagConstraints();
		gbc_jlblSSSNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblSSSNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSSSNumber.gridx = 0;
		gbc_jlblSSSNumber.gridy = 11;
		jpnlContentPane.add(jlblSSSNumber, gbc_jlblSSSNumber);
		
		jtxtfldSSSNumber = new JTextField();
		GridBagConstraints gbc_jtxtfldSSSNumber = new GridBagConstraints();
		gbc_jtxtfldSSSNumber.gridwidth = 3;
		gbc_jtxtfldSSSNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldSSSNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSSSNumber.gridx = 1;
		gbc_jtxtfldSSSNumber.gridy = 11;
		jpnlContentPane.add(jtxtfldSSSNumber, gbc_jtxtfldSSSNumber);
		jtxtfldSSSNumber.setColumns(10);
		
		jlblTIN = new JLabel("TIN:");
		jlblTIN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTIN = new GridBagConstraints();
		gbc_jlblTIN.anchor = GridBagConstraints.EAST;
		gbc_jlblTIN.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTIN.gridx = 0;
		gbc_jlblTIN.gridy = 12;
		jpnlContentPane.add(jlblTIN, gbc_jlblTIN);
		
		jtxtfldTIN = new JTextField();
		GridBagConstraints gbc_jtxtfldTIN = new GridBagConstraints();
		gbc_jtxtfldTIN.gridwidth = 3;
		gbc_jtxtfldTIN.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldTIN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTIN.gridx = 1;
		gbc_jtxtfldTIN.gridy = 12;
		jpnlContentPane.add(jtxtfldTIN, gbc_jtxtfldTIN);
		jtxtfldTIN.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 13;
		jpnlContentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		jbtnSave = new JButton("Save");
		panel.add(jbtnSave);

	}

}
