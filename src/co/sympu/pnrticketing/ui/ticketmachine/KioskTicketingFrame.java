package co.sympu.pnrticketing.ui.ticketmachine;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

@SuppressWarnings("serial")
public class KioskTicketingFrame extends JFrame {

	private JPanel contentPane;
	
	public KioskTicketingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton(">");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("<");
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Choose Destination");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JRadioButton rdbtn1 = new JRadioButton("Blumentrit");
		GridBagConstraints gbc_rdbtn1 = new GridBagConstraints();
		gbc_rdbtn1.anchor = GridBagConstraints.WEST;
		gbc_rdbtn1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn1.gridx = 1;
		gbc_rdbtn1.gridy = 1;
		panel_1.add(rdbtn1, gbc_rdbtn1);
		
		JRadioButton rdbtn6 = new JRadioButton("Paco");
		GridBagConstraints gbc_rdbtn6 = new GridBagConstraints();
		gbc_rdbtn6.anchor = GridBagConstraints.WEST;
		gbc_rdbtn6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn6.gridx = 3;
		gbc_rdbtn6.gridy = 1;
		panel_1.add(rdbtn6, gbc_rdbtn6);
		
		JRadioButton rdbtn11 = new JRadioButton("EDSA");
		GridBagConstraints gbc_rdbtn11 = new GridBagConstraints();
		gbc_rdbtn11.anchor = GridBagConstraints.WEST;
		gbc_rdbtn11.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn11.gridx = 5;
		gbc_rdbtn11.gridy = 1;
		panel_1.add(rdbtn11, gbc_rdbtn11);
		
		JRadioButton rdbtn16 = new JRadioButton("Alabang");
		GridBagConstraints gbc_rdbtn16= new GridBagConstraints();
		gbc_rdbtn16.anchor = GridBagConstraints.WEST;
		gbc_rdbtn16.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn16.gridx = 7;
		gbc_rdbtn16.gridy = 1;
		panel_1.add(rdbtn16, gbc_rdbtn16);
		
		JRadioButton rdbtn21 = new JRadioButton("Bi\u00F1an");
		GridBagConstraints gbc_rdbtn21 = new GridBagConstraints();
		gbc_rdbtn21.anchor = GridBagConstraints.WEST;
		gbc_rdbtn21.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn21.gridx = 9;
		gbc_rdbtn21.gridy = 1;
		panel_1.add(rdbtn21, gbc_rdbtn21);
		
		JRadioButton rdbtn2 = new JRadioButton("Laon Laan");
		GridBagConstraints gbc_rdbtn2 = new GridBagConstraints();
		gbc_rdbtn2.anchor = GridBagConstraints.WEST;
		gbc_rdbtn2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn2.gridx = 1;
		gbc_rdbtn2.gridy = 2;
		panel_1.add(rdbtn2, gbc_rdbtn2);
		
		JRadioButton rdbtn7 = new JRadioButton("San Andres");
		GridBagConstraints gbc_rdbtn7 = new GridBagConstraints();
		gbc_rdbtn7.anchor = GridBagConstraints.WEST;
		gbc_rdbtn7.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn7.gridx = 3;
		gbc_rdbtn7.gridy = 2;
		panel_1.add(rdbtn7, gbc_rdbtn7);
		
		JRadioButton rdbtn12 = new JRadioButton("Nichols");
		GridBagConstraints gbc_rdbtn12 = new GridBagConstraints();
		gbc_rdbtn12.anchor = GridBagConstraints.WEST;
		gbc_rdbtn12.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn12.gridx = 5;
		gbc_rdbtn12.gridy = 2;
		panel_1.add(rdbtn12, gbc_rdbtn12);
		
		JRadioButton rdbtn17 = new JRadioButton("Muntinlupa");
		GridBagConstraints gbc_rdbtn17 = new GridBagConstraints();
		gbc_rdbtn17.anchor = GridBagConstraints.WEST;
		gbc_rdbtn17.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn17.gridx = 7;
		gbc_rdbtn17.gridy = 2;
		panel_1.add(rdbtn17, gbc_rdbtn17);
		
