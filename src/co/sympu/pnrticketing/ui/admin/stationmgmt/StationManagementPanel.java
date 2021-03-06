package co.sympu.pnrticketing.ui.admin.stationmgmt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.domain.Station;
import co.sympu.pnrticketing.exception.RepositoryAccessException;
import co.sympu.pnrticketing.repository.StationRepository;
import co.sympu.pnrticketing.ui.admin.MainFrame;

/**
 * Station Management Panel.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class StationManagementPanel extends JPanel {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Station Repository for persisting Station Information.
	 */
	protected StationRepository stationRepository;
	
	/**
	 * Main Frame that owns this management panel.
	 */
	protected MainFrame mainFrame;
	
	/**
	 * Main Form Dialog for Adding and Updating Stations.
	 */
	private FormDialog formDialog;
	
	/**
	 * Station Pricing Dialog of this Frame. Is opened and manipulated depending on the station selected.
	 */
	private PricingDialog stationPricingDialog;
	
	/**
	 * Table of Stations
	 */
	private JTable jtblStation;
	
	/**
	 * Table Model of the station table.
	 */
	protected StationTableModel stationTableModel;

	/**
	 * Create the panel. All dialog initialization code here.
	 */
	public StationManagementPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		/* formDialog - dialog box for adding or updating stations */
		formDialog = new FormDialog();
		formDialog.stationManagementPanel = this;
		
		/* stationPricingDialog - The Dialog Box for updating station prices. */
		stationPricingDialog = new PricingDialog();
		stationPricingDialog.stationManagementPanel = this;
		
		/* jpnlHeader - header panel. Contains a header label and a button for adding stations */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setMaximumSize(new Dimension(32767, 50));
		jpnlHeader.setMinimumSize(new Dimension(10, 50));
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		/* END OF jpnlHeader */
		
		/* jlblHeader - main header label of the frame */
		JLabel jlblHeader = new JLabel("Manage Stations");
		jlblHeader.setFont(new Font("Roboto", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */
		
		/* jpnlButtonActions - just a container for right aligning the add button */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setMinimumSize(new Dimension(32767, 10));
		jpnlHeader.add(jpnlButtonActions);
		jpnlButtonActions.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		/* END OF jpnlButtonActions */
		
		/* jbtnAddStationDialog - Button for showing an add form dialog box */
		JButton jbtnAddStation = new JButton("Add a Station");
		jbtnAddStation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnAddStation.setForeground(Color.BLACK);
		jbtnAddStation.setBackground(Color.WHITE);
		jbtnAddStation.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		// Add Station Button Click Event
		// When this button is clicked, initialize form dialog then show
		jbtnAddStation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Initialize formDialog for a new station
				formDialog.initialize();
				
				// Update formDialog's title appropriately
				formDialog.setTitle("Add Station");
				
				// Show formDialog
				formDialog.setVisible(true);
				
			}
		});
		jpnlButtonActions.add(jbtnAddStation);
		/* END OF jbtnAddStationDialog */
		
		/* jbtnPricing - Button for updating a station's pricing */
		JButton jbtnPricing = new JButton("Pricing");
		jbtnPricing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPricing.setForeground(Color.BLACK);
		jbtnPricing.setBackground(Color.WHITE);
		jbtnPricing.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		// Pricing Button Click Event
		// When this button is clicked, show the Pricing Dialog.
		jbtnPricing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If there are no selected rows in the table
				if(jtblStation.getSelectionModel().getSelectedItemsCount() == 0) {
					// Output a friendly message telling the user to select a row first
					JOptionPane.showMessageDialog(
							mainFrame,
							"Please select a station first before clicking the update pricing button.",
							"Notice",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Else, grab the selected row index
				int selectedRowIndex = jtblStation.getSelectionModel().getSelectedIndices()[0];

				// Get the id of the station in the table model depending on the given row
				Station station = stationTableModel.getStationByRow(selectedRowIndex);
				
				// Update the pricing dialog internal form accordingly
				stationPricingDialog.initialize(station);
				
				// Show the dialog
				stationPricingDialog.setVisible(true);
			}
		});
		jpnlButtonActions.add(jbtnPricing);
		/* END OF jbtnPricing */

		/* jbtnUpdateStation - Button for updating a station */
		JButton jbtnUpdateStation = new JButton("Update");
		jbtnUpdateStation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnUpdateStation.setForeground(Color.BLACK);
		jbtnUpdateStation.setBackground(Color.WHITE);
		jbtnUpdateStation.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		// Update Button Click Event
		// When this button is clicked, setup the update dialog and show the selected record
		jbtnUpdateStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If there are no selected rows in the table
				if(jtblStation.getSelectionModel().getSelectedItemsCount() == 0) {
					// Output a friendly message telling the user to select a row first
					JOptionPane.showMessageDialog(
							mainFrame,
							"Please select a station first before clicking the update button.",
							"Notice",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Else, grab the selected row index
				int selectedRowIndex = jtblStation.getSelectionModel().getSelectedIndices()[0];
				
				// Get the id of the station in the table model depending on the given row
				Station station = stationTableModel.getStationByRow(selectedRowIndex);
				
				// Initialize form dialog with the retrieved station
				formDialog.initialize(station);
				
				// Update formDialog's title appropriately
				formDialog.setTitle("Update Station");
				
				// Show form dialog
				formDialog.setVisible(true);
			}
		});
		jpnlButtonActions.add(jbtnUpdateStation);
		/* END OF jbtnUpdateStation */

		/* jbtnDelete - Button for removing a station */
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnDelete.setForeground(Color.BLACK);
		jbtnDelete.setBackground(Color.WHITE);
		jbtnDelete.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		// Delete Button Click Event
		// When this button is clicked, delete the selected row on the table
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If there are no selected rows in the table
				if(jtblStation.getSelectionModel().getSelectedItemsCount() == 0) {
					// Output a friendly message telling the user to select a row first
					JOptionPane.showMessageDialog(
							mainFrame,
							"Please select a station first before clicking the delete button.",
							"Notice",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Ask confirmation from the user first
				if(JOptionPane.showConfirmDialog(mainFrame, "Delete this station?") == JOptionPane.YES_OPTION) {
					// Else, grab the selected row index
					int selectedRowIndex = jtblStation.getSelectionModel().getSelectedIndices()[0];
	
					// Get the id of the station in the table model depending on the given row
					Station station = stationTableModel.getStationByRow(selectedRowIndex);
					
					// Construct a SwingWorker to perform the delete in another thread,
					// so the UI remains responsive
					new SwingWorker<Boolean, Void>() {

						@Override
						protected Boolean doInBackground() throws Exception {
							try {
								// Delete the station by its id
								stationRepository.deleteById(station.getId());
								
								return true;
							} catch(RepositoryAccessException e) {
								// Show error message
								if(e.type == RepositoryAccessException.Type.GENERAL)
									JOptionPane.showMessageDialog(
											mainFrame,
											"An error occured while retrieving station information from the database.\n\nMessage: " + e.getMessage(),
											"Error",
											JOptionPane.ERROR_MESSAGE);
							}
							return false;
						}
						
						@Override
						protected void done() {
							try {
								if(get()) {
									// When execution reaches here,
									// the delete was successful. Output a friendly message.
									JOptionPane.showMessageDialog(
											mainFrame,
											"Successfully removed the station.",
											"Success!",
											JOptionPane.INFORMATION_MESSAGE);
									
									// Refresh the table.
									stationTableModel.refresh();
								}
							} catch (InterruptedException | ExecutionException e) {
								JOptionPane.showMessageDialog(
										mainFrame,
										"The station was removed but an error occured afterwards.\n\nMessage: " + e.getMessage(),
										"Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}.execute();
				}
			}
		});
		jpnlButtonActions.add(jbtnDelete);
		/* END OF jbtnDelete */
		
		/* jscrlpnStationTable - Scrollable Container for the JTable */
		JScrollPane jscrlpnStationTable = new JScrollPane();
		add(jscrlpnStationTable);
		/* END OF jscrlpnStationTable */
		
		/* jtblStation - Table of Stations */
		jtblStation = new JTable();
		jtblStation.setRowHeight(22);
		jtblStation.setIntercellSpacing(new Dimension(4, 4));
		jtblStation.setFont(new Font("Roboto", Font.PLAIN, 12));
		
		// stationTableModel - TableModel for this Table.
		stationTableModel = new StationTableModel();
		stationTableModel.stationManagementPanel = this;
		jtblStation.setModel(stationTableModel);
		jscrlpnStationTable.setViewportView(jtblStation);
		/* END OF jtblStation */
		
	}
	
	
	/**
	 * Binds a station repository object to this management panel. This is also
	 * effectively bound to the other UI components.
	 * 
	 * @param stationRepository the repository to set
	 */
	public void setStationRepository(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	
	/**
	 * Refresh the JTable.
	 */
	public void refreshTable() {
		this.stationTableModel.refresh();
	}

}
