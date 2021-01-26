package co.sympu.pnrticketing.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 * Station Management Panel.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class StationManagementFrame extends JFrame {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Add Form Dialog of this Frame. Is opened when add button is clicked.
	 */
	private AddStationDialog addStationDialog;
	
	/**
	 * Station Pricing Dialog of this Frame. Is opened and manipulated depending on the station selected.
	 */
	private StationPricingDialog stationPricingDialog;
	
	/**
	 * Main content panel.
	 */
	private JPanel jpnlContentPane;
	
	/**
	 * Table of Stations
	 */
	private JTable jtblStation;
	
	/**
	 * Table Model of the station table.
	 */
	protected StationTableModel stationTableModel;

	/**
	 * Create the frame. All dialog initialization code here.
	 */
	public StationManagementFrame() {
		
		// Get a reference to this frame, so we can refer to it later inside ActionListeners
		StationManagementFrame thisFrame = this;
		
		/* addStationDialog - The Dialog Box for adding stations. */
		addStationDialog = new AddStationDialog();
		addStationDialog.owner = this;
		
		/* stationPricingDialog - The Dialog Box for updating station prices. */
		stationPricingDialog = new StationPricingDialog();
		
		/* This frame's properties */
		setMinimumSize(new Dimension(600, 400));
		setTitle("Station Management Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		/* END OF frame properties */
		
		/* jpnlContentPane - main content JPanel that contains two panels, the header panel and the table panel. */
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.Y_AXIS));
		/* END OF jpnlContentPane */
		
		/* jpnlHeader - header panel. Contains a header label and a button for adding stations */
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setMaximumSize(new Dimension(32767, 50));
		jpnlHeader.setMinimumSize(new Dimension(10, 50));
		jpnlContentPane.add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		/* END OF jpnlHeader */
		
		/* jlblHeader - main header label of the frame */
		JLabel jlblHeader = new JLabel("Manage Stations");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */
		
		/* jpnlButtonActions - just a container for right aligning the add button */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setMinimumSize(new Dimension(32767, 10));
		jpnlHeader.add(jpnlButtonActions);
		jpnlButtonActions.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		/* END OF jpnlButtonActions */
		
		/* jbtnAddStationDialog - Button for showing an add form dialog box */
		JButton jbtnAddStationDialog = new JButton("Add a Station");
		jbtnAddStationDialog.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnAddStationDialog);
		
		/* jbtnPricing - Button for updating a station's pricing */
		JButton jbtnPricing = new JButton("Pricing");
		jbtnPricing.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Pricing Button Click Event
		// When this button is clicked, show the Pricing Dialog.
		jbtnPricing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If there are no selected rows in the table
				if(jtblStation.getSelectionModel().getSelectedItemsCount() == 0) {
					// Output a friendly message telling the user to select a row first
					JOptionPane.showMessageDialog(
							thisFrame,
							"Please select a station first before clicking the update pricing button.",
							"Notice",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Else, grab the selected row index
				int selectedRowIndex = jtblStation.getSelectionModel().getSelectedIndices()[0];
				
				// Get the id of the station in the table model depending on the given row
				int stationId = stationTableModel.getStationId(selectedRowIndex);
				// Get the name of the station in the table model
				String stationName = (String) stationTableModel.getValueAt(selectedRowIndex, 1);
				
				// Update the dialog internal form accordingly
				stationPricingDialog.setStation(stationId, stationName);
				
				// Show the dialog
				stationPricingDialog.setVisible(true);
			}
		});
		jpnlButtonActions.add(jbtnPricing);
		/* END OF jbtnPricing */

		/* jbtnUpdateStation - Button for updating a station */
		JButton jbtnUpdateStation = new JButton("Update");
		jbtnUpdateStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnUpdateStation);
		/* END OF jbtnUpdateStation */

		/* jbtnDelete - Button for removing a station */
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnDelete);
		/* END OF jbtnDelete */
		
		// CLICK EVENT HERE.
		// When this button is clicked, show the addStationDialog.
		jbtnAddStationDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show addStationDialog
				addStationDialog.setVisible(true);
			}
		});
		/* END OF jbtnAddStationDialog */
		
		/* jscrlpnStationTable - Scrollable Container for the JTable */
		JScrollPane jscrlpnStationTable = new JScrollPane();
		jpnlContentPane.add(jscrlpnStationTable);
		/* END OF jscrlpnStationTable */
		
		/* jtblStation - Table of Stations */
		jtblStation = new JTable();
		jtblStation.setRowHeight(22);
		jtblStation.setIntercellSpacing(new Dimension(4, 4));
		jtblStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// stationTableModel - TableModel for this Table.
		stationTableModel = new StationTableModel();
		jtblStation.setModel(stationTableModel);
		jscrlpnStationTable.setViewportView(jtblStation);
		/* END OF jtblStation */
		
		// Refresh the station table model initially
		stationTableModel.refresh();
		
	}

}
