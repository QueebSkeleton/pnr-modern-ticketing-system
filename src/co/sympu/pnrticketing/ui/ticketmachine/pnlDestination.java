package co.sympu.pnrticketing.ui.ticketmachine;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class pnlDestination extends JPanel {
	
	Connection objCon;
	protected ButtonGroup grpStations;
	protected KioskMachine objKiosk;
		public pnlDestination() {	
		
		//establish connection
		Createconn();
		
		this.setLayout(new BorderLayout());
		// panel for the steps
		JPanel pnlSteps = new JPanel();
		pnlSteps.setBackground(Color.WHITE);
		add(pnlSteps, BorderLayout.NORTH);
		
		//img for steps
		JLabel lblimgSteps = new JLabel("");
		
		
		//adding img
		Image imgSteps = new ImageIcon(this.getClass().getResource("/PNR-2.jpg")).getImage();
		pnlSteps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblimgSteps.setIcon(new ImageIcon(imgSteps));
		pnlSteps.add(lblimgSteps);
		
		//adding pnlContent
		JPanel pnlContent = new JPanel();
		this.add(pnlContent,BorderLayout.CENTER);
		pnlContent.setBackground(Color.WHITE);
		pnlContent.setLayout(new BorderLayout(0, 0));
		
		//add scrollpane for navigation in radiobuttons
		JScrollPane scrollPane = new JScrollPane();
		pnlContent.add(scrollPane, BorderLayout.CENTER);
		
		JPanel pnlButtons = new JPanel();
		scrollPane.setViewportView(pnlButtons);
		pnlButtons.setLayout(new GridLayout(0,5,5,5));
		
				//[REFERENCE FONT]lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		//Adding JButtons
		
		//create a statement
		
		try {
			
			Statement objStmt = objCon.createStatement();
			
			//execute query
			
			ResultSet objRS = objStmt.executeQuery("SELECT name FROM station WHERE id != '"+LoginDialog.assigned_id+"' ");
		
			
			while(objRS.next()) {
				String strStation = objRS.getString("name");
				pnlButtons.add(new JRadioButton(strStation));
			}
			
			objRS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create a button group for jradiobuttons
		
		grpStations = new ButtonGroup();
		
		Component[] cmpButtons = pnlButtons.getComponents();
		for(Component component : cmpButtons) {
			grpStations.add((JRadioButton) component);
			component.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		}
		
		
		
		this.setSize(1370, 460);

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
		
		
	}//void Createconn()

}
