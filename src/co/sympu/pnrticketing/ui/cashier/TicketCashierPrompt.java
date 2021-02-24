package co.sympu.pnrticketing.ui.cashier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class TicketCashierPrompt extends JFrame {

	private JPanel contentPane;
	private JTextField jtxtfldNoOfTickets;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketCashierPrompt frame = new TicketCashierPrompt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TicketCashierPrompt() {
		setTitle("Cashier Module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel jpnlDestinationHeader = new JPanel();
		jpnlDestinationHeader.setMaximumSize(new Dimension(32767, 22000));
		contentPane.add(jpnlDestinationHeader);
		jpnlDestinationHeader.setLayout(null);
		
		JLabel jlblDestinationHeader = new JLabel("Choose destination");
		jlblDestinationHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlblDestinationHeader.setBounds(10, 11, 130, 25);
		jpnlDestinationHeader.add(jlblDestinationHeader);
		
		JPanel jpnlDestinationOption = new JPanel();
		jpnlDestinationOption.setMaximumSize(new Dimension(32767, 10000));
		contentPane.add(jpnlDestinationOption);
		contentPane.add(jpnlDestinationOption, BorderLayout.CENTER);
		GridBagLayout gbl_jpnlDestinationOption = new GridBagLayout();
		gbl_jpnlDestinationOption.columnWidths = new int[]{42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlDestinationOption.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_jpnlDestinationOption.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlDestinationOption.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlDestinationOption.setLayout(gbl_jpnlDestinationOption);
		
		JRadioButton jrdbtnBluementrit = new JRadioButton("Blumentrit");
		jrdbtnBluementrit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnBluementrit = new GridBagConstraints();
		gbc_jrdbtnBluementrit.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnBluementrit.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnBluementrit.gridx = 1;
		gbc_jrdbtnBluementrit.gridy = 0;
		jpnlDestinationOption.add(jrdbtnBluementrit, gbc_jrdbtnBluementrit);
		
		JRadioButton jrdbtnPaco = new JRadioButton("Paco");
		jrdbtnPaco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnPaco = new GridBagConstraints();
		gbc_jrdbtnPaco.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnPaco.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnPaco.gridx = 3;
		gbc_jrdbtnPaco.gridy = 0;
		jpnlDestinationOption.add(jrdbtnPaco, gbc_jrdbtnPaco);
		
		JRadioButton jrdbtnEDSA = new JRadioButton("EDSA");
		jrdbtnEDSA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnEDSA = new GridBagConstraints();
		gbc_jrdbtnEDSA.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnEDSA.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnEDSA.gridx = 5;
		gbc_jrdbtnEDSA.gridy = 0;
		jpnlDestinationOption.add(jrdbtnEDSA, gbc_jrdbtnEDSA);
		
		JRadioButton jrdbtnAlabang = new JRadioButton("Alabang");
		jrdbtnAlabang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnAlabang= new GridBagConstraints();
		gbc_jrdbtnAlabang.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnAlabang.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnAlabang.gridx = 7;
		gbc_jrdbtnAlabang.gridy = 0;
		jpnlDestinationOption.add(jrdbtnAlabang, gbc_jrdbtnAlabang);
		
		JRadioButton jrdbtnBinan = new JRadioButton("Bi\u00F1an");
		jrdbtnBinan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnBinan = new GridBagConstraints();
		gbc_jrdbtnBinan.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnBinan.insets = new Insets(0, 0, 5, 0);
		gbc_jrdbtnBinan.gridx = 9;
		gbc_jrdbtnBinan.gridy = 0;
		jpnlDestinationOption.add(jrdbtnBinan, gbc_jrdbtnBinan);
		
		JRadioButton jrdbtnLaonLaan = new JRadioButton("Laon Laan");
		jrdbtnLaonLaan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnLaonLaan = new GridBagConstraints();
		gbc_jrdbtnLaonLaan.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnLaonLaan.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnLaonLaan.gridx = 1;
		gbc_jrdbtnLaonLaan.gridy = 1;
		jpnlDestinationOption.add(jrdbtnLaonLaan, gbc_jrdbtnLaonLaan);
		
		JRadioButton jrdbtnSanAndreas = new JRadioButton("San Andres");
		jrdbtnSanAndreas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnSanAndreas = new GridBagConstraints();
		gbc_jrdbtnSanAndreas.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnSanAndreas.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnSanAndreas.gridx = 3;
		gbc_jrdbtnSanAndreas.gridy = 1;
		jpnlDestinationOption.add(jrdbtnSanAndreas, gbc_jrdbtnSanAndreas);
		
		JRadioButton jrdbtnNichols = new JRadioButton("Nichols");
		jrdbtnNichols.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnNichols = new GridBagConstraints();
		gbc_jrdbtnNichols.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnNichols.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnNichols.gridx = 5;
		gbc_jrdbtnNichols.gridy = 1;
		jpnlDestinationOption.add(jrdbtnNichols, gbc_jrdbtnNichols);
		
		JRadioButton jrdbtnMuntinlupa = new JRadioButton("Muntinlupa");
		jrdbtnMuntinlupa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnMuntinlupa = new GridBagConstraints();
		gbc_jrdbtnMuntinlupa.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnMuntinlupa.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnMuntinlupa.gridx = 7;
		gbc_jrdbtnMuntinlupa.gridy = 1;
		jpnlDestinationOption.add(jrdbtnMuntinlupa, gbc_jrdbtnMuntinlupa);
		
		JRadioButton jrdbtnStaRosa = new JRadioButton("Sta. Rosa");
		jrdbtnStaRosa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnStaRosa = new GridBagConstraints();
		gbc_jrdbtnStaRosa.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnStaRosa.insets = new Insets(0, 0, 5, 0);
		gbc_jrdbtnStaRosa.gridx = 9;
		gbc_jrdbtnStaRosa.gridy = 1;
		jpnlDestinationOption.add(jrdbtnStaRosa, gbc_jrdbtnStaRosa);
		
		JRadioButton jrdbtnEspana = new JRadioButton("Espa\u00F1a");
		jrdbtnEspana.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnEspana = new GridBagConstraints();
		gbc_jrdbtnEspana.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnEspana.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnEspana.gridx = 1;
		gbc_jrdbtnEspana.gridy = 2;
		jpnlDestinationOption.add(jrdbtnEspana, gbc_jrdbtnEspana);
		
		JRadioButton jrdbtnVitoCruz = new JRadioButton("Vito Cruz");
		jrdbtnVitoCruz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnVitoCruz = new GridBagConstraints();
		gbc_jrdbtnVitoCruz.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnVitoCruz.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnVitoCruz.gridx = 3;
		gbc_jrdbtnVitoCruz.gridy = 2;
		jpnlDestinationOption.add(jrdbtnVitoCruz, gbc_jrdbtnVitoCruz);
		
		JRadioButton jrdbtnFTI = new JRadioButton("FTI");
		jrdbtnFTI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnFTI = new GridBagConstraints();
		gbc_jrdbtnFTI.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnFTI.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnFTI.gridx = 5;
		gbc_jrdbtnFTI.gridy = 2;
		jpnlDestinationOption.add(jrdbtnFTI, gbc_jrdbtnFTI);
		
		JRadioButton jrdbtnSanPedro = new JRadioButton("San Pedro");
		jrdbtnSanPedro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnSanPedro = new GridBagConstraints();
		gbc_jrdbtnSanPedro.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnSanPedro.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnSanPedro.gridx = 7;
		gbc_jrdbtnSanPedro.gridy = 2;
		jpnlDestinationOption.add(jrdbtnSanPedro, gbc_jrdbtnSanPedro);
		
		JRadioButton jrdbtnCabuyao = new JRadioButton("Cabuyao");
		jrdbtnCabuyao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnCabuyao = new GridBagConstraints();
		gbc_jrdbtnCabuyao.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnCabuyao.insets = new Insets(0, 0, 5, 0);
		gbc_jrdbtnCabuyao.gridx = 9;
		gbc_jrdbtnCabuyao.gridy = 2;
		jpnlDestinationOption.add(jrdbtnCabuyao, gbc_jrdbtnCabuyao);
		
		JRadioButton jrdbtnStaMesa = new JRadioButton("Sta. Mesa");
		jrdbtnStaMesa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnStaMesa = new GridBagConstraints();
		gbc_jrdbtnStaMesa.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnStaMesa.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnStaMesa.gridx = 1;
		gbc_jrdbtnStaMesa.gridy = 3;
		jpnlDestinationOption.add(jrdbtnStaMesa, gbc_jrdbtnStaMesa);
		
		JRadioButton jrdbtnBuendia = new JRadioButton("Buendia");
		jrdbtnBuendia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnBuendia = new GridBagConstraints();
		gbc_jrdbtnBuendia.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnBuendia.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnBuendia.gridx = 3;
		gbc_jrdbtnBuendia.gridy = 3;
		jpnlDestinationOption.add(jrdbtnBuendia, gbc_jrdbtnBuendia);
		
		JRadioButton jrdbtnBicutan = new JRadioButton("Bicutan");
		jrdbtnBicutan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnBicutan = new GridBagConstraints();
		gbc_jrdbtnBicutan.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnBicutan.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnBicutan.gridx = 5;
		gbc_jrdbtnBicutan.gridy = 3;
		jpnlDestinationOption.add(jrdbtnBicutan, gbc_jrdbtnBicutan);
		
		JRadioButton jrdbtnPacitaMainGate = new JRadioButton("Pacita Main Gate");
		jrdbtnPacitaMainGate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnPacitaMainGate = new GridBagConstraints();
		gbc_jrdbtnPacitaMainGate.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnPacitaMainGate.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbtnPacitaMainGate.gridx = 7;
		gbc_jrdbtnPacitaMainGate.gridy = 3;
		jpnlDestinationOption.add(jrdbtnPacitaMainGate, gbc_jrdbtnPacitaMainGate);
		
		JRadioButton jrdbtnMamatid = new JRadioButton("Mamatid");
		jrdbtnMamatid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnMamatid = new GridBagConstraints();
		gbc_jrdbtnMamatid.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnMamatid.insets = new Insets(0, 0, 5, 0);
		gbc_jrdbtnMamatid.gridx = 9;
		gbc_jrdbtnMamatid.gridy = 3;
		jpnlDestinationOption.add(jrdbtnMamatid, gbc_jrdbtnMamatid);
		
		JRadioButton jrdbtnPandacan = new JRadioButton("Pandacan");
		jrdbtnPandacan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnPandacan = new GridBagConstraints();
		gbc_jrdbtnPandacan.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnPandacan.insets = new Insets(0, 0, 0, 5);
		gbc_jrdbtnPandacan.gridx = 1;
		gbc_jrdbtnPandacan.gridy = 4;
		jpnlDestinationOption.add(jrdbtnPandacan, gbc_jrdbtnPandacan);
		
		JRadioButton jrdbtnPasayRoad = new JRadioButton("Pasay Road");
		jrdbtnPasayRoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnPasayRoad = new GridBagConstraints();
		gbc_jrdbtnPasayRoad.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnPasayRoad.insets = new Insets(0, 0, 0, 5);
		gbc_jrdbtnPasayRoad.gridx = 3;
		gbc_jrdbtnPasayRoad.gridy = 4;
		jpnlDestinationOption.add(jrdbtnPasayRoad, gbc_jrdbtnPasayRoad);
		
		JRadioButton jrdbtnSucat = new JRadioButton("Sucat");
		jrdbtnSucat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnSucat = new GridBagConstraints();
		gbc_jrdbtnSucat.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnSucat.insets = new Insets(0, 0, 0, 5);
		gbc_jrdbtnSucat.gridx = 5;
		gbc_jrdbtnSucat.gridy = 4;
		jpnlDestinationOption.add(jrdbtnSucat, gbc_jrdbtnSucat);
		
		JRadioButton jrdbtnGoldenCity1 = new JRadioButton("Golden City 1");
		jrdbtnGoldenCity1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnGoldenCity1 = new GridBagConstraints();
		gbc_jrdbtnGoldenCity1.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnGoldenCity1.insets = new Insets(0, 0, 0, 5);
		gbc_jrdbtnGoldenCity1.gridx = 7;
		gbc_jrdbtnGoldenCity1.gridy = 4;
		jpnlDestinationOption.add(jrdbtnGoldenCity1, gbc_jrdbtnGoldenCity1);
		
		JRadioButton jrdbtnCalamba = new JRadioButton("Calamba");
		jrdbtnCalamba.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_jrdbtnCalamba = new GridBagConstraints();
		gbc_jrdbtnCalamba.anchor = GridBagConstraints.WEST;
		gbc_jrdbtnCalamba.gridx = 9;
		gbc_jrdbtnCalamba.gridy = 4;
		jpnlDestinationOption.add(jrdbtnCalamba, gbc_jrdbtnCalamba);
		
		ButtonGroup grpDestination = new ButtonGroup();
		grpDestination.add(jrdbtnBluementrit);
		grpDestination.add(jrdbtnLaonLaan);
		grpDestination.add(jrdbtnEspana);
		grpDestination.add(jrdbtnStaMesa);
		grpDestination.add(jrdbtnPandacan);
		grpDestination.add(jrdbtnPaco);
		grpDestination.add(jrdbtnSanAndreas);
		grpDestination.add(jrdbtnVitoCruz);
		grpDestination.add(jrdbtnBuendia);
		grpDestination.add(jrdbtnPasayRoad);
		grpDestination.add(jrdbtnEDSA);
		grpDestination.add(jrdbtnNichols);
		grpDestination.add(jrdbtnFTI);
		grpDestination.add(jrdbtnBicutan);
		grpDestination.add(jrdbtnSucat);
		grpDestination.add(jrdbtnAlabang);
		grpDestination.add(jrdbtnMuntinlupa);
		grpDestination.add(jrdbtnSanPedro);
		grpDestination.add(jrdbtnPacitaMainGate);
		grpDestination.add(jrdbtnGoldenCity1);
		grpDestination.add(jrdbtnBinan);
		grpDestination.add(jrdbtnStaRosa);
		grpDestination.add(jrdbtnCabuyao);
		grpDestination.add(jrdbtnMamatid);
		grpDestination.add(jrdbtnCalamba);
		
		JPanel jpnlPayment = new JPanel();
		contentPane.add(jpnlPayment);
		jpnlPayment.setLayout(new BoxLayout(jpnlPayment, BoxLayout.X_AXIS));
		
		JPanel jpnlTicketAndPayment = new JPanel();
		jpnlTicketAndPayment.setBorder(new EmptyBorder(0, 10, 0, 0));
		jpnlTicketAndPayment.setMaximumSize(new Dimension(3000, 80000));
		jpnlPayment.add(jpnlTicketAndPayment);
		GridBagLayout gbl_jpnlTicketAndPayment = new GridBagLayout();
		gbl_jpnlTicketAndPayment.columnWidths = new int[]{0, 109, 68, 0};
		gbl_jpnlTicketAndPayment.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpnlTicketAndPayment.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlTicketAndPayment.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlTicketAndPayment.setLayout(gbl_jpnlTicketAndPayment);
		
		JLabel jlblNoOfTickets = new JLabel("No. Of Tickets:");
		GridBagConstraints gbc_jlblNoOfTickets = new GridBagConstraints();
		gbc_jlblNoOfTickets.anchor = GridBagConstraints.EAST;
		gbc_jlblNoOfTickets.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNoOfTickets.gridx = 0;
		gbc_jlblNoOfTickets.gridy = 0;
		jpnlTicketAndPayment.add(jlblNoOfTickets, gbc_jlblNoOfTickets);
		
		jtxtfldNoOfTickets = new JTextField();
		jtxtfldNoOfTickets.setHorizontalAlignment(SwingConstants.CENTER);
		jtxtfldNoOfTickets.setText("1");
		jtxtfldNoOfTickets.setToolTipText("");
		GridBagConstraints gbc_jtxtfldNoOfTickets = new GridBagConstraints();
		gbc_jtxtfldNoOfTickets.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldNoOfTickets.gridx = 1;
		gbc_jtxtfldNoOfTickets.gridy = 0;
		jpnlTicketAndPayment.add(jtxtfldNoOfTickets, gbc_jtxtfldNoOfTickets);
		jtxtfldNoOfTickets.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		jpnlTicketAndPayment.add(panel, gbc_panel);
		
		JButton jbtnDecrement = new JButton("-");
		jbtnDecrement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(jbtnDecrement);
		jbtnDecrement.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton jbtnIncrement = new JButton("+");
		jbtnIncrement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnIncrement.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(jbtnIncrement);
		
		JLabel jlblCash = new JLabel("Cash:");
		jlblCash.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_jlblCash = new GridBagConstraints();
		gbc_jlblCash.anchor = GridBagConstraints.EAST;
		gbc_jlblCash.insets = new Insets(0, 0, 0, 5);
		gbc_jlblCash.gridx = 0;
		gbc_jlblCash.gridy = 2;
		jpnlTicketAndPayment.add(jlblCash, gbc_jlblCash);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		jpnlTicketAndPayment.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		jpnlTicketAndPayment.add(panel_1, gbc_panel_1);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnNewButton_3);
		
		JPanel jpnlBilling = new JPanel();
		jpnlBilling.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, null));
		jpnlPayment.add(jpnlBilling);
		jpnlBilling.setLayout(null);
		
		JLabel jlblSummary = new JLabel("Summary of Billing");
		jlblSummary.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlblSummary.setBounds(20, 11, 121, 14);
		jpnlBilling.add(jlblSummary);
		
		JLabel jlblSoBDestination = new JLabel("Destination: ");
		jlblSoBDestination.setBounds(20, 47, 80, 14);
		jpnlBilling.add(jlblSoBDestination);
		
		JLabel jlblSoBNoOfTickets = new JLabel("No. of Tickets:");
		jlblSoBNoOfTickets.setBounds(20, 68, 80, 14);
		jpnlBilling.add(jlblSoBNoOfTickets);
		
		JLabel jlblSoBTotal = new JLabel("TOTAL");
		jlblSoBTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlblSoBTotal.setBounds(20, 93, 69, 14);
		jpnlBilling.add(jlblSoBTotal);
		
		JLabel lblNewLabel_4 = new JLabel("________________________________________________");
		lblNewLabel_4.setBounds(20, 72, 298, 14);
		jpnlBilling.add(lblNewLabel_4);
		
		JLabel jlblSoBCash = new JLabel("Cash:\r\n");
		jlblSoBCash.setBounds(20, 118, 46, 14);
		jpnlBilling.add(jlblSoBCash);
		
		JLabel jlblSoBDestinationOutput = new JLabel("Pacita Main Gate");
		jlblSoBDestinationOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBDestinationOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBDestinationOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBDestinationOutput.setBounds(183, 37, 113, 26);
		jpnlBilling.add(jlblSoBDestinationOutput);
		
		JLabel jlblSoBNoOfTicketsOutput = new JLabel("1");
		jlblSoBNoOfTicketsOutput.setVerticalAlignment(SwingConstants.BOTTOM);
		jlblSoBNoOfTicketsOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBNoOfTicketsOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBNoOfTicketsOutput.setBounds(183, 58, 113, 26);
		jpnlBilling.add(jlblSoBNoOfTicketsOutput);
		
		JLabel jlblSoBTotalOutput = new JLabel("20.00");
		jlblSoBTotalOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBTotalOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBTotalOutput.setBounds(183, 93, 113, 14);
		jpnlBilling.add(jlblSoBTotalOutput);
		
		JLabel jlblSoBPesoSign = new JLabel("\u20B1");
		jlblSoBPesoSign.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBPesoSign.setBounds(137, 85, 28, 26);
		jpnlBilling.add(jlblSoBPesoSign);
		
		JLabel jlblSoBChange = new JLabel("CHANGE");
		jlblSoBChange.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBChange.setBounds(20, 150, 69, 14);
		jpnlBilling.add(jlblSoBChange);
		
		JLabel jlblSoBPesoSign_1 = new JLabel("\u20B1");
		jlblSoBPesoSign_1.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBPesoSign_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBPesoSign_1.setBounds(137, 142, 28, 26);
		jpnlBilling.add(jlblSoBPesoSign_1);
		
		JLabel jlblSoBChangeOutput = new JLabel("30.00");
		jlblSoBChangeOutput.setForeground(Color.BLUE);
		jlblSoBChangeOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBChangeOutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlblSoBChangeOutput.setBounds(183, 150, 113, 14);
		jpnlBilling.add(jlblSoBChangeOutput);
		
		JLabel jlblSoBTotalOutput_1 = new JLabel("50.00");
		jlblSoBTotalOutput_1.setHorizontalAlignment(SwingConstants.TRAILING);
		jlblSoBTotalOutput_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblSoBTotalOutput_1.setBounds(175, 120, 121, 14);
		jpnlBilling.add(jlblSoBTotalOutput_1);
		
		JLabel lblPleaseDoubleCheck = new JLabel("Please double check before printing");
		lblPleaseDoubleCheck.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPleaseDoubleCheck.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPleaseDoubleCheck.setBounds(10, 189, 223, 14);
		jpnlBilling.add(lblPleaseDoubleCheck);
		
		JPanel jpnlButtons = new JPanel();
		contentPane.add(jpnlButtons);
		jpnlButtons.setLayout(null);
		
		JButton jbtnTicketError = new JButton("TICKET ERROR");
		jbtnTicketError.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		jbtnTicketError.setBounds(10, 11, 119, 23);
		jpnlButtons.add(jbtnTicketError);
		
		JButton jbtnPrintTicket = new JButton("PRINT TICKET");
		jbtnPrintTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtnPrintTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPrintTicket.setBounds(509, 11, 119, 23);
		jpnlButtons.add(jbtnPrintTicket);
		
		
	}
}
