package co.sympu.pnrticketing.ui.ticketmachine;


import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class LoginDialog extends JDialog {

	private JTextField txtmachineid;
	private JTextField txtpassword ;
	
	public LoginDialog() {
		setTitle("Machine Login ");
		setResizable(false);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{10.0, 10.0, 11.0, 11.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, Double.MIN_VALUE};
		
		getContentPane().setLayout(gridBagLayout);
		setBounds(500, 250, 333, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblmachineid = new JLabel("Enter machine ID:");
		GridBagConstraints gbc_lblmachineid = new GridBagConstraints();
		gbc_lblmachineid.anchor = GridBagConstraints.EAST;
		gbc_lblmachineid.insets = new Insets(0, 0, 5, 5);
		gbc_lblmachineid.gridx = 1;
		gbc_lblmachineid.gridy = 2;
		getContentPane().add(lblmachineid, gbc_lblmachineid);
		
		txtmachineid = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		getContentPane().add(txtmachineid, gbc_textField);
		txtmachineid.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password:");
		GridBagConstraints gbc_lblpassword = new GridBagConstraints();
		gbc_lblpassword.anchor = GridBagConstraints.EAST;
		gbc_lblpassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblpassword.gridx = 1;
		gbc_lblpassword.gridy = 4;
		getContentPane().add(lblpassword, gbc_lblpassword);
		
		txtpassword = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		getContentPane().add(txtpassword, gbc_textField_1);
		txtpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
	
		
	}
	

	

	
}




