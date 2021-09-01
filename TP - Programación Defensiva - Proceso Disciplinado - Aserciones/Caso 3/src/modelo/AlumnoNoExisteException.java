package modelo;

@SuppressWarnings("serial")
public class AlumnoNoExisteException extends Exception {

	public AlumnoNoExisteException(String message) {
		super(message);
	}
	
	public AlumnoNoExisteException() {
		super("no se ingreso legajo o se ingreso uno incorrecto");
	}
	
	
}
