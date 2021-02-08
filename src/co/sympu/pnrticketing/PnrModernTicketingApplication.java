package co.sympu.pnrticketing;

import javax.swing.SwingUtilities;

import com.mysql.cj.jdbc.MysqlDataSource;

import co.sympu.pnrticketing.repository.StationRepository;
import co.sympu.pnrticketing.ui.MainFrame;
import co.sympu.pnrticketing.ui.stationmgmt.StationManagementPanel;

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
		
		// Create the station management panel that the whole application will use,
		// wiring its needed repository.
		StationManagementPanel stationManagementPanel = new StationManagementPanel();
		stationManagementPanel.setStationRepository(stationRepository);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Create the main frame
				MainFrame mainFrame = new MainFrame();
				// Set everything it needs
				mainFrame.setStationManagementPanel(stationManagementPanel);
				// Show the frame
				mainFrame.setVisible(true);
			}
		});
		
	}

}
