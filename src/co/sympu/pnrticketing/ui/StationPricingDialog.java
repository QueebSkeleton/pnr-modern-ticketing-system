package co.sympu.pnrticketing.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.util.DatabaseUtility;

/**
 * Station pricing dialog for updating ticket prices.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class StationPricingDialog extends JDialog {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Current station bound to this dialog form
	 */
	private int stationId;
	
	/**
	 * Origin Station Label header
	 */
	private JLabel jlblOriginStation;
	
	/**
	 * Main panel form
	 */
	private JPanel jpnlMainForm;
	
	/**
	 * JTextField(s) of other stations to set their pricing,
	 * mapped to their ids in the database.
	 */
	private Map<Integer, JTextField> stationPricingTextFields;

	/**
	 * Create the dialog.
	 */
	public StationPricingDialog() {
		
		// Get a reference to this dialog, so we can refer to it later inside ActionListeners
		StationPricingDialog thisDialog = this;
		
		/* This dialog's properties */
		setMinimumSize(new Dimension(400, 400));
		setTitle("Update Pricing");
		setBounds(100, 100, 450, 300);
		/* END OF dialog properties */
		
		/* jpnlContentPane - Main panel of this dialog. Contains 3 JPanels: Header, Main Form, and Buttons Panel */
		JPanel jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.Y_AXIS));
		setContentPane(jpnlContentPane);
		/* END OF jpnlContentPane */
		
		/* jlblHeader - header of this dialog */
		JLabel jlblHeader = new JLabel("Set Pricing");
		jlblHeader.setAlignmentY(0.0f);
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		jpnlContentPane.add(jlblHeader);
		/* END OF jlblHeader */
		
		/* SPACING */
		jpnlContentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		/* END OF SPACING */
		
		/* jlblOriginStation - label for origin station field input */
		jlblOriginStation = new JLabel("Origin Station:");
		jlblOriginStation.setAlignmentY(0.0f);
		jlblOriginStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlContentPane.add(jlblOriginStation);
		/* END OF jlblOriginStation */
		
		/* SPACING */
		jpnlContentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		/* END OF SPACING */

		/* jscrlpnMainForm - main form scroller, to adapt to small sizes */
		JScrollPane jscrlpnMainForm = new JScrollPane();
		jscrlpnMainForm.setAlignmentX(0.0f);
		jscrlpnMainForm.setAlignmentY(0.0f);
		jpnlContentPane.add(jscrlpnMainForm);
		/* END OF jscrlpnMainForm */

		/* jpnlMainForm - main form panel, placed inside a scroller pane. Dynamically contains Labels and Textfields */
		jpnlMainForm = new JPanel();
		jscrlpnMainForm.setViewportView(jpnlMainForm);
		GridBagLayout gbl_jpnlMainForm = new GridBagLayout();
		gbl_jpnlMainForm.columnWidths = new int[]{0, 0};
		gbl_jpnlMainForm.columnWeights = new double[] {0.15, 0.85};
		jpnlMainForm.setLayout(gbl_jpnlMainForm);
		/* END OF jpnlMainForm */

		/* jpnlButtonActions - button actions panel */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setMaximumSize(new Dimension(32767, 70));
		jpnlButtonActions.setMinimumSize(new Dimension(10, 70));
		jpnlButtonActions.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpnlButtonActions.setAlignmentY(0.0f);
		jpnlButtonActions.setAlignmentX(0.0f);
		jpnlContentPane.add(jpnlButtonActions);
		/* END OF jpnlButtonActions */

		/* jbtnSave - save button */
		JButton jbtnSave = new JButton("Save");
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Add Button Click Event
		// When this button is clicked, add everything
		jbtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO: Start database transaction here
				try(
					// Grab a connection to the database
					Connection connection = DatabaseUtility.dataSource.getConnection();
					// Create a delete pricing statement holder
					PreparedStatement deleteCurrentPricingsStatement = connection.prepareStatement("DELETE FROM station_pricing WHERE from_id = ?");
					// Create a insert new pricing statement holder
					PreparedStatement insertNewPricingStatement = connection.prepareStatement("INSERT INTO station_pricing(from_id, to_id, price) VALUES (?, ?, ?)")) {
					
					// Bind the station id to the delete statement
					deleteCurrentPricingsStatement.setInt(1, stationId);
					// Execute the delete statement
					deleteCurrentPricingsStatement.execute();
					
					// For each entry in the JTextFields map, parse it and insert to the database.
					// This Map represents the pricing for each destination station.
					for(Integer stationId : stationPricingTextFields.keySet()) {
						// Get the station id (origin station), which is the id bound to this dialog
						insertNewPricingStatement.setInt(1, thisDialog.stationId);
						// Get the station id (destination station), the one we're looping on
						insertNewPricingStatement.setInt(2, stationId);
						// Get the JTextField text mapped on the station id
						insertNewPricingStatement.setDouble(3, Double.parseDouble(stationPricingTextFields.get(stationId).getText()));
						// Add this batch for insertion later
						insertNewPricingStatement.addBatch();
					}
					
					// Insert all ticket pricing to the database
					insertNewPricingStatement.executeBatch();
				} catch(SQLException exception) {
					// In the case where anything above causes an SQLException,
					// output a message stating that the update failed. Prompt the user to try again.
					JOptionPane.showMessageDialog(
							thisDialog,
							"Pricing update failed. Please try again later.",
							"Notice",
							JOptionPane.WARNING_MESSAGE);
					// Hide this dialog again
					setVisible(false);
				}
				
				// When execution reaches here,
				// the update was successful. Output a friendly message.
				JOptionPane.showMessageDialog(
						thisDialog,
						"Successfully updated all ticket prices with this station.",
						"Success!",
						JOptionPane.INFORMATION_MESSAGE);
				// Hide this dialog
				setVisible(false);
				
			}
		});
		jpnlButtonActions.add(jbtnSave);
		/* END OF jbtnSave */

		/* jbtnCancel - close dialog button */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Cancel Button Click Event
		// When this button is clicked, just hide this dialog
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		jpnlButtonActions.add(jbtnCancel);
		/* END OF jbtnCancel */
	}
	
	/**
	 * Sets up this form to change the pricing of stations from the specified station.
	 * Creates the JLabels and JTextFields for each destination station.
	 * 
	 * @param stationId the station id to change pricing
	 */
	public void setup(int stationId) {
		
		// Bind the stationId to this object
		this.stationId = stationId;
		
		// Station name holder, which will be retrieved from the database.
		// This will also determine if the stationId is valid and existing in the database.
		String stationName = null;
		try {
			stationName = retrieveStationName(stationId);
		} catch(IllegalStateException exception) {
			// If an exception occurs
			// Output a friendly message telling the user to try again
			JOptionPane.showMessageDialog(
					this,
					exception.getMessage() + "\n\n" + "Please try again.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
			// Hide this dialog again
			setVisible(false);
			return;
		}
		
		// If the station name is still null, then the stationId given is invalid.
		if(stationName == null) {
			// Output a friendly message telling the user to select a proper station
			JOptionPane.showMessageDialog(
					this,
					"Invalid station selected. Please select a proper station from the table.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
			// Hide this dialog again
			setVisible(false);
			return;
		}
		
		// Set the origin label's text to the station name
		jlblOriginStation.setText("Origin Station: " + stationName);
		
		// Remove all components (Labels and TextFields) from the Main Form JPanel
		jpnlMainForm.removeAll();

		// Initialize the JTextFields of ticket pricings
		stationPricingTextFields = new HashMap<>();
		// Retrieve all other station records from the database
		List<StationRecord> otherStations = null;
		try {
			otherStations = retrieveOtherStations(stationId);
		} catch(IllegalStateException exception) {
			// If an exception occurs
			// Output a friendly message telling the user to try again
			JOptionPane.showMessageDialog(
					this,
					exception.getMessage() + "\n\n" + "Please try again.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
			// Hide this dialog again
			setVisible(false);
			return;
		}
		
		// For every station record retrieved, create a JLabel and a JTextField for it
		int currentRow = 0; // For the GridBagConstraints. See GridBagLayout.
		for(StationRecord stationRecord : otherStations) {
			/* jlblPricingToThisStation - label for this input field */
			JLabel jlblPricingToThisStation = new JLabel(stationRecord.name + ":");
			jlblPricingToThisStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jlblPricingToThisStation = new GridBagConstraints();
			gbc_jlblPricingToThisStation.anchor = GridBagConstraints.EAST;
			gbc_jlblPricingToThisStation.insets = new Insets(0, 0, 5, 5);
			gbc_jlblPricingToThisStation.gridx = 0;
			gbc_jlblPricingToThisStation.gridy = currentRow;
			jpnlMainForm.add(jlblPricingToThisStation, gbc_jlblPricingToThisStation);
			/* END OF jlblPricingToThisStation */
			
			/* jtxtfldPricingToThisStation - text field input for pricing to this station */
			JTextField jtxtfldPricingToThisStation = new JTextField("0.00");
			jtxtfldPricingToThisStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jtxtfldPricingToThisStation = new GridBagConstraints();
			gbc_jtxtfldPricingToThisStation.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldPricingToThisStation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldPricingToThisStation.gridx = 1;
			gbc_jtxtfldPricingToThisStation.gridy = currentRow;
			jpnlMainForm.add(jtxtfldPricingToThisStation, gbc_jtxtfldPricingToThisStation);
			/* END OF jtxtfldPricingToThisStation */
			
			// Map this JTextField to its proper station id. Will be retrieved later for easy purposes.
			stationPricingTextFields.put(stationRecord.id, jtxtfldPricingToThisStation);
			
			// Increment currentRow for the GridBagConstraints
			currentRow++;
		}
		
		// Retrieve all station ticket pricing that root from this station
		try(
			// Grab a connection to the database
			Connection connection = DatabaseUtility.dataSource.getConnection();
			// Create a select pricing statement holder
			PreparedStatement selectPricingsFromThiStationStatement = connection.prepareStatement("SELECT to_id, price FROM station_pricing WHERE from_id = ?")) {
			
			// Bind the stationId to the statement
			selectPricingsFromThiStationStatement.setInt(1, stationId);
			
			// Execute the statement and get all pricings in a ResultSet
			try(ResultSet pricingsResultSet = selectPricingsFromThiStationStatement.executeQuery()) {
				// For each record, retrieve the appropriate JTextField and set its text to the retrieved price.
				while(pricingsResultSet.next()) {
					int toId = pricingsResultSet.getInt(1);
					stationPricingTextFields.get(toId).setText(pricingsResultSet.getString(2));
				}
			} catch(SQLException exception) {
				// In the case where an error occured while retrieving or processing the ResultSet,
				// Output a friendly message and hide the dialog box.
				JOptionPane.showMessageDialog(
						this,
						"An error occured while parsing the ticket pricing from the database. Message:\n\n" + exception.getMessage(),
						"Notice",
						JOptionPane.WARNING_MESSAGE);
				// Hide this dialog box
				setVisible(false);
			}
		} catch(SQLException exception) {
			// In the case where an error occured while creating connections,
			// Output a friendly message and hide the dialog box.
			JOptionPane.showMessageDialog(
					this,
					"An error occured while connecting to the database for the ticket pricing. Message:\n\n" + exception.getMessage(),
					"Notice",
					JOptionPane.WARNING_MESSAGE);
			// Hide this dialog box
			setVisible(false);
			
		}
		
	}
	
	/**
	 * Get all destination stations from the database.
	 * 
	 * @param stationId the id of the origin station
	 * @return the List of records of destination stations
	 */
	private List<StationRecord> retrieveOtherStations(int stationId) {
		// Keep track of all records
		List<StationRecord> stationRecords = new ArrayList<>();
		
		try(
			// Grab a connection to the database
			Connection connection = DatabaseUtility.dataSource.getConnection();
			// Create a select statement holder
			PreparedStatement selectOtherStationsStatement = connection.prepareStatement("SELECT id, name, description FROM station WHERE id != ?")) {
				
			// Bind the origin station id to the statement
			selectOtherStationsStatement.setInt(1, stationId);
			
			// Execute the select statement and retrieve all destination stations from the ResultSet
			try(ResultSet stationsResultSet = selectOtherStationsStatement.executeQuery()) {
				// Parse each record to a StationRecord object
				while(stationsResultSet.next()) {
					StationRecord stationRecord = new StationRecord();
					stationRecord.id = stationsResultSet.getInt(1);
					stationRecord.name = stationsResultSet.getString(2);
					stationRecords.add(stationRecord);
				}
			} catch(SQLException exception) {
				// In the case where an error occured while retrieving or processing the ResultSet
				// catch it in the setup method
				throw new IllegalStateException("Cannot proceed, an error occured while parsing destination stations. Message:\n\n" + exception.getMessage());
			}
		} catch(SQLException exception) {
			// In the case where an error occured while connecting to the database
			// catch it in the setup method
			throw new IllegalStateException("Cannot proceed, an error occured while connecting to database. Message:\n\n" + exception.getMessage());
		}
		
		return stationRecords;
	}
	
	/**
	 * Gets the station name of the specified station id.
	 * @param stationId the id of the station
	 * @return the name
	 */
	private String retrieveStationName(int stationId) {
		
		// Placeholder for the name
		String name = null;
		
		try(
			// Grab a connection to the database
			Connection connection = DatabaseUtility.dataSource.getConnection();
			// Create a select statement holder
			PreparedStatement selectStationStatement = connection.prepareStatement("SELECT name FROM station WHERE id = ?")) {
			
			// Bind the station id to the select statement
			selectStationStatement.setInt(1, stationId);
			
			// Execute the statement, and retrieve the ResultSet
			try(ResultSet stationResultSet = selectStationStatement.executeQuery()) {
				// Grab the name from the ResultSet
				if(stationResultSet.next())
					name = stationResultSet.getString(1);
			} catch(SQLException exception) {
				// In the case where an error occured while retrieving or processing the ResultSet
				// catch it in the setup method
				throw new IllegalStateException("Cannot proceed, an error occured while parsing station details. Messsage:\n\n" + exception.getMessage());
			}
		} catch(SQLException exception) {
			// In the case where an error occured while connecting to the database
			// catch it in the setup method
			throw new IllegalStateException("Cannot proceed, an error occured while connecting to database to grab station data. Message:\n\n" + exception.getMessage());
		}
		
		// Return the name
		return name;
	}
	
	/**
	 * Class placeholder for a station record in the database.
	 * No description since its not needed by this dialog.
	 * @author Rian Carlo Reyes
	 *
	 */
	private class StationRecord {
		int id;
		String name;
	}

}
