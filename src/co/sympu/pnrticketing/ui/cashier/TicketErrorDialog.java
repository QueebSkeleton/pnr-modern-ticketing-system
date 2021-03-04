package co.sympu.pnrticketing.ui.cashier;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.SystemColor;

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
		
	
		setBounds(100, 100, 648, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setMinimumSize(new Dimension(10, 20000));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel jlblOriginalControlNumber = new JLabel("Control Number:");
			GridBagConstraints gbc_jlblOriginalControlNumber = new GridBagConstraints();
			gbc_jlblOriginalControlNumber.insets = new Insets(0, 0, 5, 5);
			gbc_jlblOriginalControlNumber.anchor = GridBagConstraints.EAST;
			gbc_jlblOriginalControlNumber.gridx = 1;
			gbc_jlblOriginalControlNumber.gridy = 1;
			contentPanel.add(jlblOriginalControlNumber, gbc_jlblOriginalControlNumber);
		}
		{
			jtxtfldOriginalControlNumber = new JTextField();
			jtxtfldOriginalControlNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jtxtfldOriginalControlNumber = new GridBagConstraints();
			gbc_jtxtfldOriginalControlNumber.insets = new Insets(0, 0, 5, 5);
			gbc_jtxtfldOriginalControlNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldOriginalControlNumber.gridx = 2;
			gbc_jtxtfldOriginalControlNumber.gridy = 1;
			contentPanel.add(jtxtfldOriginalControlNumber, gbc_jtxtfldOriginalControlNumber);
			jtxtfldOriginalControlNumber.setColumns(10);
		}
		{
			JLabel jlblBalance = new JLabel("Balance:");
			GridBagConstraints gbc_jlblBalance = new GridBagConstraints();
			gbc_jlblBalance.anchor = GridBagConstraints.EAST;
			gbc_jlblBalance.insets = new Insets(0, 0, 5, 5);
			gbc_jlblBalance.gridx = 1;
			gbc_jlblBalance.gridy = 3;
			contentPanel.add(jlblBalance, gbc_jlblBalance);
		}
		{
			jtxtfldBalance = new JTextField();
			jtxtfldBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jtxtfldBalance = new GridBagConstraints();
			gbc_jtxtfldBalance.insets = new Insets(0, 0, 5, 5);
			gbc_jtxtfldBalance.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldBalance.gridx = 2;
			gbc_jtxtfldBalance.gridy = 3;
			contentPanel.add(jtxtfldBalance, gbc_jtxtfldBalance);
			jtxtfldBalance.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Cash:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 4;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			jtxtfldCash = new JTextField();
			jtxtfldCash.setFont(new Font("Tahoma", Font.BOLD, 14));
			jtxtfldCash.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_jtxtfldCash = new GridBagConstraints();
			gbc_jtxtfldCash.insets = new Insets(0, 0, 5, 5);
			gbc_jtxtfldCash.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldCash.gridx = 2;
			gbc_jtxtfldCash.gridy = 4;
			contentPanel.add(jtxtfldCash, gbc_jtxtfldCash);
			jtxtfldCash.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Origin Control Number:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 6;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel jlblOriginControlNumber_Output = new JLabel("New label");
			GridBagConstraints gbc_jlblOriginControlNumber_Output = new GridBagConstraints();
			gbc_jlblOriginControlNumber_Output.insets = new Insets(0, 0, 5, 5);
			gbc_jlblOriginControlNumber_Output.gridx = 2;
			gbc_jlblOriginControlNumber_Output.gridy = 6;
			contentPanel.add(jlblOriginControlNumber_Output, gbc_jlblOriginControlNumber_Output);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Price:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 7;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel jlblNewPrice_Output = new JLabel("0.00");
			jlblNewPrice_Output.setForeground(SystemColor.windowText);
			jlblNewPrice_Output.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_jlblNewPrice_Output = new GridBagConstraints();
			gbc_jlblNewPrice_Output.insets = new Insets(0, 0, 5, 5);
			gbc_jlblNewPrice_Output.gridx = 2;
			gbc_jlblNewPrice_Output.gridy = 7;
			contentPanel.add(jlblNewPrice_Output, gbc_jlblNewPrice_Output);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Change: ");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 8;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel jlblChange_Output = new JLabel("0.00");
			jlblChange_Output.setForeground(SystemColor.textHighlight);
			jlblChange_Output.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_jlblChange_Output = new GridBagConstraints();
			gbc_jlblChange_Output.insets = new Insets(0, 0, 5, 5);
			gbc_jlblChange_Output.gridx = 2;
			gbc_jlblChange_Output.gridy = 8;
			contentPanel.add(jlblChange_Output, gbc_jlblChange_Output);
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
	
	public void confirmChanges() throws SQLException {
		
				// connection statements for the database to work 
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
				Statement statement = connection.createStatement();
				
				// statement that executes selecting all data inside tickets table 
				statement.executeQuery("SELECT * FROM ticket WHERE control_number = " + jtxtfldOriginalControlNumber.getText());
				
				// statement to update ticket error 
	}

}
