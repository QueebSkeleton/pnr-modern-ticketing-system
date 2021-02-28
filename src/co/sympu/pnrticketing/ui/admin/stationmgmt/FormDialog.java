package co.sympu.pnrticketing.ui.admin.stationmgmt;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.domain.Station;
import co.sympu.pnrticketing.exception.RepositoryAccessException;

/**
 * Main Form Dialog of the Station Management Panel. Stations can be created and
 * updated with this dialog, by firstly calling the initialize() methods.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class FormDialog extends JDialog {

	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Management panel that owns this Dialog. Is automatically set on the owner
	 * class itself. Needed so that we can refresh its TableModel after saving a
	 * station.
	 */
	protected StationManagementPanel stationManagementPanel;

	// Field Inputs
	private JTextField jtxtfldStationName;
	private JTextArea jtxtareaDescription;

	/**
	 * Current station bound to this dialog.
	 */
	private Station station;

	public FormDialog() {

		// Get a reference to this dialog, so we can
		// refer to it inside deeper scopes (like ActionListeners)
		FormDialog thisDialog = this;

		/* Dialog Properties */
		setMinimumSize(new Dimension(500, 300));
		setTitle("Make a Station");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		/* END OF Dialog Properties */

		/* jpnlForm - container for all form elements */
		JPanel jpnlForm = new JPanel();
		jpnlForm.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(jpnlForm);
		GridBagLayout gbl_jpnlForm = new GridBagLayout();
		gbl_jpnlForm.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpnlForm.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpnlForm.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpnlForm.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		jpnlForm.setLayout(gbl_jpnlForm);
		/* END OF jpnlForm */

		/* jlblStationName - label for station name input */
		JLabel jlblStationName = new JLabel("Station Name:");
		jlblStationName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStationName = new GridBagConstraints();
		gbc_jlblStationName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStationName.anchor = GridBagConstraints.EAST;
		gbc_jlblStationName.gridx = 0;
		gbc_jlblStationName.gridy = 0;
		jpnlForm.add(jlblStationName, gbc_jlblStationName);
		/* END OF jlblStationName */

		/* jtxtfldStationName - station name input field */
		jtxtfldStationName = new JTextField();
		jtxtfldStationName.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldStationName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldStationName = new GridBagConstraints();
		gbc_jtxtfldStationName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldStationName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldStationName.gridx = 1;
		gbc_jtxtfldStationName.gridy = 0;
		jpnlForm.add(jtxtfldStationName, gbc_jtxtfldStationName);
		jtxtfldStationName.setColumns(10);
		/* END OF jtxtfldStationName */

		/* jlblDescription - label for description input */
		JLabel jlblDescription = new JLabel("Description:");
		jlblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDescription = new GridBagConstraints();
		gbc_jlblDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblDescription.insets = new Insets(0, 0, 0, 5);
		gbc_jlblDescription.gridx = 0;
		gbc_jlblDescription.gridy = 1;
		jpnlForm.add(jlblDescription, gbc_jlblDescription);
		/* END OF jlblDescription */

		/* jscrlpnDescription - scrollable container for description textarea */
		JScrollPane jscrlpnDescription = new JScrollPane();
		GridBagConstraints gbc_jscrlpnDescription = new GridBagConstraints();
		gbc_jscrlpnDescription.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnDescription.gridx = 1;
		gbc_jscrlpnDescription.gridy = 1;
		jpnlForm.add(jscrlpnDescription, gbc_jscrlpnDescription);
		/* END OF jsclpnDescription */

		/* jtxtareaDescription - text area input for description field */
		jtxtareaDescription = new JTextArea();
		jtxtareaDescription.setMargin(new Insets(4, 4, 4, 4));
		jtxtareaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnDescription.setViewportView(jtxtareaDescription);
		/* END OF jtxtareaDescription */

		/* jpnlButtonActions - container for action buttons */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setBorder(new EmptyBorder(0, 10, 10, 10));
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlButtonActions.setPreferredSize(new Dimension(10, 50));
		jpnlButtonActions.setMaximumSize(new Dimension(32767, 50));
		jpnlButtonActions.setMinimumSize(new Dimension(10, 50));
		getContentPane().add(jpnlButtonActions);
		/* END OF jpnlButtonActions */

		/* jbtnSave - save button */
		JButton jbtnSave = new JButton("Save");

		// Save Button Action Listener
		// When this button is clicked, insert or update the station inputted
		jbtnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					// If the current bound station to this dialog is null,
					// perform an insert
					if (station == null) {
						// Create a new station object out of the inputted fields
						station = new Station(jtxtfldStationName.getText());
						station.setDescription(jtxtareaDescription.getText());

						// Save this station object
						stationManagementPanel.stationRepository.save(station);
					}

					// Else, perform an update
					else {
						// Update the fields of the bound station object accordingly
						station.setName(jtxtfldStationName.getText());
						station.setDescription(jtxtareaDescription.getText());

						// Update this station object
						stationManagementPanel.stationRepository.update(station);
					}
				} catch (RepositoryAccessException exception) {
					// Show error message
					if (exception.type == RepositoryAccessException.Type.GENERAL)
						JOptionPane.showMessageDialog(thisDialog,
								"An error occured while saving station information to the database.\n\nMessage: "
										+ exception.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
					else if (exception.type == RepositoryAccessException.Type.INPUT)
						JOptionPane.showMessageDialog(thisDialog,
								"Error occured while saving to database. Please check your inputs.\n\nMessage: "
										+ exception.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// If execution reaches here, the station was successfully saved or updated.
				// Output a friendly message.
				JOptionPane.showMessageDialog(thisDialog, "Station was successfully saved.", "Success",
						JOptionPane.INFORMATION_MESSAGE);

				// Hide this dialog
				setVisible(false);

				// Update the StationTableModel in the owner frame
				stationManagementPanel.stationTableModel.refresh();
			}
		});
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnSave);
		/* END OF jbtnSave */

		/* jbtnCancel - hide dialog button */
		JButton jbtnCancel = new JButton("Cancel");

		// Cancel Button Action Listener
		// When this button is clicked, simply hide the dialog
		jbtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Re-initialize the table
				initialize();
				// Hide this dialog
				setVisible(false);
			}
		});
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnCancel);
		/* END OF jbtnCancel */
	}

	/**
	 * Initializes this dialog for inserting a new station.
	 */
	public void initialize() {
		// Clear the input fields
		jtxtfldStationName.setText("");
		jtxtareaDescription.setText("");
	}

	/**
	 * Initializes this dialog for updating a station, with a specified id.
	 * 
	 * @param stationId the id of the station to update
	 */
	public void initialize(Station station) {
		// Bind the given station to this dialog
		this.station = station;
		// Update the input fields with the station fields
		jtxtfldStationName.setText(station.getName());
		jtxtareaDescription.setText(station.getDescription());
	}

}
