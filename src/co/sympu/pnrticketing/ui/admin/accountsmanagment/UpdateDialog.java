package co.sympu.pnrticketing.ui.admin.accountsmanagment;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Add form dialog for Accounts management.
 * 
 * @author Bismillah C. Constantino
 *
 */
public class UpdateDialog extends JDialog {

	/**
	 * Default Serial Version UID (for serializability, not important, placed to
	 * remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	/**
	 * Accounts Management Panel that owns this dialog box.
	 */
	protected AccountsManagementPanel accountsManagementPanel;

	// form components
	private JTextField jtxtfldUsername;
	private JPasswordField jpwdPassword;
	private JLabel jlblRePassword;
	private JPasswordField jpwdRePassword;
	private JLabel jlblFirstName;
	private JTextField jtxtfldFirstName;
	private JLabel jlblContactNumber;
	private JTextField jtxtfldContactNumber;
	private JLabel jlblAssignedStation;
	private JLabel jlblSSSNumber;
	private JTextField jtxtfldSSSNumber;
	private JLabel jlblTIN;
	private JTextField jtxtfldTIN;
	private JPanel buttonPane;
	private JButton jbtnSave;
	private JButton jbtnCancel;
	private JLabel jlblLastName;
	private JTextField jtxtfldLastName;
	private JComboBox<String> jcmbAssignedStation;
	private JLabel jlblMiddleName;
	private JTextField jtxtfldMiddleName;
	private JLabel jlblUpdateAccount;
	private JLabel jlblName;
	private JLabel jlblInstruction;
	private int accountIdCurrentlyBeingUpdated;
	private JLabel jlblSex;
	private JRadioButton jrdbtnMale;
	private JRadioButton jrdbtnFemale;

