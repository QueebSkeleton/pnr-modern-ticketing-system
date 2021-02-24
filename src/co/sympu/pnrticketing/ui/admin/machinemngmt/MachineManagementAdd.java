package co.sympu.pnrticketing.ui.admin.machinemngmt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MachineManagementAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
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
		setTitle("Add Machine");
		setBounds(100, 100, 450, 263);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{80, 109, 147, 0};
		gbl_contentPanel.rowHeights = new int[]{27, 19, 19, 19, 19, 19, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Serial Number");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(20);
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
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPanel.add(comboBox, gbc_comboBox);
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
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 3;
		contentPanel.add(comboBox_1, gbc_comboBox_1);
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		textField_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		contentPanel.add(textField_1, gbc_textField_1);
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(20);
		textField_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		contentPanel.add(textField_2, gbc_textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
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
