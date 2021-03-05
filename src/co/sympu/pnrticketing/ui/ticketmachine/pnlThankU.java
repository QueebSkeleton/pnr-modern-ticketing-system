package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class pnlThankU extends JPanel {


	protected KioskMachine objKiosk;
	
	public pnlThankU() {

		this.setLayout(new BorderLayout());
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		add(pnlContent, BorderLayout.CENTER);
		

		JLabel lblNewLabel = new JLabel("<html>Thank You!<h1 style=\"text-align:center\">Your ticket is now being printed<h1/><html/>");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 99));
		GroupLayout gl_pnlContent = new GroupLayout(pnlContent);
		gl_pnlContent.setHorizontalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlContent.createSequentialGroup()
					.addContainerGap(462, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 898, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnlContent.setVerticalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGap(112)
					.addComponent(lblNewLabel)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		pnlContent.setLayout(gl_pnlContent);
		

		this.setSize(1500, 400);
	}

}
