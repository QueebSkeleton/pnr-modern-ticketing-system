package co.sympu.pnrticketing.ui.admin.salesmonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class PastWeekSalesTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private class DaySales {
		LocalDate date;
		int ticketCount;
		double total;
	}
	
	private List<DaySales> currentSalesDisplayed;
	
	public PastWeekSalesTableModel() {
		super();
		currentSalesDisplayed = new ArrayList<>();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		case 0:
			return "Date";
			
		case 1:
			return "Ticket Count";
			
		case 2:
			return "Total";
			
		default:
			return null;
		
		}
	}
	
	@Override
	public int getRowCount() {
		return currentSalesDisplayed.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DaySales daySales = currentSalesDisplayed.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return daySales.date;
			
		case 1:
			return daySales.ticketCount;
			
		case 2:
			return daySales.total;
			
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			Statement retrieveSalesStatement = connection.createStatement();
			ResultSet pastWeekSalesResultSet = retrieveSalesStatement.executeQuery("SELECT DATE(ticket.processed_on) AS 'date', count(ticket.control_number) AS 'ticket_count', SUM(ticket.price) AS 'total' "
					+ "FROM ticket WHERE DATE(ticket.processed_on) >= DATE_SUB(NOW(), INTERVAL 7 DAY) "
					+ "GROUP BY DATE(ticket.processed_on)")) {
			
			Map<LocalDate, DaySales> salesMap = new LinkedHashMap<>();
			salesMap.put(LocalDate.now(), new DaySales());
			salesMap.put(LocalDate.now().minusDays(1), new DaySales());
			salesMap.put(LocalDate.now().minusDays(2), new DaySales());
			salesMap.put(LocalDate.now().minusDays(3), new DaySales());
			salesMap.put(LocalDate.now().minusDays(4), new DaySales());
			salesMap.put(LocalDate.now().minusDays(5), new DaySales());
			salesMap.put(LocalDate.now().minusDays(6), new DaySales());
			
			while(pastWeekSalesResultSet.next()) {
				LocalDate rowDate = LocalDate.parse(pastWeekSalesResultSet.getString("date"));
				int rowTicketCount = pastWeekSalesResultSet.getInt("ticket_count");
				double rowTotal = pastWeekSalesResultSet.getDouble("total");
				
				DaySales daySales = salesMap.get(rowDate);
				daySales.ticketCount = rowTicketCount;
				daySales.total = rowTotal;
			}
			
			currentSalesDisplayed.clear();
			for(LocalDate salesDate : salesMap.keySet()) {
				DaySales daySales = salesMap.get(salesDate);
				daySales.date = salesDate;
				currentSalesDisplayed.add(daySales);
			}
			
			fireTableDataChanged();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
