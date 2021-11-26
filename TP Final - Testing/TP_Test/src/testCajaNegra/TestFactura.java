package testCajaNegra;

import java.util.GregorianCalendar;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.HabitacionCompartida;
import infraestructura.Prestacion;
import modelo.IMedico;
import modelo.MedicoFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import personas.Mayor;
import personas.Paciente;


public class TestFactura {
	
	Factura factura=null;
	Paciente paciente=null;
	GregorianCalendar fecha=new GregorianCalendar();
	public TestFactura() {
		
	}
	
	@Before
	public void setUpFactura() {
		paciente = new Mayor("321756312", "Marco", "Polo", "Balcarce", "3321311", "Colon 1242");
		factura=new Factura(2,fecha,paciente);
	}
	
	@After
	public void tearDown() {
		factura=null;
		paciente=null;
	}
	

	@Test
	public void crearFactura() {
		Assert.assertNotNull("La factura no deberia ser nula",factura);
		int nroFactura=factura.getNroFactura();
		GregorianCalendar fecha=factura.getFecha();
		Paciente paciente=factura.getPaciente();
		Assert.assertEquals("Deberia ser igual al asignado",nroFactura,2);
		Assert.assertEquals("Deberia ser igual al asignado",fecha,this.fecha);
		Assert.assertEquals("Deberia ser igual al asignado",paciente,this.paciente);
		
	}
	
	@Test
	public void asignarMedico() throws Exception {
		IMedico medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1111","Cirujia","Permanente","Magister");
		factura.asignarMedico(medico);
		Assert.assertTrue("Deberia tener unicamente una prestacion", factura.getPrestaciones().size() == 1);
		Prestacion prestacion = factura.getPrestaciones().get(0);
		Assert.assertEquals("Deberia ser igual al asignado",prestacion.getPrestacion(),medico.getNombre()+" "+medico.getMatricula());
		Assert.assertEquals("Deberia contar 1 sola vez",factura.getPrestaciones().get(0).getCantidad(),1);
	}
	
	@Test
	public void agregarPrestacionMedico() throws Exception{
		IMedico medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1111","Cirujia","Permanente","Magister");
		factura.asignarMedico(medico);
		factura.asignarMedico(medico);
		Assert.assertTrue("Deberia tener unicamente una prestacion", factura.getPrestaciones().size() == 1);
		Prestacion prestacion = factura.getPrestaciones().get(0);
		Assert.assertEquals("Deberia ser igual al asignado",prestacion.getPrestacion(),medico.getNombre()+" "+medico.getMatricula());
		Assert.assertEquals("Deberia contar 2 veces",factura.getPrestaciones().get(0).getCantidad(),2);
		
	}
	
	
	@Test
	public void asignarHabitacion()  {
		Habitacion habitacion=new HabitacionCompartida(1,3,100);
		factura.asignarHabitacion(habitacion);
		Assert.assertTrue("Deberia tener unicamente una prestacion", factura.getPrestaciones().size() == 1);
		Prestacion prestacion = factura.getPrestaciones().get(0);
		Assert.assertEquals("Deberia ser igual al asignado",prestacion.getPrestacion(),habitacion.toString());
	}
	

	
}