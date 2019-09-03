
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JSeparator;

public class Main {

	private JFrame ventana;
	
	// Main 2 JPanels
	private JPanel sidebar, content;
	
	// SIDEBAR main buttons
	private JButton btnResumen, btnIngresos, btnGastos, btnPresupuestos, btnSalir;
	
	// CONTENT main JPanels
	private JPanel resumen, ingresos, gastos, presupuestos;
	
	private JLabel lblGastos, lblNewLabel;
	
	Presupuestos pres = new Presupuestos();
	private int presupuestoTotal, fieldTotalHogar, fieldTotalAuto, fieldTotalAlimentos, fieldTotalEntretenimiento, fieldTotalSalud, fieldTotalEducacion, fieldTotalFinanzas,
				fieldTotalRopa, fieldTotalRegalos, fieldTotalViajes;

	private int ingresosTotal = 7000;



	private JLabel label_37;

	private JLabel picLabel;
	private BufferedImage myPicture = null, imageUp = null, imageDown = null;
	private JLabel lblUsername;
	private JLabel lblIngresos;
	private JLabel lblQ_1;
	private JLabel lblQ_2;
	private JLabel lblGastos_1;
	private JLabel lblUp;
	private JLabel lblDown;
	private JButton btnTest;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana = new JFrame();
		ventana.setTitle("UVG Finanzas");
		ventana.getContentPane().setBackground(Color.WHITE);
		ventana.setBackground(Color.WHITE);
		ventana.setSize(1280, 740);
		ventana.setLocationRelativeTo(null);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		
		sidebar = new JPanel();
		sidebar.setBackground(SystemColor.controlHighlight);
		sidebar.setBounds(0, 0, 240, 701);
		ventana.getContentPane().add(sidebar);
		sidebar.setLayout(null);
		
		btnResumen = new JButton("Resumen");
		MiListener oyenteResumen = new MiListener();
		btnResumen.addActionListener(oyenteResumen);
		btnResumen.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnResumen.setForeground(Color.WHITE);
		btnResumen.setBackground(new Color(51, 153, 255));
		btnResumen.setBounds(0, 169, 239, 47);
		btnResumen.setBorder(null);
		sidebar.add(btnResumen);
		
		btnIngresos = new JButton("Ingresos");
		MiListener oyenteIngresos = new MiListener();
		btnIngresos.addActionListener(oyenteIngresos);
		btnIngresos.setForeground(SystemColor.controlDkShadow);
		btnIngresos.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnIngresos.setBackground(SystemColor.controlHighlight);
		btnIngresos.setBounds(0, 273, 239, 47);
		btnIngresos.setBorder(null);
		sidebar.add(btnIngresos);
		
		btnGastos = new JButton("Gastos");
		MiListener oyenteGastos = new MiListener();
		btnGastos.addActionListener(oyenteGastos);
		btnGastos.setBackground(SystemColor.controlHighlight);
		btnGastos.setForeground(SystemColor.controlDkShadow);
		btnGastos.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnGastos.setBackground(SystemColor.controlHighlight);
		btnGastos.setBounds(0, 318, 239, 47);
		btnGastos.setBorder(null);
		sidebar.add(btnGastos);
		
		btnPresupuestos = new JButton("Presupuestos");
		MiListener oyentePrespuesto = new MiListener();
		btnPresupuestos.addActionListener(oyentePrespuesto);
		btnPresupuestos.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnPresupuestos.setForeground(Color.WHITE);
		btnPresupuestos.setBackground(new Color(51, 153, 255));
		btnPresupuestos.setBounds(0, 364, 239, 47);
		btnPresupuestos.setBorder(null);
		sidebar.add(btnPresupuestos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.controlHighlight);
		btnSalir.setForeground(SystemColor.controlDkShadow);
		btnSalir.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSalir.setBounds(0, 410, 239, 47);
		btnSalir.setBorder(null);
		sidebar.add(btnSalir);		
		
