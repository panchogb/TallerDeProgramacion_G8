package TestCajaBlanca;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import modelo.BDdeMedicos;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestCamino3 {

	private Paciente paciente;
	private ArrayList<Double> insumos;
	
	@Before
	public void setUp()
	{
		insumos = new ArrayList<Double>();
		insumos.add(250.0);
	}
	@Test
	public void Test()
	{		
		Assert.assertEquals(0.0, Clinica.getInstance().calculoImporteAdicionales(2, new Date(2021,5,13), insumos), 1e-6);
	}
	
}
