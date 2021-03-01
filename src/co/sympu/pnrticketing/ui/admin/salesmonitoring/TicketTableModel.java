package co.sympu.pnrticketing.ui.admin.salesmonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TicketTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private class TicketRecord {
		int controlNumber;
		String origin;
		String destination;
		String processedOn;
		double price;
	}
	
	private List<TicketRecord> ticketsDisplayed;
	
	public TicketTableModel() {
		super();
		ticketsDisplayed = new ArrayList<>();
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		case 0:
			return "Control #";
			
		case 1:
			return "Origin";
			
		case 2:
			return "Destination";
			
		case 3:
			return "Date";
			
		case 4:
			return "Price";
			
		default:
			return null;
		
		}
	}
	
	@Override
	public int getRowCount() {
		return ticketsDisplayed.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TicketRecord ticketRecord = ticketsDisplayed.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return ticketRecord.controlNumber;
			
		case 1:
			return ticketRecord.origin;
			
		case 2:
			return ticketRecord.destination;
			
		case 3:
			return ticketRecord.processedOn;
			
		case 4:
			return ticketRecord.price;
			
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db", "pnr_app", "password123");
			Statement retrieveTicketsStatement = connection.createStatement();
			ResultSet ticketsResultSet = retrieveTicketsStatement.executeQuery("SELECT ticket.control_number, origin.name AS origin, destination.name AS destination, ticket.processed_on, ticket.price FROM ticket "
					+ "LEFT JOIN station origin ON origin.id = ticket.origin_station_id "
					+ "LEFT JOIN station destination ON destination.id = ticket.destination_station_id")) {
			
			ticketsDisplayed.clear();
			while(ticketsResultSet.next()) {
				TicketRecord ticketRecord = new TicketRecord();
				ticketRecord.controlNumber = ticketsResultSet.getInt("control_number");
				ticketRecord.origin = ticketsResultSet.getString("origin");
				ticketRecord.destination = ticketsResultSet.getString("destination");
				ticketRecord.processedOn = ticketsResultSet.getString("processed_on");
				ticketRecord.price = ticketsResultSet.getDouble("price");
				ticketsDisplayed.add(ticketRecord);
			}
			
			fireTableDataChanged();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
