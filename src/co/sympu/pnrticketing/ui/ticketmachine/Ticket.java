package co.sympu.pnrticketing.ui.ticketmachine;

public class Ticket {

	
	
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getMoney() {
		return Money;
	}
	public void setMoney(float money) {
		Money = money;
	}
	
	private String Destination;
	private int Quantity;
	private float Money;
	
	
	
}
