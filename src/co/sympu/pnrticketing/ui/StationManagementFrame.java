package co.sympu.pnrticketing.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	 * Main content panel.
	 */
	private JPanel jpnlContentPane;
	
	/**
	 * Table of Stations
	 */
	private JTable jtblStation;

	/**
	 * Create the frame.
	 */
	public StationManagementFrame() {
		
		setMinimumSize(new Dimension(500, 400));
		setTitle("Station Management Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.Y_AXIS));
		
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setMaximumSize(new Dimension(32767, 50));
		jpnlHeader.setMinimumSize(new Dimension(10, 50));
		jpnlContentPane.add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		
		JLabel jlblHeader = new JLabel("Manage Stations");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		jpnlHeader.add(jlblHeader);
		
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setMinimumSize(new Dimension(32767, 10));
		jpnlHeader.add(jpnlButtonActions);
		jpnlButtonActions.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton jbtnAddStationDialog = new JButton("Add a Station");
		jbtnAddStationDialog.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnAddStationDialog);
		
		JScrollPane jscrlpnStationTable = new JScrollPane();
		jpnlContentPane.add(jscrlpnStationTable);
		
		jtblStation = new JTable();
		jtblStation.setRowHeight(22);
		jtblStation.setIntercellSpacing(new Dimension(4, 4));
		jtblStation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// TODO: Change to actual database data.
		jtblStation.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Test", "Test"},
				{"2", "Test", "Test"},
			},
			new String[] {
				"#", "Station Name", "Description"
			}
		));
		
		jscrlpnStationTable.setViewportView(jtblStation);
		
	}

}
