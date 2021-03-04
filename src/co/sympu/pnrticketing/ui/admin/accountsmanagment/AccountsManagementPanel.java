package co.sympu.pnrticketing.ui.admin.accountsmanagment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountsManagementPanel extends JPanel{

	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The main table of this panel.
	 */
	private JTable jtblAccounts;
	
	/**
	 * Add Form Dialog of this panel.
	 */
	protected AddDialog addDialog;
	protected UpdateDialog updateDialog;
	/**
	 * Construct the panel.
	 */
	public AccountsManagementPanel() {
		AccountsManagementPanel thisPanel = this;
		// Set background to white
		setBackground(Color.WHITE);
		// Set border to EmptyBorder for spacing
		setBorder(new EmptyBorder(10, 10, 10, 10));
		// Use BoxLayout to lay the internal 3 panels: Header, Table, Pagination Actions
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* jpnlHeader - Header Panel */
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jpnlHeader.setMinimumSize(new Dimension(10, 45));
		jpnlHeader.setMaximumSize(new Dimension(32767, 55));
		jpnlHeader.setBackground(Color.WHITE);
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		/* END OF jpnlHeader */
		
		/* jlblHeader - Header label */
		JLabel jlblHeader = new JLabel("Manage Accounts");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */

		/* jpnlButtonActions - panel for buttons */
		JPanel jpnlButtonActions = new JPanel();
		FlowLayout fl_jpnlButtonActions = (FlowLayout) jpnlButtonActions.getLayout();
		fl_jpnlButtonActions.setAlignment(FlowLayout.RIGHT);
		jpnlButtonActions.setBackground(Color.WHITE);
		jpnlHeader.add(jpnlButtonActions);
		/* END OF jpnlButtonActions */

		/* jbtnShowAddForm - button for adding an account */
		JButton jbtnShowAddForm = new JButton("Add");
		jbtnShowAddForm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnShowAddForm.addActionListener(event -> {
			addDialog.resetForm();
			addDialog.setVisible(true);
		});
		jpnlButtonActions.add(jbtnShowAddForm);
		/* END OF jbtnShowAddForm */
		
		/*  jbtnUpdate - button for updating account */
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int selectedRowIndexOnTable = jtblAccounts.getSelectedRow();
			if(selectedRowIndexOnTable == -1) {
				JOptionPane.showMessageDialog(thisPanel, "Please select an account first before clicking this button.", "Warning!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int databaseIdOfSelectedAccount = (int )jtblAccounts.getValueAt(selectedRowIndexOnTable, 0);
			
			updateDialog.initializeWithAccountId(databaseIdOfSelectedAccount);
			
			updateDialog.setVisible(true);
			}
		});
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnUpdate);
		/*END OF jbtnUpdate */
		
		/*jbtnDelete - button for deleting account*/
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndexOnTable = jtblAccounts.getSelectedRow();
				if(selectedRowIndexOnTable == -1){
					JOptionPane.showMessageDialog(thisPanel, "Please select an account first before clicking this button.", "Warning!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(JOptionPane.showConfirmDialog(thisPanel, "Are you sure you want to delete this account?") == JOptionPane.YES_OPTION) {
					// perform delete here
					int databaseIdOfSelectedAccount = (int) jtblAccounts.getValueAt(selectedRowIndexOnTable, 0);
					try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db","pnr_app", "password123");
							PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM cashier WHERE id = ?")) {
							
							deleteStatement.setInt(1, databaseIdOfSelectedAccount);
							
							deleteStatement.execute();
							
							JOptionPane.showMessageDialog(thisPanel, "Successfully deleted account.", "Success!", JOptionPane.INFORMATION_MESSAGE);
							
							refreshTable();
						} catch(SQLException e1) {
							JOptionPane.showMessageDialog(thisPanel, "An error occured while fetching contacts from the database.\n\nDetails: " + e1.getMessage());
						}
					}
				}
			});
					
				
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnDelete);
		/*END OF jbtnDelete*/
		
		/* jscrlpnAccounts - Scrollable Table Panel */
		JScrollPane jscrlpnAccounts = new JScrollPane();
		add(jscrlpnAccounts);
		/* END OF jscrlpnAccounts */
		
		/* jtblAccounts - Main Panel Table */
		jtblAccounts = new JTable();
		jscrlpnAccounts.setViewportView(jtblAccounts);
		
		/*END OF jtblAccounts*/
		
		/* jpnlTablePagination - Panel for Pagination Components */
		JPanel jpnlTablePagination = new JPanel();
		jpnlTablePagination.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpnlTablePagination.setBackground(Color.WHITE);
		jpnlTablePagination.setMaximumSize(new Dimension(32767, 60));
		jpnlTablePagination.setMinimumSize(new Dimension(10, 50));
		add(jpnlTablePagination);
		jpnlTablePagination.setLayout(new BoxLayout(jpnlTablePagination, BoxLayout.X_AXIS));
		/* END OF jpnlTablePagination */
		
		// Spacing
		jpnlTablePagination.add(Box.createRigidArea(new Dimension(10, 0)));
		
		// Create the add form dialog
		addDialog = new AddDialog();
		addDialog.accountsManagementPanel = this;
		
		updateDialog = new UpdateDialog();
		updateDialog.accountsManagementPanel = this;
	}
	public void refreshTable() {
		DefaultTableModel accountsTableData = new DefaultTableModel();
		accountsTableData.setColumnCount(3);
		accountsTableData.setColumnIdentifiers(new String[] {"ID", "Name", "Assigned Station"});
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
				Statement retrieveStatement = connection.createStatement();){
			retrieveStatement.execute("SELECT cashier.id, cashier.first_name, cashier.last_name, station.name AS assigned_station FROM cashier LEFT JOIN station ON station.id = cashier.assigned_station_id");
			ResultSet retrievedAccountsData = retrieveStatement.getResultSet();
			
			while(retrievedAccountsData.next()) {
				int id = retrievedAccountsData.getInt("id");
				String firstName = retrievedAccountsData.getString("first_name");
				String lastName = retrievedAccountsData.getString("last_name");
				String assignedStation = retrievedAccountsData.getString("assigned_station");
				accountsTableData.addRow(new Object[] { id, firstName +" "+ lastName, assignedStation });
			}
				
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, e);
		}
		jtblAccounts.setModel(accountsTableData);
		
	}

}
