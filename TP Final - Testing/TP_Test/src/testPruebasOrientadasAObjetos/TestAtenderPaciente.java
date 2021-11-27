package testPruebasOrientadasAObjetos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestAtenderPaciente {
	private Paciente paciente;
	
	@Before
	public void setUp() throws Exception {
		paciente = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Joven");
		Clinica.getInstance().ingresoPaciente(paciente);

	}

	@Test
	public void atenderPaciente() {
		Clinica.getInstance().atenderPaciente(paciente);
		Assert.assertTrue("No deberia estar en la lista de espera",Clinica.getInstance().getListaEspera().size()==0);
		Assert.assertNotNull("Deberia estar en la lista de atencion",Clinica.getInstance().getListaAtencion().size()==1);
	}
	

	@After
	public void tearDown() {
		paciente=null;
	
	}
}