		JRadioButton rdbtn22 = new JRadioButton("Sta. Rosa");
		GridBagConstraints gbc_rdbtn22 = new GridBagConstraints();
		gbc_rdbtn22.anchor = GridBagConstraints.WEST;
		gbc_rdbtn22.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn22.gridx = 9;
		gbc_rdbtn22.gridy = 2;
		panel_1.add(rdbtn22, gbc_rdbtn22);
		
		JRadioButton rdbtn3 = new JRadioButton("Espa\u00F1a");
		GridBagConstraints gbc_rdbtn3 = new GridBagConstraints();
		gbc_rdbtn3.anchor = GridBagConstraints.WEST;
		gbc_rdbtn3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn3.gridx = 1;
		gbc_rdbtn3.gridy = 3;
		panel_1.add(rdbtn3, gbc_rdbtn3);
		
		JRadioButton rdbtn8 = new JRadioButton("Vito Cruz");
		GridBagConstraints gbc_rdbtn8 = new GridBagConstraints();
		gbc_rdbtn8.anchor = GridBagConstraints.WEST;
		gbc_rdbtn8.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn8.gridx = 3;
		gbc_rdbtn8.gridy = 3;
		panel_1.add(rdbtn8, gbc_rdbtn8);
		
		JRadioButton rdbtn13 = new JRadioButton("FTI");
		GridBagConstraints gbc_rdbtn13 = new GridBagConstraints();
		gbc_rdbtn13.anchor = GridBagConstraints.WEST;
		gbc_rdbtn13.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn13.gridx = 5;
		gbc_rdbtn13.gridy = 3;
		panel_1.add(rdbtn13, gbc_rdbtn13);
		
		JRadioButton rdbtn18 = new JRadioButton("San Pedro");
		GridBagConstraints gbc_rdbtn18 = new GridBagConstraints();
		gbc_rdbtn18.anchor = GridBagConstraints.WEST;
		gbc_rdbtn18.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn18.gridx = 7;
		gbc_rdbtn18.gridy = 3;
		panel_1.add(rdbtn18, gbc_rdbtn18);
		
		JRadioButton rdbtn23 = new JRadioButton("Cabuyao");
		GridBagConstraints gbc_rdbtn23 = new GridBagConstraints();
		gbc_rdbtn23.anchor = GridBagConstraints.WEST;
		gbc_rdbtn23.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn23.gridx = 9;
		gbc_rdbtn23.gridy = 3;
		panel_1.add(rdbtn23, gbc_rdbtn23);
		
		JRadioButton rdbtn4 = new JRadioButton("Sta. Mesa");
		GridBagConstraints gbc_rdbtn4 = new GridBagConstraints();
		gbc_rdbtn4.anchor = GridBagConstraints.WEST;
		gbc_rdbtn4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn4.gridx = 1;
		gbc_rdbtn4.gridy = 4;
		panel_1.add(rdbtn4, gbc_rdbtn4);
		
		JRadioButton rdbtn9 = new JRadioButton("Buendia");
		GridBagConstraints gbc_rdbtn9 = new GridBagConstraints();
		gbc_rdbtn9.anchor = GridBagConstraints.WEST;
		gbc_rdbtn9.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn9.gridx = 3;
		gbc_rdbtn9.gridy = 4;
		panel_1.add(rdbtn9, gbc_rdbtn9);
		
		JRadioButton rdbtn14 = new JRadioButton("Bicutan");
		GridBagConstraints gbc_rdbtn14 = new GridBagConstraints();
		gbc_rdbtn14.anchor = GridBagConstraints.WEST;
		gbc_rdbtn14.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn14.gridx = 5;
		gbc_rdbtn14.gridy = 4;
		panel_1.add(rdbtn14, gbc_rdbtn14);
		
