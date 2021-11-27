package testPruebasOrientadasAObjetos;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.HabitacionCompartida;
import infraestructura.Prestacion;

import personas.Mayor;
import personas.Paciente;

public class TestAsignarHabitacion {
	private Habitacion habitacion;
	private Factura factura;
	
	@Before
	public void setUp() {
		habitacion=new HabitacionCompartida(1,3,100);
		Paciente paciente = new Mayor("321756312", "Marco", "Polo", "Balcarce", "3321311", "Colon 1242");
		factura=new Factura(2,new GregorianCalendar(),paciente);
	}
	
	@Test
	public void asignarHabitacion()  {
		
		factura.asignarHabitacion(habitacion);
		Assert.assertTrue("Deberia tener unicamente una prestacion", factura.getPrestaciones().size() == 1);
		Prestacion prestacion = factura.getPrestaciones().get(0);
		Assert.assertEquals("Deberia ser igual al asignado",prestacion.getPrestacion(),habitacion.toString());
	}
	
	@After
	public void tearDown()  {
		habitacion=null;
		factura=null;
	}
	
}
