package excepciones;

/**
 * 
 * Esta excepcion se utiliza cuando el deposito de combustible se encuentra vacio
 *
 */

public class VacioException extends Exception {

	public VacioException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VacioException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VacioException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VacioException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
