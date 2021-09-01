package Modelo;

import Excepciones.MesaIncorrectaExcepcion;
import Excepciones.NumeroMesaMayorExcepcion;

public class BeerHouse {
	private Mesa[] mesas;
	
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
	}
	
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: la mesa cambia de estado a mesa ocupada
     * @param nroMesa : el numero de mesa que se va a ocupar
     * @return devuelve la mesa ocupada
     * 	 * @throws NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * 	 * @throws MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
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
     * @param cantMesas : el numero de mesa que se va a cerrar
     * @return devuelve el gasto de la mesa
     * 	 * @throws NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * 	 * @throws MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
     */
	public float cerrarMesa(int nroMesa) throws NumeroMesaMayorExcepcion, MesaIncorrectaExcepcion
	{
		numeroDeMesaCorrecta(nroMesa);
		
		return mesas[nroMesa].cerrarMesa();
	}
    /**   
     * PRE: el numero de mesa debe ser mayor o igual 0
     * POS: se agrega a la mesa el producto con su precio
     * @param cantMesas : el numero de mesa que se va a cerrar
     * @return devuelve el gasto de la mesa
     * 	 * @throws NumeroMesaMayorExcepcion : cuando el numero de mesa sobrepasa la cantidad de mesas
     * 	 * @throws MesaIncorrectaExcepcion : cuando la mesa no esta en el estado correcto
     */
	public void agregarProducto(int nroMesa, float precio) throws NumeroMesaMayorExcepcion, MesaIncorrectaExcepcion
	{
		numeroDeMesaCorrecta(nroMesa);		
		mesas[nroMesa].agregarProducto(precio);
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
}
