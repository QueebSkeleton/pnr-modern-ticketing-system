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

import co.sympu.pnrticketing.ui.admin.accountsmanagment.AccountsManagementPanel;
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
	 * Accounts Management Panel of this module.
	 */
	private AccountsManagementPanel accountsManagementPanel;

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
		jpnlSidebar.setBorder(null);
		jpnlSidebar.setBackground(new Color(51, 102, 255));
		jpnlSidebar.setMaximumSize(new Dimension(225, 32767));
		jpnlSidebar.setMinimumSize(new Dimension(225, 10));
		jpnlContentPane.add(jpnlSidebar);
		jpnlSidebar.setLayout(new BoxLayout(jpnlSidebar, BoxLayout.Y_AXIS));
		/* END OF jpnlSidebar */
		
		/* jlblSidebarHeader - header label in the sidebar */
		
		JLabel jlblMiniHeader = new JLabel("Philippine National Railways");
		jlblMiniHeader.setAlignmentY(0.0f);
		jlblMiniHeader.setForeground(Color.WHITE);
		jlblMiniHeader.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		jlblMiniHeader.setBorder(new EmptyBorder(20, 20, 0, 20));
		jpnlSidebar.add(jlblMiniHeader);
		JLabel jlblSidebarHeader = new JLabel("<html>PNR Modern<br>Ticketing System</html>");
		jlblSidebarHeader.setAlignmentY(0.0f);
		jlblSidebarHeader.setBorder(new EmptyBorder(0, 20, 0, 20));
		jlblSidebarHeader.setForeground(Color.WHITE);
		jlblSidebarHeader.setFont(new Font("Roboto", Font.PLAIN, 20));
		jpnlSidebar.add(jlblSidebarHeader);
		/* END OF jlblSidebarHeader */
		
		// Spacing for the sidebar before the buttons
		jpnlSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
		
		/* jbtnStationPanel - button for showing the station management panel */
		JButton jbtnStationPanel = new JButton("Stations");
		jbtnStationPanel.setAlignmentY(0.0f);
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
				else if(jpnlCurrentShownPanel != null) {
					jpnlContentPane.remove(jpnlCurrentShownPanel);
					revalidate();
				}

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
		jbtnStationPanel.setMinimumSize(new Dimension(200, 40));
		jbtnStationPanel.setFont(new Font("Roboto", Font.PLAIN, 13));
		jbtnStationPanel.setForeground(Color.WHITE);
		jbtnStationPanel.setBackground(new Color(51, 102, 255));
		jbtnStationPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		jbtnStationPanel.setFocusPainted(false);
		jbtnStationPanel.setBorderPainted(false);
		jbtnStationPanel.setMaximumSize(new Dimension(32767, 40));
		jpnlSidebar.add(jbtnStationPanel);
		
		JButton jbtnMachinesPanel = new JButton("Machine Management");
		jbtnMachinesPanel.setAlignmentY(0.0f);
		jbtnMachinesPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				if(jpnlCurrentShownPanel == machineManagementPanel)
					return;
				
				else if(jpnlCurrentShownPanel != null) {
					jpnlContentPane.remove(jpnlCurrentShownPanel);
					revalidate();
				}
				
				machineManagementPanel.refreshtbl();
				// Set current shown panel (pointer) to MachineManagementPanel
				jpnlCurrentShownPanel = machineManagementPanel;
				// Add MachineManagementPanel to the content pane
				jpnlContentPane.add(machineManagementPanel);
				// Redraw the frame
				revalidate();
			}
		});
		jbtnMachinesPanel.setMinimumSize(new Dimension(200, 40));
		jbtnMachinesPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnMachinesPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnMachinesPanel.setForeground(Color.WHITE);
		jbtnMachinesPanel.setFont(new Font("Roboto", Font.PLAIN, 13));
		jbtnMachinesPanel.setFocusPainted(false);
		jbtnMachinesPanel.setBorderPainted(false);
		jbtnMachinesPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		jbtnMachinesPanel.setBackground(new Color(51, 102, 255));
		jpnlSidebar.add(jbtnMachinesPanel);
		
		JButton jbtnSalesPanel = new JButton("Ticket Sales");
		jbtnSalesPanel.setAlignmentY(0.0f);
		jbtnSalesPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If the current shown panel is sales monitoring panel
				if(jpnlCurrentShownPanel == salesMonitoringPanel)
					return;
				
				// Else, if the current shown panel is another,
				// remove it from the content pane
				else if(jpnlCurrentShownPanel != null) {
					jpnlContentPane.remove(jpnlCurrentShownPanel);
					revalidate();
				}
				
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
		jbtnSalesPanel.setMinimumSize(new Dimension(200, 40));
		jbtnSalesPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnSalesPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSalesPanel.setForeground(Color.WHITE);
		jbtnSalesPanel.setFont(new Font("Roboto", Font.PLAIN, 13));
		jbtnSalesPanel.setFocusPainted(false);
		jbtnSalesPanel.setBorderPainted(false);
		jbtnSalesPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		jbtnSalesPanel.setBackground(new Color(51, 102, 255));
		jpnlSidebar.add(jbtnSalesPanel);
		
		JButton jbtnAccountsPanel = new JButton("Accounts Management");
		jbtnAccountsPanel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// If the current shown panel is accounts management panel
					if(jpnlCurrentShownPanel == accountsManagementPanel)
						return;
					
					// Else, if the current shown panel is another,
					// remove it from the content pane
					else if(jpnlCurrentShownPanel != null)
						jpnlContentPane.remove(jpnlCurrentShownPanel);
					
					// Refresh table when the panel is shown
					accountsManagementPanel.refreshTable();
					// Set current shown panel (pointer) to accountsManagementPanel
					jpnlCurrentShownPanel = accountsManagementPanel;
					// Add accountsManagementPanel to the content pane
					jpnlContentPane.add(accountsManagementPanel);
					// Redraw the frame
					revalidate();
			}
		});
		jbtnAccountsPanel.setMinimumSize(new Dimension(200, 35));
		jbtnAccountsPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnAccountsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnAccountsPanel.setForeground(Color.WHITE);
		jbtnAccountsPanel.setFont(new Font("Roboto", Font.PLAIN, 13));
		jbtnAccountsPanel.setFocusPainted(false);
		jbtnAccountsPanel.setBorderPainted(false);
		jbtnAccountsPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		jbtnAccountsPanel.setBackground(new Color(51, 102, 255));
		jpnlSidebar.add(jbtnAccountsPanel);
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
	public void setAccountsManagementPanel(AccountsManagementPanel accountsManagementPanel) {
		this.accountsManagementPanel = accountsManagementPanel;
	}

}
