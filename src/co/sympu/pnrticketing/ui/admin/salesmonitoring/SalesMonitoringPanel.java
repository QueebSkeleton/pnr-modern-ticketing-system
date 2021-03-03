package co.sympu.pnrticketing.ui.admin.salesmonitoring;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

public class SalesMonitoringPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private DaySalesDialog daySalesDialog;
	
	protected PastWeekSalesTableModel pastWeekSalesTableModel;
	protected TicketTableModel ticketTableModel;
	
	private JTable jtblPastWeekSales;
	private JTable jtblTicketsSold;
	private JTextField jtxtfldSalesDay;
	
	public SalesMonitoringPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* jpnlHeader - header panel. Contains a header label and a button for adding stations */
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setAlignmentY(0.0f);
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setMaximumSize(new Dimension(32767, 50));
		jpnlHeader.setMinimumSize(new Dimension(10, 50));
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		/* END OF jpnlHeader */
		
		/* jlblHeader - main header label of the frame */
		JLabel jlblHeader = new JLabel("Monitor Ticket Sales");
		jlblHeader.setFont(new Font("Roboto", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);
		
		JPanel jpnlMainContent = new JPanel();
		jpnlMainContent.setAlignmentX(0.0f);
		jpnlMainContent.setAlignmentY(0.0f);
		jpnlMainContent.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(jpnlMainContent);
		jpnlMainContent.setLayout(new BoxLayout(jpnlMainContent, BoxLayout.Y_AXIS));
		
		JPanel jpnlSalesHeader = new JPanel();
		jpnlSalesHeader.setAlignmentX(0.0f);
		jpnlMainContent.add(jpnlSalesHeader);
		jpnlSalesHeader.setLayout(new BoxLayout(jpnlSalesHeader, BoxLayout.X_AXIS));
		
		JLabel jlblPastWeekSales = new JLabel("Sales from the Past Week");
		jpnlSalesHeader.add(jlblPastWeekSales);
		jlblPastWeekSales.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		JPanel jpnlViewPanel = new JPanel();
		jpnlViewPanel.setAlignmentX(0.0f);
		jpnlViewPanel.setPreferredSize(new Dimension(350, 30));
		jpnlViewPanel.setMaximumSize(new Dimension(32767, 50));
		jpnlSalesHeader.add(jpnlViewPanel);
		FlowLayout fl_jpnlViewPanel = (FlowLayout) jpnlViewPanel.getLayout();
		fl_jpnlViewPanel.setVgap(0);
		fl_jpnlViewPanel.setAlignment(FlowLayout.RIGHT);
		
		JLabel jlblViewSalesDay = new JLabel("View sales for specific day:");
		jlblViewSalesDay.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlViewPanel.add(jlblViewSalesDay);
		
		jtxtfldSalesDay = new JTextField();
		jtxtfldSalesDay.setMargin(new Insets(2, 2, 2, 2));
		jtxtfldSalesDay.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlViewPanel.add(jtxtfldSalesDay);
		jtxtfldSalesDay.setColumns(7);
		
		JButton jbtnView = new JButton("View");
		jbtnView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnView.setBackground(Color.WHITE);
		jbtnView.addActionListener(event -> {
			try {
				daySalesDialog.initialize(LocalDate.parse(jtxtfldSalesDay.getText()));
				daySalesDialog.setVisible(true);
			} catch(DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Please check your input. It must be of the format yyyy-MM-dd\n"
						+ "Example: 2021-01-01",
						"Check your inputs!",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		jbtnView.setFont(new Font("Roboto", Font.PLAIN, 12));
		jpnlViewPanel.add(jbtnView);
		
		jpnlMainContent.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JScrollPane jscrlpnPastWeekSalesTable = new JScrollPane();
		jscrlpnPastWeekSalesTable.setPreferredSize(new Dimension(3, 180));
		jscrlpnPastWeekSalesTable.setMinimumSize(new Dimension(22, 50));
		jscrlpnPastWeekSalesTable.setMaximumSize(new Dimension(32767, 180));
		jscrlpnPastWeekSalesTable.setAlignmentX(0.0f);
		jscrlpnPastWeekSalesTable.setAlignmentY(0.0f);
		jpnlMainContent.add(jscrlpnPastWeekSalesTable);
		
		jtblPastWeekSales = new JTable();
		jtblPastWeekSales.setRowHeight(22);
		jtblPastWeekSales.setIntercellSpacing(new Dimension(4, 4));
		
		pastWeekSalesTableModel = new PastWeekSalesTableModel();
		jtblPastWeekSales.setModel(pastWeekSalesTableModel);
		jscrlpnPastWeekSalesTable.setViewportView(jtblPastWeekSales);
		
		jpnlMainContent.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JLabel jlblTicketsSold = new JLabel("Tickets Sold");
		jlblTicketsSold.setAlignmentY(0.0f);
		jlblTicketsSold.setFont(new Font("Roboto", Font.PLAIN, 16));
		jpnlMainContent.add(jlblTicketsSold);
		
		jpnlMainContent.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JScrollPane jscrlpnTicketsSoldTable = new JScrollPane();
		jscrlpnTicketsSoldTable.setAlignmentX(0.0f);
		jscrlpnTicketsSoldTable.setAlignmentY(0.0f);
		jpnlMainContent.add(jscrlpnTicketsSoldTable);
		
		jtblTicketsSold = new JTable();
		jtblTicketsSold.setRowHeight(22);
		jtblTicketsSold.setIntercellSpacing(new Dimension(4, 4));
		ticketTableModel = new TicketTableModel();
		jtblTicketsSold.setModel(ticketTableModel);
		jscrlpnTicketsSoldTable.setViewportView(jtblTicketsSold);
		
		daySalesDialog = new DaySalesDialog();
	}
	
	public void refresh() {
		pastWeekSalesTableModel.refresh();
		ticketTableModel.refresh();
	}

}
