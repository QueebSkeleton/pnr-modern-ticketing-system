package co.sympu.pnrticketing.ui.ticketerrorhandling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConfirmationMessage extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ConfirmationMessage() {
		setTitle("Ready to Print?");
		setBounds(100, 100, 339, 297);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Summary of Billing");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(15, 11, 114, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel jlblSoBControlNumber = new JLabel("Control Number: ");
			jlblSoBControlNumber.setBounds(15, 46, 91, 14);
			contentPanel.add(jlblSoBControlNumber);
		}
		{
			JLabel jlblSoBBalance = new JLabel("Balance:");
			jlblSoBBalance.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBBalance.setBounds(15, 67, 80, 14);
			contentPanel.add(jlblSoBBalance);
		}
		{
			JLabel jlblSoBTotal = new JLabel("TOTAL");
			jlblSoBTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			jlblSoBTotal.setBounds(15, 92, 69, 14);
			contentPanel.add(jlblSoBTotal);
		}
		{
			JLabel jlblSoBCash = new JLabel("Cash:\r\n");
			jlblSoBCash.setBounds(15, 117, 46, 14);
			contentPanel.add(jlblSoBCash);
		}
		{
			JLabel jlblSoBBalanceOutput = new JLabel("20.00");
			jlblSoBBalanceOutput.setVerticalAlignment(SwingConstants.BOTTOM);
			jlblSoBBalanceOutput.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBBalanceOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBBalanceOutput.setBounds(178, 57, 113, 26);
			contentPanel.add(jlblSoBBalanceOutput);
		}
		{
			JLabel jlblSoBTotalOutput = new JLabel("20.00");
			jlblSoBTotalOutput.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBTotalOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBTotalOutput.setBounds(178, 92, 113, 14);
			contentPanel.add(jlblSoBTotalOutput);
		}
		{
			JLabel jlblSoBPesoSign = new JLabel("\u20B1");
			jlblSoBPesoSign.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBPesoSign.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBPesoSign.setBounds(132, 84, 28, 26);
			contentPanel.add(jlblSoBPesoSign);
		}
		{
			JLabel jlblSoBChange = new JLabel("CHANGE");
			jlblSoBChange.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBChange.setBounds(15, 149, 69, 14);
			contentPanel.add(jlblSoBChange);
		}
		{
			JLabel jlblSoBPesoSign_1 = new JLabel("\u20B1");
			jlblSoBPesoSign_1.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBPesoSign_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBPesoSign_1.setBounds(132, 141, 28, 26);
			contentPanel.add(jlblSoBPesoSign_1);
		}
		{
			JLabel jlblSoBChangeOutput = new JLabel("30.00");
			jlblSoBChangeOutput.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBChangeOutput.setForeground(Color.BLUE);
			jlblSoBChangeOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
			jlblSoBChangeOutput.setBounds(178, 149, 113, 14);
			contentPanel.add(jlblSoBChangeOutput);
		}
		{
			JLabel jlblSoBCashOutput = new JLabel("50.00");
			jlblSoBCashOutput.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBCashOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBCashOutput.setBounds(170, 119, 121, 14);
			contentPanel.add(jlblSoBCashOutput);
		}
		{
			JLabel jlblSoBControlNumberOutput = new JLabel("123456789076542");
			jlblSoBControlNumberOutput.setVerticalAlignment(SwingConstants.BOTTOM);
			jlblSoBControlNumberOutput.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBControlNumberOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBControlNumberOutput.setBounds(149, 36, 142, 26);
			contentPanel.add(jlblSoBControlNumberOutput);
		}
		{
			JLabel jlblSoBPesoSign = new JLabel("\u20B1");
			jlblSoBPesoSign.setHorizontalAlignment(SwingConstants.TRAILING);
			jlblSoBPesoSign.setFont(new Font("Tahoma", Font.BOLD, 14));
			jlblSoBPesoSign.setBounds(132, 59, 28, 26);
			contentPanel.add(jlblSoBPesoSign);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("________________________________________________");
			lblNewLabel_4.setBounds(15, 71, 298, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblPleaseDoubleCheck = new JLabel("Please double check before printing");
			lblPleaseDoubleCheck.setHorizontalAlignment(SwingConstants.CENTER);
			lblPleaseDoubleCheck.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPleaseDoubleCheck.setFont(new Font("Tahoma", Font.ITALIC, 11));
			lblPleaseDoubleCheck.setBounds(48, 200, 223, 14);
			contentPanel.add(lblPleaseDoubleCheck);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("CONFIRM");
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
