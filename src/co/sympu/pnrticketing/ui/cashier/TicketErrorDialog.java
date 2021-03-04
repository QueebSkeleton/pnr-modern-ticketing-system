package co.sympu.pnrticketing.ui.cashier;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Cursor;

public class TicketErrorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldOriginalControlNumber;
	private JTextField jtxtfldBalance;
	private JTextField jtxtfldCash;

	// reference for TicketCashierPrompt
	protected TicketCashierPrompt ticketCashierPrompt;
	
	// Self referencing 
	TicketErrorDialog ticketErrorDialog = this;

	/**
	 * Create the dialog.
	 */
	public TicketErrorDialog() {
		
	
		
		setResizable(false);
		setTitle("Ticket Error Prompt");
		
	
		setBounds(100, 100, 450, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel jlblOriginalControlNumber = new JLabel("Control Number:");
			GridBagConstraints gbc_jlblOriginalControlNumber = new GridBagConstraints();
			gbc_jlblOriginalControlNumber.insets = new Insets(0, 0, 5, 5);
			gbc_jlblOriginalControlNumber.anchor = GridBagConstraints.EAST;
			gbc_jlblOriginalControlNumber.gridx = 1;
			gbc_jlblOriginalControlNumber.gridy = 2;
			contentPanel.add(jlblOriginalControlNumber, gbc_jlblOriginalControlNumber);
		}
		{
			jtxtfldOriginalControlNumber = new JTextField();
			jtxtfldOriginalControlNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jtxtfldOriginalControlNumber = new GridBagConstraints();
			gbc_jtxtfldOriginalControlNumber.insets = new Insets(0, 0, 5, 5);
			gbc_jtxtfldOriginalControlNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldOriginalControlNumber.gridx = 2;
			gbc_jtxtfldOriginalControlNumber.gridy = 2;
			contentPanel.add(jtxtfldOriginalControlNumber, gbc_jtxtfldOriginalControlNumber);
			jtxtfldOriginalControlNumber.setColumns(10);
		}
		{
			JLabel jlblBalance = new JLabel("Balance:");
			GridBagConstraints gbc_jlblBalance = new GridBagConstraints();
			gbc_jlblBalance.anchor = GridBagConstraints.EAST;
			gbc_jlblBalance.insets = new Insets(0, 0, 5, 5);
			gbc_jlblBalance.gridx = 1;
			gbc_jlblBalance.gridy = 4;
			contentPanel.add(jlblBalance, gbc_jlblBalance);
		}
		{
			jtxtfldBalance = new JTextField();
			jtxtfldBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jtxtfldBalance = new GridBagConstraints();
			gbc_jtxtfldBalance.insets = new Insets(0, 0, 5, 5);
			gbc_jtxtfldBalance.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldBalance.gridx = 2;
			gbc_jtxtfldBalance.gridy = 4;
			contentPanel.add(jtxtfldBalance, gbc_jtxtfldBalance);
			jtxtfldBalance.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Cash:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 5;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			jtxtfldCash = new JTextField();
			jtxtfldCash.setFont(new Font("Tahoma", Font.BOLD, 14));
			jtxtfldCash.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_jtxtfldCash = new GridBagConstraints();
			gbc_jtxtfldCash.insets = new Insets(0, 0, 0, 5);
			gbc_jtxtfldCash.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldCash.gridx = 2;
			gbc_jtxtfldCash.gridy = 5;
			contentPanel.add(jtxtfldCash, gbc_jtxtfldCash);
			jtxtfldCash.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton jbtnConfirm = 	new JButton("CONFIRM");
				jbtnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jbtnConfirm.setActionCommand("OK");
				buttonPane.add(jbtnConfirm);
				getRootPane().setDefaultButton(jbtnConfirm);
			}
			{
				JButton jbtnCancel = new JButton("Cancel");
				jbtnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				jbtnCancel.setActionCommand("Cancel");
				buttonPane.add(jbtnCancel);
			}
		}
	}
	
	public void confirmChanges() {
		
				// connection statements for the database to work 
				//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
				//Statement statement = connection.createStatement();
				
				// statement that executes selecting all data inside tickets table 
				
	}

}
