package Modelo;

public class Producto {
	private String nombre;
	private float precio;

    /**   
     * PRE: el nombre debe tener mas de 1 caracter y el precio ser mayor o igual a 0
     * POS: se agrega a la mesa el producto con su precio
     * @param nombre : nombre de producto
     * @param precio : precio del producto
     */
	public Producto(String nombre, float precio)
	{
		assert precio >= 0 : "nombre incorrecto";
		assert nombre.length() > 0 : "nombre incorrecto";
		
		this.nombre = nombre;
		this.precio = precio;
	}
	public float getPrecio()
	{
		return precio;
	}
	@Override
	public String toString()
	{
		return nombre + "| $" + precio;
	}
}
