package excepciones;

@SuppressWarnings("serial")
/**
 * Excepcion que sera lanzada en caso de que se pidan datos de un alumno que no este en la base
 * o en caso de que se pidan los datos antes de buscar un alumno
 * 
 *
 */
public class AlumnoNoExisteException extends Exception {

	public AlumnoNoExisteException(String message) {
		super(message);
	}
	
	public AlumnoNoExisteException() {
		super("no se ingreso legajo o se ingreso uno incorrecto");
	}
	
	
}
