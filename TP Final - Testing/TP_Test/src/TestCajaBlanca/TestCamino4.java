package TestCajaBlanca;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import modelo.BDdeMedicos;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestCamino4 {

	private Paciente paciente;
	private ArrayList<Double> insumos;
	
	private Factura factura;
	
	@Before
	public void setUp()
	{
		try {
			paciente = PacienteFactory.getPaciente("11751542", "pepe", "botella", "Madrid", "1254432", "Calle 1", "Mayor");
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		insumos = new ArrayList<Double>();
		//insumos.add(200.0);
		
		factura = new Factura(1, new GregorianCalendar(25, 10, 2021), paciente);
		
		Clinica.getInstance().ingresoPaciente(paciente);
		Clinica.getInstance().atenderPaciente(paciente);
		Clinica.getInstance().egreso(paciente, factura);
	}
	@Test
	public void Test()
	{		
		Assert.assertEquals(0.0, Clinica.getInstance().calculoImporteAdicionales(2, new Date(2021,15,25), insumos), 1e-6);
	}
	
}