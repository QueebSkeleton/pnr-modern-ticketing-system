package co.sympu.pnrticketing.ui.admin.machinemngmt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class MachineManagementAdd extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	protected JTextField txtSerial = new JTextField();
	protected JTextField txtPassword = new JTextField();
	protected JTextField txtRePassword = new JTextField();

	protected JButton okButton = new JButton("OK");
	protected JButton editButton = new JButton("Edit");
	protected JButton deleteButton = new JButton("Delete");

	protected JComboBox cmbStation = new JComboBox();
	protected JComboBox cmbStatus = new JComboBox();

	static Connection objConn;
	static ResultSet objResultSet;
	static Statement objSQLQuery;

	protected MachineManagementPanel machineManagementPanel;
	private final JLabel jlblHeader = new JLabel("Save a Machine");

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		try {
			MachineManagementAdd dialog = new MachineManagementAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MachineManagementAdd() {
		setMinimumSize(new Dimension(400, 320));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});

		setTitle("Add Machine");
		setBounds(100, 100, 450, 263);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0 };
		contentPanel.setLayout(gbl_contentPanel);

		GridBagConstraints gbc_jlblHeader = new GridBagConstraints();
		gbc_jlblHeader.anchor = GridBagConstraints.WEST;
		gbc_jlblHeader.gridwidth = 2;
		gbc_jlblHeader.insets = new Insets(0, 0, 10, 5);
		gbc_jlblHeader.gridx = 0;
		gbc_jlblHeader.gridy = 0;
		jlblHeader.setFont(new Font("Roboto", Font.PLAIN, 24));
		contentPanel.add(jlblHeader, gbc_jlblHeader);
		{
			JLabel lblSerial = new JLabel("Serial Number");
			lblSerial.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSerial.setFont(new Font("Roboto", Font.PLAIN, 12));
			GridBagConstraints gbc_lblSerial = new GridBagConstraints();
			gbc_lblSerial.anchor = GridBagConstraints.EAST;
			gbc_lblSerial.insets = new Insets(0, 0, 5, 5);
			gbc_lblSerial.gridx = 0;
			gbc_lblSerial.gridy = 1;
			contentPanel.add(lblSerial, gbc_lblSerial);
		}
		{
			txtSerial = new JTextField();
			txtSerial.setMargin(new Insets(5, 5, 5, 5));
			txtSerial.setFont(new Font("Roboto", Font.PLAIN, 12));
			// txtSerial = new JTextField();
			txtSerial.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_txtSerial = new GridBagConstraints();
			gbc_txtSerial.fill = GridBagConstraints.BOTH;
			gbc_txtSerial.insets = new Insets(0, 0, 5, 5);
			gbc_txtSerial.gridx = 1;
			gbc_txtSerial.gridy = 1;
			contentPanel.add(txtSerial, gbc_txtSerial);
			txtSerial.setColumns(20);
		}
		{
			JLabel lblStation = new JLabel("Station");
			lblStation.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStation.setFont(new Font("Roboto", Font.PLAIN, 12));
			GridBagConstraints gbc_lblStation = new GridBagConstraints();
			gbc_lblStation.anchor = GridBagConstraints.EAST;
			gbc_lblStation.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblStation.insets = new Insets(0, 0, 5, 5);
			gbc_lblStation.gridx = 0;
			gbc_lblStation.gridy = 2;
			contentPanel.add(lblStation, gbc_lblStation);
		}

		// JComboBox cmbStation = new JComboBox();
		GridBagConstraints gbc_cmbStation = new GridBagConstraints();
		gbc_cmbStation.fill = GridBagConstraints.BOTH;
		gbc_cmbStation.insets = new Insets(0, 0, 5, 5);
		gbc_cmbStation.gridx = 1;
		gbc_cmbStation.gridy = 2;
		cmbStation.setMinimumSize(new Dimension(31, 30));
		cmbStation.setPreferredSize(new Dimension(31, 30));
		cmbStation.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPanel.add(cmbStation, gbc_cmbStation);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			objConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			objSQLQuery = objConn.createStatement();

		} catch (Exception objEx) {
			System.out.println("Problem retrieving information..");
			System.out.println(objEx);
		}

		{
			JLabel lblStatus = new JLabel("Status");
			lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStatus.setFont(new Font("Roboto", Font.PLAIN, 12));
			GridBagConstraints gbc_lblStatus = new GridBagConstraints();
			gbc_lblStatus.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatus.gridx = 0;
			gbc_lblStatus.gridy = 3;
			contentPanel.add(lblStatus, gbc_lblStatus);
		}
		cmbStatus.setPreferredSize(new Dimension(31, 30));
		cmbStatus.setMinimumSize(new Dimension(31, 30));
		cmbStatus.setFont(new Font("Roboto", Font.PLAIN, 12));

		// JComboBox cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] { "active", "inactive" }));
		GridBagConstraints gbc_cmbStatus = new GridBagConstraints();
		gbc_cmbStatus.fill = GridBagConstraints.BOTH;
		gbc_cmbStatus.insets = new Insets(0, 0, 5, 5);
		gbc_cmbStatus.gridx = 1;
		gbc_cmbStatus.gridy = 3;
		contentPanel.add(cmbStatus, gbc_cmbStatus);
		{
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setFont(new Font("Roboto", Font.PLAIN, 12));
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 0;
			gbc_lblPassword.gridy = 4;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		txtPassword.setMargin(new Insets(5, 5, 5, 5));
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 12));

		// txtPassword = new JTextField();
		txtPassword.setColumns(20);
		txtPassword.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.BOTH;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 4;
		contentPanel.add(txtPassword, gbc_txtPassword);
		{
			JLabel lblRetypePassword = new JLabel("Retype Password");
			lblRetypePassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRetypePassword.setFont(new Font("Roboto", Font.PLAIN, 12));
			GridBagConstraints gbc_lblRetypePassword = new GridBagConstraints();
			gbc_lblRetypePassword.anchor = GridBagConstraints.EAST;
			gbc_lblRetypePassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblRetypePassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblRetypePassword.gridx = 0;
			gbc_lblRetypePassword.gridy = 5;
			contentPanel.add(lblRetypePassword, gbc_lblRetypePassword);
		}
		txtRePassword.setMargin(new Insets(5, 5, 5, 5));
		txtRePassword.setFont(new Font("Roboto", Font.PLAIN, 12));

		// txtRePassword = new JTextField();
		txtRePassword.setColumns(20);
		txtRePassword.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtRePassword = new GridBagConstraints();
		gbc_txtRePassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtRePassword.fill = GridBagConstraints.BOTH;
		gbc_txtRePassword.gridx = 1;
		gbc_txtRePassword.gridy = 5;
		contentPanel.add(txtRePassword, gbc_txtRePassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 20, 20, 20));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.setFont(new Font("Roboto", Font.PLAIN, 12));
				okButton.setBackground(Color.WHITE);
				// JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String pass1 = txtPassword.getText(), pass2 = txtRePassword.getText();

						if (!(pass1.equals(pass2))) {

							JOptionPane.showMessageDialog(okButton, "Passwords do not Match", "Notice",
									JOptionPane.WARNING_MESSAGE);

							return;
						}

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db",
									"pnr_app", "password123");

							Statement stmt = con.createStatement();

							stmt.execute("INSERT INTO machine (serial_number, password, status, assigned_station_id) "
									+ "VALUES ('" + txtSerial.getText() + "','" + txtPassword.getText() + "', '"
									+ ((String) cmbStatus.getSelectedItem()) + "', '"
									+ ((String) cmbStation.getSelectedItem()).split(" - ")[0].trim() + "')");

							stmt.close();
							con.close();

							JOptionPane.showMessageDialog(null, "Successfully created machine with credentials.");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, txtSerial.getText() + "\nError\n\n" + e);
						}
						machineManagementPanel.refreshtbl();
						dispose();
						// setVisible(false);
					}

				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				editButton.setFont(new Font("Roboto", Font.PLAIN, 12));
				editButton.setBackground(Color.WHITE);

				// JButton editButton = new JButton("Edit");
				editButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							String strID = machineManagementPanel.getTblMachineManagementTable()
									.getValueAt(machineManagementPanel.getTblMachineManagementTable().getSelectedRow(),
											0)
									.toString();
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db",
									"pnr_app", "password123");

							java.sql.Statement stmt = con.createStatement();
							String query = "SELECT serial_number from machine " + "WHERE serial_number = '" + strID
									+ "'";
							ResultSet rs = stmt.executeQuery(query);
							if (rs.next()) {

								stmt.execute("UPDATE machine " + "SET serial_number = '" + txtSerial.getText() + "', "
										+ "password = '" + txtPassword.getText() + "', " + "status = '"
										+ ((String) cmbStatus.getSelectedItem()) + "', " + "assigned_station_id = '"
										+ ((String) cmbStation.getSelectedItem()).split(" - ")[0].trim() + "' "
										+ "WHERE serial_number = '" + rs.getString("serial_number") + "'");

							} else {
								JOptionPane.showMessageDialog(editButton, "No such ID", "Notice",
										JOptionPane.WARNING_MESSAGE);
							}

							rs.close();
							stmt.close();
							con.close();

							JOptionPane.showMessageDialog(null, "Successfully updated machine.");

							machineManagementPanel.refreshtbl();
							dispose();

						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				});

				editButton.setActionCommand("Edit");
				buttonPane.add(editButton);
				deleteButton.setFont(new Font("Roboto", Font.PLAIN, 12));
				deleteButton.setBackground(Color.WHITE);

				// JButton deleteButton = new JButton("Delete");
				deleteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

					}
				});

				deleteButton.setActionCommand("Delete");
				buttonPane.add(deleteButton);

				getRootPane().setDefaultButton(okButton);
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setFont(new Font("Roboto", Font.PLAIN, 12));
					cancelButton.setBackground(Color.WHITE);
					cancelButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							setVisible(false);
						}
					});
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
	}

	public void resetForm() {
		try {
			String strQuery = "SELECT id, name FROM station";
			ResultSet rs = objSQLQuery.executeQuery(strQuery);

			cmbStation.removeAllItems();
			while (rs.next()) {
				cmbStation.addItem(rs.getString("id") + " - " + rs.getString("name"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
}
