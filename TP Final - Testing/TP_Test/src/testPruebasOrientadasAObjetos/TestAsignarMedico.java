package testPruebasOrientadasAObjetos;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.Prestacion;
import modelo.IMedico;
import modelo.MedicoFactory;
import personas.Mayor;
import personas.Paciente;


public class TestAsignarMedico {
	private IMedico medico;
	private Factura factura;

	@Before
	public void setUp() throws NoExisteEspecialidadException, NoExisteContratacionException, NoExistePosgradoException{
		medico = MedicoFactory.getMedico("24512331", "Pepe", "Ortigoza", "Mar del plata", "4451354","Calle 15", "13524", "Clinica", "Permanente", "Doctor");
		Paciente paciente = new Mayor("321756312", "Marco", "Polo", "Balcarce", "3321311", "Colon 1242");
		factura=new Factura(2,new GregorianCalendar(),paciente);
	}

	@Test
	public void asignarMedicoOK() throws NoExisteRangoEtarioException {
		
		factura.asignarMedico(medico);
		Assert.assertTrue("Deberia tener unicamente una prestacion", factura.getPrestaciones().size() == 1);
		Prestacion prestacion = factura.getPrestaciones().get(0);
		Assert.assertEquals("Deberia ser igual al asignado",prestacion.getPrestacion(),medico.getNombre()+" "+medico.getMatricula());
		Assert.assertEquals("Deberia contar 1 sola vez",factura.getPrestaciones().get(0).getCantidad(),1);
	}
	

	@After
	public void tearDown() {
		medico=null;
		factura=null;
	}
}