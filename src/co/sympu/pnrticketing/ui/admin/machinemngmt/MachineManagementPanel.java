package co.sympu.pnrticketing.ui.admin.machinemngmt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.sympu.pnrticketing.ui.admin.MainFrame;

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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setBackground(UIManager.getColor("Button.background"));
		jpnlHeader.setBorder(null);
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));

		JLabel jlblHeader = new JLabel("Manage Machines");
		jlblHeader.setAlignmentY(0.0f);
		jlblHeader.setMaximumSize(new Dimension(32767, 200));
		jlblHeader.setHorizontalAlignment(SwingConstants.LEFT);
		jlblHeader.setFont(new Font("Roboto", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);

		JPanel jpnlButtonActions = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlButtonActions.setAlignmentY(0.0f);
		jpnlButtonActions.setAlignmentX(0.0f);
		jpnlHeader.add(jpnlButtonActions);

		JButton btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlButtonActions.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				machineManagementAdd.setVisible(true);
				machineManagementAdd.setLocationRelativeTo(tblMachineManagementTable);
				machineManagementAdd.txtSerial.setEnabled(true);
				machineManagementAdd.txtSerial.setText("");
				machineManagementAdd.txtPassword.setText("");
				machineManagementAdd.txtRePassword.setText("");
				machineManagementAdd.okButton.setVisible(true);
				machineManagementAdd.editButton.setVisible(false);
				machineManagementAdd.deleteButton.setVisible(false);
				machineManagementAdd.resetForm();
			}
		});
		btnAdd.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnUpload = new JButton("Update");
		btnUpload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpload.setBackground(Color.WHITE);
		btnUpload.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlButtonActions.add(btnUpload);
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTblMachineManagementTable().getSelectionModel().getSelectedItemsCount() == 0) {

					JOptionPane.showMessageDialog(mainFrame,
							"Please select a Machine first before clicking the Update button.", "Notice",
							JOptionPane.WARNING_MESSAGE);

					return;
				}

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app",
							"password123");

					String query = "select serial_number, " + "password," + "assigned_station_id " + "from machine "
							+ "where serial_number = '" + getTblMachineManagementTable()
									.getValueAt(getTblMachineManagementTable().getSelectedRow(), 0)
							+ "'";

					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					rs.next();

					machineManagementAdd.setVisible(true);
					machineManagementAdd.setLocationRelativeTo(tblMachineManagementTable);
					machineManagementAdd.okButton.setVisible(false);
					machineManagementAdd.editButton.setVisible(true);
					machineManagementAdd.deleteButton.setVisible(false);
					machineManagementAdd.resetForm();

					machineManagementAdd.txtSerial.setText(rs.getString("serial_number"));
					machineManagementAdd.txtSerial.setEnabled(false);
					machineManagementAdd.txtPassword.setText(rs.getString("password"));
					machineManagementAdd.txtRePassword.setText(rs.getString("password"));

					rs.close();
					stmt.close();
					con.close();

				} catch (Exception Exe) {
					Exe.printStackTrace();
				}
			}
		});
		btnUpload.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlButtonActions.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTblMachineManagementTable().getSelectionModel().getSelectedItemsCount() == 0) {

					JOptionPane.showMessageDialog(mainFrame,
							"Please select a Machine first before clicking the Delete button.", "Notice",
							JOptionPane.WARNING_MESSAGE);

					return;
				}
				DefaultTableModel bagModel = (DefaultTableModel) tblMachineManagementTable.getModel();
				int intSelectedRow = tblMachineManagementTable.getSelectedRow();
				int result = JOptionPane.showConfirmDialog(tblMachineManagementTable, "Confirm Deletion", "Notice",
						JOptionPane.INFORMATION_MESSAGE);

				if (result == JOptionPane.OK_OPTION) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app",
								"password123");

						Statement stmt = con.createStatement();
						stmt.execute("DELETE FROM machine WHERE serial_number = '"
								+ (bagModel.getValueAt(intSelectedRow, 0)).toString() + "'");

						refreshtbl();

						stmt.close();
						con.close();

						JOptionPane.showMessageDialog(null, "Successfully removed machine.");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error Deleting");
					}
				}
			}
		});
		btnDelete.setHorizontalAlignment(SwingConstants.RIGHT);

		scrMachineManagementPanel = new JScrollPane();
		scrMachineManagementPanel.setAlignmentX(0.0f);
		scrMachineManagementPanel.setToolTipText("Station\r\n");
		scrMachineManagementPanel.setViewportBorder(null);
		add(scrMachineManagementPanel);

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

			String query = "select machine.serial_number, machine.status, station.name as station_name from machine left join station on station.id = machine.assigned_station_id";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("serial_number"), rs.getString("status"),
						rs.getString("station_name") });
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
		tblMachineManagementTable.setFont(new Font("Roboto", Font.PLAIN, 12));
		tblMachineManagementTable.setRowHeight(22);
		tblMachineManagementTable.setIntercellSpacing(new Dimension(4, 4));
		tblMachineManagementTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}
}
