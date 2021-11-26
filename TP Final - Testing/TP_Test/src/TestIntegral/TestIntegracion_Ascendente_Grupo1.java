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

public class TestIntegracion_Ascendente_Grupo1 {

	private Paciente paciente1;

	@Before
	public void setUp()
	{
			
		paciente1=null;
		
		try {
			paciente1 = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Joven");
			
			Clinica.getInstance().getSalaEspera().ocupaSalaDeEspera(paciente1);			
			Clinica.getInstance().derivarPaciente(paciente1);
			
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
		Assert.assertEquals(Clinica.getInstance().getPatio().iterator().next(), paciente1);
	}
	
}
