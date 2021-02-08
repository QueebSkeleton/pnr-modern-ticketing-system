package co.sympu.pnrticketing.ui.stationmgmt;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import co.sympu.pnrticketing.domain.Station;
import co.sympu.pnrticketing.exception.RepositoryAccessException;

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
	 * The management panel that owns this TableModel.
	 * Is automatically set on the owner class itself.
	 */
	protected StationManagementPanel stationManagementPanel;
	
	/**
	 * Column names.
	 */
	private static final String[] columnNames = { "#", "Station Name", "Description" };
	
	/**
	 * Current cache of this TableModel.
	 * Refreshed when refresh() method is called.
	 */
	private List<Station> stationListCache;

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
		// If cache is still null, return 0 for now.
		if(stationListCache == null)
			return 0;
		
		// Return the size of the internal cache
		return stationListCache.size();
	}

	/**
	 * Gets the value at each cell.
	 * @param rowIndex the row of the data
	 * @param columnIndex the column of the data
	 * @return the data
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Grab the station at the specified rowIndex,
		// coincidentally the same index inside the internal cache.
		Station station = stationListCache.get(rowIndex);
			
		// Depending on the specified columnIndex, return the proper field.
		switch(columnIndex) {
		
		// First Column: Just return the rowIndex for now
		case 0:
			return rowIndex + 1;
			
		// Second Column: Return the name in the record
		case 1:
			return station.getName();
			
		// Third Column: Return the description in the record
		case 2:
			return station.getDescription();
			
		// Never gets called when getColumnCount() is properly coded.
		default:
			throw new IllegalArgumentException("Invalid column index.");
		
		}
	}
	
	/**
	 * Refreshes the internal cache, and redraws the listening table (via fireTableDataChanged()).
	 * This is called by AddStationDialog after saving a record,
	 * and also initially called by StationManagementFrame to initialize the Table at first start.
	 */
	public void refresh() {
		try {
			// Refresh the cache with new data from the station repository
			stationListCache = stationManagementPanel.stationRepository.getAll();
			// Prompt redraw of listening JTable
			fireTableDataChanged();
		} catch(RepositoryAccessException e) {
			// Show error message
			if(e.type == RepositoryAccessException.Type.GENERAL)
				JOptionPane.showMessageDialog(
						stationManagementPanel.mainFrame,
						"An error occured while retrieving station information from the database.\n\nMessage: " + e.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Gets the station stored in this TableModel,
	 * by its row index
	 * 
	 * @param rowIndex the index of the record
	 * @return the station entity
	 */
	public Station getStationByRow(int rowIndex) {
		return stationListCache.get(rowIndex);
	}

}