		JRadioButton rdbtn19 = new JRadioButton("Pacita Main Gate");
		GridBagConstraints gbc_rdbtn19 = new GridBagConstraints();
		gbc_rdbtn19.anchor = GridBagConstraints.WEST;
		gbc_rdbtn19.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn19.gridx = 7;
		gbc_rdbtn19.gridy = 4;
		panel_1.add(rdbtn19, gbc_rdbtn19);
		
		JRadioButton rdbtn24 = new JRadioButton("Mamatid");
		GridBagConstraints gbc_rdbtn24 = new GridBagConstraints();
		gbc_rdbtn24.anchor = GridBagConstraints.WEST;
		gbc_rdbtn24.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn24.gridx = 9;
		gbc_rdbtn24.gridy = 4;
		panel_1.add(rdbtn24, gbc_rdbtn24);
		
		JRadioButton rdbtn5 = new JRadioButton("Pandacan");
		GridBagConstraints gbc_rdbtn5 = new GridBagConstraints();
		gbc_rdbtn5.anchor = GridBagConstraints.WEST;
		gbc_rdbtn5.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn5.gridx = 1;
		gbc_rdbtn5.gridy = 5;
		panel_1.add(rdbtn5, gbc_rdbtn5);
		
		JRadioButton rdbtn10 = new JRadioButton("Pasay Road");
		GridBagConstraints gbc_rdbtn10 = new GridBagConstraints();
		gbc_rdbtn10.anchor = GridBagConstraints.WEST;
		gbc_rdbtn10.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn10.gridx = 3;
		gbc_rdbtn10.gridy = 5;
		panel_1.add(rdbtn10, gbc_rdbtn10);
		
		JRadioButton rdbtn15 = new JRadioButton("Sucat");
		GridBagConstraints gbc_rdbtn15 = new GridBagConstraints();
		gbc_rdbtn15.anchor = GridBagConstraints.WEST;
		gbc_rdbtn15.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn15.gridx = 5;
		gbc_rdbtn15.gridy = 5;
		panel_1.add(rdbtn15, gbc_rdbtn15);
		
		JRadioButton rdbtn20 = new JRadioButton("Golden City 1");
		GridBagConstraints gbc_rdbtn20 = new GridBagConstraints();
		gbc_rdbtn20.anchor = GridBagConstraints.WEST;
		gbc_rdbtn20.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn20.gridx = 7;
		gbc_rdbtn20.gridy = 5;
		panel_1.add(rdbtn20, gbc_rdbtn20);
		
		JRadioButton rdbtn25 = new JRadioButton("Calamba");
		GridBagConstraints gbc_rdbtn25 = new GridBagConstraints();
		gbc_rdbtn25.anchor = GridBagConstraints.WEST;
		gbc_rdbtn25.gridx = 9;
		gbc_rdbtn25.gridy = 5;
		panel_1.add(rdbtn25, gbc_rdbtn25);
		
		ButtonGroup grpDestination = new ButtonGroup();
		grpDestination.add(rdbtn1);
		grpDestination.add(rdbtn2);
		grpDestination.add(rdbtn3);
		grpDestination.add(rdbtn4);
		grpDestination.add(rdbtn5);
		grpDestination.add(rdbtn6);
		grpDestination.add(rdbtn7);
		grpDestination.add(rdbtn8);
		grpDestination.add(rdbtn9);
		grpDestination.add(rdbtn10);
		grpDestination.add(rdbtn11);
		grpDestination.add(rdbtn12);
		grpDestination.add(rdbtn13);
		grpDestination.add(rdbtn14);
		grpDestination.add(rdbtn15);
		grpDestination.add(rdbtn16);
		grpDestination.add(rdbtn17);
		grpDestination.add(rdbtn18);
		grpDestination.add(rdbtn19);
		grpDestination.add(rdbtn20);
		grpDestination.add(rdbtn21);
		grpDestination.add(rdbtn22);
		grpDestination.add(rdbtn23);
		grpDestination.add(rdbtn24);
		grpDestination.add(rdbtn25);
	
	}
}
