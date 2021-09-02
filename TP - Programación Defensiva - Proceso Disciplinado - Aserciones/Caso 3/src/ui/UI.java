package ui;

import excepciones.AlumnoNoExisteException;
import negocio.Negocio;

/**
 * 
 * Clase que representa la interfaz de usuario
 *
 */
public class UI {
	private Negocio negocio =new Negocio();
	/**
	 * PRE:
	 * 
	 * POS:Se actualizan las varibles internas del certificado respecto al alumno
	 * 
	 * @param legajo  : numero con el que se identifica al alumno
	 * @throws AlumnoNoExisteException : si no se encuentra al alumno
	 */
	public void pedirCertificado(int legajo) {
		try {
			negocio.pedirCertificado(legajo);
		} catch (AlumnoNoExisteException e) {
			System.out.println(e.getMessage());
			
		}
	}
	 /**
	  * PRE: la materia tiene que ser una de las cuatro (Historia, Matemática, Literatura o Fisica)
	  * 
	  * POS: devuelve el estado en una materia del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	public void mostrarEstado(String materia) {
		try {
			System.out.println(negocio.traerEstado(materia));
		} catch (AlumnoNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * PRE: se debe haber encontrado anteriormente el legajo
	 * 
	 * POS: muestra el certificado del alumno con el legajo encontrado 
	 */
	public void mostrarCertificado() {
		System.out.println(negocio.getCertificado());
	}
	
}
