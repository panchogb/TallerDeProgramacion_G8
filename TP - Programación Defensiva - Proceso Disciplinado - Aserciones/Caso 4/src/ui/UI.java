package ui;

import excepciones.DivisionPorCeroException;
import excepciones.OperacionInvalidaException;
import excepciones.ResultadoNegativoException;
import negocio.Negocio;
/**
 * 
 * Clase que representa la interfaz de usuario
 *
 */
public class UI {
	private Negocio negocio;
	public UI() {
		negocio= new Negocio();
	}
	/**
	 * PRE: Los operando tienen que ser positivos 
	 * 
	 * POS: Muestra el resultado de la operacion
	 * 
	 * @param PrimerOperando El primer operando
	 * @param SegundoOperando El segundo operando
	 * @param Operacion El signo de la operacion	 * 
	 */
	public void calcular(int PrimerOperando, int SegundoOperando, String Operacion) {

			try {
				System.out.println(PrimerOperando+" "+Operacion+" "+SegundoOperando+" = "+negocio.calcular(PrimerOperando, SegundoOperando, Operacion));
			} catch (OperacionInvalidaException | DivisionPorCeroException | ResultadoNegativoException e) {
				System.out.println(e.getMessage());
			}
			
	}
	/**
	 * PRE: Se debe haber hecho un calculo anteriormente
	 * 
	 * POS: Muestra el resultado de la última operación exitosa.
	 *
	 */
	public void mostrarResultado() {
		System.out.println(negocio.traerResultado());
	}
}
