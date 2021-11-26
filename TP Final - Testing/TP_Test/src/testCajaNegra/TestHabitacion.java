package testCajaNegra;

import org.junit.Test;

import infraestructura.Habitacion;
import infraestructura.HabitacionCompartida;
import infraestructura.HabitacionPrivada;
import infraestructura.TerapiaIntensiva;
import junit.framework.Assert;

/**
 * Test de Clase Habitacion
 */
public class TestHabitacion {

	private Habitacion habitacion;
	public TestHabitacion() {
		// TODO Auto-generated constructor stub
	}

	public void setUpHabitacionCompartida() {
		habitacion=new HabitacionCompartida(1,3,100);
	}
	public void setUpHabitacionPrivada() {
		habitacion=new HabitacionPrivada(1,3,100);
	}
	public void setUpTerapiaIntensiva() {
		habitacion=new TerapiaIntensiva(1,3,100);
	}
	
	@Test
	public void crearHabitacionCompartida() {
		int nroHabitacion,cantDias; double costoAsignacion;
		setUpHabitacionCompartida();
		nroHabitacion=habitacion.getNroHabitacion();
		cantDias=habitacion.getCantDias();
		costoAsignacion=habitacion.getCostoAsignacion();
		Assert.assertTrue("La habitacion no deberia ser null",habitacion != null);
		Assert.assertEquals("nroHabitacion deberia ser el asignado",nroHabitacion,1);
		Assert.assertEquals("cantDias deberia ser el asignado",cantDias,3);
		Assert.assertEquals("costoAsignacion deberia ser el asignado",costoAsignacion,100.0);
	}
	
	@Test
	public void crearHabitacionPrivada() {
		int nroHabitacion,cantDias; double costoAsignacion;
		setUpHabitacionPrivada();
		nroHabitacion=habitacion.getNroHabitacion();
		cantDias=habitacion.getCantDias();
		costoAsignacion=habitacion.getCostoAsignacion();
		Assert.assertTrue("La habitacion no deberia ser null",habitacion != null);
		Assert.assertEquals("nroHabitacion deberia ser el asignado",nroHabitacion,1);
		Assert.assertEquals("cantDias deberia ser el asignado",cantDias,3);
		Assert.assertEquals("costoAsignacion deberia ser el asignado",costoAsignacion,100.0);
	}
	
	@Test
	public void crearTerapiaIntensiva() {
		int nroHabitacion,cantDias; double costoAsignacion;
		setUpTerapiaIntensiva();
		nroHabitacion=habitacion.getNroHabitacion();
		cantDias=habitacion.getCantDias();
		costoAsignacion=habitacion.getCostoAsignacion();
		Assert.assertTrue("La habitacion no deberia ser null",habitacion != null);
		Assert.assertEquals("nroHabitacion deberia ser el asignado",nroHabitacion,1);
		Assert.assertEquals("cantDias deberia ser el asignado",cantDias,3);
		Assert.assertEquals("costoAsignacion deberia ser el asignado",costoAsignacion,100.0);
	}
	
	@Test
	public void TestCostoDeHabitacionCompartida() {
		int cantDias;
		setUpHabitacionCompartida();
		cantDias=1;
		System.out.println("Habitacion compartida:");
		System.out.println("cantDias=1: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=2;
		System.out.println("cantDias=2: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=7;
		System.out.println("cantDias=7: "+habitacion.costoDeHabitacion(cantDias));
	}
	@Test
	public void TestCostoDeHabitacionPrivada() {
		int cantDias;
		setUpHabitacionPrivada();
		cantDias=1;
		System.out.println("Habitacion privada:");
		System.out.println("cantDias=1: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=2;
		System.out.println("cantDias=2: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=7;
		System.out.println("cantDias=7: "+habitacion.costoDeHabitacion(cantDias));
	}
	@Test
	public void TestCostoDeHabitacionTerapiaIntensiva() {
		int cantDias;
		setUpTerapiaIntensiva();
		cantDias=1;
		System.out.println("TerapiaIntensiva:");
		System.out.println("cantDias=1: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=2;
		System.out.println("cantDias=2: "+habitacion.costoDeHabitacion(cantDias));
		cantDias=7;
		System.out.println("cantDias=7: "+habitacion.costoDeHabitacion(cantDias));
	}
}
