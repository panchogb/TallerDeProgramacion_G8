package Factory;

import Modelo.Titular;
import Modelo.TitularFisico;
import Modelo.TitularJuridico;

/**
 * @author Taller1
 * 
 * Esta clase se encarga de instanciar los titulares de la empresa.
 */

public class TitularFactory {
	
	/**
	 * Este metodo estatico permite crear un nuevo titular. <br>
	 * 
	 * <b>pre:</b> La empresa existe (no es null). <br>
	 * <b>post:</b> Se crea un nuevo titular. <br>
	 * 
	 * @param tipo Es el tipo de titular que sera creado, puede ser "Fisico" o "Juridico".
	 * @param nombre Es el nombre del titular que sera creado !=null !="".
	 * @param dni Es el dni del titular, debe ser positivo.
	 * @param tipoDePago Es el tipo de pago, podra ser "Efectivo", "Cheque" o "Tarjeta".
	 * 
	 * @return Retorna el titular que ser� agregado a la empresa.
	 */
	public static Titular getTitular(String tipo, String nombre, int dni, String tipoDePago) {
		Titular respuesta = null;
		if (tipo.equals("Fisico")) {
			respuesta = new TitularFisico(nombre, dni, tipoDePago);
		} else {
			if (tipo.equals("Juridico")) {
				respuesta = new TitularJuridico(nombre, dni, tipoDePago);
			}
		}
		return respuesta;
	}
}
