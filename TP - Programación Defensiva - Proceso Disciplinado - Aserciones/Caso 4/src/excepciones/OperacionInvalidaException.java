package excepciones;

/**
 * Excepcion que se lanza si el signo de la operacion es invalido
 * 
 *
 */
@SuppressWarnings("serial")
public class OperacionInvalidaException extends Exception {

	public OperacionInvalidaException() {
		super("Operacion no valida");
		
	}
	
}
