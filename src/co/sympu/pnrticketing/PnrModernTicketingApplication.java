package co.sympu.pnrticketing;

import javax.swing.SwingUtilities;

import co.sympu.pnrticketing.ui.StationManagementFrame;

/**
 * Main entry point of the application.<br><br>
 *
 */
public class PnrModernTicketingApplication {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				StationManagementFrame stationManagementFrame = new StationManagementFrame();
				stationManagementFrame.setVisible(true);
			}
		});
		
	}

}
