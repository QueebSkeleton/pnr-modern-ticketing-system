package co.sympu.pnrticketing.ui.admin.salesmonitoring;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SalesMonitoringPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
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
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlHeader.add(panel);
		
		JLabel jlblViewSalesDay = new JLabel("View sales for specific day:");
		jlblViewSalesDay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(jlblViewSalesDay);
		
		jtxtfldSalesDay = new JTextField();
		jtxtfldSalesDay.setMargin(new Insets(2, 2, 2, 2));
		jtxtfldSalesDay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(jtxtfldSalesDay);
		jtxtfldSalesDay.setColumns(7);
		
		JButton jbtnView = new JButton("View");
		jbtnView.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panel.add(jbtnView);
		
		JPanel jpnlMainContent = new JPanel();
		jpnlMainContent.setAlignmentX(0.0f);
		jpnlMainContent.setAlignmentY(0.0f);
		jpnlMainContent.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(jpnlMainContent);
		GridBagLayout gbl_jpnlMainContent = new GridBagLayout();
		gbl_jpnlMainContent.columnWidths = new int[]{251, 0};
		gbl_jpnlMainContent.rowWeights = new double[]{0.0, 1.0};
		gbl_jpnlMainContent.columnWeights = new double[]{0.0, 1.0};
		jpnlMainContent.setLayout(gbl_jpnlMainContent);
		
		JLabel jlblPastWeekSales = new JLabel("Sales from the Past Week");
		jlblPastWeekSales.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblPastWeekSales = new GridBagConstraints();
		gbc_jlblPastWeekSales.anchor = GridBagConstraints.WEST;
		gbc_jlblPastWeekSales.insets = new Insets(0, 0, 5, 20);
		gbc_jlblPastWeekSales.gridx = 0;
		gbc_jlblPastWeekSales.gridy = 0;
		jpnlMainContent.add(jlblPastWeekSales, gbc_jlblPastWeekSales);
		
		JLabel jlblTicketsSold = new JLabel("Tickets Sold");
		jlblTicketsSold.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTicketsSold = new GridBagConstraints();
		gbc_jlblTicketsSold.anchor = GridBagConstraints.WEST;
		gbc_jlblTicketsSold.insets = new Insets(0, 0, 5, 0);
		gbc_jlblTicketsSold.gridx = 1;
		gbc_jlblTicketsSold.gridy = 0;
		jpnlMainContent.add(jlblTicketsSold, gbc_jlblTicketsSold);
		
		JScrollPane jscrlpnPastWeekSalesTable = new JScrollPane();
		GridBagConstraints gbc_jscrlpnPastWeekSalesTable = new GridBagConstraints();
		gbc_jscrlpnPastWeekSalesTable.insets = new Insets(0, 0, 5, 5);
		gbc_jscrlpnPastWeekSalesTable.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnPastWeekSalesTable.gridx = 0;
		gbc_jscrlpnPastWeekSalesTable.gridy = 1;
		jpnlMainContent.add(jscrlpnPastWeekSalesTable, gbc_jscrlpnPastWeekSalesTable);
		
		jtblPastWeekSales = new JTable();
		
		pastWeekSalesTableModel = new PastWeekSalesTableModel();
		jtblPastWeekSales.setModel(pastWeekSalesTableModel);
		jscrlpnPastWeekSalesTable.setViewportView(jtblPastWeekSales);
		
		JScrollPane jscrlpnTicketsSoldTable = new JScrollPane();
		GridBagConstraints gbc_jscrlpnTicketsSoldTable = new GridBagConstraints();
		gbc_jscrlpnTicketsSoldTable.insets = new Insets(0, 0, 5, 0);
		gbc_jscrlpnTicketsSoldTable.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnTicketsSoldTable.gridx = 1;
		gbc_jscrlpnTicketsSoldTable.gridy = 1;
		jpnlMainContent.add(jscrlpnTicketsSoldTable, gbc_jscrlpnTicketsSoldTable);
		
		jtblTicketsSold = new JTable();
		ticketTableModel = new TicketTableModel();
		jtblTicketsSold.setModel(ticketTableModel);
		jscrlpnTicketsSoldTable.setViewportView(jtblTicketsSold);
	}
	
	public void refresh() {
		pastWeekSalesTableModel.refresh();
		ticketTableModel.refresh();
	}

}
