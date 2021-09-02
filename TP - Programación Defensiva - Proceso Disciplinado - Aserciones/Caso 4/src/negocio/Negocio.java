package negocio;

import excepciones.DivisionPorCeroException;
import excepciones.OperacionInvalidaException;
import excepciones.ResultadoNegativoException;
import modelo.Calcular;
/**
 * 
 * Clase encargada de la capa negocio
 *
 */
public class Negocio {
	private Calcular calcular;
	
	public Negocio() {
		calcular= new Calcular();
	}
	/**
	 * PRE: Los operando tienen que ser positivos 
	 * 
	 * POS: Devuelve el resultado de la operacion
	 * 
	 * @param PrimerOperando El primer operando
	 * @param SegundoOperando El segundo operando
	 * @param Operacion El signo de la operacion
	 * @return El resultado de la operacion
	 * @throws OperacionInvalidaException Si el signo es incorrecto
	 * @throws DivisionPorCeroException Si se intenta hacer una division por cero
	 * @throws ResultadoNegativoException Si se hace una resta donde el segundo operando es mayor
	 */
	public int calcular(int PrimerOperando, int SegundoOperando, String Operacion) throws OperacionInvalidaException, DivisionPorCeroException, ResultadoNegativoException {
		return calcular.calcular(PrimerOperando, SegundoOperando, Operacion);
	}
	/**
	 * PRE: Se debe haber hecho un calculo anteriormente
	 * 
	 * POS: Devuelve el resultado de la última operación exitosa.
	 * 
	 * @return El resultado de la operacion exitosa anterior
	 */
	public int traerResultado() {
		return calcular.traerResultado();
	}
}
