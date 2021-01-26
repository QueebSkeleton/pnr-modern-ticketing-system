package co.sympu.pnrticketing.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.util.DatabaseUtility;

/**
 * Add form dialog for creating stations.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class UpdateStationDialog extends JDialog {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Current station bound to this dialog form
	 */
	private int stationId;
	
	/**
	 * The Management frame that owns this dialog form.
	 * Is automatically set on who instantiates an AddStationDialog,
	 * which in this case is also StationManagementFrame, when it creates an object.
	 */
	protected StationManagementFrame owner;
	
	/**
	 * Station Name text field.
	 */
	private JTextField jtxtfldStationName;
	
	/**
	 * Station Description text area.
	 */
	private JTextArea jtxtareaDescription;

	/**
	 * Create the dialog.
	 */
	public UpdateStationDialog() {
		
		// Get a reference to this dialog, so we can refer to it later inside ActionListeners
		UpdateStationDialog thisDialog = this;
		
		/* This dialog's properties */
		setTitle("Update Station Form");
		setBounds(100, 100, 450, 300);
		// Use BorderLayout for the whole dialog. Center the form, bottom border for the action buttons panel.
		getContentPane().setLayout(new BorderLayout());
		/* END OF dialog properties */
		
		/* jpnlForm - Main JPanel for Form Elements. Uses a GridBagLayout to layout Labels and TextFields in a grid.  */
		JPanel jpnlForm = new JPanel();
		jpnlForm.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(jpnlForm, BorderLayout.CENTER);
		GridBagLayout gbl_jpnlForm = new GridBagLayout();
		gbl_jpnlForm.columnWidths = new int[] {0, 0 };
		gbl_jpnlForm.rowHeights = new int[]{0, 0 };
		gbl_jpnlForm.columnWeights = new double[]{0.10, 0.90};
		gbl_jpnlForm.rowWeights = new double[]{0.0, 0.0, 1.0};
		jpnlForm.setLayout(gbl_jpnlForm);
		/* END OF jpnlForm */
		
		/* jlblStationName - label for station name input field */
		JLabel jlblStationName = new JLabel("Station Name:");
		jlblStationName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStationName = new GridBagConstraints();
		gbc_jlblStationName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStationName.anchor = GridBagConstraints.EAST;
		gbc_jlblStationName.gridx = 0;
		gbc_jlblStationName.gridy = 0;
		jpnlForm.add(jlblStationName, gbc_jlblStationName);
		/* END OF jlblStationName */
		
		/* jtxtfldStationName - text field input for station name */
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
		
		/* jlblDescription - label for station description input field */
		JLabel jlblDescription = new JLabel("Description:");
		jlblDescription.setAlignmentY(0.0f);
		jlblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDescription = new GridBagConstraints();
		gbc_jlblDescription.anchor = GridBagConstraints.EAST;
		gbc_jlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDescription.gridx = 0;
		gbc_jlblDescription.gridy = 1;
		jpnlForm.add(jlblDescription, gbc_jlblDescription);
		/* END OF jlblDescription */
		
		/* jscrlpnDescription - scrollable container for description input field */
		JScrollPane jscrlpnDescription = new JScrollPane();
		GridBagConstraints gbc_jscrlpnDescription = new GridBagConstraints();
		gbc_jscrlpnDescription.gridwidth = 2;
		gbc_jscrlpnDescription.insets = new Insets(0, 0, 0, 5);
		gbc_jscrlpnDescription.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnDescription.gridx = 0;
		gbc_jscrlpnDescription.gridy = 2;
		jpnlForm.add(jscrlpnDescription, gbc_jscrlpnDescription);
		/* END OF jscrlpnDescription */
		
		/* jtxtareaDescription - text area field input for description */
		jtxtareaDescription = new JTextArea();
		jscrlpnDescription.setViewportView(jtxtareaDescription);
		/* END OF jtxtareaDescription */
		
		/* jpnlButtonActions - main panel for OK and Cancel buttons */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setBorder(new EmptyBorder(0, 10, 10, 10));
		jpnlButtonActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtonActions, BorderLayout.SOUTH);
		/* END OF jpnlButtonActions */
		
		/* jbtnOk - Save station button */
		JButton jbtnOk = new JButton("OK");
		jbtnOk.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnOk.setActionCommand("OK");
		jpnlButtonActions.add(jbtnOk);
		getRootPane().setDefaultButton(jbtnOk);
		
		// jbtnOk's Button Click Listener.
		// When this button is clicked, grab the inputs from the input fields
		// then save the record.
		jbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Extract data from the form
				String name = jtxtfldStationName.getText(),
					   description = jtxtareaDescription.getText();
				
				// Clear the form
				jtxtfldStationName.setText("");
				jtxtareaDescription.setText("");
				
				// Save the inputted station data
				try(
					// Grab a connection to the database	
					Connection connection = DatabaseUtility.dataSource.getConnection();
					// Prepare an update sql statement
					PreparedStatement updateStationStatement =
							connection.prepareStatement(
									"UPDATE station SET name = ?, description = ? WHERE id = ?")) {
					// Bind the inputs to the insert statement
					updateStationStatement.setString(1, name);
					updateStationStatement.setString(2, description);
					updateStationStatement.setInt(3, stationId);
					
					// Execute the insert statement
					// If execute() returns 1, then 1 row was inserted.
					if(updateStationStatement.executeUpdate() == 1) {
						// Show friendly message indicating success
						JOptionPane.showMessageDialog(
							thisDialog,
							"Succesfully updated station to database.",
							"Success!",
							JOptionPane.INFORMATION_MESSAGE);

						// Hide this dialog form
						thisDialog.setVisible(false);
					}
					
					// If not successful
					else
						// Show friendly message indicating user input failure
						JOptionPane.showMessageDialog(
								thisDialog,
								"Cannot update the station with the given inputs.\n\n" +
								"Please check your data.",
								"Recheck!",
								JOptionPane.WARNING_MESSAGE);
				} catch(SQLException exception) {
					// If an SQLException occurs, output a dialog box telling the user
					// that the operation was not successful.
					JOptionPane.showMessageDialog(
							thisDialog,
							"An error occured while trying to update station to database:\n" +
							exception.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Refresh the main table
				owner.stationTableModel.refresh();
			}
		});
		/* END OF jbtnOk */
		
		/* jbtnCancel - Hide form button */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// jbtnCancel's Button Click Listener.
		// When this button is clicked, reset the form then hide the dialog
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear the form
				jtxtfldStationName.setText("");
				jtxtareaDescription.setText("");
				
				// Hide the dialog
				setVisible(false);
			}
		});
		jpnlButtonActions.add(jbtnCancel);
		/* END OF jbtnCancel */
		
	}
	
	public void setup(int stationId) {
		// Retrieve the station first
		try(
			// Grab a connection to the database
			Connection connection = DatabaseUtility.dataSource.getConnection();
			// Create a select station statement holder
			PreparedStatement selectStationStatement = connection.prepareStatement("SELECT name, description FROM station WHERE id = ?")) {
			
			// Bind the station id to the select statement
			selectStationStatement.setInt(1, stationId);
			
			// Execute the select statement and retrieve the station from the ResultSet
			try(ResultSet stationResultSet = selectStationStatement.executeQuery()) {
				if(stationResultSet.next()) {
					this.stationId = stationId;
					jtxtfldStationName.setText(stationResultSet.getString(1));
					jtxtareaDescription.setText(stationResultSet.getString(2));
				}
			} catch(SQLException exception) {
				// In the case where parsing the ResultSet fails,
				// output a message stating that the select failed. Prompt the user to try again.
				JOptionPane.showMessageDialog(
						this,
						"An error occured while parsing station data. Message:\n\n" + exception.getMessage() +
						"\n\nPlease try again.",
						"Notice",
						JOptionPane.WARNING_MESSAGE);
				// Hide this dialog
				setVisible(false);
				return;
			}
			
		} catch(SQLException exception) {
			// In the case where connection fails,
			// output a message stating that the connection failed. Prompt the user to try again.
			JOptionPane.showMessageDialog(
					this,
					"An error occured while connecting to the database to retrieve station data. Message:\n\n" + exception.getMessage() +
					"\n\nPlease try again.",
					"Notice",
					JOptionPane.WARNING_MESSAGE);
			// Hide this dialog
			setVisible(false);
			return;
		}
	}

}
