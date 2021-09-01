package modelo;

import java.util.HashMap;

public class Escuela {
	private static Escuela instance=null;
	private HashMap<Integer,Alumno> alumnos = new HashMap<Integer,Alumno>();
	
	private Escuela() {
		
	}
	
	public static Escuela getInstance() {
		if (Escuela.instance == null) {
			Escuela.instance = new Escuela();
		}
		return instance;
	}
	
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumno.getLegajo(), alumno);
	}

	public HashMap<Integer, Alumno> getAlumnos() {
		return alumnos;
	}
	
	
}