	public UpdateDialog() {
		// For reference later
		UpdateDialog thisDialog = this;

		// Set background color
		setBackground(Color.WHITE);

		// prevent user to resize the dialog
		setResizable(false);

		// set window size
		setMinimumSize(new Dimension(600, 430));

		// set title
		setTitle("Add Account");

		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Create the main content pane of this frame
		setContentPane(jpnlContentPane);

		// Use GridBagLayout for an eye-friendly form
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 110, 118, 91, 117 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 30, 20, 30, 30, 40, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		jpnlContentPane.setLayout(gridBagLayout);

		/*   */
		jlblUpdateAccount = new JLabel("Update Account");
		jlblUpdateAccount.setFont(new Font("Segoe UI", Font.BOLD, 22));
		GridBagConstraints gbc_jlblUpdateAccount = new GridBagConstraints();
		gbc_jlblUpdateAccount.gridwidth = 2;
		gbc_jlblUpdateAccount.anchor = GridBagConstraints.NORTHWEST;
		gbc_jlblUpdateAccount.insets = new Insets(0, 0, 5, 5);
		gbc_jlblUpdateAccount.gridx = 0;
		gbc_jlblUpdateAccount.gridy = 0;
		jpnlContentPane.add(jlblUpdateAccount, gbc_jlblUpdateAccount);
		/*   */

		/*   */
		jlblInstruction = new JLabel("Please fill this form to update an account");
		jlblInstruction.setForeground(Color.GRAY);
		jlblInstruction.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblInstruction = new GridBagConstraints();
		gbc_jlblInstruction.anchor = GridBagConstraints.WEST;
		gbc_jlblInstruction.gridwidth = 2;
		gbc_jlblInstruction.insets = new Insets(0, 0, 20, 5);
		gbc_jlblInstruction.gridx = 0;
		gbc_jlblInstruction.gridy = 1;
		jpnlContentPane.add(jlblInstruction, gbc_jlblInstruction);
		/*   */

		/*   */
		jlblName = new JLabel("Name:");
		jlblName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblName = new GridBagConstraints();
		gbc_jlblName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblName.anchor = GridBagConstraints.EAST;
		gbc_jlblName.gridx = 0;
		gbc_jlblName.gridy = 2;
		jpnlContentPane.add(jlblName, gbc_jlblName);
		/*   */

		/*   */
		jtxtfldFirstName = new JTextField();
		jtxtfldFirstName.setToolTipText("");
		jtxtfldFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldFirstName = new GridBagConstraints();
		gbc_jtxtfldFirstName.anchor = GridBagConstraints.SOUTH;
		gbc_jtxtfldFirstName.insets = new Insets(0, 5, 5, 5);
		gbc_jtxtfldFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldFirstName.gridx = 1;
		gbc_jtxtfldFirstName.gridy = 2;
		jpnlContentPane.add(jtxtfldFirstName, gbc_jtxtfldFirstName);
		jtxtfldFirstName.setColumns(10);
		/*   */

		/*   */
		jtxtfldMiddleName = new JTextField();
		jtxtfldMiddleName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldMiddleName = new GridBagConstraints();
		gbc_jtxtfldMiddleName.anchor = GridBagConstraints.SOUTH;
		gbc_jtxtfldMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldMiddleName.gridx = 2;
		gbc_jtxtfldMiddleName.gridy = 2;
		jpnlContentPane.add(jtxtfldMiddleName, gbc_jtxtfldMiddleName);
		jtxtfldMiddleName.setColumns(10);
		/*   */

		/*   */
		jtxtfldLastName = new JTextField();
		jtxtfldLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldLastName = new GridBagConstraints();
		gbc_jtxtfldLastName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldLastName.anchor = GridBagConstraints.SOUTH;
		gbc_jtxtfldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldLastName.gridx = 3;
		gbc_jtxtfldLastName.gridy = 2;
		jpnlContentPane.add(jtxtfldLastName, gbc_jtxtfldLastName);
		jtxtfldLastName.setColumns(10);
		/*   */

		/*   */
		jlblFirstName = new JLabel("First name");
		jlblFirstName.setForeground(Color.GRAY);
		jlblFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblFirstName = new GridBagConstraints();
		gbc_jlblFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_jlblFirstName.insets = new Insets(0, 5, 20, 5);
		gbc_jlblFirstName.gridx = 1;
		gbc_jlblFirstName.gridy = 3;
		jpnlContentPane.add(jlblFirstName, gbc_jlblFirstName);
		/*   */

		/*   */
		jlblMiddleName = new JLabel("Middle name");
		jlblMiddleName.setForeground(Color.GRAY);
		jlblMiddleName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblMiddleName = new GridBagConstraints();
		gbc_jlblMiddleName.anchor = GridBagConstraints.NORTHWEST;
		gbc_jlblMiddleName.insets = new Insets(0, 5, 5, 5);
		gbc_jlblMiddleName.gridx = 2;
		gbc_jlblMiddleName.gridy = 3;
		jpnlContentPane.add(jlblMiddleName, gbc_jlblMiddleName);
		/*   */

		/*   */
		jlblLastName = new JLabel("Last name");
		jlblLastName.setForeground(Color.GRAY);
		jlblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblLastName = new GridBagConstraints();
		gbc_jlblLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_jlblLastName.insets = new Insets(0, 5, 5, 0);
		gbc_jlblLastName.gridx = 3;
		gbc_jlblLastName.gridy = 3;
		jpnlContentPane.add(jlblLastName, gbc_jlblLastName);
		/*   */

		/*   */
		jlblContactNumber = new JLabel("Contact number:");
		jlblContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblContactNumber = new GridBagConstraints();
		gbc_jlblContactNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblContactNumber.gridx = 0;
		gbc_jlblContactNumber.gridy = 4;
		jpnlContentPane.add(jlblContactNumber, gbc_jlblContactNumber);
		/*   */

		/*   */
		jtxtfldContactNumber = new JTextField();
		jtxtfldContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldContactNumber.setText("");
		GridBagConstraints gbc_jtxtfldContactNumber = new GridBagConstraints();
		gbc_jtxtfldContactNumber.gridwidth = 3;
		gbc_jtxtfldContactNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldContactNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldContactNumber.gridx = 1;
		gbc_jtxtfldContactNumber.gridy = 4;
		jpnlContentPane.add(jtxtfldContactNumber, gbc_jtxtfldContactNumber);
		jtxtfldContactNumber.setColumns(10);
		/*   */

		/*   */
		JLabel jlblUsername = new JLabel("Username:");
		jlblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblUsername = new GridBagConstraints();
		gbc_jlblUsername.anchor = GridBagConstraints.EAST;
		gbc_jlblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_jlblUsername.gridx = 0;
		gbc_jlblUsername.gridy = 5;
		jpnlContentPane.add(jlblUsername, gbc_jlblUsername);
		jtxtfldUsername = new JTextField();
		jtxtfldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldUsername = new GridBagConstraints();
		gbc_jtxtfldUsername.gridwidth = 3;
		gbc_jtxtfldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldUsername.gridx = 1;
		gbc_jtxtfldUsername.gridy = 5;
		jpnlContentPane.add(jtxtfldUsername, gbc_jtxtfldUsername);
		/*   */

		/*   */
		jtxtfldUsername.setColumns(10);
		JLabel jlblPassword = new JLabel("Password:");
		jlblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblPassword = new GridBagConstraints();
		gbc_jlblPassword.anchor = GridBagConstraints.EAST;
		gbc_jlblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jlblPassword.gridx = 0;
		gbc_jlblPassword.gridy = 6;
		jpnlContentPane.add(jlblPassword, gbc_jlblPassword);
		/*   */

		/*   */
		jpwdPassword = new JPasswordField();
		jpwdPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jpwdPassword = new GridBagConstraints();
		gbc_jpwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jpwdPassword.gridx = 1;
		gbc_jpwdPassword.gridy = 6;
		jpnlContentPane.add(jpwdPassword, gbc_jpwdPassword);
		/*   */

		/*   */
		jlblRePassword = new JLabel("Confirm Password:");
		jlblRePassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblRePassword = new GridBagConstraints();
		gbc_jlblRePassword.anchor = GridBagConstraints.EAST;
		gbc_jlblRePassword.insets = new Insets(0, 0, 5, 5);
		gbc_jlblRePassword.gridx = 2;
		gbc_jlblRePassword.gridy = 6;
		jpnlContentPane.add(jlblRePassword, gbc_jlblRePassword);
		/*   */

		/*   */
		jpwdRePassword = new JPasswordField();
		jpwdRePassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jpwdRePassword = new GridBagConstraints();
		gbc_jpwdRePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpwdRePassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpwdRePassword.gridx = 3;
		gbc_jpwdRePassword.gridy = 6;
		jpnlContentPane.add(jpwdRePassword, gbc_jpwdRePassword);
		/*   */

		/*   */
		jlblTIN = new JLabel("TIN:");
		jlblTIN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTIN = new GridBagConstraints();
		gbc_jlblTIN.anchor = GridBagConstraints.EAST;
		gbc_jlblTIN.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTIN.gridx = 0;
		gbc_jlblTIN.gridy = 7;
		jpnlContentPane.add(jlblTIN, gbc_jlblTIN);
		/*   */

		/*   */
		jtxtfldTIN = new JTextField();
		GridBagConstraints gbc_jtxtfldTIN = new GridBagConstraints();
		gbc_jtxtfldTIN.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldTIN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTIN.gridx = 1;
		gbc_jtxtfldTIN.gridy = 7;
		jpnlContentPane.add(jtxtfldTIN, gbc_jtxtfldTIN);
		jtxtfldTIN.setColumns(10);
		/*   */

		/*   */
		jlblSSSNumber = new JLabel("SSS number:");
		jlblSSSNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSSSNumber = new GridBagConstraints();
		gbc_jlblSSSNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblSSSNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSSSNumber.gridx = 2;
		gbc_jlblSSSNumber.gridy = 7;
		jpnlContentPane.add(jlblSSSNumber, gbc_jlblSSSNumber);
		/*   */

		/*   */
		jtxtfldSSSNumber = new JTextField();
		GridBagConstraints gbc_jtxtfldSSSNumber = new GridBagConstraints();
		gbc_jtxtfldSSSNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSSSNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSSSNumber.gridx = 3;
		gbc_jtxtfldSSSNumber.gridy = 7;
		jpnlContentPane.add(jtxtfldSSSNumber, gbc_jtxtfldSSSNumber);
		jtxtfldSSSNumber.setColumns(10);
		/*   */
				
				jlblSex = new JLabel("Sex:");
				jlblSex.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				GridBagConstraints gbc_jlblSex = new GridBagConstraints();
				gbc_jlblSex.insets = new Insets(0, 0, 5, 5);
				gbc_jlblSex.gridx = 0;
				gbc_jlblSex.gridy = 8;
				jpnlContentPane.add(jlblSex, gbc_jlblSex);
				
				ButtonGroup sexButtonGroup = new ButtonGroup();
				
				jrdbtnMale = new JRadioButton("Male");
				GridBagConstraints gbc_jrdbtnMale = new GridBagConstraints();
				gbc_jrdbtnMale.insets = new Insets(0, 0, 5, 5);
				gbc_jrdbtnMale.gridx = 1;
				gbc_jrdbtnMale.gridy = 8;
				jpnlContentPane.add(jrdbtnMale, gbc_jrdbtnMale);
				sexButtonGroup.add(jrdbtnMale);
				
				jrdbtnFemale = new JRadioButton("Female");
				GridBagConstraints gbc_jrdbtnFemale = new GridBagConstraints();
				gbc_jrdbtnFemale.insets = new Insets(0, 0, 5, 5);
				gbc_jrdbtnFemale.gridx = 2;
				gbc_jrdbtnFemale.gridy = 8;
				jpnlContentPane.add(jrdbtnFemale, gbc_jrdbtnFemale);
				sexButtonGroup.add(jrdbtnFemale);
		
				jlblAssignedStation = new JLabel("Assigned Station:");
				jlblAssignedStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				GridBagConstraints gbc_jlblAssignedStation = new GridBagConstraints();
				gbc_jlblAssignedStation.anchor = GridBagConstraints.EAST;
				gbc_jlblAssignedStation.insets = new Insets(0, 0, 5, 5);
				gbc_jlblAssignedStation.gridx = 0;
				gbc_jlblAssignedStation.gridy = 9;
				jpnlContentPane.add(jlblAssignedStation, gbc_jlblAssignedStation);
		
				jcmbAssignedStation = new JComboBox<>();
				jcmbAssignedStation.setToolTipText("");
				GridBagConstraints gbc_jcmbAssignedStation = new GridBagConstraints();
				gbc_jcmbAssignedStation.insets = new Insets(0, 0, 5, 5);
				gbc_jcmbAssignedStation.fill = GridBagConstraints.HORIZONTAL;
				gbc_jcmbAssignedStation.gridx = 1;
				gbc_jcmbAssignedStation.gridy = 9;
				jpnlContentPane.add(jcmbAssignedStation, gbc_jcmbAssignedStation);

		buttonPane = new JPanel();
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.gridwidth = 4;
		gbc_buttonPane.fill = GridBagConstraints.BOTH;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 10;
		jpnlContentPane.add(buttonPane, gbc_buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		jbtnSave = new JButton("Save");
		jbtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = jtxtfldFirstName.getText();
				String middleName = jtxtfldMiddleName.getText();
				String lastName = jtxtfldLastName.getText();
				String userName = jtxtfldUsername.getText();
				if (userName.contains(" ")) {
					JOptionPane.showMessageDialog(thisDialog, "Username must not have spaces!");
					return;
				}
				String contactNumber = jtxtfldContactNumber.getText();
				String password = String.valueOf(jpwdPassword.getPassword());
				String confirmPassword = String.valueOf(jpwdRePassword.getPassword());

				if (!password.contentEquals(confirmPassword)) {
					JOptionPane.showMessageDialog(thisDialog, "Password does not match retype.");
					// dont proceed to insert
					return;
				}
				
				String sex = "";
				if(jrdbtnMale.isSelected())
					sex = "Male";
				else if(jrdbtnFemale.isSelected())
					sex = "Female";

				String tin = jtxtfldTIN.getText();
				String sssNumber = jtxtfldSSSNumber.getText();
				int assignedStationId = Integer.parseInt(((String) jcmbAssignedStation.getSelectedItem()).split("-")[0].trim());
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db",
						"pnr_app", "password123");
						PreparedStatement updateStatement = connection.prepareStatement(
								"UPDATE cashier SET first_name = ?, middle_name = ?, last_name = ?, contact_number = ?, username = ?, password = ?,"
										+ " sss_number = ?, tax_identification_number = ?, assigned_station_id = ?, sex = ?  WHERE id = ?")) {

					updateStatement.setString(1, firstName);
					updateStatement.setString(2, middleName);
					updateStatement.setString(3, lastName);
					updateStatement.setString(4, contactNumber);
					updateStatement.setString(5, userName);
					updateStatement.setString(6, password);
					updateStatement.setString(7, sssNumber);
					updateStatement.setString(8, tin);
					updateStatement.setInt(9, assignedStationId); // station id
					updateStatement.setString(10, sex);
					updateStatement.setInt(11, accountIdCurrentlyBeingUpdated);
					updateStatement.execute();

					JOptionPane.showMessageDialog(thisDialog, "Successfully updated contact.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);

					// hide this dialog
					thisDialog.setVisible(false);

					// refresh the table in mainframe, but how?
					accountsManagementPanel.refreshTable();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(thisDialog,
							"An error occured while trying to save contact.\n\nDetails: " + e1.getMessage(), "Error!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		jbtnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnSave.setBackground(Color.WHITE);
		buttonPane.add(jbtnSave);

		jbtnCancel = new JButton("Cancel");
		jbtnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnCancel.setBackground(Color.WHITE);
		jbtnCancel.addActionListener(event -> {
			thisDialog.setVisible(false);
		});
		buttonPane.add(jbtnCancel);
	}

	public void initializeWithAccountId(int accountID) {
		// do select query here by id, then get the data, then set the ui text inputs

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app",
				"password123");
				PreparedStatement retrieveAccountByIdStatement = connection
						.prepareStatement("SELECT * FROM cashier WHERE id = ?");
				Statement retrieveAllStationsStatement = connection.createStatement();
				ResultSet stationsResultSet = retrieveAllStationsStatement.executeQuery("SELECT * FROM station")) {

			retrieveAccountByIdStatement.setInt(1, accountID);

			retrieveAccountByIdStatement.execute();

			ResultSet accountResult = retrieveAccountByIdStatement.getResultSet();

			accountResult.next();
			// fetch the contact, store the id in class-scope variable
			accountIdCurrentlyBeingUpdated = accountResult.getInt("id");
			// update the ui fields from the fetched contact
			jtxtfldFirstName.setText(accountResult.getString("first_name"));
			jtxtfldMiddleName.setText(accountResult.getString("middle_name"));
			jtxtfldLastName.setText(accountResult.getString("last_name"));
			jtxtfldContactNumber.setText(accountResult.getString("contact_number"));
			jtxtfldUsername.setText(accountResult.getString("username"));
			jtxtfldTIN.setText(accountResult.getString("tax_identification_number"));
			jtxtfldSSSNumber.setText(accountResult.getString("sss_number"));
			
			String sex = accountResult.getString("sex");
			if(sex.equals("Male"))
				jrdbtnMale.setSelected(true);
			else if(sex.equals("Female"))
				jrdbtnFemale.setSelected(true);
			
			jcmbAssignedStation.removeAllItems();
			int selectedIndex = 0,
				currentIndex = 0;
			while(stationsResultSet.next()) {
				int stationId = stationsResultSet.getInt("id");
				jcmbAssignedStation.addItem(stationId + "-" + stationsResultSet.getString("name"));
				
				if(stationId == accountResult.getInt("assigned_station_id"))
					selectedIndex = currentIndex;
				
				currentIndex++;
			}
			jcmbAssignedStation.setSelectedIndex(selectedIndex);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this,
					"An error occured while trying to fetch account data. Please try again.\n\nDetails: "
							+ e.getMessage());
		}
	}

}
