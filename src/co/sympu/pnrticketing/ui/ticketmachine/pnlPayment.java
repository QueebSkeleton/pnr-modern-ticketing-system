package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class pnlPayment extends JPanel {
	
	 
	protected JTextField txtMoney;
	protected KioskMachine objKiosk;
	
	
	public pnlPayment() {
		this.setLayout(new BorderLayout());
		
		// panel for the steps
		JPanel pnlSteps = new JPanel();
		pnlSteps.setBackground(Color.WHITE);
		add(pnlSteps, BorderLayout.NORTH);
		
		//img for steps
		JLabel lblimgSteps = new JLabel("");
		
		
		//adding img
		Image imgSteps = new ImageIcon(this.getClass().getResource("/PNR-4.jpg")).getImage();
		pnlSteps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblimgSteps.setIcon(new ImageIcon(imgSteps));
		pnlSteps.add(lblimgSteps);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		add(pnlContent, BorderLayout.CENTER);
		
		JLabel lblTitle = new JLabel("Please enter your money:\r\n");
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		
		txtMoney = new JTextField();
		txtMoney.setBackground(Color.LIGHT_GRAY);
		txtMoney.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		txtMoney.setColumns(10);
		txtMoney.setHorizontalAlignment(JTextField.CENTER);
		
		//Ticket objTicket = new Ticket();
		//objTicket.setMoney(Float.parseFloat(txtMoney.getText()));
		
		
		
		
		GroupLayout gl_pnlContent = new GroupLayout(pnlContent);
		gl_pnlContent.setHorizontalGroup(
			gl_pnlContent.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(233)
							.addComponent(lblTitle))
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(505)
							.addComponent(txtMoney, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(421, Short.MAX_VALUE))
		);
		gl_pnlContent.setVerticalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGap(35)
					.addComponent(lblTitle)
					.addGap(71)
					.addComponent(txtMoney, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		pnlContent.setLayout(gl_pnlContent);
		
		this.setSize(1500, 400);
	}
}
