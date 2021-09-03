package excepciones;

/**
 * 
 * Esta excepcicion se utiliza por ingresos invalidos de cargas
 *
 */
public class CargaInvalidaException extends Exception {

	public CargaInvalidaException() {
		// TODO Auto-generated constructor stub
	}

	public CargaInvalidaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CargaInvalidaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CargaInvalidaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CargaInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
