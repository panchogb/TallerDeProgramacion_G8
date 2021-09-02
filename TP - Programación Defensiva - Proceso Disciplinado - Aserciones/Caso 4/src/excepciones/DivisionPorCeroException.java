package excepciones;


/**
 * Excepcion que se lanza si se intenta dividir por cero
 * 
 */
@SuppressWarnings("serial")
public class DivisionPorCeroException extends Exception {

	public DivisionPorCeroException() {
		super("Intento hacer una division por cero");
		
	}
	
}
