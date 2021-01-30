package co.sympu.pnrticketing;

import javax.swing.SwingUtilities;

import co.sympu.pnrticketing.ui.stationmgmt.MainFrame;

/**
 * Main entry point of the application.<br><br>
 *
 */
public class PnrModernTicketingApplication {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame stationManagementFrame = new MainFrame();
				stationManagementFrame.setVisible(true);
			}
		});
		
	}

}
