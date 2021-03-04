package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		JLabel lblNewLabel = new JLabel("CONFIRMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		pnlContent.add(lblNewLabel);
		
		this.setSize(1500, 400);
	}

}