		try {
			myPicture = ImageIO.read(new File("user.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image newImage = myPicture.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		picLabel = new JLabel(new ImageIcon(newImage));
		
		picLabel.setLocation(0, 21);
		picLabel.setSize(239, 100);
		sidebar.add(picLabel);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(51,51,51));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(0, 111, 239, 35);
		sidebar.add(lblUsername);
		
		lblIngresos = new JLabel("Ingresos");
		lblIngresos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblIngresos.setBounds(50, 162, 60, 15);
		sidebar.add(lblIngresos);
		
		lblQ_1 = new JLabel("Q 7,000");
		lblQ_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblQ_1.setBounds(50, 181, 60, 15);
		sidebar.add(lblQ_1);
		
		lblQ_2 = new JLabel("Q 2,340");
		lblQ_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblQ_2.setBounds(165, 181, 60, 15);
		sidebar.add(lblQ_2);
		
		lblGastos_1 = new JLabel("Gastos");
		lblGastos_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblGastos_1.setBounds(165, 162, 60, 15);
		sidebar.add(lblGastos_1);
		
		try {
			imageUp = ImageIO.read(new File("up.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image imgUp = imageUp.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		lblUp = new JLabel(new ImageIcon(imgUp));
		lblUp.setBounds(15, 162, 30, 35);
		sidebar.add(lblUp);
		
		try {
			imageDown = ImageIO.read(new File("down.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image imgDown = imageDown.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		lblDown = new JLabel(new ImageIcon(imgDown));
		lblDown.setBounds(130, 162, 30, 35);
		sidebar.add(lblDown);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.windowBorder);
		separator.setForeground(SystemColor.windowBorder);
		separator.setBounds(122, 162, 1, 35);
		sidebar.add(separator);
		
		btnTest = new JButton("TEST");
		btnTest.setBounds(61, 495, 89, 23);
		sidebar.add(btnTest);
		
		MiListener oyenteCrearPres = new MiListener();
		MiListener oyentePresAuto = new MiListener();
		MiListener oyentePresHogar = new MiListener();
		MiListener oyentePresAlimentos = new MiListener();
		MiListener oyentePresEntretenimiento = new MiListener();
		MiListener oyentePresSalud = new MiListener();
		MiListener oyentePresEducacion = new MiListener();
		MiListener oyentePresFinanzas = new MiListener();
		MiListener oyentePresRopa = new MiListener();
		MiListener oyentePresRegalos = new MiListener();
		MiListener oyentePresViajes = new MiListener();
		MiListener oyenteBtnSelecCategRegresar = new MiListener();
		MiListener oyenteBtnHogarGuardar = new MiListener();
		MiListener oyenteBtnHogarRegresar = new MiListener();
		MiListener oyenteBtnAlimentosRegresar = new MiListener();
		MiListener oyenteBtnAutoGuardar = new MiListener();
		MiListener oyenteBtnAutoRegresar = new MiListener();
		MiListener oyenteBtnEntretenimientoRegresar = new MiListener();
		MiListener oyenteBtnSaludRegresar = new MiListener();
		MiListener oyenteBtnEducacionRegresar = new MiListener();
		MiListener oyenteBtnFinanzasRegresar = new MiListener();
		MiListener oyenteBtnRopaRegresar = new MiListener();
		MiListener oyenteBtnRegalosRegresar = new MiListener();
		MiListener oyenteBtnViajesRegresar = new MiListener();
		
		content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(240, 0, 1024, 701);
		ventana.getContentPane().add(content);
		content.setLayout(new CardLayout(0, 0));
		
		presupuestos = new JPanel();
		presupuestos.setBackground(Color.WHITE);
		content.add(presupuestos);
		presupuestos.setLayout(new CardLayout(0, 0));
		
		presupuestoMain = new JPanel();
		presupuestoMain.setBackground(new Color(255, 255, 255));
		presupuestos.add(presupuestoMain);
		presupuestoMain.setLayout(null);
		
		label_4 = new JLabel("PRESUPUESTOS");
		label_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		label_4.setBounds(423, 60, 170, 64);
		presupuestoMain.add(label_4);
		
		lblPresupuestoTotal_1 = new JLabel("Presupuesto total:");
		lblPresupuestoTotal_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblPresupuestoTotal_1.setBounds(113, 149, 158, 19);
		presupuestoMain.add(lblPresupuestoTotal_1);
		
		label_6 = new JLabel("Total Ingresos:");
		label_6.setFont(new Font("Verdana", Font.PLAIN, 17));
		label_6.setBounds(679, 149, 133, 19);
		presupuestoMain.add(label_6);
		
		progressBar = new JProgressBar();
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(113, 174, 800, 27);
		presupuestoMain.add(progressBar);
		
		btnCrearPres = new JButton("+");
		btnCrearPres.addActionListener(oyenteCrearPres);
		btnCrearPres.setForeground(Color.WHITE);
		btnCrearPres.setBackground(new Color(51, 153, 255));
		btnCrearPres.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCrearPres.setBounds(450, 246, 133, 50);
		btnCrearPres.setBorder(null);
		presupuestoMain.add(btnCrearPres);
		
		label_7 = new JLabel("Crear presupuesto");
		label_7.setFont(new Font("Verdana", Font.PLAIN, 14));
		label_7.setBounds(450, 296, 133, 27);
		presupuestoMain.add(label_7);
		
		panel_82 = new JPanel();
		panel_82.setBackground(new Color(240, 240, 240));
		panel_82.setBounds(113, 399, 365, 33);
		presupuestoMain.add(panel_82);
		panel_82.setLayout(null);
		
		presMainLabel1 = new JLabel("");
		presMainLabel1.setBackground(new Color(0, 153, 255));
		presMainLabel1.setForeground(new Color(255, 255, 255));
		presMainLabel1.setFont(new Font("Verdana", Font.BOLD, 13));
		presMainLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		presMainLabel1.setBounds(0, 0, 181, 33);
		panel_82.add(presMainLabel1);
		
		presMainLabel2 = new JLabel("");
		presMainLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		presMainLabel2.setForeground(Color.WHITE);
		presMainLabel2.setFont(new Font("Verdana", Font.BOLD, 15));
		presMainLabel2.setBackground(new Color(0, 153, 255));
		presMainLabel2.setBounds(184, 0, 181, 33);
		panel_82.add(presMainLabel2);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(548, 399, 365, 33);
		presupuestoMain.add(panel);
		panel.setLayout(null);
		
		resumenMain = new JPanel();
		resumenMain.setBackground(Color.WHITE);
		resumen.add(resumenMain, "name_217400835253720");
		resumenMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 12, 560, 295);
		resumenMain.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(652, 11, 300, 135);
		resumenMain.add(panel_1);
		
		JLabel label = new JLabel("Ingresos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		label.setBounds(0, 22, 300, 26);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("0.0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Verdana", Font.BOLD, 17));
		label_1.setBounds(0, 59, 300, 41);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 153, 153));
		panel_2.setBounds(652, 172, 300, 135);
		resumenMain.add(panel_2);
		
		JLabel label_2 = new JLabel("Gastos");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Verdana", Font.BOLD, 15));
		label_2.setBounds(0, 22, 300, 26);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("0.0");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Verdana", Font.BOLD, 17));
		label_3.setBounds(0, 59, 300, 41);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(61, 172, 219));
		panel_3.setBounds(525, 332, 200, 87);
		resumenMain.add(panel_3);
		
		JLabel label_4 = new JLabel("Hogar");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Verdana", Font.BOLD, 14));
		label_4.setBounds(0, 5, 200, 25);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Verdana", Font.BOLD, 16));
		label_5.setBounds(0, 36, 200, 40);
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(61, 172, 219));
		panel_4.setBounds(70, 332, 428, 87);
		resumenMain.add(panel_4);
		
		JLabel label_6 = new JLabel("Total presupuestos:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Verdana", Font.BOLD, 14));
		label_6.setBounds(85, 30, 164, 29);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("0.0");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Verdana", Font.BOLD, 17));
		label_7.setBounds(259, 30, 79, 29);
		panel_4.add(label_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(61, 172, 219));
		panel_5.setBounds(752, 332, 200, 87);
		resumenMain.add(panel_5);
		
		JLabel label_8 = new JLabel("Auto y Transporte");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Verdana", Font.BOLD, 14));
		label_8.setBounds(0, 5, 200, 25);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Verdana", Font.BOLD, 16));
		label_9.setBounds(0, 36, 200, 40);
		panel_5.add(label_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(61, 172, 219));
		panel_6.setBounds(298, 447, 200, 87);
		resumenMain.add(panel_6);
		
		JLabel label_10 = new JLabel("Entretenimiento");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Verdana", Font.BOLD, 14));
		label_10.setBounds(0, 5, 200, 25);
		panel_6.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Verdana", Font.BOLD, 16));
		label_11.setBounds(0, 36, 200, 40);
		panel_6.add(label_11);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(61, 172, 219));
		panel_7.setBounds(71, 447, 200, 87);
		resumenMain.add(panel_7);
		
		JLabel label_12 = new JLabel("Alimentos");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Verdana", Font.BOLD, 14));
		label_12.setBounds(0, 5, 200, 25);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Verdana", Font.BOLD, 16));
		label_13.setBounds(0, 36, 200, 40);
		panel_7.add(label_13);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(61, 172, 219));
		panel_8.setBounds(298, 563, 200, 87);
		resumenMain.add(panel_8);
		
