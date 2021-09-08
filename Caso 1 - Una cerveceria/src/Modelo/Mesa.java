package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.MesaIncorrectaExcepcion;

public class Mesa {
	private int nroMesa;
	private char uso;
	private ArrayList<Producto> productos;
	
	private static int cantMesas = 0;
	
	public Mesa()
	{
		nroMesa = cantMesas++;
		uso = 'L';
		productos = new ArrayList<Producto>();
	}

    /**   
     * PRE:
     * POS: la mesa cambia de estado a mesa ocupada
     * 	 * @throws MesaIncorrectaExcepcion : cuando ya esta ocupada
     */
	public void ocuparMesa() throws MesaIncorrectaExcepcion
	{
		if (uso == 'O')
		{
			throw new MesaIncorrectaExcepcion("Mesa ya ocupada");
		}
		uso = 'O';
	}
	
    /**   
     * PRE: producto debe ser distinto a nulo
     * POS: a la mesa se le agrega el importe mas el producto
     * @param producto : referencia al producto que se va a agregar a la mesa
     * 	 * @throws MesaIncorrectaExcepcion : cuando ya esta liberada
     */
	public void agregarProducto(Producto producto) throws MesaIncorrectaExcepcion
	{
		assert producto != null : "Producto nulo";
		if (uso == 'L')
		{
			throw new MesaIncorrectaExcepcion("mesa vacia");
		}
		
		productos.add(producto);	
	}

    /**   
     * PRE:
     * POS: la mesa cambia de estado a mesa cerrada
     * 	 * @throws MesaIncorrectaExcepcion : cuando ya esta liberada
     */
	public String cerrarMesa() throws MesaIncorrectaExcepcion
	{
		if (uso == 'L')
		{
			throw new MesaIncorrectaExcepcion("la mesa esta libre");
		}
		uso = 'L';
		return DevolverResumen();
	}


    /**   
     * PRE: productos debe ser distinto a null
     * POS: devuelve el los productos y el importe total de la mesa
     */
	private String DevolverResumen()
	{
		Iterator it = productos.iterator();
		String mensaje = "Productos:\n";
		float importe = 0;
		while (it.hasNext())
		{
			Producto producto = (Producto)it.next();
			
			mensaje += "   " + producto.toString() + '\n';
			
			importe += producto.getPrecio();
		}
		mensaje += "------------------------\n";
		mensaje += "Importe total = $" + importe;
		return mensaje;
	}
	
    /**   
     * PRE: productos debe ser distinto a null
     * POS: devuelve el importe total de la mesa
     */
	private float calcularImporte()
	{
		Iterator it = productos.iterator();
		float importe = 0;
		while (it.hasNext())
		{			
			importe += ((Producto) it.next()).getPrecio();
		}
		return importe;
	}
	
	@Override
	public String toString()
	{
		String mensaje = "NumMesa = "+ nroMesa + "| uso = " + uso;
		if (uso == 'O')
		{
			mensaje += "| cant productos = " + productos.size() + "| importe total = $" + calcularImporte();
		}
		return mensaje;
	}
}
