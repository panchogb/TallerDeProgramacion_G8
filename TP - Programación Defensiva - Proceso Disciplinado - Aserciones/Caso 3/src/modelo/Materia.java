package modelo;

public class Materia {
	private String nombre;
	private String condicion;
	private String nota;
	
	public Materia(String nombre) {
		this.nombre = nombre;
		this.condicion = "A cursar";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}


	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", condicion=" + condicion + ", nota=" + nota + "]";
	}
	
	
	
}
