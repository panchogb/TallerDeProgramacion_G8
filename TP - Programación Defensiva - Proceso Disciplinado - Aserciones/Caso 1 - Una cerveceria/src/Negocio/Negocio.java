package Negocio;
import Vista.IVista;
import Vista.Ventana;
import Excepciones.MesaIncorrectaExcepcion;
import Excepciones.NumeroMesaMayorExcepcion;
import Modelo.BeerHouse;
import Modelo.Mesa;


public class Negocio{
	
	private IVista vista;
	private BeerHouse beerHouse;
	
	public Negocio(Ventana ventana)
	{
		this.vista = ventana;
		this.vista.setNegocio(this);
		this.beerHouse = new BeerHouse();
	}
    /**   
     * PRE: la cantidad de mesas debe ser mayor e igual a 1
     * POS: se crean la cantidad de mesas definidas
     * @param cantMesas : cantidad de mesas que se abriran
     */
	public void abrirLocal(int cantMesas)
	{
		beerHouse.abrirLocal(cantMesas);
		
		vista.mostrarMesas(beerHouse.mostrarMesas());
	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: la mesa cambia de estado a mesa ocupada
     * @param nroMesa : el numero de mesa que se va a ocupar
     * @return devuelve la mesa ocupada o null en caso de error
     */
	public Mesa ocuparMesa(int nroMesa)
	{
		Mesa mesa = null;
		try {
			mesa = beerHouse.ocuparMesa(nroMesa);
			vista.mostrarMesas(beerHouse.mostrarMesas());
		} catch (NumeroMesaMayorExcepcion | MesaIncorrectaExcepcion e) {
			vista.mostrarMensajeError(e.getMessage());
		}
		return mesa;

	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: la mesa cambia de estado a mesa ocupada
     * @param nroMesa : el numero de mesa que se va a cerrar
     * @return devuelve el importe de la mesa o 0 en caso de error
     */
	public float cerrarMesa(int nroMesa)
	{
		float importe = 0;
		try {
			importe = beerHouse.cerrarMesa(nroMesa);
			vista.mostrarMesas(beerHouse.mostrarMesas());
		} catch (NumeroMesaMayorExcepcion | MesaIncorrectaExcepcion e) {
			vista.mostrarMensajeError(e.getMessage());
		}
		return importe;
	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: agrega un producto a la mesa con su importe
     * @param nroMesa : el numero de mesa que se va a agregar el producto
     * @param precio : precio del producto
     */
	public void agregarProducto(int nroMesa, float precio)
	{
		try {
			beerHouse.agregarProducto(nroMesa, precio);
			vista.mostrarMesas(beerHouse.mostrarMesas());
		} catch (NumeroMesaMayorExcepcion | MesaIncorrectaExcepcion e) {
			vista.mostrarMensajeError(e.getMessage());
		}
	}
}
