package co.sympu.pnrticketing.ui.ticketmachine;

public class TicketMachineMain {
	public static void main(String[] args) {
	
	LoginDialog login = new LoginDialog();
	login.setVisible(true);
	
	KioskTicketingFrame window = new KioskTicketingFrame(); 
	window.setVisible(true);
		
	
	}
}
