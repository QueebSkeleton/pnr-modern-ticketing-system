package co.sympu.pnrticketing.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import co.sympu.pnrticketing.domain.Station;

/**
 * Main repository for saving and managing persisted Stations.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class StationRepository {
	
	/**
	 * Main datasource of this repository
	 */
	private final DataSource dataSource;
	
	/**
	 * Constructs a StationRepository with the given datasource
	 * as its source of data. 
	 * @param dataSource the datasource that this repository interacts with
	 */
	public StationRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Gets all Stations from the database.
	 * @return the list of Stations
	 */
	public List<Station> getAll() {
		// Placeholder for all stations
		List<Station> stationList = new ArrayList<>();
		
		try(
			// Grab a connection to the database
			Connection connection = dataSource.getConnection();
			// Create a placeholder for a SELECT SQL Statement
			Statement retrieveStationsStatement = connection.createStatement();
			// Execute a SELECT all then retrieve the ResultSet
			ResultSet stationResultSet = retrieveStationsStatement.executeQuery("SELECT id, name, description FROM station")) {
			
			// For each record in the ResultSet,
			// map it to a Station object then add it to the placeholder list
			while(stationResultSet.next())
				stationList.add(
					new Station(
						stationResultSet.getInt(1),
						stationResultSet.getString(2),
						stationResultSet.getString(3)));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Return the final constructed station list
		return stationList;
	}
	
	/**
	 * Gets a Station from the database by its id.
	 * 
	 * @param id the database id of the station
	 * @return the station object
	 */
	public Station getById(int id) {
		return getById(id, false);
	}
	
	/**
	 * Gets a Station from the database by its id,
	 * including its current pricing table if retrievePricing is true.
	 * 
	 * @param id the id of the station
	 * @param retrievePricing include the pricing information if this is true
	 * @return the station object
	 */
	public Station getById(int id, boolean retrievePricing) {
		// Placeholder for the station retrieved
		Station station = null;
		
		try(
			// Grab a connection to the database	
			Connection connection = dataSource.getConnection();
			// Create a placeholder for a SELECT SQL Statement
			Statement retrieveStationStatement = connection.createStatement();
			// Execute a SELECT query, including pricing if necessary
			ResultSet stationResultSet = retrieveStationStatement.executeQuery(
					"SELECT * FROM station " + 
						(retrievePricing ? " LEFT JOIN station_pricing ON station_pricing.from_id = station.id" : "")
						+ " WHERE id = " + id)) {
			
			// If there is a result
			if(stationResultSet.next()) {
				// Parse the first row, and map it to a new Station object
				station =
					new Station(
						stationResultSet.getInt(1),
						stationResultSet.getString(2),
						stationResultSet.getString(3));
				
				// If retrievePricing is set to true,
				// retrieve pricing information on the next columns
				if(retrievePricing) {
					// Retrieve the first pricing
					if(stationResultSet.getInt(4) != 0)
						station.setTicketPrice(
								stationResultSet.getInt(5),
								stationResultSet.getDouble(6));
					
					// Retrieve the rest of the pricing information
					while(stationResultSet.next()) {
						if(stationResultSet.getInt(4) != 0)
							station.setTicketPrice(
									stationResultSet.getInt(5),
									stationResultSet.getDouble(6));
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Return the station object
		return station;
	}
	
	/**
	 * Persists a station object to the database.
	 * @param station the station to save
	 */
	public void save(Station station) {
		try(
			// Grab a connection to the database	
			Connection connection = dataSource.getConnection();
			// Create a placeholder for an INSERT SQL Statement
			PreparedStatement insertStationStatement = connection.prepareStatement("INSERT INTO station (name, description) VALUES (?, ?)")) {
			
			// Bind the station fields into the insert statement
			insertStationStatement.setString(1, station.getName());
			insertStationStatement.setString(2, station.getDescription());
			
			// Execute the insert statement
			insertStationStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates a station currently in the database, with new information.
	 * @param station the station to update
	 */
	public void update(Station station) {
		try(
			// Grab a connection to the database	
			Connection connection = dataSource.getConnection();
			// Create a placeholder for an UPDATE SQL Statement
			PreparedStatement updateStationStatement = connection.prepareStatement("UPDATE station SET name = ?, description = ? WHERE id = ?")) {
			
			// Bind the station fields into the update statement
			updateStationStatement.setString(1, station.getName());
			updateStationStatement.setString(2, station.getDescription());
			updateStationStatement.setInt(3, station.getId());
			
			// Execute the update statement
			updateStationStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates all ticket pricing of a station.
	 * 
	 * @param station the station's pricing to update
	 */
	public void updatePricing(Station station) {
		try(
			// Grab a connection to the database
			Connection connection = dataSource.getConnection();
			// Create a placeholder for DELETE SQL Statement for deleting all ticket pricings
			PreparedStatement deletePricingStatement = connection.prepareStatement("DELETE FROM station_pricing WHERE from_id = ?");
			// Create a placeholder for INSERT SQL Statement for re-inserting new ticket pricings
			PreparedStatement insertPricingStatement = connection.prepareStatement("INSERT INTO station_pricing (from_id, to_id, price) VALUES (?, ?, ?)")) {
			
			// Bind the station id to the delete statement,
			// then execute the delete statement
			deletePricingStatement.setInt(1, station.getId());
			deletePricingStatement.execute();
			
			// For every other station in the ticket pricing table
			for(Integer stationId : station.getPricingTable().keySet()) {
				// Bind the ticket price information to the insert
				insertPricingStatement.setInt(1, station.getId());
				insertPricingStatement.setInt(2, stationId);
				insertPricingStatement.setDouble(3, station.getTicketPrice(stationId));
				// Add this currently added pricing to a batch
				insertPricingStatement.addBatch();
			}
			
			// Execute all pricings as a batch insert
			insertPricingStatement.executeBatch();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes a station by its database id
	 * 
	 * @param id the database id of the station
	 */
	public void deleteById(int id) {
		try(
			// Grab a connection to the database	
			Connection connection = dataSource.getConnection();
			// Create a placeholder for a DELETE SQL Statement
			PreparedStatement deleteStationStatement = connection.prepareStatement("DELETE FROM station WHERE id = ?")) {
			
			// Bind the station id to the delete statement
			deleteStationStatement.setInt(1, id);
			
			// Execute the delete statement
			deleteStationStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
