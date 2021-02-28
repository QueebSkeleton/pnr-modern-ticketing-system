package co.sympu.pnrticketing.ui.admin.machinemngmt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.sympu.pnrticketing.ui.admin.MainFrame;
import co.sympu.pnrticketing.ui.admin.stationmgmt.FormDialog;
import co.sympu.pnrticketing.ui.admin.stationmgmt.StationTableModel;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("unused")
public class MachineManagementAdd extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerial;
	private JTextField txtPassword;
	private JTextField txtRePassword;

	static Connection objConn;
	static ResultSet objResultSet;
	static Statement objSQLQuery;

	protected MachineManagementPanel machineManagementPanel;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtSerial.setText("");
				txtPassword.setText("");
				txtRePassword.setText("");
			}
		});

		setTitle("Add Machine");
		setBounds(100, 100, 450, 263);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 80, 109, 147, 0 };
		gbl_contentPanel.rowHeights = new int[] { 27, 19, 19, 19, 19, 19, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSerial = new JLabel("Serial Number");
			lblSerial.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSerial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblSerial = new GridBagConstraints();
			gbc_lblSerial.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblSerial.insets = new Insets(0, 0, 5, 5);
			gbc_lblSerial.gridx = 1;
			gbc_lblSerial.gridy = 1;
			contentPanel.add(lblSerial, gbc_lblSerial);
		}
		{
			txtSerial = new JTextField();
			txtSerial.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_txtSerial = new GridBagConstraints();
			gbc_txtSerial.fill = GridBagConstraints.BOTH;
			gbc_txtSerial.insets = new Insets(0, 0, 5, 0);
			gbc_txtSerial.gridx = 2;
			gbc_txtSerial.gridy = 1;
			contentPanel.add(txtSerial, gbc_txtSerial);
			txtSerial.setColumns(20);
		}
		{
			JLabel lblStation = new JLabel("Station");
			lblStation.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblStation = new GridBagConstraints();
			gbc_lblStation.anchor = GridBagConstraints.SOUTH;
			gbc_lblStation.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblStation.insets = new Insets(0, 0, 5, 5);
			gbc_lblStation.gridx = 1;
			gbc_lblStation.gridy = 2;
			contentPanel.add(lblStation, gbc_lblStation);
		}

		JComboBox cmbStation = new JComboBox();
		GridBagConstraints gbc_cmbStation = new GridBagConstraints();
		gbc_cmbStation.fill = GridBagConstraints.BOTH;
		gbc_cmbStation.insets = new Insets(0, 0, 5, 0);
		gbc_cmbStation.gridx = 2;
		gbc_cmbStation.gridy = 2;
		contentPanel.add(cmbStation, gbc_cmbStation);
		{
			JLabel lblStatus = new JLabel("Status");
			lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStatus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblStatus = new GridBagConstraints();
			gbc_lblStatus.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatus.gridx = 1;
			gbc_lblStatus.gridy = 3;
			contentPanel.add(lblStatus, gbc_lblStatus);
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			objConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			objSQLQuery = objConn.createStatement();

		} catch (Exception objEx) {
			System.out.println("Problem retrieving information..");
			System.out.println(objEx);
		}

		try {
			String strQuery = "SELECT id, name FROM station";
			ResultSet rs = objSQLQuery.executeQuery(strQuery);

			while (rs.next()) {
				cmbStation.addItem(rs.getString("id") + " - " + rs.getString("name"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}

		JComboBox cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] { "active", "inactive" }));
		GridBagConstraints gbc_cmbStatus = new GridBagConstraints();
		gbc_cmbStatus.fill = GridBagConstraints.BOTH;
		gbc_cmbStatus.insets = new Insets(0, 0, 5, 0);
		gbc_cmbStatus.gridx = 2;
		gbc_cmbStatus.gridy = 3;
		contentPanel.add(cmbStatus, gbc_cmbStatus);
		{
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.NORTH;
			gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 1;
			gbc_lblPassword.gridy = 4;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}

		txtPassword = new JTextField();
		txtPassword.setColumns(20);
		txtPassword.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.BOTH;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 4;
		contentPanel.add(txtPassword, gbc_txtPassword);
		{
			JLabel lblRetypePassword = new JLabel("Retype Password");
			lblRetypePassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRetypePassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblRetypePassword = new GridBagConstraints();
			gbc_lblRetypePassword.anchor = GridBagConstraints.NORTH;
			gbc_lblRetypePassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblRetypePassword.insets = new Insets(0, 0, 0, 5);
			gbc_lblRetypePassword.gridx = 1;
			gbc_lblRetypePassword.gridy = 5;
			contentPanel.add(lblRetypePassword, gbc_lblRetypePassword);
		}

		txtRePassword = new JTextField();
		txtRePassword.setColumns(20);
		txtRePassword.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtRePassword = new GridBagConstraints();
		gbc_txtRePassword.fill = GridBagConstraints.BOTH;
		gbc_txtRePassword.gridx = 2;
		gbc_txtRePassword.gridy = 5;
		contentPanel.add(txtRePassword, gbc_txtRePassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db",
									"pnr_app", "password123");

							Statement stmt = con.createStatement();
							stmt.execute("INSERT INTO machine (serial_number, password, status, assigned_station_id) "
									+ "VALUES ('" + txtSerial.getText() + "','" + txtPassword.getText() + "', '"
									+ ((String) cmbStatus.getSelectedItem()) + "', '"
									+ ((String) cmbStation.getSelectedItem()).split(" - ")[0].trim() + "')");

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
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
