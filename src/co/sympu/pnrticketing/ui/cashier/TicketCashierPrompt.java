package co.sympu.pnrticketing.ui.cashier;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class TicketCashierPrompt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JTextField jtxtfldNoOfTickets;
	private JTextField jtxtfldCash;
	
	// output variables for Summary of Billing
	private JLabel jlblSoBDestinationOutput;
	private JLabel jlblSoBNoOfTicketsOutput;
	private JLabel jlblSoBTotalOutput;
	private JLabel jlblSoBCashOutput;
	private JLabel jlblSoBChangeOutput;
	
	
	private JComboBox jcmbStations;
	
	// reference for LoginFrame
	protected LoginFrame loginFrame; 

	// reference for cashier's credentials 
	protected int cashierID; 
	protected String cashierName;
	protected int assignedStationID;

	// Self referencing 
	TicketCashierPrompt ticketCashierPrompt = this;
	
	// value holders for calculatePrice method
	private String strVHDestination;  
	private int intVHStationID; 
	
	private float fltAmount;
	private float fltChange;
	
	
	

	/**
	 * Create the frame.
	 */
	public TicketCashierPrompt() {
		setResizable(false);
		setTitle("Cashier Module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel jpnlDestinationHeader = new JPanel();
		jpnlDestinationHeader.setMaximumSize(new Dimension(32767, 22000));
		contentPane.add(jpnlDestinationHeader);
		jpnlDestinationHeader.setLayout(null);
		
		JLabel jlblDestinationHeader = new JLabel("Philippine National Railways ");
		jlblDestinationHeader.setFont(new Font("Times New Roman", Font.BOLD, 26));
		jlblDestinationHeader.setBounds(151, 11, 338, 25);
		jpnlDestinationHeader.add(jlblDestinationHeader);
		
		
		JPanel jpnlPayment = new JPanel();
		contentPane.add(jpnlPayment);
		jpnlPayment.setLayout(new BoxLayout(jpnlPayment, BoxLayout.X_AXIS));
		
		JPanel jpnlTicketAndPayment = new JPanel();
		jpnlTicketAndPayment.setBorder(new EmptyBorder(0, 10, 0, 0));
		jpnlTicketAndPayment.setMaximumSize(new Dimension(3000, 1000));
		jpnlPayment.add(jpnlTicketAndPayment);
		GridBagLayout gbl_jpnlTicketAndPayment = new GridBagLayout();
		gbl_jpnlTicketAndPayment.columnWidths = new int[]{0, 109, 68, 0};
		gbl_jpnlTicketAndPayment.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlTicketAndPayment.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlTicketAndPayment.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlTicketAndPayment.setLayout(gbl_jpnlTicketAndPayment);
		
		JLabel jlblStations = new JLabel("Stations:");
		GridBagConstraints gbc_jlblStations = new GridBagConstraints();
		gbc_jlblStations.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStations.anchor = GridBagConstraints.EAST;
		gbc_jlblStations.gridx = 0;
		gbc_jlblStations.gridy = 1;
		jpnlTicketAndPayment.add(jlblStations, gbc_jlblStations);
		
		jcmbStations = new JComboBox();
		GridBagConstraints gbc_jcmbStations = new GridBagConstraints();
		gbc_jcmbStations.insets = new Insets(0, 0, 5, 5);
		gbc_jcmbStations.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbStations.gridx = 1;
		gbc_jcmbStations.gridy = 1;
		jpnlTicketAndPayment.add(jcmbStations, gbc_jcmbStations);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		jpnlTicketAndPayment.add(verticalStrut, gbc_verticalStrut);
		
		JLabel jlblNoOfTickets = new JLabel("No. Of Tickets:");
		GridBagConstraints gbc_jlblNoOfTickets = new GridBagConstraints();
		gbc_jlblNoOfTickets.anchor = GridBagConstraints.EAST;
		gbc_jlblNoOfTickets.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNoOfTickets.gridx = 0;
		gbc_jlblNoOfTickets.gridy = 3;
		jpnlTicketAndPayment.add(jlblNoOfTickets, gbc_jlblNoOfTickets);
		
		jtxtfldNoOfTickets = new JTextField();
		jtxtfldNoOfTickets.setHorizontalAlignment(SwingConstants.CENTER);
		jtxtfldNoOfTickets.setText("1");
		jtxtfldNoOfTickets.setToolTipText("");
		GridBagConstraints gbc_jtxtfldNoOfTickets = new GridBagConstraints();
		gbc_jtxtfldNoOfTickets.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldNoOfTickets.gridx = 1;
		gbc_jtxtfldNoOfTickets.gridy = 3;
		jpnlTicketAndPayment.add(jtxtfldNoOfTickets, gbc_jtxtfldNoOfTickets);
		jtxtfldNoOfTickets.setColumns(10);
		
		JLabel jlblCash = new JLabel("Cash:");
		jlblCash.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_jlblCash = new GridBagConstraints();
		gbc_jlblCash.anchor = GridBagConstraints.EAST;
		gbc_jlblCash.insets = new Insets(0, 0, 0, 5);
		gbc_jlblCash.gridx = 0;
		gbc_jlblCash.gridy = 5;
		jpnlTicketAndPayment.add(jlblCash, gbc_jlblCash);
		
		jtxtfldCash = new JTextField();
		GridBagConstraints gbc_jtxtfldCash = new GridBagConstraints();
		gbc_jtxtfldCash.insets = new Insets(0, 0, 0, 5);
		gbc_jtxtfldCash.gridx = 1;
		gbc_jtxtfldCash.gridy = 5;
		jpnlTicketAndPayment.add(jtxtfldCash, gbc_jtxtfldCash);
		jtxtfldCash.setColumns(10);
		
		JPanel jpnlBilling = new JPanel();
		jpnlBilling.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, null));
		jpnlPayment.add(jpnlBilling);
		jpnlBilling.setLayout(null);
		
		
		/* START of Summary Billing GUI*/
		JLabel jlblSummary = new JLabel("Summary of Billing");
		jlblSummary.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlblSummary.setBounds(20, 11, 121, 14);
		jpnlBilling.add(jlblSummary);
		
		JLabel jlblSoBDestination = new JLabel("Destination: ");
		jlblSoBDestination.setBounds(20, 47, 80, 14);
		jpnlBilling.add(jlblSoBDestination);
		
		JLabel jlblSoBNoOfTickets = new JLabel("No. of Tickets:");
		jlblSoBNoOfTickets.setBounds(20, 68, 80, 14);
		jpnlBilling.add(jlblSoBNoOfTickets);
		
		JLabel jlblSoBTotal = new JLabel("TOTAL");
		jlblSoBTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlblSoBTotal.setBounds(20, 93, 69, 14);
		jpnlBilling.add(jlblSoBTotal);
		
		JLabel lblNewLabel_4 = new JLabel("________________________________________________");
		lblNewLabel_4.setBounds(20, 72, 298, 14);
		jpnlBilling.add(lblNewLabel_4);
		
		JLabel jlblSoBCash = new JLabel("Cash:\r\n");
		jlblSoBCash.setBounds(20, 118, 46, 14);
		jpnlBilling.add(jlblSoBCash);
		
		jlblSoBDestinationOutput = new JLabel("Pacita Main Gate");
		jlblSoBDestinationOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBDestinationOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBDestinationOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBDestinationOutput.setBounds(183, 37, 113, 26);
		jpnlBilling.add(jlblSoBDestinationOutput);
		
		jlblSoBNoOfTicketsOutput = new JLabel("1");
		jlblSoBNoOfTicketsOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBNoOfTicketsOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBNoOfTicketsOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBNoOfTicketsOutput.setBounds(183, 58, 113, 26);
		jpnlBilling.add(jlblSoBNoOfTicketsOutput);
		
		jlblSoBTotalOutput = new JLabel("20.00");
		jlblSoBTotalOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBTotalOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBTotalOutput.setBounds(183, 93, 113, 14);
		jpnlBilling.add(jlblSoBTotalOutput);
		
		JLabel jlblSoBPesoSign = new JLabel("\u20B1");
		jlblSoBPesoSign.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBPesoSign.setBounds(137, 85, 28, 26);
		jpnlBilling.add(jlblSoBPesoSign);
		
		JLabel jlblSoBChange = new JLabel("CHANGE");
		jlblSoBChange.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBChange.setBounds(20, 150, 69, 14);
		jpnlBilling.add(jlblSoBChange);
		
		JLabel jlblSoBPesoSign_1 = new JLabel("\u20B1");
		jlblSoBPesoSign_1.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBPesoSign_1.setBounds(137, 142, 28, 26);
		jpnlBilling.add(jlblSoBPesoSign_1);
		
		jlblSoBChangeOutput = new JLabel("30.00");
		jlblSoBChangeOutput.setForeground(Color.BLUE);
		jlblSoBChangeOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBChangeOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlblSoBChangeOutput.setBounds(183, 150, 113, 14);
		jpnlBilling.add(jlblSoBChangeOutput);
		
		jlblSoBCashOutput = new JLabel("50.00");
		jlblSoBCashOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBCashOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBCashOutput.setBounds(175, 116, 121, 14);
		jpnlBilling.add(jlblSoBCashOutput);
		
		JLabel lblPleaseDoubleCheck = new JLabel("Please double check before printing");
		lblPleaseDoubleCheck.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPleaseDoubleCheck.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPleaseDoubleCheck.setBounds(10, 189, 223, 14);
		jpnlBilling.add(lblPleaseDoubleCheck);
		
		/*END of Summary of Billing GUI*/
		
		// Buttons Panel for Ticket Error Handling, Update Billing, and Print Ticket
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setMinimumSize(new Dimension(10, 1000));
		jpnlButtons.setMaximumSize(new Dimension(32767, 10000));
		contentPane.add(jpnlButtons);
		jpnlButtons.setLayout(null);
		
		JButton jbtnTicketError = new JButton("TICKET ERROR");
		jbtnTicketError.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		jbtnTicketError.setBounds(10, 11, 119, 23);
		jpnlButtons.add(jbtnTicketError);
		
		JButton jbtnPrintTicket = new JButton("UPDATE BILLING");
		jbtnPrintTicket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						calculatePrice();
						updateBilling();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		jbtnPrintTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPrintTicket.setBounds(509, 11, 119, 23);
		jpnlButtons.add(jbtnPrintTicket);
		
		JButton btnNewButton = new JButton("PRINT TICKET");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(266, 11, 119, 23);
		jpnlButtons.add(btnNewButton);
		
		
	
	}
	
	//method to initialize the UI component of cashier account right after login
	// will create station options based on its credentials 
	public void initializeUI() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM station WHERE id != " + assignedStationID);
			
			while (resultSet.next()) {
				jcmbStations.addItem(resultSet.getString("id") + " " + resultSet.getString("name"));
			}
			
			revalidate(); 
			resultSet.close();
			statement.close();
			connection.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	// Method to calculate the price based from user's input 
	public void calculatePrice() throws SQLException {
		strVHDestination = (String) jcmbStations.getItemAt(jcmbStations.getSelectedIndex());
		
		//temporary value holder for the split strVHStation
		String tempStringHolder = strVHDestination.split(" ")[0];
		intVHStationID = Integer.parseInt(tempStringHolder); 
				
	
		// Retrieving price from the station_pricing table 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
		Statement statement = connection.createStatement();
		
		
		ResultSet resultSetPricing = statement.executeQuery("SELECT * FROM station_pricing WHERE from_id =" + assignedStationID + " AND to_id =" + intVHStationID);
		
		// Value Holder for the price from station_pricing
		resultSetPricing.next();
		float fltVHPrice = resultSetPricing.getFloat("price");
		
		// Calculations for the Payable amount 
		fltAmount = fltVHPrice * (Integer.parseInt(jtxtfldNoOfTickets.getText())); 
		
		// Calculation for passenger's change
		fltChange = (Float.parseFloat(jtxtfldCash.getText())) - fltAmount; 
		
	}
	
	/*This method updates the following variables: 
	 * private JLabel jlblSoBDestinationOutput;
	 * private JLabel jlblSoBNoOfTicketsOutput;
	 * private JLabel jlblSoBTotalOutput;
	 * private JLabel jlblSoBCashOutput;
	 * private JLabel jlblSoBChangeOutput;*/
	public void updateBilling() { 
		
		jlblSoBDestinationOutput.setText(strVHDestination);
		jlblSoBNoOfTicketsOutput.setText(jtxtfldNoOfTickets.getText());
		jlblSoBTotalOutput.setText("" + fltAmount);
		jlblSoBCashOutput.setText(jtxtfldCash.getText());
		jlblSoBChangeOutput.setText("" + fltChange);
	
	}
}