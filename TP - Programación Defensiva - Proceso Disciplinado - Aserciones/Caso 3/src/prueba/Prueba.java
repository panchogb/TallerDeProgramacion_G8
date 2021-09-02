package prueba;

import modelo.Alumno;
import modelo.Escuela;
import ui.UI;

public class Prueba {

	public static void main(String[] args) {
		Escuela.getInstance().addAlumno(new Alumno(1,"Fran","kafca"));
		UI ui = new UI();
		ui.pedirCertificado(1);
		ui.mostrarEstado("Fisica");
		ui.mostrarCertificado();

	}

}
