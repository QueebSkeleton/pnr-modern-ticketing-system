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
		

		
		GroupLayout gl_pnlContent = new GroupLayout(pnlContent);
		gl_pnlContent.setHorizontalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
								.addComponent(ttlChange)
								.addGroup(gl_pnlContent.createSequentialGroup()
									.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
										.addComponent(ttlDestination)
										.addComponent(ttlPrice))
									.addGap(327)
									.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
										.addComponent(ttlPayment)
										.addComponent(ttlQty)))))
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(230)
							.addComponent(lblPayment)))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_pnlContent.setVerticalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGap(35)
					.addComponent(lblPayment)
					.addGap(31)
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.BASELINE)
						.addComponent(ttlDestination)
						.addComponent(ttlQty))
					.addGap(18)
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.BASELINE)
						.addComponent(ttlPrice)
						.addComponent(ttlPayment))
					.addGap(18)
					.addComponent(ttlChange)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		pnlContent.setLayout(gl_pnlContent);
		
		this.setSize(1500, 400);
	}

}
