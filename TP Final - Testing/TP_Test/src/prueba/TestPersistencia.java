package prueba;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import persistencia.PacienteDTO;
import persistencia.Persistencia;
import personas.Joven;
import personas.Mayor;
import personas.Paciente;
import util.Util;

/**
 * 
 * Clase de prueba de Persistencia de pacientes.
 *
 */

public class TestPersistencia {
	
	private PacienteDTO pacientes;
	private Persistencia persistencia;
	
	
	public TestPersistencia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que inicializa las clases para probar persistencia. Inicia una lista de pacientes vacia.
	 * Si hay un archivo con el mismo nombre lo elimina.
	 */
	public void setUpVacio() {
		
		pacientes=new PacienteDTO();
		persistencia=new Persistencia();
		File archivo=new File("paciente.bin");
		if(archivo.exists()){
			archivo.delete();
		}
	}
	
	/**
	 * Metodo que inicializa las clases para probar persistencia. Inicia una lista de pacientes con dos pacientes.
	 * Si hay un archivo con el mismo nombre lo elimina.
	 */
	public void setUpLleno() {
		setUpVacio();
		ArrayList<Paciente> listapacientes= new ArrayList<Paciente>();
		Paciente paciente1=new Joven("12345678","Juan","Miguel", "Mar del Plata", "4448888","Calle 1");
		Paciente paciente2=new Mayor("11122233","Elida","Gomez","Buenos Aires", "4446789", "Calle 35");
		listapacientes.add(paciente1); listapacientes.add(paciente2);
		pacientes.setPacientes(listapacientes);
	}
	
	/**
	 * Verifica la creacion de un archivo.
	 */
	@Test
	public void TestCrearArchivo() {
		setUpVacio();
		try {
			persistencia.abrirOutput("paciente.bin");
			File archivo=new File("paciente.bin");
			persistencia.escribir(pacientes);
			Assert.assertTrue("Deberia existir el archivo paciente.bin",archivo.exists());
			persistencia.cerrarOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Verifica la escritura y lectura de un archivo con una lista de pacientes vacia.
	 */
	@Test
	public void TestPacientesVacioArchivo() {
		setUpVacio();
		try {
			persistencia.abrirOutput("paciente.bin");
			persistencia.escribir(pacientes);
			persistencia.abrirInput("paciente.bin");
			try {
				PacienteDTO pacientes2=(PacienteDTO) persistencia.leer();
				Assert.assertFalse(pacientes.equals(pacientes2));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica la escritura y lectura de un archivo con una lista de pacientes no vacia.
	 */
	@Test
	public void TestBDPacientes() {
		setUpLleno();
		try {
			persistencia.abrirOutput("paciente.bin");
			persistencia.escribir(pacientes);
			persistencia.abrirInput("paciente.bin");
			try {
				PacienteDTO pacientes2=(PacienteDTO) persistencia.leer();
				Assert.assertFalse(pacientes.equals(pacientes2));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Verifica que se informe si se intenta leer un archivo inexistente
	 */
	@Test
	public void despersistirArchivoInexistente() {
		setUpVacio();
		try {
			persistencia.abrirInput("archivo.bin");
			pacientes=(PacienteDTO) persistencia.leer();
			Assert.fail("Deberia indicar que no existe el archivo");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@After
	public void limpiar() {
		try {
			persistencia.cerrarInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			persistencia.cerrarOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File archivo=new File("paciente.bin");
		if(archivo.exists()) {
			archivo.delete();
		}
	}
}
