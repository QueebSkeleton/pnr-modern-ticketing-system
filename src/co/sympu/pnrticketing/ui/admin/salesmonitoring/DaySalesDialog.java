package co.sympu.pnrticketing.ui.admin.salesmonitoring;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class DaySalesDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel jpnlMainContentPanel;
	
	private JTable jtblTicketsSold;
	private DayTicketSalesTableModel dayTicketSalesTableModel;
	
	private JLabel jlblDateShown;
	private JLabel jlblTotalSales;

	/**
	 * Create the dialog.
	 */
	public DaySalesDialog() {
		setTitle("Sales for this Day");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		jpnlMainContentPanel = new JPanel();
		jpnlMainContentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(jpnlMainContentPanel, BorderLayout.CENTER);
		jpnlMainContentPanel.setLayout(new BoxLayout(jpnlMainContentPanel, BoxLayout.Y_AXIS));
		
		jlblDateShown = new JLabel("Selected Date:");
		jlblDateShown.setAlignmentY(0.0f);
		jlblDateShown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlMainContentPanel.add(jlblDateShown);
		
		jpnlMainContentPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		
		jlblTotalSales = new JLabel("Total Sales:");
		jlblTotalSales.setAlignmentY(0.0f);
		jlblTotalSales.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlMainContentPanel.add(jlblTotalSales);
		
		jpnlMainContentPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		
		JScrollPane jscrlpnTicketSales = new JScrollPane();
		jscrlpnTicketSales.setAlignmentY(0.0f);
		jscrlpnTicketSales.setAlignmentX(0.0f);
		jpnlMainContentPanel.add(jscrlpnTicketSales);
		
		jtblTicketsSold = new JTable();
		dayTicketSalesTableModel = new DayTicketSalesTableModel();
		jtblTicketsSold.setModel(dayTicketSalesTableModel);
		jscrlpnTicketSales.setViewportView(jtblTicketsSold);

		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtonActions, BorderLayout.SOUTH);

		JButton jbtnExit = new JButton("Exit");
		jbtnExit.addActionListener(event -> {
			setVisible(false);
		});
		jbtnExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnExit.setActionCommand("X");
		jpnlButtonActions.add(jbtnExit);
		getRootPane().setDefaultButton(jbtnExit);

	}
	
	public void initialize(LocalDate salesDate) {
		
		jlblDateShown.setText("Selected Date: " + salesDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy - EEEE")));
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			Statement retrieveAllStatement = connection.createStatement()) {
			
			try(ResultSet ticketSalesThisDayResultSet = retrieveAllStatement.executeQuery("SELECT COUNT(ticket.control_number) AS 'ticket_count', SUM(ticket.price) AS 'total' "
					+ "FROM ticket WHERE DATE(ticket.processed_on) = DATE(NOW()) "
					+ "GROUP BY DATE(ticket.processed_on)")) {
				
				if(ticketSalesThisDayResultSet.next())
					jlblTotalSales.setText("Total Sales: " + ticketSalesThisDayResultSet.getInt("ticket_count")
							+ "tickets, Php" + ticketSalesThisDayResultSet.getDouble("total"));
					
				else
					jlblTotalSales.setText("Total Sales: no tickets, Php0.00");
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "An error occured while fetching sales data. Try again.\n\nMessage: " + e);
		}
		
		dayTicketSalesTableModel.refresh(salesDate);
	}

}
