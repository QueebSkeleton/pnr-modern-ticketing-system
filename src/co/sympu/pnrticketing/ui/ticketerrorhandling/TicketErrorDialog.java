package co.sympu.pnrticketing.ui.ticketerrorhandling;

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

public class TicketErrorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldOriginalControlNumber;
	private JTextField jtxtfldBalance;
	private JTextField textField;


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
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 4;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel jlblChange = new JLabel("Change: ");
			jlblChange.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jlblChange = new GridBagConstraints();
			gbc_jlblChange.insets = new Insets(0, 0, 0, 5);
			gbc_jlblChange.gridx = 1;
			gbc_jlblChange.gridy = 6;
			contentPanel.add(jlblChange, gbc_jlblChange);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("00.00");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 6;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = 	new JButton("CONFIRM");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