		JLabel label_14 = new JLabel("Ropa y Calzado");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Verdana", Font.BOLD, 14));
		label_14.setBounds(0, 5, 200, 25);
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Verdana", Font.BOLD, 16));
		label_15.setBounds(0, 36, 200, 40);
		panel_8.add(label_15);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(61, 172, 219));
		panel_9.setBounds(71, 563, 200, 87);
		resumenMain.add(panel_9);
		
		JLabel label_16 = new JLabel("Finanzas e Impuestos");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Verdana", Font.BOLD, 14));
		label_16.setBounds(0, 5, 200, 25);
		panel_9.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Verdana", Font.BOLD, 16));
		label_17.setBounds(0, 36, 200, 40);
		panel_9.add(label_17);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(61, 172, 219));
		panel_10.setBounds(752, 447, 200, 87);
		resumenMain.add(panel_10);
		
		JLabel label_18 = new JLabel("Educaci\u00F3n");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Verdana", Font.BOLD, 14));
		label_18.setBounds(0, 5, 200, 25);
		panel_10.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Verdana", Font.BOLD, 16));
		label_19.setBounds(0, 36, 200, 40);
		panel_10.add(label_19);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(61, 172, 219));
		panel_11.setBounds(525, 447, 200, 87);
		resumenMain.add(panel_11);
		
		JLabel label_20 = new JLabel("Salud y Belleza");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Verdana", Font.BOLD, 14));
		label_20.setBounds(0, 5, 200, 25);
		panel_11.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Verdana", Font.BOLD, 16));
		label_21.setBounds(0, 36, 200, 40);
		panel_11.add(label_21);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(61, 172, 219));
		panel_12.setBounds(752, 563, 200, 87);
		resumenMain.add(panel_12);
		
		JLabel label_22 = new JLabel("Viajes");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Verdana", Font.BOLD, 14));
		label_22.setBounds(0, 5, 200, 25);
		panel_12.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Verdana", Font.BOLD, 16));
		label_23.setBounds(0, 36, 200, 40);
		panel_12.add(label_23);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(61, 172, 219));
		panel_13.setBounds(525, 563, 200, 87);
		resumenMain.add(panel_13);
		
		JLabel label_24 = new JLabel("Regalos y Ayuda");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Verdana", Font.BOLD, 14));
		label_24.setBounds(0, 5, 200, 25);
		panel_13.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Verdana", Font.BOLD, 16));
		label_25.setBounds(0, 36, 200, 40);
		panel_13.add(label_25);
		MiListener oyenteBtnAlimentosGuardar = new MiListener();
		MiListener oyentebtnEntretenimientoGuardar = new MiListener();
		MiListener oyentebtnSaludGuardar = new MiListener();
		MiListener oyentebtnEducacionGuardar = new MiListener();
		MiListener oyentebtnFinanzasGuardar = new MiListener();
		MiListener oyentebtnRopaGuardar = new MiListener();
		MiListener oyentebtnRegalosGuardar = new MiListener();
		MiListener oyentebtnViajesGuardar = new MiListener();
		
		ingresos = new JPanel();
		ingresos.setBackground(Color.WHITE);
		content.add(ingresos, "name_18777845815723");
		ingresos.setLayout(null);
		
		lblNewLabel = new JLabel("INGRESOS");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(86, 149, 282, 169);
		ingresos.add(lblNewLabel);
		
		
		gastos = new JPanel();
		gastos.setBackground(Color.WHITE);
		content.add(gastos, "name_18782269186194");
		gastos.setLayout(null);
		
		lblGastos = new JLabel("GASTOS");
		lblGastos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGastos.setBounds(88, 171, 349, 177);
		gastos.add(lblGastos);
		
		presupuestos = new JPanel();
		presupuestos.setBackground(Color.WHITE);
		content.add(presupuestos, "name_18828671709833");
		presupuestos.setLayout(new CardLayout(0, 0));
		presupuestos.setVisible(true);

	}
	
	private class MiListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// sidebar bottons menu 
			if(e.getSource() == btnResumen) {
				resumen.setVisible(true);
				ingresos.setVisible(false);
				gastos.setVisible(false);
				presupuestos.setVisible(false);
				btnResumen.setForeground(Color.WHITE);
				btnResumen.setBackground(new Color(51, 153, 255));
				btnIngresos.setBackground(SystemColor.controlHighlight);
				btnIngresos.setForeground(SystemColor.controlDkShadow);
				btnGastos.setBackground(SystemColor.controlHighlight);
				btnGastos.setForeground(SystemColor.controlDkShadow);
				btnPresupuestos.setBackground(SystemColor.controlHighlight);
				btnPresupuestos.setForeground(SystemColor.controlDkShadow);
			}
			if(e.getSource() == btnIngresos) {
				ingresos.setVisible(true);
				resumen.setVisible(false);
				gastos.setVisible(false);
				presupuestos.setVisible(false);
				btnIngresos.setForeground(Color.WHITE);
				btnIngresos.setBackground(new Color(51, 153, 255));
				btnResumen.setBackground(SystemColor.controlHighlight);
				btnResumen.setForeground(SystemColor.controlDkShadow);
				btnGastos.setBackground(SystemColor.controlHighlight);
				btnGastos.setForeground(SystemColor.controlDkShadow);
				btnPresupuestos.setBackground(SystemColor.controlHighlight);
				btnPresupuestos.setForeground(SystemColor.controlDkShadow);
			}
			if(e.getSource() == btnGastos) {
				gastos.setVisible(true);
				resumen.setVisible(false);
				ingresos.setVisible(false);
				presupuestos.setVisible(false);
				btnGastos.setForeground(Color.WHITE);
				btnGastos.setBackground(new Color(51, 153, 255));
				btnResumen.setBackground(SystemColor.controlHighlight);
				btnResumen.setForeground(SystemColor.controlDkShadow);
				btnIngresos.setBackground(SystemColor.controlHighlight);
				btnIngresos.setForeground(SystemColor.controlDkShadow);
				btnPresupuestos.setBackground(SystemColor.controlHighlight);
				btnPresupuestos.setForeground(SystemColor.controlDkShadow);
			}
			if(e.getSource() == btnPresupuestos) {
				presupuestos.setVisible(true);
				resumen.setVisible(false);
				ingresos.setVisible(false);
				gastos.setVisible(false);
				btnPresupuestos.setForeground(Color.WHITE);
				btnPresupuestos.setBackground(new Color(51, 153, 255));
				btnResumen.setBackground(SystemColor.controlHighlight);
				btnResumen.setForeground(SystemColor.controlDkShadow);
				btnIngresos.setBackground(SystemColor.controlHighlight);
				btnIngresos.setForeground(SystemColor.controlDkShadow);
				btnGastos.setBackground(SystemColor.controlHighlight);
				btnGastos.setForeground(SystemColor.controlDkShadow);
			}
			
		}
	}
}
































