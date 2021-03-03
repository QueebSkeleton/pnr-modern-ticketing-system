package co.sympu.pnrticketing.ui.admin.machinemngmt;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.sympu.pnrticketing.ui.admin.MainFrame;

import java.awt.SystemColor;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MachineManagementPanel extends JPanel {

	static Connection objConn;
	static ResultSet objResultSet;
	static Statement objSQLQuery;
	
	protected MainFrame mainFrame;
	
	private static final long serialVersionUID = 1L;
	private JTable tblMachineManagementTable;

	private MachineManagementAdd machineManagementAdd;
	private JScrollPane scrMachineManagementPanel;

	/**
	 * Create the panel.
	 */
	public MachineManagementPanel() {

		machineManagementAdd = new MachineManagementAdd();
		machineManagementAdd.machineManagementPanel = this;
		// machineManagementAdd.machineManagementAdd = this;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 172, 0 };
		gridBagLayout.rowHeights = new int[] { 74, 216, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 106, 108, 51, 67, 63, 0 };
		gbl_panel.rowHeights = new int[] { 32, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Machine\r\n: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				machineManagementAdd.setVisible(true);
				machineManagementAdd.setLocationRelativeTo(tblMachineManagementTable);
				machineManagementAdd.txtSerial.setText("");
				machineManagementAdd.txtPassword.setText("");
				machineManagementAdd.txtRePassword.setText("");
				machineManagementAdd.okButton.setVisible(true);
				machineManagementAdd.editButton.setVisible(false);
				machineManagementAdd.deleteButton.setVisible(false);
			}
		});
		btnAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);

		JButton btnUpload = new JButton("Update");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTblMachineManagementTable().getSelectionModel().getSelectedItemsCount() == 0) {
					
					JOptionPane.showMessageDialog(
					mainFrame, 
					"Please select a Machine first before clicking the Update button.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app",
							"password123");

					String query = "select serial_number, "
								+ "password,"
								+ "assigned_station_id "
								+ "from machine "
							+ "where serial_number = '" + getTblMachineManagementTable().getValueAt(
									getTblMachineManagementTable().getSelectedRow(), 0) + "'";
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
				
				machineManagementAdd.setVisible(true);
				machineManagementAdd.setLocationRelativeTo(tblMachineManagementTable);
				machineManagementAdd.okButton.setVisible(false);
				machineManagementAdd.editButton.setVisible(true);
				machineManagementAdd.deleteButton.setVisible(false);
				
				machineManagementAdd.txtSerial.setText(rs.getString("serial_number"));
				machineManagementAdd.txtSerial.setEnabled(false);
				machineManagementAdd.txtPassword.setText(rs.getString("password"));
				machineManagementAdd.txtRePassword.setText(rs.getString("password"));
				

				rs.close();
				stmt.close();
				con.close();
				
			}catch(Exception Exe) {
				Exe.printStackTrace();
			}
			}
		});
		btnUpload.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnUpload = new GridBagConstraints();
		gbc_btnUpload.anchor = GridBagConstraints.WEST;
		gbc_btnUpload.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpload.gridx = 3;
		gbc_btnUpload.gridy = 0;
		panel.add(btnUpload, gbc_btnUpload);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTblMachineManagementTable().getSelectionModel().getSelectedItemsCount() == 0) {
					
					JOptionPane.showMessageDialog(
					mainFrame, 
					"Please select a Machine first before clicking the Delete button.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
					
					return;
				}
				DefaultTableModel bagModel = (DefaultTableModel)tblMachineManagementTable.getModel();
		        int intSelectedRow = tblMachineManagementTable.getSelectedRow();
		        int result = JOptionPane.showConfirmDialog(tblMachineManagementTable, "Confirm Deletion", "Notice", JOptionPane.INFORMATION_MESSAGE);
		        
		        if (result == JOptionPane.OK_OPTION) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");

		            Statement stmt = con.createStatement();
			    stmt.execute("DELETE FROM machine WHERE serial_number = '" + 
		                    (bagModel.getValueAt(intSelectedRow, 0)).toString() +"'");
		            
			    refreshtbl();
		        }catch(Exception e1){
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error Deleting");
		        }
		        }
			}
		});
		btnDelete.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.WEST;
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 0;
		panel.add(btnDelete, gbc_btnDelete);

		scrMachineManagementPanel = new JScrollPane();
		scrMachineManagementPanel.setToolTipText("Station\r\n");
		scrMachineManagementPanel.setViewportBorder(null);
		GridBagConstraints gbc_scrMachineManagementPanel = new GridBagConstraints();
		gbc_scrMachineManagementPanel.gridwidth = 2;
		gbc_scrMachineManagementPanel.insets = new Insets(0, 0, 5, 0);
		gbc_scrMachineManagementPanel.fill = GridBagConstraints.BOTH;
		gbc_scrMachineManagementPanel.gridx = 0;
		gbc_scrMachineManagementPanel.gridy = 1;
		add(scrMachineManagementPanel, gbc_scrMachineManagementPanel);

		setTblMachineManagementTable(new JTable());
		scrMachineManagementPanel.add(getTblMachineManagementTable());
		scrMachineManagementPanel.setViewportView(getTblMachineManagementTable());
	}

	public void refreshtbl() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Status");
		model.addColumn("Station");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app",
					"password123");

			String query = "select serial_number, status, assigned_station_id from machine";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("serial_number"), rs.getString("status"),
						rs.getString("assigned_station_id") });
			}

			rs.close();
			stmt.close();
			con.close();

			getTblMachineManagementTable().setModel(model);
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, e.printStackTrace());
			e.printStackTrace();
		}
	}

	public JTable getTblMachineManagementTable() {
		return tblMachineManagementTable;
	}

	public void setTblMachineManagementTable(JTable tblMachineManagementTable) {
		this.tblMachineManagementTable = tblMachineManagementTable;
		tblMachineManagementTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
}
