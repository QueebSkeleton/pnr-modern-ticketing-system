package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Image;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


@SuppressWarnings("serial")
public class KioskMachine extends JFrame {
	
	protected static int Counter;
	private int btnClick;

	public KioskMachine() {
		
		setTitle("Ticket Machine");
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setPreferredSize(new Dimension(1370, 768));

		// creating a title panel
		JPanel pnlTitle = new JPanel();
		getContentPane().add(pnlTitle, BorderLayout.NORTH);
		pnlTitle.setBackground(new Color(138, 196, 223));

		// adding the title name
		JLabel lblLogo = new JLabel("<html>Philippine National Railways <br/>"
				+ "<h1 style=\\\"text-align:center;\\\">Est.1892</h1><html/>");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		lblLogo.setOpaque(false);

		// adding icon in Title
		Image imgLogo = new ImageIcon(this.getClass().getResource("/pnrLogo.png")).getImage();
		pnlTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblLogo.setIcon(new ImageIcon(imgLogo));
		pnlTitle.add(lblLogo);

		// Creating a panel Content that contains panels created from other class
		JPanel pnlContent = new JPanel();
		getContentPane().add(pnlContent, BorderLayout.CENTER);
		pnlContent.setBackground(Color.WHITE);

		// Setting CardLayout to pnlContent

		CardLayout cl = new CardLayout();
		pnlContent.setLayout(cl);

		// --------adding the new panel Destination

		pnlDestination objDestination = new pnlDestination();
		objDestination.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objDestination, "1");

		// --------adding the new panel Ticket Quantity

		pnlTicketQuantity TicketQuantity = new pnlTicketQuantity();
		TicketQuantity.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(TicketQuantity, "2");

		// --------adding the new panel Payment

		pnlPayment objPayment = new pnlPayment();
		objPayment.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objPayment, "3");

		// --------adding the new panel Confirmation

		pnlConfirmation objConfirm = new pnlConfirmation();
		objConfirm.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objConfirm, "4");

		// --------adding the new panel ThankU

		pnlThankU objThanks = new pnlThankU();
		objThanks.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objThanks, "5");

		// first show
		cl.show(pnlContent, "1");

		// creating the button panel
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(Color.WHITE);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		// create Proceed Button
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnProceed.setForeground(Color.WHITE);
		btnProceed.setBackground(Color.GRAY);
		btnProceed.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		btnProceed.setPreferredSize(new Dimension(320, 80));
		btnProceed.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		// setting the layout
		pnlButtons.setLayout(new BorderLayout(0, 0));
		pnlButtons.add(btnProceed, BorderLayout.EAST);
		
		JButton btnGoback = new JButton("Go back...");
		btnGoback.setPreferredSize(new Dimension(320, 80));
		btnGoback.setForeground(Color.WHITE);
		btnGoback.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		btnGoback.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnGoback.setBackground(Color.GRAY);
		pnlButtons.add(btnGoback, BorderLayout.WEST);

		this.setExtendedState(MAXIMIZED_BOTH);
		
		btnClick = 0;
		
			
			
			// adding action listener for btnProceed
			btnGoback.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				cl.previous(pnlContent);;
				--btnClick;
				}
			});
		
		
			// adding action listener for btnProceed
			btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnProceedActionPerformed(e);
				cl.next(pnlContent);
			    //++btnClick;		
				}
			});
			
			if (btnClick == 0) {
				btnGoback.setVisible(false);
			}else {
				btnGoback.setVisible(true);
			}
		

		}
	
		private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {                                         
		    ++btnClick;	
		}     
	}


