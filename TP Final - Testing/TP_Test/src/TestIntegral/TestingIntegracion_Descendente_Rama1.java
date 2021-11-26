package TestIntegral;

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

public class TestingIntegracion_Descendente_Rama1 {

	private Paciente paciente;

	@Before
	public void setUp()
	{
			
		paciente=null;
		
		try {
			paciente = PacienteFactory.getPaciente("12345392", "Juan", "Salto", "Mar del plata", "47544123", "Calle 13", "Mayor");
			Clinica.getInstance().ingresoPaciente(paciente);
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() 
	{
	}
	
	@Test
	public void Test()
	{
		//Mismo paciente
		Assert.assertEquals(Clinica.getInstance().getPacientes().getPacientesBD().iterator().next(), paciente);
	}
	
}
