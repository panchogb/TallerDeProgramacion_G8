package modelo;

import java.util.HashMap;

import excepciones.AlumnoNoExisteException;
/**
 * 
 * Clase que representa los certificados de los alumnos 
 *
 */
public class Certificado {
	private int legajo;
	private String nombre,apellido; 
	private boolean seEncontro=false;
	private HashMap<String,Materia> materias = new HashMap<String,Materia>();

	/**
	 * PRE:
	 * 
	 * POS:Se actualizan las varibles internas del certificado respecto al alumno
	 * 
	 * @param legajo  : numero con el que se identifica al alumno
	 * @throws AlumnoNoExisteException : si no se encuentra al alumno
	 */
	 public void pedirCertificado(int legajo) throws AlumnoNoExisteException {
		 try {
			 Alumno alumno = Escuela.getInstance().getAlumnos().get(legajo);
			 this.legajo=alumno.getLegajo();
			 this.nombre=alumno.getNombre();
			 this.apellido=alumno.getApellido();
			 this.materias=alumno.getMaterias();
			 seEncontro=true;
		 }
		 catch(Exception e){
			 throw new AlumnoNoExisteException("No existe un alumno con ese legajo");
		 }
	 }
	 
	 /**
	  * PRE: 
	  * 
	  * POS: devuelve el apellido y nombre del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerApellidoYNombre() throws AlumnoNoExisteException {
		 if(!seEncontro)
			 throw new AlumnoNoExisteException();
		return this.apellido + " "+ this.nombre;
		 
	 }
	 /**
	  * PRE: la materia tiene que ser una de las cuatro (Historia, Matemática, Literatura o Fisica)
	  * 
	  * POS: devuelve el estado en una materia del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerEstado(String materia) throws AlumnoNoExisteException {
		 if(!seEncontro)
			 throw new AlumnoNoExisteException();
		 return this.materias.get(materia).getEstado();
	 }
	 /**
	  * PRE: la materia tiene que ser una de las cuatro (Historia, Matemática, Literatura o Fisica)
	  * 
	  * POS: devuelve la nota en una materia del alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerNota(String materia) throws AlumnoNoExisteException {
		 if(!seEncontro)
			 throw new AlumnoNoExisteException();
		 return this.materias.get(materia).getNota();
	 }
	 
	 /**
	  * PRE:
	  * 
	  * POS: devuelve la condicion el la cual se encuentra el alumno
	  *
	  * @throws AlumnoNoExisteException : si no se encontro a un alumno anteriormente
	  */
	 public String traerCondicion() throws AlumnoNoExisteException {
		 if(!seEncontro)
			 throw new AlumnoNoExisteException();
		 int cont=0;
		 for(Materia i: materias.values()) {
			 if(i.getEstado()=="A cursar")
				 cont++;
		 }
		if(cont>=2)
			return "irregular";
		else
			return "regular";
		 
	 }

	@Override
	public String toString() {
		return "Certificado [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", materias="
				+ materias + "]";
	}
	
	
}
