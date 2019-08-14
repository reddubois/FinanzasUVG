import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;


import javax.swing.JButton;
import javax.swing.JLabel;

public class Main {

	private JFrame ventana;
	private JPanel sidebar;
	private JPanel content;
	private JButton btnResumen;
	private JButton btnIngresos;
	private JButton btnGastos;
	private JButton btnPresupuestos;
	private JButton btnSalir;
	private JPanel resumen;
	private JPanel ingresos;
	private JPanel gastos;
	private JPanel presupuestos;
	private JLabel lblNewLabel;
	private JLabel lblGastos;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
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
		ventana.getContentPane().setBackground(Color.WHITE);
		ventana.setBackground(Color.WHITE);
		ventana.setBounds(50, 15, 1280, 740);
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
		btnResumen.setForeground(SystemColor.controlDkShadow);
		btnResumen.setBackground(SystemColor.controlHighlight);
		btnResumen.setBounds(0, 169, 239, 47);
		sidebar.add(btnResumen);
		
		btnIngresos = new JButton("Ingresos");
		MiListener oyenteIngresos = new MiListener();
		btnIngresos.addActionListener(oyenteIngresos);
		btnIngresos.setForeground(SystemColor.controlDkShadow);
		btnIngresos.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnIngresos.setBackground(SystemColor.controlHighlight);
		btnIngresos.setBounds(0, 213, 239, 47);
		sidebar.add(btnIngresos);
		
		btnGastos = new JButton("Gastos");
		MiListener oyenteGastos = new MiListener();
		btnGastos.addActionListener(oyenteGastos);
		btnGastos.setForeground(SystemColor.controlDkShadow);
		btnGastos.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnGastos.setBackground(SystemColor.controlHighlight);
		btnGastos.setBounds(0, 258, 239, 47);
		sidebar.add(btnGastos);
		
		btnPresupuestos = new JButton("Presupuestos");
		MiListener oyentePrespuesto = new MiListener();
		btnPresupuestos.addActionListener(oyentePrespuesto);
		btnPresupuestos.setForeground(SystemColor.controlDkShadow);
		btnPresupuestos.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnPresupuestos.setBackground(SystemColor.controlHighlight);
		btnPresupuestos.setBounds(0, 304, 239, 47);
		sidebar.add(btnPresupuestos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(SystemColor.controlDkShadow);
		btnSalir.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSalir.setBackground(SystemColor.controlHighlight);
		btnSalir.setBounds(0, 350, 239, 47);
		sidebar.add(btnSalir);
		
		content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(240, 0, 1024, 701);
		ventana.getContentPane().add(content);
		content.setLayout(new CardLayout(0, 0));
		
		resumen = new JPanel();
		resumen.setBackground(Color.WHITE);
		content.add(resumen, "name_18739609784760");
		resumen.setLayout(null);
		
		lblNewLabel_1 = new JLabel("RESUMEN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(69, 200, 340, 183);
		resumen.add(lblNewLabel_1);
		resumen.setVisible(true);
		
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
		presupuestos.setLayout(null);
		
		lblNewLabel_2 = new JLabel("PRESUPUESTOS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(40, 202, 324, 164);
		presupuestos.add(lblNewLabel_2);

	}
	
	private class MiListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnResumen) {
				resumen.setVisible(true);
				ingresos.setVisible(false);
				gastos.setVisible(false);
				presupuestos.setVisible(false);
			}
			if(e.getSource() == btnIngresos) {
				ingresos.setVisible(true);
				resumen.setVisible(false);
				gastos.setVisible(false);
				presupuestos.setVisible(false);
			}
			if(e.getSource() == btnGastos) {
				gastos.setVisible(true);
				resumen.setVisible(false);
				ingresos.setVisible(false);
				presupuestos.setVisible(false);
			}
			if(e.getSource() == btnPresupuestos) {
				presupuestos.setVisible(true);
				resumen.setVisible(false);
				ingresos.setVisible(false);
				gastos.setVisible(false);
			}
		}
	}
}
