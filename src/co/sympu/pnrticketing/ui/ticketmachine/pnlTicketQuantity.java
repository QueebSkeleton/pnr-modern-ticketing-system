package co.sympu.pnrticketing.ui.ticketmachine;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class pnlTicketQuantity extends JPanel {


	public pnlTicketQuantity() {
		KioskMachine.Counter = 1;
		this.setLayout(new BorderLayout());
		
		JPanel pnlSteps = new JPanel();
		pnlSteps.setBackground(Color.WHITE);
		add(pnlSteps, BorderLayout.NORTH);
	
		//img for steps
		JLabel lblimgSteps = new JLabel("");
		
		
		//adding img
		Image imgSteps = new ImageIcon(this.getClass().getResource("/PNR-3.jpg")).getImage();
		pnlSteps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblimgSteps.setIcon(new ImageIcon(imgSteps));
		pnlSteps.add(lblimgSteps);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		add(pnlContent, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("TICKET QUANTITY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		pnlContent.add(lblNewLabel);
		
		this.setSize(1500, 400);
		
		
	}

}
