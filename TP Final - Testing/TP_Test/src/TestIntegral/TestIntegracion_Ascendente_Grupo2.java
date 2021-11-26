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

public class TestIntegracion_Ascendente_Grupo2 {

	private Paciente paciente1;
	private Paciente paciente2;

	@Before
	public void setUp()
	{
			
		paciente1=null;
		paciente2=null;
		
		try {
			paciente1 = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Joven");
			paciente2 = PacienteFactory.getPaciente("12345392", "Juan", "Salto", "Mar del plata", "47544123", "Calle 13", "Mayor");
			

			Clinica.getInstance().ingresoPaciente(paciente2);
			Clinica.getInstance().ingresoPaciente(paciente1);
			
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
		Assert.assertEquals(Clinica.getInstance().getListaEspera().iterator().next(), paciente1);
		Assert.assertEquals(Clinica.getInstance().getPatio().iterator().next(), paciente2);
	}
	
}
