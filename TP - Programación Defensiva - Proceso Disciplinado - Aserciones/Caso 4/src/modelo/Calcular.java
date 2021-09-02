package modelo;

import excepciones.DivisionPorCeroException;
import excepciones.OperacionInvalidaException;
import excepciones.ResultadoNegativoException;
/**
 * 
 * Clase encargada de hacer los calculos
 *
 */
public class Calcular {
	private int resultado;
	
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
		assert PrimerOperando>=0 && SegundoOperando>=0:"Los valores tienen que ser positivos" ;
		
		switch(Operacion) {
		case "+":
			resultado= PrimerOperando + SegundoOperando;
			break;
		case "-":
			if(SegundoOperando>PrimerOperando) {
				throw new ResultadoNegativoException();
			}
			resultado= PrimerOperando - SegundoOperando;
			break;
		case "*":
			resultado= PrimerOperando * SegundoOperando;
			break;
		case "/":
			if(SegundoOperando==0)
				throw new DivisionPorCeroException();
			resultado= PrimerOperando / SegundoOperando;
			break;
		default:
			throw new OperacionInvalidaException();
		}

		return resultado;	
	}
	/**
	 * PRE: Se debe haber hecho un calculo anteriormente
	 * 
	 * POS: Devuelve el resultado de la última operación exitosa.
	 * 
	 * @return El resultado de la operacion exitosa anterior
	 */
	public int traerResultado() {
		return resultado;
	}
	
}
