package co.sympu.pnrticketing.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Domain entity for a Station.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class Station {
	
	/**
	 * Database ID of this station.
	 */
	private int id;
	/**
	 * Name of the station.
	 */
	private String name;
	/**
	 * Short description of the station.
	 */
	private String description;
	/**
	 * Pricing Map of the station.
	 */
	private Map<Integer, Double> pricingTable;
	
	/**
	 * Constructs a fresh station with a name.
	 * @param name the name of the new station.
	 */
	public Station(String name) {
		this.name = name;
	}

	/**
	 * Constructs a station with pre-initialized data.
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public Station(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricingTable = new HashMap<>();
	}
	
	/**
	 * Constructs a station with pre-initialized data.
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param pricingTable
	 */
	public Station(int id, String name, String description, Map<Integer, Double> pricingTable) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricingTable = pricingTable;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Retrieves the ticket price from this station to the specified station id
	 * @param otherStationId
	 * @return the price
	 */
	public double getTicketPrice(int otherStationId) {
		if(pricingTable == null)
			return 0;
		try {
			return pricingTable.get(otherStationId);
		} catch(NullPointerException e) {
			return 0;
		}
	}

	
	/**
	 * Sets the ticket price from this station to the specified station id
	 * @param otherStationId
	 */
	public void setTicketPrice(int otherStationId, double price) {
		if(pricingTable == null)
			pricingTable = new HashMap<>();
		
		pricingTable.put(otherStationId, price);
	}
	
	/**
	 * Retrieves the ticket pricing for all stations, from this station
	 * @return the map of all ticket prices
	 */
	public Map<Integer, Double> getPricingTable() {
		Map<Integer, Double> clone = new HashMap<>();
		
		for(Integer key : pricingTable.keySet())
			clone.put(key, pricingTable.get(key));
		
		return clone;
	}

}
