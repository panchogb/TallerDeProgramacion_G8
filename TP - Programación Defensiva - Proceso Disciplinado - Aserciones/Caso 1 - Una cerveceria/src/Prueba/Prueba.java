package Prueba;

import Negocio.Negocio;
import Vista.Ventana;

public class Prueba {
	
	public static void main(String[] args) {		

		// TODO Auto-generated method stub
		String h = "Hola";
		String ho = "hola";
		
		System.out.println(h.equals(ho));
		Negocio ventana = new Negocio(new Ventana()); 
	}

}