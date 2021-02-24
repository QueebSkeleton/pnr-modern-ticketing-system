package co.sympu.pnrticketing;

import javax.swing.SwingUtilities;

import com.mysql.cj.jdbc.MysqlDataSource;

import co.sympu.pnrticketing.repository.StationRepository;
import co.sympu.pnrticketing.ui.EntryFrame;
import co.sympu.pnrticketing.ui.admin.MainFrame;
import co.sympu.pnrticketing.ui.admin.machinemngmt.MachineManagementPanel;
import co.sympu.pnrticketing.ui.admin.stationmgmt.StationManagementPanel;
import co.sympu.pnrticketing.ui.cashier.LoginFrame;
import co.sympu.pnrticketing.ui.ticketmachine.LoginDialog;

/**
 * Main entry point of the application.<br><br>
 *
 */
public class PnrModernTicketingApplication {
	
	public static void main(String[] args) {
		
		// Instantiate the sole datasource that the whole application will use,
		// and set the proper credentials it will use
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/pnr_db");
		dataSource.setUser("pnr_app");
		dataSource.setPassword("password123");
		
		// Create the station repository that the whole application will use,
		// wiring its needed datasource.
		StationRepository stationRepository = new StationRepository(dataSource);
		
		// Create the station management panel
		StationManagementPanel stationManagementPanel = new StationManagementPanel();
		stationManagementPanel.setStationRepository(stationRepository);
    
		// Create the machine management panel
		MachineManagementPanel machineManagementPanel = new MachineManagementPanel();
    
		// Create the 3 Entry Point Frames (or whatever)
		// TODO: THIS SHOULD BE 3 LOGIN DIALOGS! (JDialog)
		/* MainFrame - Administrator Entry Point */
		MainFrame mainFrame = new MainFrame();
		mainFrame.setStationManagementPanel(stationManagementPanel);
		mainFrame.setMachineManagementPanel(machineManagementPanel);
		/* END OF MainFrame */
		/* LoginFrame - Cashier Entry Point */
		LoginFrame loginFrame = new LoginFrame();
		/* END OF LoginFrame */
		/* LoginDialog - Ticket-Selling Machine Entry Point */
		LoginDialog loginDialog = new LoginDialog();
		/* END OF LoginDialog */
		
		// Create the Main Entry Frame
		EntryFrame entryFrame = new EntryFrame();
		// Wire the three login entry points to this frame
		entryFrame.setAdministratorEntryPoint(mainFrame);
		entryFrame.setCashierEntryPoint(loginFrame);
		entryFrame.setTicketMachineEntryPoint(loginDialog);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Show the entry frame.
				entryFrame.setVisible(true);
			}
		});
		
	}

}
