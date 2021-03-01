package co.sympu.pnrticketing.ui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.ui.admin.machinemngmt.MachineManagementPanel;
import co.sympu.pnrticketing.ui.admin.salesmonitoring.SalesMonitoringPanel;
import co.sympu.pnrticketing.ui.admin.stationmgmt.StationManagementPanel;

/**
 * Administrator Module's sole window frame. All administrator operations
 * are made here.<br><br>
 * 
 * Internally manages its own side panel for proper navigation between
 * the different management panels of this module.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class MainFrame extends JFrame {

	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Custom content pane for this Frame
	 */
	private JPanel jpnlContentPane;
	
	/**
	 * The current shown panel (to the right)
	 */
	private JPanel jpnlCurrentShownPanel;
	
	/**
	 * Station Management Panel of this module.
	 */
	private StationManagementPanel stationManagementPanel;
	
	/**
	 * Machine Management Panel of this module.
	 */
	private MachineManagementPanel machineManagementPanel;
	
	/**
	 * Sales Monitoring Panel of this module.
	 */
	private SalesMonitoringPanel salesMonitoringPanel;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setMinimumSize(new Dimension(800, 450));
		
		/* Frame Properties */
		setTitle("PNR Administrator");
		setBounds(100, 100, 727, 482);
		/* END OF Frame Properties */
		
		/* jpnlContentPane - custom content pane for this frame */
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(null);
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.X_AXIS));
		/* END OF jpnlContentPane */
		
		/* jpnlSidebar - sidebar panel shown on the left, uses BoxLayout to lay its components */
		JPanel jpnlSidebar = new JPanel();
		jpnlSidebar.setBackground(Color.BLUE);
		jpnlSidebar.setMaximumSize(new Dimension(180, 32767));
		jpnlSidebar.setMinimumSize(new Dimension(180, 10));
		jpnlContentPane.add(jpnlSidebar);
		jpnlSidebar.setLayout(new BoxLayout(jpnlSidebar, BoxLayout.Y_AXIS));
		/* END OF jpnlSidebar */
		
		/* jlblSidebarHeader - header label in the sidebar */
		JLabel jlblSidebarHeader = new JLabel("<html>PNR Modern<br>Ticketing System</html>");
		jlblSidebarHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
		jlblSidebarHeader.setForeground(Color.WHITE);
		jlblSidebarHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		jpnlSidebar.add(jlblSidebarHeader);
		/* END OF jlblSidebarHeader */
		
		// Spacing for the sidebar before the buttons
		jpnlSidebar.add(Box.createRigidArea(new Dimension(0, 30)));
		
		/* jbtnStationPanel - button for showing the station management panel */
		JButton jbtnStationPanel = new JButton("Stations");
		jbtnStationPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnStationPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If the current shown panel is station management panel,
				// do nothing.
				if(jpnlCurrentShownPanel == stationManagementPanel)
					return;
				
				// Else, if the current shown panel is another,
				// remove it from the content pane
				else if(jpnlCurrentShownPanel != null)
					jpnlContentPane.remove(jpnlCurrentShownPanel);

				// Refresh the table
				stationManagementPanel.refreshTable();
				// Set current shown panel (pointer) to stationManagementPanel
				jpnlCurrentShownPanel = stationManagementPanel;
				// Add stationManagementPanel to the content pane
				jpnlContentPane.add(stationManagementPanel);
				// Redraw the frame
				revalidate();
			}
		});
		jbtnStationPanel.setMinimumSize(new Dimension(200, 35));
		jbtnStationPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnStationPanel.setForeground(Color.WHITE);
		jbtnStationPanel.setBackground(Color.BLUE);
		jbtnStationPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		jbtnStationPanel.setFocusPainted(false);
		jbtnStationPanel.setBorderPainted(false);
		jbtnStationPanel.setMaximumSize(new Dimension(32767, 35));
		jpnlSidebar.add(jbtnStationPanel);
		
		JButton jbtnMachinesPanel = new JButton("Machine Management");
		jbtnMachinesPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				if(jpnlCurrentShownPanel == machineManagementPanel)
					return;
				
				else if(jpnlCurrentShownPanel != null)
					jpnlContentPane.remove(jpnlCurrentShownPanel);
				
				machineManagementPanel.refreshtbl();
				// Set current shown panel (pointer) to MachineManagementPanel
				jpnlCurrentShownPanel = machineManagementPanel;
				// Add MachineManagementPanel to the content pane
				jpnlContentPane.add(machineManagementPanel);
				// Redraw the frame
				revalidate();
				repaint();
			}
		});
		jbtnMachinesPanel.setMinimumSize(new Dimension(200, 35));
		jbtnMachinesPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnMachinesPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnMachinesPanel.setForeground(Color.WHITE);
		jbtnMachinesPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnMachinesPanel.setFocusPainted(false);
		jbtnMachinesPanel.setBorderPainted(false);
		jbtnMachinesPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		jbtnMachinesPanel.setBackground(Color.BLUE);
		jpnlSidebar.add(jbtnMachinesPanel);
		
		JButton jbtnSalesPanel = new JButton("Ticket Sales");
		jbtnSalesPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If the current shown panel is sales monitoring panel
				if(jpnlCurrentShownPanel == salesMonitoringPanel)
					return;
				
				// Else, if the current shown panel is another,
				// remove it from the content pane
				else if(jpnlCurrentShownPanel != null)
					jpnlContentPane.remove(jpnlCurrentShownPanel);
				
				// Refresh the panel
				salesMonitoringPanel.refresh();
				// Set current shown panel (pointer) to salesMonitoringPanel
				jpnlCurrentShownPanel = salesMonitoringPanel;
				// Add salesMonitoringPanel to the content pane
				jpnlContentPane.add(salesMonitoringPanel);
				// Redraw the frame
				revalidate();
			}
		});
		jbtnSalesPanel.setMinimumSize(new Dimension(200, 35));
		jbtnSalesPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnSalesPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSalesPanel.setForeground(Color.WHITE);
		jbtnSalesPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnSalesPanel.setFocusPainted(false);
		jbtnSalesPanel.setBorderPainted(false);
		jbtnSalesPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		jbtnSalesPanel.setBackground(Color.BLUE);
		jpnlSidebar.add(jbtnSalesPanel);
		/* END OF jbtnStationPanel */
	}
	
	/**
	 * Sets the station management panel that this frame should handle and show.<br><br>
	 * 
	 * For developers:<br>
	 * Note that this class does not instantiate its own panel, but rather relies on somebody
	 * else to give it its management panel, i.e. the main method.
	 * 
	 * @param stationManagementPanel
	 */
	public void setStationManagementPanel(StationManagementPanel stationManagementPanel) {
		this.stationManagementPanel = stationManagementPanel;
	}
	
	public void setMachineManagementPanel(MachineManagementPanel machineManagementPanel) {
		this.machineManagementPanel = machineManagementPanel;
	}
	
	public void setSalesMonitoringPanel(SalesMonitoringPanel salesMonitoringPanel) {
		this.salesMonitoringPanel = salesMonitoringPanel;
	}

}
