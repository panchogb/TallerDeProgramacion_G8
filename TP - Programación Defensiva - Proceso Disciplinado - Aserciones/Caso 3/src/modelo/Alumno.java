package modelo;

import java.util.HashMap;
/**
 * 
 * Clase que representa los alumnos donde es guardada su informacion basica y la de sus materias
 *
 */
public class Alumno {
	private int legajo;
	private String nombre,apellido; 
	private HashMap<String,Materia> materias = new HashMap<String,Materia>();
	
	public Alumno(int legajo, String nombre, String apellido) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		materias.put("Historia", new Materia("Historia"));
		materias.put("Matematica", new Materia("Matematica"));
		materias.put("Literatura", new Materia("Literatura"));
		materias.put("Fisica", new Materia("Fisica"));
	}

	public void setNotaMateria(String materia, String nota) {
		materias.get(materia).setNota(nota);
	}
	
	public void setCondicionMateria(String materia, String estado) {
		materias.get(materia).setEstado(estado);
	}
	
	
	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public HashMap<String, Materia> getMaterias() {
		return materias;
	}
	
	
	
	
}
