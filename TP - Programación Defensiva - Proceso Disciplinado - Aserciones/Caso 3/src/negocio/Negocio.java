package negocio;

import modelo.AlumnoNoExisteException;
import modelo.Certificado;
/**
 * 
 * Clase encargada de la capa negocio
 *
 */
public class Negocio {
	private Certificado certificado;
	
	/**
	 * PRE:
	 * 
	 * POS:Se actualizan las varibles internas del certificado respecto al alumno
	 * 
	 * @param legajo  : numero con el que se identifica al alumno
	 * @throws AlumnoNoExisteException : si no se encuentra al alumno
	 */
	 public void pedirCertificado(int legajo) throws AlumnoNoExisteException {
		 certificado= new Certificado();
		 certificado.pedirCertificado(legajo);
	 }
	 /**
	  * PRE: 
	  * 
	  * POS: devuelve el apellido y nombre del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerApellidoYNombre() throws AlumnoNoExisteException {
		 return certificado.traerApellidoYNombre();
	 }
	 /**
	  * PRE: la materia tiene que ser una de las cuatro (Historia, Matemática, Literatura o Fisica)
	  * 
	  * POS: devuelve el estado en una materia del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerEstado(String materia) throws AlumnoNoExisteException {
		 assert materia=="Historia" || materia=="Matematica"|| materia=="Literatura"|| materia=="Fisica":"no existe esa materia"; 
		return certificado.traerEstado(materia);
	 }
	 /**
	  * PRE: la materia tiene que ser una de las cuatro (Historia, Matemática, Literatura o Fisica)
	  * 
	  * POS: devuelve la nota en una materia del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerNota(String materia) throws AlumnoNoExisteException {
		 assert materia=="Historia" || materia=="Matematica"|| materia=="Literatura"|| materia=="Fisica":"no existe esa materia";  
		 return certificado.traerNota(materia);
	 }
	 /**
	  * PRE:
	  * 
	  * POS: devuelve la condicion el la cual se encuentra el alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerCondicion() throws AlumnoNoExisteException {
		 return certificado.traerCondicion();
	 }

	public Certificado getCertificado() {
		return certificado;
	}
	 
}
