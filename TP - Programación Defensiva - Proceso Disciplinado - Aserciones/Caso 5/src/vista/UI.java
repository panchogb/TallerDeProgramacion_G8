package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import negocio.Monitor;

import java.awt.Color;

/**
 * 
 * Esta clase genera la ventana de interfaz de usuario
 *
 */
public class UI extends JFrame implements ActionListener, MouseListener,IVista{

	private JPanel contentPane;
	private JTextField textNumeroPrueba;
	private JTextField textNumeroIntentos;
	private JTextField textEstado;
	private JTextArea textMensaje;
	private static Monitor monitor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					monitor=new Monitor(frame);
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelInicio = new JPanel();
		panel.add(panelInicio);
		
		JButton btnJuegoNuevo = new JButton("Juego nuevo");
		btnJuegoNuevo.addActionListener(this);
		btnJuegoNuevo.setActionCommand("inicializar");
		panelInicio.add(btnJuegoNuevo);
		
		JPanel panelProbar = new JPanel();
		panel.add(panelProbar);
		panelProbar.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panelProbarBoton = new JPanel();
		panelProbar.add(panelProbarBoton);
		
		JLabel lblNumero = new JLabel("Numero:");
		panelProbarBoton.add(lblNumero);
		
		textNumeroPrueba = new JTextField();
		panelProbarBoton.add(textNumeroPrueba);
		textNumeroPrueba.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panelProbar.add(panel_1);
		
		JButton btnProbar = new JButton("Probar");
		btnProbar.addActionListener(this);
		btnProbar.setActionCommand("probar");
		panel_1.add(btnProbar);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblIntentosTexto = new JLabel("Numero de intentos: ");
		panel_3.add(lblIntentosTexto);
		
		textNumeroIntentos = new JTextField();
		textNumeroIntentos.setEditable(false);
		panel_3.add(textNumeroIntentos);
		textNumeroIntentos.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblEstado = new JLabel("Estado: ");
		panel_4.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		panel_4.add(textEstado);
		textEstado.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textMensaje = new JTextArea();
		textMensaje.setEditable(false);
		panel_2.add(textMensaje);
	}

	/**
	 * Este metodo llama a los metodos correspondientes segun los botones accionados
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toString())
		{
		case "inicializar":inicializarJuego(); break;
		case "probar":probarNumero();break;
		}
	}
	
	/**
	 * Este metodo le informa a la capa de negocio que debe inicializar el juego
	 */
	public void inicializarJuego() {
		this.monitor.inicializarJuego();
		this.informar("Se ha iniciado un juego nuevo.");
	}
	
	/**
	 * Este metodo le informa a la capa de negocio que debe probar el numero ingresado y muestra los mensajes correspondientes
	 */
	public void probarNumero() {
		float numero=Float.parseFloat(textNumeroPrueba.getText());
		this.monitor.probarNumero(numero);
		mostrarIntentos();
		mostrarEstado();
	}
	
	/**
	 * Estos metodos muestran la cantidad de intentos y el estado del juego respectivamente
	 */
	public void mostrarIntentos() {
		int intentos=this.monitor.traerIntentos();
		this.textNumeroIntentos.setText(Integer.toString(intentos));
	}
	public void mostrarEstado() {
		this.textEstado.setText(this.monitor.traerEstado());
	}
	
	public void informar(String mensaje) {
		this.textMensaje.append(mensaje+"\n");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMonitor(Monitor monitor) {
		this.monitor=monitor;
	}

}
