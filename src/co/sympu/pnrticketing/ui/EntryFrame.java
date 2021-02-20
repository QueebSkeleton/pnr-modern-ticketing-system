package co.sympu.pnrticketing.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import co.sympu.pnrticketing.ui.ticketerrorhandling.LoginFrame;
import co.sympu.pnrticketing.ui.ticketmachine.LoginDialog;

/**
 * Entry frame of the application. Prompts user on the module to simulate.<br><br>
 * 
 * Wire all needed objects here first before showing this frame.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class EntryFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// Administrator Main Frame
	private MainFrame administratorEntryPoint;
	
	// Cashier Login Frame
	private LoginFrame cashierEntryPoint;
	
	// Ticket Machine Login Dialog
	private LoginDialog ticketMachineEntryPoint;
	
	private JPanel jpnlContentPane;

	/**
	 * Create the frame.
	 */
	public EntryFrame() {
		
		// For referencing in deeper scopes
		EntryFrame thisFrame = this;
		
		/* Frame Properties */
		setPreferredSize(new Dimension(400, 250));
		setMinimumSize(new Dimension(400, 250));
		setTitle("Welcome to PNR Modern Ticketing System!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		/* END OF Frame Properties */
		
		/* jpnlContentPane - overriden content pane of this frame */
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpnlContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(jpnlContentPane);
		/* END OF jpnlContentPane */
		
		/* jpnlMainContainer - contains all main components of this frame */
		JPanel jpnlMainContainer = new JPanel();
		jpnlMainContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpnlContentPane.add(jpnlMainContainer, BorderLayout.CENTER);
		jpnlMainContainer.setLayout(new BoxLayout(jpnlMainContainer, BoxLayout.Y_AXIS));
		/* END OF jpnlMainContainer */
		
		/* jlblHeader - header label */
		JLabel jlblHeader = new JLabel("What module would you like to open?");
		jlblHeader.setAlignmentX(0.5f);
		jlblHeader.setAlignmentY(0.0f);
		jlblHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpnlMainContainer.add(jlblHeader);
		/* END OF jlblHeader */
		
		// Spacing
		jpnlMainContainer.add(Box.createRigidArea(new Dimension(0, 20)));
		
		// Main Button Group of the module choices
		ButtonGroup moduleChoiceGroup = new ButtonGroup();
		
		/* jrdbtnAdministrator - administrator module choice */
		JRadioButton jrdbtnAdministrator = new JRadioButton("Administrator");
		jrdbtnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrdbtnAdministrator.setAlignmentX(0.5f);
		jrdbtnAdministrator.setAlignmentY(0.0f);
		moduleChoiceGroup.add(jrdbtnAdministrator);
		jpnlMainContainer.add(jrdbtnAdministrator);
		/* END OF jrdbtnAdministrator */
		
		// Spacing
		jpnlMainContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		
		/* jrdbtnCashier - cashier module choice */
		JRadioButton jrdbtnCashier = new JRadioButton("Cashier");
		jrdbtnCashier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrdbtnCashier.setAlignmentY(0.0f);
		jrdbtnCashier.setAlignmentX(0.5f);
		moduleChoiceGroup.add(jrdbtnCashier);
		jpnlMainContainer.add(jrdbtnCashier);
		/* END OF jrdbtnCashier */
		
		// Spacing
		jpnlMainContainer.add(Box.createRigidArea(new Dimension(0, 10)));
		
		/* jrdbtnTicketsellingMachine - ticket selling machine module choice */
		JRadioButton jrdbtnTicketsellingMachine = new JRadioButton("Ticket-Selling Machine");
		jrdbtnTicketsellingMachine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrdbtnTicketsellingMachine.setAlignmentY(0.0f);
		jrdbtnTicketsellingMachine.setAlignmentX(0.5f);
		moduleChoiceGroup.add(jrdbtnTicketsellingMachine);
		jpnlMainContainer.add(jrdbtnTicketsellingMachine);
		/* END OF jrdbtnTicketsellingMachine */
		
		/* jpnlButtonActions - panel for button actions */
		JPanel jpnlButtonActions = new JPanel();
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlContentPane.add(jpnlButtonActions, BorderLayout.SOUTH);
		/* END OF jpnlButtonActions */
		
		/* jbtnExit - exit button */
		JButton jbtnExit = new JButton("Exit");
		jpnlButtonActions.add(jbtnExit);
		/* END OF jbtnExit */
		
		/* jbtnProceed - proceed to selected module button */
		JButton jbtnProceed = new JButton("Proceed");
		jbtnProceed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// If administrator module is selected
				if(jrdbtnAdministrator.isSelected())
					administratorEntryPoint.setVisible(true);
				
				// If cashier module is selected
				else if(jrdbtnCashier.isSelected())
					cashierEntryPoint.setVisible(true);
				
				// If ticket selling machine module is selected
				else if(jrdbtnTicketsellingMachine.isSelected())
					ticketMachineEntryPoint.setVisible(true);
				
				// If none is selected
				else
					JOptionPane.showMessageDialog(
							thisFrame,
							"Please select a module to open first.",
							"Select!",
							JOptionPane.WARNING_MESSAGE);
				
			}
		});
		jpnlButtonActions.add(jbtnProceed);
		/* END OF jbtnProceed */
	}

	/**
	 * Wires the administrator entry point that this frame will open
	 * if the respective choice is selected.
	 * 
	 * @param administratorEntryPoint
	 */
	public void setAdministratorEntryPoint(MainFrame administratorEntryPoint) {
		this.administratorEntryPoint = administratorEntryPoint;
	}

	/**
	 * Wires the cashier entry point that this frame will open
	 * if the respective choice is selected.
	 * 
	 * @param cashierEntryPoint
	 */
	public void setCashierEntryPoint(LoginFrame cashierEntryPoint) {
		this.cashierEntryPoint = cashierEntryPoint;
	}
	
	/**
	 * Wires the ticket selling machine entry point that this frame will open
	 * if the respective choice is selected.
	 * 
	 * @param ticketMachineEntryPoint
	 */
	public void setTicketMachineEntryPoint(LoginDialog ticketMachineEntryPoint) {
		this.ticketMachineEntryPoint = ticketMachineEntryPoint;
	}

}
