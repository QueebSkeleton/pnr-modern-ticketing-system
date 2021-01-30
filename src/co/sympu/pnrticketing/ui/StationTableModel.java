package co.sympu.pnrticketing.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import co.sympu.pnrticketing.util.DatabaseUtility;

/**
 * The Main Table Model of the Station Management Frame's JTable.<br><br>
 * 
 * A StationManagementFrame object instantiates this class and sets the resulting object
 * as its JTable's TableModel.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class StationTableModel extends AbstractTableModel {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Management frame that owns this TableModel.
	 * Is automatically set on the owner class itself.
	 * Why need this?
	 * So we can create JOptionPanes later.
	 */
	protected StationManagementFrame owner;
	
	/**
	 * Column names.
	 */
	private static final String[] columnNames = { "#", "Station Name", "Description" };
	
	/**
	 * Current cache of this TableModel.
	 * Refreshed when refresh() method is called.
	 */
	private CachedRowSet cache;

	/**
	 * Gets the column count of this TableModel.
	 * @return the number of columns in this TableModel.
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	/**
	 * Gets the name of the specified column index.
	 * @param columnIndex the index of the column
	 * @return the name of the column
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	/**
	 * Gets the row count of this TableModel. Depends
	 * on how many rows are in the CachedRowSet cache.
	 * @return the number of rows in this TableModel.
	 */
	@Override
	public int getRowCount() {
		if(cache == null)
			return 0;
		
		return cache.size();
	}

	/**
	 * Gets the value at each cell.
	 * @param rowIndex the row of the data
	 * @param columnIndex the column of the data
	 * @return the data
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			// Move the current referred row in the RowSet to the specified rowIndex
			// ( +1 since JTable is 0-based rows, RowSet is 1-based row)
			cache.absolute(rowIndex + 1);
			
			// Depending on the specified columnIndex, return the proper field.
			switch(columnIndex) {
			
			// First Column: Just return the rowIndex for now
			case 0:
				return rowIndex + 1;
				
			// Second Column: Return the name in the record
			case 1:
				return cache.getString(2);
				
			// Third Column: Return the description in the record
			case 2:
				return cache.getString(3);
				
			// Never gets called when getColumnCount() is properly coded.
			default:
				throw new IllegalArgumentException("Invalid column index.");
			
			}
		} catch(SQLException exception) {
			// If an SQLException occurs, output a dialog box telling the user
			// that the mapping was not successful.
			JOptionPane.showMessageDialog(
					owner,
					"An error occured while trying to retrieve cached data:\n" +
					exception.getMessage(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
			throw new IllegalStateException("Invalid data.");
		}
	}
	
	/**
	 * Refreshes the internal cache, and redraws the listening table (via fireTableDataChanged()).
	 * This is called by AddStationDialog after saving a record,
	 * and also initially called by StationManagementFrame to initialize the Table at first start.
	 */
	public void refresh() {
		try(
			// Grab a connection to the database
			Connection connection = DatabaseUtility.dataSource.getConnection();
			// Create a select statement holder
			Statement selectStationsStatement = connection.createStatement();
			// Execute the select stations statement and retrieve all data in the resultset
			ResultSet stationsResultSet = selectStationsStatement.executeQuery("SELECT id, name, description FROM station")) {
			
			// Create a CachedRowSet to hold the data,
			// so we can close the ResultSet, Statement, and Connection later
			cache = RowSetProvider.newFactory().createCachedRowSet();
			// Populate the cache with the returned ResultSet
			cache.populate(stationsResultSet);
			
		} catch(SQLException exception) {
			// If an SQLException occurs, output a dialog box telling the user
			// that the retrieval was not successful.
			JOptionPane.showMessageDialog(
					owner,
					"An error occured while trying to retrieve data from the database:\n" +
					exception.getMessage(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} // Hidden Auto close block, since this is a try-with-resources block.
		
		fireTableDataChanged();
	}
	
	/**
	 * Gets the identifier of the station record in the database,
	 * depending on its row index.
	 * 
	 * @param rowIndex the index of the record
	 * @return the database id
	 */
	public int getStationId(int rowIndex) {
		try {
			cache.absolute(rowIndex + 1);
			return cache.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException("Cache Row Set cannot be accessed.");
		}
		
	}

}
