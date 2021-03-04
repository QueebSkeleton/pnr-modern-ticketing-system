package co.sympu.pnrticketing.ui.ticketmachine;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class pnlTicketQuantity extends JPanel {
	private JTextField txtQuantity;


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
		
		JLabel lblNewLabel = new JLabel("Please choose ticket quantity:\r\n");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		JButton btnPlus = new JButton("+\r\n");
		btnPlus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		txtQuantity = new JTextField();
		txtQuantity.setEditable(false);
		txtQuantity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		txtQuantity.setBackground(Color.LIGHT_GRAY);
		txtQuantity.setColumns(10);
		txtQuantity.setHorizontalAlignment(JTextField.CENTER);
		
		//int quantity
		int intQuantity = 0;
		String strQuantity = Integer.toString(intQuantity);
		txtQuantity.setText(strQuantity);
		
		GroupLayout gl_pnlContent = new GroupLayout(pnlContent);
		gl_pnlContent.setHorizontalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(233)
							.addComponent(lblNewLabel))
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGap(505)
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnMinus, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnPlus, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
					.addGap(357))
		);
		gl_pnlContent.setVerticalGroup(
			gl_pnlContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContent.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addGap(71)
					.addGroup(gl_pnlContent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_pnlContent.createSequentialGroup()
							.addGroup(gl_pnlContent.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMinus, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
								.addComponent(btnPlus, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(133))))
		);
		pnlContent.setLayout(gl_pnlContent);
		
		this.setSize(1500, 400);
		
		
	}
}
