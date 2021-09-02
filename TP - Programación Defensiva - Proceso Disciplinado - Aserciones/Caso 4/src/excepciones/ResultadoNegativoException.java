package excepciones;


/**
 * Excepcion que se lanza si se intenta hacer una operacion que tenga signo negativo
 */
@SuppressWarnings("serial")
public class ResultadoNegativoException extends Exception {
	
	public ResultadoNegativoException() {
		super("El resultado no puede ser negativo");
		
	}
}
