package testPruebasOrientadasAObjetos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestIngresoPaciente {
	private Paciente paciente1;
	private Paciente paciente2;

	@Before
	public void setUp() throws Exception {
		paciente1 = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Mayor");
		paciente2 = PacienteFactory.getPaciente("23423236", "Marco", "Silo", "Mar del plata", "47312123", "Calle 14", "Joven");
	}
	
	@Test
	public void ingresoPaciente() {
		Assert.assertFalse(Clinica.getInstance().getSalaEspera().isOcupada());
		Assert.assertTrue(Clinica.getInstance().getPatio().size()==0);
		
		Clinica.getInstance().ingresoPaciente(paciente1);

		Assert.assertTrue(Clinica.getInstance().getSalaEspera().isOcupada());
		Assert.assertTrue(Clinica.getInstance().getPatio().size()==0);
		
		Clinica.getInstance().ingresoPaciente(paciente2);
		
		Assert.assertTrue(Clinica.getInstance().getSalaEspera().isOcupada());
		Assert.assertTrue(Clinica.getInstance().getPatio().size()==1);
		
		
	}
	

	@After
	public void tearDown() {
		paciente1=null;
		paciente2=null;
	}
}
