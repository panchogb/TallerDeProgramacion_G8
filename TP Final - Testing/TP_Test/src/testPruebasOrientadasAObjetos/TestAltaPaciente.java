package testPruebasOrientadasAObjetos;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import infraestructura.Factura;
import modelo.Clinica;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestAltaPaciente {
	private Paciente paciente;
	private Factura factura;
	
	@Before
	public void setUp() throws Exception {
		paciente = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Joven");
		factura=new Factura(2,new GregorianCalendar(),paciente);
		Clinica.getInstance().ingresoPaciente(paciente);
		Clinica.getInstance().atenderPaciente(paciente);
	}
	
	@Test
	public void altaPaciente(){
		Clinica.getInstance().egreso(paciente, factura);
		Assert.assertTrue(Clinica.getInstance().getListaAtencion().size()==0);
		Assert.assertTrue(Clinica.getInstance().getFacturas().contains(factura));
	}
	
	@After
	public void tearDown() {
		paciente=null;
		factura=null;
	}
	
}


