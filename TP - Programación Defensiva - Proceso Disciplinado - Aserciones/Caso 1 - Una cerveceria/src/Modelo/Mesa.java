package Modelo;

import Excepciones.MesaIncorrectaExcepcion;

public class Mesa {
	private int nroMesa;
	private char uso;
	private int productos;
	private float importeTotal;
	
	private static int cantMesas = 0;
	
	public Mesa()
	{
		nroMesa = cantMesas++;
		uso = 'L';
		productos = 0;
		importeTotal = 0f;
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
			throw new MesaIncorrectaExcepcion("Mesa ocupada");
		}
		uso = 'O';
	}
	
    /**   
     * PRE: el precio debe ser positivo
     * POS: a la mesa se le agrega el importe mas el producto
     * 	 * @throws MesaIncorrectaExcepcion : cuando ya esta liberada
     */
	public void agregarProducto(float precio) throws MesaIncorrectaExcepcion
	{
		assert precio > 0 : "Precio incorrecto";
		if (uso == 'L')
		{
			throw new MesaIncorrectaExcepcion("mesa disponible");
		}
		
		this.importeTotal +=  precio;		
		this.productos++;		
	}

    /**   
     * PRE:
     * POS: la mesa cambia de estado a mesa cerrada
     * 	 * @throws MesaIncorrectaExcepcion : cuando ya esta liberada
     */
	public float cerrarMesa() throws MesaIncorrectaExcepcion
	{
		if (uso == 'L')
		{
			throw new MesaIncorrectaExcepcion("la mesa esta libre");
		}
		uso = 'L';
		return importeTotal;
	}
	
	@Override
	public String toString()
	{
		String mensaje = "NumMesa = "+ nroMesa + "| uso = " + uso;
		if (uso == 'O')
		{
			mensaje += "| productos = " + productos + "| importe total = " + importeTotal;
		}
		return mensaje;
	}
}
