package co.sympu.pnrticketing.ui.admin.accountsmanagment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ManagementPanel extends JPanel{

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
	protected AccountsDialog accountsAddDialog;
	/**
	 * Construct the panel.
	 */
	public ManagementPanel() {
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
			accountsAddDialog.setVisible(true);
		});
		jpnlButtonActions.add(jbtnShowAddForm);
		/* END OF jbtnShowAddForm */
		
		/*  jbtnUpdate - button for updating account */
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnUpdate);
		/*END OF jbtnUpdate */
		
		/*jbtnDelete - button for deleting account*/
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnDelete);
		/*END OF jbtnDelete*/
		
		/* jscrlpnCarTable - Scrollable Table Panel */
		JScrollPane jscrlpnCarTable = new JScrollPane();
		add(jscrlpnCarTable);
		/* END OF jscrlpnCarTable */
		
		/* jtblAccounts - Main Panel Table */
		jtblAccounts = new JTable();
		jtblAccounts.setRowHeight(25);
		jtblAccounts.setIntercellSpacing(new Dimension(10, 10));
		jtblAccounts.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		/* END OF jscrlpnCarTable */
		
		/* jtblAccounts - Main Panel Table */
		jtblAccounts = new JTable();
		jtblAccounts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Name", "Description"
			}
		));
		jtblAccounts.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtblAccounts.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtblAccounts.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtblAccounts.setRowHeight(25);
		jtblAccounts.setIntercellSpacing(new Dimension(10, 10));
		jtblAccounts.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnCarTable.setViewportView(jtblAccounts);
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
		accountsAddDialog = new AccountsDialog();
		accountsAddDialog.accountsManagementPanel = this;
	}

}
