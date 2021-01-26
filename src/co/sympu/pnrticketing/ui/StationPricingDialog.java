package co.sympu.pnrticketing.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * Create the dialog.
	 */
	public StationPricingDialog() {
		
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
		JLabel jlblOriginStation = new JLabel("Origin Station:");
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
		JPanel jpnlMainForm = new JPanel();
		jscrlpnMainForm.setViewportView(jpnlMainForm);
		GridBagLayout gbl_jpnlMainForm = new GridBagLayout();
		gbl_jpnlMainForm.columnWidths = new int[]{0};
		gbl_jpnlMainForm.rowHeights = new int[]{0};
		gbl_jpnlMainForm.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_jpnlMainForm.rowWeights = new double[]{Double.MIN_VALUE};
		jpnlMainForm.setLayout(gbl_jpnlMainForm);
		/* END OF jpnlMainForm */

		/* jpnlButtonActions - button actions panel */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setMaximumSize(new Dimension(32767, 100));
		jpnlButtonActions.setMinimumSize(new Dimension(10, 100));
		jpnlButtonActions.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpnlButtonActions.setAlignmentY(0.0f);
		jpnlButtonActions.setAlignmentX(0.0f);
		jpnlContentPane.add(jpnlButtonActions);
		/* END OF jpnlButtonActions */

		/* jbtnSave - save button */
		JButton jbtnSave = new JButton("Save");
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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

}
