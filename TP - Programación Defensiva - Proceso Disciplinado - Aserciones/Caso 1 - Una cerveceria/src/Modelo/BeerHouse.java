package Modelo;

import Excepciones.MesaIncorrectaExcepcion;
import Excepciones.NumeroMesaMayorExcepcion;
import Excepciones.ProductoIncorrectoExcepcion;

public class BeerHouse {
	private Mesa[] mesas;
	private Producto[] productos;
	
    /**   
     * PRE: la cantidad de mesas debe ser mayor e igual a 1
     * POS: se crean la cantidad de mesas definidas
     * @param cantMesas : cantidad de mesas que se abriran
     */
	public void abrirLocal(int cantMesas)
	{
		assert cantMesas >= 1 : "cantidad menor a 1";
		
		mesas = new Mesa[cantMesas];
		
		for (int i = 0; i < cantMesas; i++)
		{
			mesas[i] = new Mesa();
		}
		
		productos = new Producto[] { 
				new Producto("Hamburguesa Simple", 450), 
				new Producto("Hamburguesa con Queso", 500),
				new Producto("Agua", 100), 
				new Producto("Gaseosa", 200),
				new Producto("Cerveza", 200),
		};
	}
	
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: la mesa cambia de estado a mesa ocupada
     * @param nroMesa : el numero de mesa que se va a ocupar
     * @return devuelve la mesa ocupada
     * @exception NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * @exception MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
     */
	public Mesa ocuparMesa(int nroMesa) throws NumeroMesaMayorExcepcion, MesaIncorrectaExcepcion
	{
		numeroDeMesaCorrecta(nroMesa);
		
		mesas[nroMesa].ocuparMesa();		
		return mesas[nroMesa];
	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: se cierra la mesa 
     * @param nroMesa : el numero de mesa que se va a cerrar
     * @return devuelve en un string los productos y el gasto total
     * @exception NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * @exception MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
     */
	public String cerrarMesa(int nroMesa) throws NumeroMesaMayorExcepcion, MesaIncorrectaExcepcion
	{
		numeroDeMesaCorrecta(nroMesa);
		
		return mesas[nroMesa].cerrarMesa();
	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: se agrega a la mesa el producto con su precio
     * @param nroMesa : el numero de mesa en la que se agrega el producto
     * @param indice : indice del producto que se va a agregar
     * @exception NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * @exception MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
     * @exception ProductoIncorrectoExcepcion : cuando el producto no es correcto
     */
	public void agregarProducto(int nroMesa, int indice) throws NumeroMesaMayorExcepcion, MesaIncorrectaExcepcion, ProductoIncorrectoExcepcion
	{
		numeroDeMesaCorrecta(nroMesa);
		productoCorrecto(indice);
		
		mesas[nroMesa].agregarProducto(productos[indice]);
	}
	private void productoCorrecto(int indice) throws ProductoIncorrectoExcepcion
	{
		if (indice >= productos.length)
		{
			throw new ProductoIncorrectoExcepcion("Indice de producto Incorrecto");
		}
	}
	private void numeroDeMesaCorrecta(int nroMesa) throws NumeroMesaMayorExcepcion
	{
		assert nroMesa >= 0 : "nroMesa erroneo";
		if (nroMesa >= mesas.length)
		{
			throw new NumeroMesaMayorExcepcion("numero de mesa mayor al disponible");
		}
	}

    /**   
     * PRE: debe estar abierto el local
     * POS: carga la informacion de las mesas en un array de strings
     * @return devuelve la informacion de todas las mesas
     */
	public String[] mostrarMesas()
	{
		assert mesas != null : "no esta abierto el local";
		
		String[] mensajes = new String[mesas.length];
		for (int i = 0; i < mesas.length; i++)
		{
			mensajes[i] = mesas[i].toString();
		}
		return mensajes;
	}
    /**   
     * PRE: debe estar abierto el local
     * POS: carga la informacion de los productos en un array de strings
     * @return devuelve la informacion de todos los productos
     */
	public String[] mostrarProductos()
	{
		assert mesas != null : "no esta abierto el local";
		
		String[] mensajes = new String[productos.length];
		for (int i = 0; i < productos.length; i++)
		{
			mensajes[i] = productos[i].toString();
		}
		return mensajes;
	}
}
