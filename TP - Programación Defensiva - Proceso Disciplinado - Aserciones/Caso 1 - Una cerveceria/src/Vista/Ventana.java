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
	private JButton btn_CerrarMesa;
	private JButton btn_agregarProducto;
	private JButton btn_OcuparMesa;
	private JPanel panel;
	private JPanel panel_1;

	private Negocio negocio;
	private JList list_productos;

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
		setBounds(100, 100, 700, 300);
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
		this.panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 6));
		this.list_Mesas = new JList();
		this.panel_1.add(this.list_Mesas);
		
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
		
		this.list_productos = new JList();
		this.panel_1.add(this.list_productos);
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
		try
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
				mostrarMensajeError("Cantidad de mesas incorrectas");
			}
		}
		catch (NumberFormatException e)
		{
			mostrarMensajeError("Cantidad de mesas incorrectas");
		}
	}
	private void agregarProducto()
	{
		int numero = list_Mesas.getSelectedIndex();//Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			int indice = list_productos.getSelectedIndex();
			if (indice >= 0)
			{
				this.negocio.agregarProducto(numero, indice);
			}
			else
			{
				mostrarMensajeError("No se ha seleccionado un producto");
			}
		}
		else
		{
			mostrarMensajeError("No se ha seleccionado una mesa");
		}
	}
	private void ocuparMesa()
	{
		int numero = list_Mesas.getSelectedIndex();//Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			this.negocio.ocuparMesa(numero);
		}
		else
		{
			mostrarMensajeError("No se ha seleccionado una mesa");
		}
	}
	private void cerrarMesa()
	{
		int numero = list_Mesas.getSelectedIndex();//Integer.parseInt(text_nroMesa.getText());
		if (numero >= 0)
		{
			mostrarDatosMesa(this.negocio.cerrarMesa(numero));
		}
		else
		{
			mostrarMensajeError("No se ha seleccionado una mesa");
		}
	}
	
	public void mostrarMesas(String[] mesas)
	{
		this.list_Mesas.setListData(mesas);
	}
	public void mostrarProductos(String[] productos)
	{
		this.list_productos.setListData(productos);
	}
	public void mostrarMensajeError(String mensaje)
	{
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void mostrarDatosMesa(String mensaje)
	{
        JOptionPane.showMessageDialog(null, mensaje , "Importe", JOptionPane.INFORMATION_MESSAGE);
	}

}
