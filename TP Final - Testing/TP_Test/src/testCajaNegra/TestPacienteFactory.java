package testCajaNegra;

import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteRangoEtarioException;
import junit.framework.Assert;
import modelo.PacienteFactory;
import personas.Joven;
import personas.Mayor;
import personas.Nino;
import personas.Paciente;

/**
 * 
 * Prueba de la clase PacienteFactory
 *
 */

public class TestPacienteFactory {

	
	public TestPacienteFactory() {
		// TODO Auto-generated constructor stub
	}
	

	@Test
	public void TestCrearPaciente() {
		Paciente pacienteNiño,pacienteJoven,pacienteMayor,pacienteOtro;
		try {
			pacienteNiño=PacienteFactory.getPaciente("56728731","Juan","Miguel", "Mar del plata","4155892","Calle 31", "Nino");
			Paciente paciente1=new Nino("56728731","Juan","Miguel", "Mar del plata","4155892","Calle 31");
			Assert.assertFalse(pacienteNiño.equals(paciente1));
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			System.out.println("No deberia lanzar excepcion para rango Nino");
		}
		try {
			pacienteJoven=PacienteFactory.getPaciente("46753731","Diego","Gonzalez","Mar del plata","4157732","Calle 33", "Joven");
			Paciente paciente2=new Joven("46753731","Diego","Gonzalez","Mar del plata","4157732","Calle 33");
			Assert.assertFalse(pacienteJoven.equals(paciente2));
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			System.out.println("No deberia lanzar excepcion para rango Joven");
		}
		try {
			pacienteMayor=PacienteFactory.getPaciente("36753731", "Pepe","Garcia", "Mar del plata","2157732","Calle 71", "Mayor");
			Paciente paciente3=new Mayor("36753731", "Pepe","Garcia", "Mar del plata","2157732","Calle 71");
			Assert.assertFalse(pacienteMayor.equals(paciente3));
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			System.out.println("No deberia lanzar excepcion para rango Mayor");
		}
		try {
			pacienteOtro=PacienteFactory.getPaciente("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31", "Adolescentes");
			Assert.fail("Deberia lanzar NoExisteRangoEtarioException");
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: "+e.getMessage());
		}
	}

}
