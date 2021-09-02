package modelo;
/**
 * 
 * Clase que representa las distintas materia con su estado y nota
 *
 */
public class Materia {
	private String nombre;
	private String estado;
	private String nota;
	
	public Materia(String nombre) {
		this.nombre = nombre;
		this.estado = "A cursar";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}


	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", estado=" + estado + ", nota=" + nota + "]";
	}
	
	
	
}
