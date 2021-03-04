package co.sympu.pnrticketing.ui.cashier;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TicketCashierPrompt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JTextField jtxtfldNoOfTickets;
	private JTextField jtxtfldCash;
	
	// reference for the ticket error handling prompt
	protected TicketErrorDialog ticketErrorDialog; 
	
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
	private float fltVHPrice;
	private String strVHDestination;  
	private int intVHStationID; 
	
	private float fltAmount;
	private float fltChange;
	
	
	

	/**
	 * Create the frame.
	 */
	public TicketCashierPrompt() {
		
		// for ticket error prompt reference later 
		ticketErrorDialog = new TicketErrorDialog();
		
		setTitle("Cashier Module");
		setBounds(100, 100, 888, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		
		JPanel jpnlPayment = new JPanel();
		contentPane.add(jpnlPayment);
		jpnlPayment.setLayout(new BoxLayout(jpnlPayment, BoxLayout.X_AXIS));
		
		JPanel jpnlBilling = new JPanel();
		jpnlBilling.setBackground(SystemColor.menu);
		jpnlBilling.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, null));
		jpnlPayment.add(jpnlBilling);
		jpnlBilling.setLayout(null);
		
		
		/* START of Summary Billing GUI*/
		
		jcmbStations = new JComboBox();
		jcmbStations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jcmbStations.setBackground(SystemColor.menu);
		jcmbStations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcmbStations.setBounds(158, 177, 279, 33);
		jpnlBilling.add(jcmbStations);
		
		JLabel jlblStations = new JLabel("Stations:");
		jlblStations.setFont(new Font("Roboto", Font.PLAIN, 18));
		jlblStations.setBounds(69, 179, 79, 33);
		jpnlBilling.add(jlblStations);
		
		JLabel jlblNoOfTickets = new JLabel("No. Of Tickets:");
		jlblNoOfTickets.setFont(new Font("Roboto", Font.PLAIN, 18));
		jlblNoOfTickets.setBounds(27, 223, 123, 33);
		jpnlBilling.add(jlblNoOfTickets);
		
		jtxtfldNoOfTickets = new JTextField();
		jtxtfldNoOfTickets.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtxtfldNoOfTickets.setBounds(158, 221, 279, 35);
		jpnlBilling.add(jtxtfldNoOfTickets);
		jtxtfldNoOfTickets.setHorizontalAlignment(SwingConstants.CENTER);
		jtxtfldNoOfTickets.setToolTipText("");
		jtxtfldNoOfTickets.setColumns(10);
		
		JLabel jlblCash = new JLabel("Cash:");
		jlblCash.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlblCash.setBounds(37, 299, 108, 33);
		jpnlBilling.add(jlblCash);
		jlblCash.setHorizontalAlignment(SwingConstants.TRAILING);
		
		jtxtfldCash = new JTextField();
		jtxtfldCash.setHorizontalAlignment(SwingConstants.CENTER);
		jtxtfldCash.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtxtfldCash.setBounds(158, 297, 279, 42);
		jpnlBilling.add(jtxtfldCash);
		jtxtfldCash.setColumns(10);
		
		JPanel jpnlSummaryOfBilling = new JPanel();
		jpnlSummaryOfBilling.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		jpnlSummaryOfBilling.setBackground(Color.WHITE);
		jpnlSummaryOfBilling.setBounds(459, 107, 380, 305);
		jpnlBilling.add(jpnlSummaryOfBilling);
		jpnlSummaryOfBilling.setLayout(null);
		JLabel jlblSummary = new JLabel("Summary of Billing");
		jlblSummary.setBounds(28, 21, 324, 42);
		jpnlSummaryOfBilling.add(jlblSummary);
		jlblSummary.setFont(new Font("Roboto Black", Font.BOLD, 35));
		
		JLabel jlblSoBDestination = new JLabel("Destination: ");
		jlblSoBDestination.setBounds(28, 96, 130, 14);
		jpnlSummaryOfBilling.add(jlblSoBDestination);
		jlblSoBDestination.setFont(new Font("Roboto Light", Font.BOLD, 18));
		
		JLabel jlblSoBNoOfTickets = new JLabel("No. of Tickets:");
		jlblSoBNoOfTickets.setBounds(28, 121, 128, 14);
		jpnlSummaryOfBilling.add(jlblSoBNoOfTickets);
		jlblSoBNoOfTickets.setFont(new Font("Roboto Light", Font.BOLD, 18));
		
		JLabel jlblSoBTotal = new JLabel("TOTAL");
		jlblSoBTotal.setBounds(28, 153, 69, 14);
		jpnlSummaryOfBilling.add(jlblSoBTotal);
		jlblSoBTotal.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("_______________________________________________________");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(28, 123, 331, 22);
		jpnlSummaryOfBilling.add(lblNewLabel_4);
		
		JLabel jlblSoBCash = new JLabel("Cash:\r\n");
		jlblSoBCash.setBounds(28, 178, 46, 14);
		jpnlSummaryOfBilling.add(jlblSoBCash);
		jlblSoBCash.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		jlblSoBDestinationOutput = new JLabel("Pacita Main Gate");
		jlblSoBDestinationOutput.setBounds(139, 88, 213, 26);
		jpnlSummaryOfBilling.add(jlblSoBDestinationOutput);
		jlblSoBDestinationOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBDestinationOutput.setFont(new Font("Roboto Black", Font.BOLD, 18));
		jlblSoBDestinationOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		
		jlblSoBNoOfTicketsOutput = new JLabel("1");
		jlblSoBNoOfTicketsOutput.setBounds(239, 113, 113, 26);
		jpnlSummaryOfBilling.add(jlblSoBNoOfTicketsOutput);
		jlblSoBNoOfTicketsOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBNoOfTicketsOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBNoOfTicketsOutput.setFont(new Font("Roboto Black", Font.BOLD, 18));
		
		jlblSoBTotalOutput = new JLabel("20.00");
		jlblSoBTotalOutput.setBounds(239, 152, 113, 14);
		jpnlSummaryOfBilling.add(jlblSoBTotalOutput);
		jlblSoBTotalOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBTotalOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jlblSoBPesoSign = new JLabel("\u20B1");
		jlblSoBPesoSign.setBounds(147, 146, 28, 26);
		jpnlSummaryOfBilling.add(jlblSoBPesoSign);
		jlblSoBPesoSign.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jlblSoBChange = new JLabel("CHANGE");
		jlblSoBChange.setBounds(28, 221, 95, 14);
		jpnlSummaryOfBilling.add(jlblSoBChange);
		jlblSoBChange.setFont(new Font("Roboto", Font.BOLD, 18));
		
		jlblSoBChangeOutput = new JLabel("30.00");
		jlblSoBChangeOutput.setBounds(239, 220, 113, 14);
		jpnlSummaryOfBilling.add(jlblSoBChangeOutput);
		jlblSoBChangeOutput.setForeground(Color.BLUE);
		jlblSoBChangeOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBChangeOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		jlblSoBCashOutput = new JLabel("50.00");
		jlblSoBCashOutput.setBounds(231, 173, 121, 22);
		jpnlSummaryOfBilling.add(jlblSoBCashOutput);
		jlblSoBCashOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBCashOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblPleaseDoubleCheck = new JLabel("Please double check before printing");
		lblPleaseDoubleCheck.setBounds(10, 272, 301, 22);
		jpnlSummaryOfBilling.add(lblPleaseDoubleCheck);
		lblPleaseDoubleCheck.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPleaseDoubleCheck.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JLabel jlblSoBPesoSign_1 = new JLabel("\u20B1");
		jlblSoBPesoSign_1.setBounds(147, 171, 28, 26);
		jpnlSummaryOfBilling.add(jlblSoBPesoSign_1);
		jlblSoBPesoSign_1.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("PHILIPPINE NATIONAL RAILWAYS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 11, 594, 42);
		jpnlBilling.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Serving the Nation and the Filipino People since 1892");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(191, 46, 510, 22);
		jpnlBilling.add(lblNewLabel_1);
		
		/*END of Summary of Billing GUI*/
		
		// Buttons Panel for Ticket Error Handling, Update Billing, and Print Ticket
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBackground(new Color(240,240,240));
		jpnlButtons.setMinimumSize(new Dimension(10, 1000));
		jpnlButtons.setMaximumSize(new Dimension(32767, 4000));
		contentPane.add(jpnlButtons);
		jpnlButtons.setLayout(null);
		
		JButton jbtnTicketError = new JButton("TICKET ERROR");
		jbtnTicketError.setFont(new Font("Roboto", Font.BOLD, 18));
		jbtnTicketError.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnTicketError.setBounds(25, 6, 162, 37);
		jbtnTicketError.addActionListener (event -> {
			ticketErrorDialog.setVisible(true);
		});
		jpnlButtons.add(jbtnTicketError);
		
		JButton jbtnUpdateTicket = new JButton("UPDATE BILL");
		jbtnUpdateTicket.setFont(new Font("Roboto", Font.BOLD, 18));
		jbtnUpdateTicket.addActionListener(new ActionListener() {
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
		jbtnUpdateTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnUpdateTicket.setBounds(349, 7, 162, 35);
		jpnlButtons.add(jbtnUpdateTicket);
		
		JButton jbtnPrintTicket = new JButton("PRINT TICKET");
		jbtnPrintTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPrintTicket.setFont(new Font("Roboto", Font.BOLD, 18));
		jbtnPrintTicket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						printTicket();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		jbtnPrintTicket.setBounds(673, 8, 162, 35);
		jpnlButtons.add(jbtnPrintTicket);
		
		
	
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
		fltVHPrice = resultSetPricing.getFloat("price");
		
		// Calculations for the Payable amount 
		fltAmount = fltVHPrice * (Integer.parseInt(jtxtfldNoOfTickets.getText())); 
		
		// Calculation for passenger's change
		fltChange = (Float.parseFloat(jtxtfldCash.getText())) - fltAmount; 
		
		resultSetPricing.close();
		statement.close(); 
		connection.close();
		
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
	
	// This method will submit the ticket order to the pnr_db under ticket table 
	public void printTicket() throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
		Statement insertStatement = connection.createStatement();
		
		String insertSqlStatement = "INSERT INTO ticket VALUES";
		// using a loop, get all inputs, concatenate to this insertSqlStatement in this format:
		// INSERT INTO ticket VALUES (NULL, 65, 66, NOW(), 20), (NULL, 65, 66, NOW(), 20), (NULL, 64, 65, NOW(), 10)
		
		
		// Terminator of the loop
		int intTerminator = Integer.parseInt(jlblSoBNoOfTicketsOutput.getText());
		
	
		
		do {
			
			insertSqlStatement += "(NULL," + assignedStationID + ", " + intVHStationID + ", NOW(), " + fltVHPrice + ")";
			
			if (intTerminator == 1)
				break; 
			else 
				insertSqlStatement += ",";
			
			intTerminator--;
			
		} while (intTerminator != 0); 
		
		insertStatement.execute(insertSqlStatement);
		
		insertStatement.close();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Ticket order done!\nNow Printing...");
		
	}
	
	
}