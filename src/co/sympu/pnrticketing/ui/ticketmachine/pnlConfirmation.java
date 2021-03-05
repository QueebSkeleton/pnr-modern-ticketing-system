package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class pnlConfirmation extends JPanel {
	
	protected JLabel Qty;
	protected JLabel Payment;
	protected KioskMachine objMachine;
	
	public pnlConfirmation() {
		this.setLayout(new BorderLayout());
		
		
		// panel for the steps
		JPanel pnlSteps = new JPanel();
		pnlSteps.setBackground(Color.WHITE);
		add(pnlSteps, BorderLayout.NORTH);
		
		//img for steps
		JLabel lblimgSteps = new JLabel("");
		
		
		//adding img
		Image imgSteps = new ImageIcon(this.getClass().getResource("/PNR-5.jpg")).getImage();
		pnlSteps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblimgSteps.setIcon(new ImageIcon(imgSteps));
		pnlSteps.add(lblimgSteps);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		add(pnlContent, BorderLayout.CENTER);
		
		JLabel lblPayment = new JLabel("Please confirm ticket details before proceeding");
		lblPayment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		
		JLabel ttlDestination = new JLabel("Destination:");
		ttlDestination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel ttlChange = new JLabel("Change:\r\n");
		ttlChange.setForeground(Color.RED);
		ttlChange.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel ttlPrice = new JLabel("Price:\r\n");
		ttlPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel ttlQty = new JLabel("Qty:");
		ttlQty.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel ttlPayment = new JLabel("Payment:\r\n");
		ttlPayment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel Destination = new JLabel("\r\n");
		Destination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel Price = new JLabel("");
		Price.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JLabel Change = new JLabel("");
		Change.setForeground(Color.BLACK);
		Change.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		Payment = new JLabel("");
		Payment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
	
		
		Qty = new JLabel("");
		Qty.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		

		
		GroupLayout gl_pnlContent = new GroupLayout(pnlContent);
		gl_pnlContent.setHorizontalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlContent.createSequentialGroup()
									.addComponent(ttlChange)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Change, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlContent.createSequentialGroup()
									.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlContent.createSequentialGroup()
											.addComponent(ttlDestination)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Destination, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlContent.createSequentialGroup()
											.addComponent(ttlPrice)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Price, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
									.addGap(80)
									.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlContent.createSequentialGroup()
											.addComponent(ttlPayment)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Payment, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlContent.createSequentialGroup()
											.addComponent(ttlQty)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(Qty, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(230)
							.addComponent(lblPayment)))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		gl_pnlContent.setVerticalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGap(35)
					.addComponent(lblPayment)
					.addGap(31)
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.BASELINE)
						.addComponent(ttlDestination)
						.addComponent(ttlQty)
						.addComponent(Destination, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(Qty, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_pnlContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(ttlPrice)
								.addComponent(ttlPayment)
								.addComponent(Payment, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(18)
							.addComponent(Price, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addComponent(ttlChange)
						.addComponent(Change, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		pnlContent.setLayout(gl_pnlContent);
		
		this.setSize(1500, 400);
	}
}
