package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


@SuppressWarnings("serial")

public class KioskMachine extends JFrame {
	
	protected static JButton btnProceed;
	
	private int btnClick = 1;	
	private double price;
	private int destination_assigned_id;
	private double change;
	Connection objCon;

	public KioskMachine() {	
		Createconn();
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
		objDestination.objKiosk = this;

		// --------adding the new panel Ticket Quantity

		pnlTicketQuantity TicketQuantity = new pnlTicketQuantity();
		TicketQuantity.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(TicketQuantity, "2");
		TicketQuantity.objKiosk = this;

		// --------adding the new panel Payment

		pnlPayment objPayment = new pnlPayment();
		objPayment.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objPayment, "3");
		objPayment.objKiosk = this;

		// --------adding the new panel Confirmation

		pnlConfirmation objConfirm = new pnlConfirmation();
		objConfirm.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objConfirm, "4");
		objConfirm.objKiosk = this;
		

		// --------adding the new panel ThankU

		pnlThankU objThanks = new pnlThankU();
		objThanks.setPreferredSize(new Dimension(1370, 460));
		pnlContent.add(objThanks, "5");
		objThanks.objKiosk = this;

		// first show
		cl.show(pnlContent, "1");

		// creating the button panel
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(Color.WHITE);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		// create Proceed Button
		btnProceed = new JButton("Proceed");
		btnProceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnProceed.setForeground(Color.WHITE);
		btnProceed.setBackground(Color.GRAY);
		btnProceed.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		btnProceed.setPreferredSize(new Dimension(320, 80));
		btnProceed.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		/*
		// create Confirm button
		
				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				btnConfirm.setForeground(Color.WHITE);
				btnConfirm.setBackground(Color.GRAY);
				btnConfirm.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
				btnConfirm.setPreferredSize(new Dimension(320, 80));
				btnConfirm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				btnConfirm.setVisible(false);
				
		// create Complete button
				
				JButton btnComplete = new JButton("Complete");
				btnComplete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				btnComplete.setForeground(Color.WHITE);
				btnComplete.setBackground(Color.GRAY);
				btnComplete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
				btnComplete.setPreferredSize(new Dimension(320, 80));
				btnComplete.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				btnComplete.setVisible(false);
		*/
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

			btnGoback.setVisible(false);
			
			// adding action listener for btnGoback
			btnGoback.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				 --btnClick;
				 cl.previous(pnlContent);
				 if (btnClick == 1) {
					 btnGoback.setVisible(false);
				 }
				
				}
			});
		
		
			// adding action listener for btnProceed
			btnProceed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					cl.next(pnlContent);
					++btnClick;
					
					if (btnClick == 2) {
						btnGoback.setVisible(true);
						
					}else if (btnClick == 4) {
						
					//showcase the 	receipt
						
						String Destination = getSelectedButtonText(objDestination.grpStations);
						
						//get the destination id
						
						//create a statement
						Statement objStmt;
						
						

						try {
							objStmt = objCon.createStatement();
							//execute query
							ResultSet objRS = objStmt.executeQuery("SELECT id FROM station WHERE name = '"+Destination+"' ");
							objRS.next();
							
							if (objRS != null) {
								
								destination_assigned_id = objRS.getInt("id");	
							}
							objRS.close();
							objStmt.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							objStmt = objCon.createStatement();
							//execute query
							ResultSet objRS = objStmt.executeQuery("SELECT price FROM station_pricing WHERE from_id = '"+LoginDialog.assigned_id+"' AND to_id = '"+destination_assigned_id+"' ");
							objRS.next();
							
							if (objRS != null) {
								price = objRS.getDouble("price");
							}
							objRS.close();
							objStmt.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						objConfirm.Price.setText(Double.toString(price));
						objConfirm.Destination.setText(Destination);
						
						double money = Double.parseDouble(objPayment.txtMoney.getText());
						int quantity = Integer.parseInt(TicketQuantity.txtQuantity.getText());
						
						change = money - (quantity * price);
						
						objConfirm.Change.setText(Double.toString(change));
						objConfirm.Payment.setText(objPayment.txtMoney.getText());
						objConfirm.Qty.setText(TicketQuantity.txtQuantity.getText());
						
					}else if (btnClick == 5) {
					
					//jdbc 
						
						try {
	
							Statement insertStatement = objCon.createStatement();

							String insertSqlStatement = "INSERT INTO ticket VALUES";
							
							int intTerminator = Integer.parseInt(TicketQuantity.txtQuantity.getText());
							
							// depending on quantity inputted, loop then construct the sql string
							do {
							            
							    insertSqlStatement += "(NULL," + LoginDialog.assigned_id + ", " + destination_assigned_id + ", NOW(), " + price + ")";
							            
							  if (intTerminator == 1)
							    break; 
							  else 
							    insertSqlStatement += ",";
							            
							  intTerminator--;
							} while (intTerminator != 0); 
							        
							insertStatement.execute(insertSqlStatement);
							
							insertStatement.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					//clear selection
					objDestination.grpStations.clearSelection();
					objPayment.txtMoney.setText("");
					TicketQuantity.txtQuantity.setText("");
						
					//setVisible false to btnGoback
						btnGoback.setVisible(false);
					//btnClick reset to 0
						btnClick = 0;
						
						
					}
				}
			});
			
			/*
			// adding action listener for btnConfirm
						btnConfirm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								btnClick = 0;
								cl.next(pnlContent);
								btnGoback.setVisible(false);
								btnConfirm.setVisible(false);
								btnProceed.setVisible(false);
								btnComplete.setVisible(true);
								pnlButtons.add(btnComplete, BorderLayout.EAST);
							}
						});
			
			// adding action listener for btnConfirm
						btnComplete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								btnClick = 1;
								cl.next(pnlContent);
								btnGoback.setVisible(false);
								btnConfirm.setVisible(false);
								btnComplete.setVisible(false);
								btnProceed.setVisible(true);
								pnlButtons.add(btnProceed, BorderLayout.EAST);
							}
						});
				*/

			this.setExtendedState(MAXIMIZED_BOTH);
			
			

		}
	
		public static String getSelectedButtonText(ButtonGroup buttonGroup) {
			for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				if (button.isSelected()) {
                return button.getText();
            }
        }
			return null;
	
	}
		void Createconn() {
			
			try {
				
				//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//connect to the database
				objCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnr_db","pnr_app", "password123");
				
				
			}catch(Exception objEx) {
				JOptionPane.showMessageDialog(null, objEx);
			}
			

}
}