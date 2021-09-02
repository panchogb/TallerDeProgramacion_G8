package prueba;

import negocio.Negocio;
import vista.Interfaz;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz ventana=new Interfaz();
		Negocio negocio=new Negocio(ventana);
	}

}
