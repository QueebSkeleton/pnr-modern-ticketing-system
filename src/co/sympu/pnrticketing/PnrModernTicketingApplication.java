package co.sympu.pnrticketing;

import javax.swing.SwingUtilities;

import com.mysql.cj.jdbc.MysqlDataSource;

import co.sympu.pnrticketing.repository.StationRepository;
import co.sympu.pnrticketing.ui.stationmgmt.MainFrame;

/**
 * Main entry point of the application.<br><br>
 *
 */
public class PnrModernTicketingApplication {
	
	public static void main(String[] args) {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/pnr_db");
		dataSource.setUser("pnr_app");
		dataSource.setPassword("password123");
		
		StationRepository stationRepository = new StationRepository(dataSource);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame stationManagementFrame = new MainFrame();
				stationManagementFrame.setStationRepository(stationRepository);
				stationManagementFrame.setVisible(true);
			}
		});
		
	}

}
