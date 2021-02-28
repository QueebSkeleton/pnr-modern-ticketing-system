package co.sympu.pnrticketing.ui.admin.stationmgmt;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import co.sympu.pnrticketing.domain.Station;
import co.sympu.pnrticketing.exception.RepositoryAccessException;

/**
 * Station pricing dialog for updating ticket prices.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class PricingDialog extends JDialog {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Management Panel that this Dialog is owned by.
	 * Used to refer to the StationRepository object in there.
	 */
	protected StationManagementPanel stationManagementPanel;
	
	/**
	 * Current station bound to this dialog form
	 */
	private Station station;
	
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
	public PricingDialog() {
		
		// Get a reference to this dialog, so we can refer to it later inside ActionListeners
		PricingDialog thisDialog = this;
		
		/* This dialog's properties */
		setMinimumSize(new Dimension(400, 400));
		setTitle("Update Pricing");
		setBounds(100, 100, 450, 300);
		/* END OF dialog properties */
		
		/* jpnlContentPane - Main panel of this dialog. Contains 3 JPanels: Header, Main Form, and Buttons Panel */
		JPanel jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 0, 10));
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.Y_AXIS));
		setContentPane(jpnlContentPane);
		/* END OF SPACING */
		
		/* jlblOriginStation - label for origin station field input */
		jlblOriginStation = new JLabel("Origin Station:");
		jlblOriginStation.setAlignmentY(0.0f);
		jlblOriginStation.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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
		jpnlMainForm.setBorder(new EmptyBorder(10, 10, 0, 10));
		jscrlpnMainForm.setViewportView(jpnlMainForm);
		GridBagLayout gbl_jpnlMainForm = new GridBagLayout();
		gbl_jpnlMainForm.columnWidths = new int[]{0, 0};
		gbl_jpnlMainForm.columnWeights = new double[] {0.10, 0.90};
		jpnlMainForm.setLayout(gbl_jpnlMainForm);
		/* END OF jpnlMainForm */

		/* jpnlButtonActions - button actions panel */
		JPanel jpnlButtonActions = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlButtonActions.setMaximumSize(new Dimension(32767, 70));
		jpnlButtonActions.setMinimumSize(new Dimension(10, 70));
		jpnlButtonActions.setBorder(new EmptyBorder(10, 0, 5, 0));
		jpnlButtonActions.setAlignmentY(0.0f);
		jpnlButtonActions.setAlignmentX(0.0f);
		jpnlContentPane.add(jpnlButtonActions);
		/* END OF jpnlButtonActions */

		/* jbtnSave - save button */
		/* END OF jbtnSave */

		/* jbtnCancel - close dialog button */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		// Cancel Button Click Event
		// When this button is clicked, just hide this dialog
		jbtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Hide this dialog
				setVisible(false);
			}
		});
		jpnlButtonActions.add(jbtnCancel);
		JButton jbtnSave = new JButton("Finalize");
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		// Save Button Click Event
		// When this button is clicked, save ticket prices
		jbtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// For every station text field in this form,
				// update the bound station object's pricing table
				for(Integer stationId : stationPricingTextFields.keySet())
					station.setTicketPrice(stationId, Double.parseDouble(stationPricingTextFields.get(stationId).getText()));
				
				// Re-update the pricing table in the database
				stationManagementPanel.stationRepository.updatePricing(station);
				
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
		/* END OF jbtnCancel */
	}
	
	/**
	 * Sets up this form to change the pricing of stations from the specified station.
	 * Creates the JLabels and JTextFields for each destination station.
	 * 
	 * @param stationId the station id to change pricing
	 */
	public void initialize(Station station) {
		
		try {
			// Bind the stationId to this object
			this.station = stationManagementPanel.stationRepository.getById(station.getId(), true);
		} catch(RepositoryAccessException e) {
			// Show error message
			if(e.type == RepositoryAccessException.Type.GENERAL)
				JOptionPane.showMessageDialog(
						stationManagementPanel.mainFrame,
						"An error occured while retrieving station information from the database.\n\nMessage: " + e.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
			// Hide dialog
			setVisible(false);
			return;
		}
		
		// Set the origin label's text to the station name
		jlblOriginStation.setText("Origin Station: " + station.getName());
		
		// Remove all components (Labels and TextFields) from the Main Form JPanel
		jpnlMainForm.removeAll();

		// Initialize the JTextFields of ticket pricings
		stationPricingTextFields = new HashMap<>();
		// Retrieve all stations from the database
		List<Station> allStations = null;
		try {
			allStations = stationManagementPanel.stationRepository.getAll();
		} catch(RepositoryAccessException e) {
			// Show error message
			if(e.type == RepositoryAccessException.Type.GENERAL)
				JOptionPane.showMessageDialog(
						stationManagementPanel.mainFrame,
						"An error occured while retrieving stations information from the database.\n\nMessage: " + e.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
			// Hide dialog
			setVisible(false);
			return;
		}
		
		// For every station retrieved, create a JLabel and a JTextField for it
		int currentRow = 0; // For the GridBagConstraints. See GridBagLayout.
		for(Station stationToPopulate : allStations) {
			if(stationToPopulate.getId() == station.getId())
				continue;
			
			/* jlblPricingToThisStation - label for this input field */
			JLabel jlblPricingToThisStation = new JLabel(stationToPopulate.getName() + ":");
			jlblPricingToThisStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jlblPricingToThisStation = new GridBagConstraints();
			gbc_jlblPricingToThisStation.anchor = GridBagConstraints.EAST;
			gbc_jlblPricingToThisStation.insets = new Insets(0, 0, 5, 5);
			gbc_jlblPricingToThisStation.gridx = 0;
			gbc_jlblPricingToThisStation.gridy = currentRow;
			jpnlMainForm.add(jlblPricingToThisStation, gbc_jlblPricingToThisStation);
			/* END OF jlblPricingToThisStation */
			
			/* jtxtfldPricingToThisStation - text field input for pricing to this station */
			JTextField jtxtfldPricingToThisStation = new JTextField("" + this.station.getTicketPrice(stationToPopulate.getId()));
			jtxtfldPricingToThisStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_jtxtfldPricingToThisStation = new GridBagConstraints();
			gbc_jtxtfldPricingToThisStation.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldPricingToThisStation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldPricingToThisStation.gridx = 1;
			gbc_jtxtfldPricingToThisStation.gridy = currentRow;
			jpnlMainForm.add(jtxtfldPricingToThisStation, gbc_jtxtfldPricingToThisStation);
			/* END OF jtxtfldPricingToThisStation */
			
			// Map this JTextField to its proper station id. Will be retrieved later for easy purposes.
			stationPricingTextFields.put(stationToPopulate.getId(), jtxtfldPricingToThisStation);
			
			// Increment currentRow for the GridBagConstraints
			currentRow++;
		}
		
	}

}
