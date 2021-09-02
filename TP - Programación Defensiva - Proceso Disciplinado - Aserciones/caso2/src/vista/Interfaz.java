package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Negocio;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;

public class Interfaz extends JFrame implements ActionListener,IVista{

	private JPanel contentPane;
	private JTextField textCarga;
	private Negocio negocio;
	private JTextArea textMensaje;


	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCarga = new JPanel();
		contentPane.add(panelCarga, BorderLayout.NORTH);
		
		JLabel labelCarga = new JLabel("Carga");
		panelCarga.add(labelCarga);
		
		textCarga = new JTextField();
		panelCarga.add(textCarga);
		textCarga.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panelBotones.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnIniciar = new JButton("Inicializar surtidor");
		panel.add(btnIniciar);
		btnIniciar.addActionListener(this);
		btnIniciar.setActionCommand("inicializar");
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JButton btnCargar = new JButton("Cargar surtidor");
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand("cargar");
		panel_4.add(btnCargar);
		
		JPanel panel_1_1 = new JPanel();
		panelBotones.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1_1.add(panel_3);
		
		JButton btnActivaMG1 = new JButton("Activar manguera 1");
		btnActivaMG1.addActionListener(this);
		btnActivaMG1.setActionCommand("activar1");
		panel_3.add(btnActivaMG1);
		
		JPanel panel_4_1 = new JPanel();
		panel_1_1.add(panel_4_1);
		
		JButton btnDesactivarMG1 = new JButton("Desactivar manguera 1");
		btnDesactivarMG1.addActionListener(this);
		btnDesactivarMG1.setActionCommand("desactivar1");
		panel_4_1.add(btnDesactivarMG1);
		
		JPanel panel_1_2 = new JPanel();
		panelBotones.add(panel_1_2);
		panel_1_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1_2.add(panel_2);
		
		JButton btnActivarMG2 = new JButton("Activar manguera 2");
		btnActivarMG2.addActionListener(this);
		btnActivarMG2.setActionCommand("activar2");
		panel_2.add(btnActivarMG2);
		
		JPanel panel_4_2 = new JPanel();
		panel_1_2.add(panel_4_2);
		
		JButton btnDesactivarMG2 = new JButton("Desactivar manguera 2");
		btnDesactivarMG2.addActionListener(this);
		btnDesactivarMG2.setActionCommand("desactivar2");
		panel_4_2.add(btnDesactivarMG2);
		
		JPanel panelMensaje = new JPanel();
		contentPane.add(panelMensaje, BorderLayout.SOUTH);
		panelMensaje.setLayout(new BorderLayout(0, 0));
		
		textMensaje = new JTextArea();
		panelMensaje.add(textMensaje, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toString())
		{
		case "inicializar":inicializaSurtidor(); break;
		case "cargar":cargarSurtidor(); break;
		case "activar1":activaManguera1(); break;
		case "activar2":activaManguera2(); break;
		case "desactivar1":desactivaManguera1(); break;
		case "desactivar2":desactivaManguera2(); break;
		}
	}
	
	public void inicializaSurtidor() {
		String texto=textCarga.getText(); float carga=Float.parseFloat(texto);
		this.negocio.inicializaSurtidor(carga);
	}
	public void cargarSurtidor() {
		String texto=textCarga.getText(); float carga=Float.parseFloat(texto);
		this.negocio.cargaSurtidor(carga);
	}
	public void activaManguera1() {
		this.negocio.activaManguera1();
	}
	public void activaManguera2() {
		this.negocio.activaManguera2();
	}
	public void desactivaManguera1() {
		this.negocio.desactivaManguera1();
		informar("Acumulado de la manguera 1: "+this.negocio.getAcumuladoManguera1());
	}
	public void desactivaManguera2() {
		this.negocio.activaManguera2();
		informar("Acumulado de la manguera 2: "+this.negocio.getAcumuladoManguera2());
	}
	public void informar(String mensaje) {
		textMensaje.append(mensaje);
	}

	@Override
	public void setNegocio(Negocio negocio) {
		this.negocio=negocio;
	}

}
