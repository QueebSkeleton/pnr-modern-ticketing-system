package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pnlThankU extends JPanel {

	
	public pnlThankU() {

		this.setLayout(new BorderLayout());
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		add(pnlContent, BorderLayout.CENTER);
		

		JLabel lblNewLabel = new JLabel("<html>Thank You!<h1 style=\"text-align:center\">Your ticket is now being printed<h1/><html/>");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 99));
		pnlContent.add(lblNewLabel);
		

		this.setSize(1500, 400);
	}

}
