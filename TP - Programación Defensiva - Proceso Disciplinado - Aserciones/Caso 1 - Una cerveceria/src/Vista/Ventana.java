package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Negocio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.GridLayout;

public class Ventana extends JFrame implements IVista, ActionListener {

	private JPanel contentPane;
	private JTextField texto_nroMesas;
	
	private JPanel panelCerrado;
	private JPanel panelAbierto;
	private JList list_Mesas;
	private JTextField text_nroMesa;
	private JButton btn_CerrarMesa;
	private JButton btn_agregarProducto;
	private JButton btn_OcuparMesa;
	private JPanel panel;
	private JPanel panel_1;

	private Negocio negocio;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public void setNegocio(Negocio negocio)
	{
		this.negocio = negocio;
	}
	public Ventana() {
		initGUI();
	}
	private void initGUI() {

		this.panelCerrado = new JPanel();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(panelCerrado, "name_1056406703465899");
		panelCerrado.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 5));
		
		texto_nroMesas = new JTextField();
		panelCerrado.add(texto_nroMesas);
		texto_nroMesas.setColumns(10);
		
		JButton btn_abrirLocal = new JButton("Abrir local");
		btn_abrirLocal.addActionListener(this);
		btn_abrirLocal.setActionCommand("abrirLocal");
		panelCerrado.add(btn_abrirLocal);
		
		this.setVisible(true);
		
		this.panelAbierto = new JPanel();
		this.panelAbierto.setVisible(false);
		this.contentPane.add(this.panelAbierto, "name_1056406711033900");

		this.panelAbierto.setLayout(new BoxLayout(this.panelAbierto, BoxLayout.X_AXIS));
		
		this.panel_1 = new JPanel();
		this.panelAbierto.add(this.panel_1);
		this.list_Mesas = new JList();
		this.panel_1.add(this.list_Mesas);
		
		this.text_nroMesa = new JTextField();
		this.panel_1.add(this.text_nroMesa);
		this.text_nroMesa.setColumns(10);
		
		this.panel = new JPanel();
		this.panel_1.add(this.panel);
		this.panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.btn_agregarProducto = new JButton("Agregar producto");
		this.btn_agregarProducto.addActionListener(this);
		this.panel.add(this.btn_agregarProducto);
		btn_agregarProducto.setActionCommand("agregarProducto");
		
		this.btn_OcuparMesa = new JButton("Ocupar Mesa");
		this.btn_OcuparMesa.addActionListener(this);
		this.panel.add(this.btn_OcuparMesa);
		btn_OcuparMesa.setActionCommand("ocuparMesa");
		
		this.btn_CerrarMesa = new JButton("Cerrar mesa");
		this.btn_CerrarMesa.addActionListener(this);
		this.panel.add(this.btn_CerrarMesa);
		btn_CerrarMesa.setActionCommand("cerrarMesa");
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toString())
		{
		case "abrirLocal": abrirLocal(); break;
		case "agregarProducto": agregarProducto(); break;
		case "ocuparMesa": ocuparMesa(); break;
		case "cerrarMesa": cerrarMesa(); break;
		}
	}
	
	private void abrirLocal()
	{
		int numero = Integer.parseInt(texto_nroMesas.getText());
		if (numero > 0)
		{
			this.negocio.abrirLocal(numero);

			this.panelCerrado.setVisible(false);
			this.panelAbierto.setVisible(true);
		}
		else
		{
			mostrarMensajeError("Numero menor a 0");
		}
	}
	private void agregarProducto()
	{
		int numero = Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			this.negocio.agregarProducto(numero, 50f);
		}
		else
		{
			mostrarMensajeError("Numero menor a 0");
		}
	}
	private void ocuparMesa()
	{
		int numero = Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			this.negocio.ocuparMesa(numero);
		}
		else
		{
			mostrarMensajeError("Numero menor a 0");
		}
	}
	private void cerrarMesa()
	{
		int numero = Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			mostrarImporte(this.negocio.cerrarMesa(numero));
		}
		else
		{
			mostrarMensajeError("Numero menor a 0");
		}
	}
	
	public void mostrarMesas(String[] mesas)
	{
		this.list_Mesas.setListData(mesas);
	}
	public void mostrarMensajeError(String mensaje)
	{
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void mostrarImporte(float importe)
	{
        JOptionPane.showMessageDialog(null, "Importe Total = " + Float.toString(importe) , "Importe", JOptionPane.INFORMATION_MESSAGE);
	}

}
