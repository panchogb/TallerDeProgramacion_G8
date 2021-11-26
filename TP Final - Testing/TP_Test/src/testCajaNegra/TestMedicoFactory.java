package testCajaNegra;

import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import junit.framework.Assert;
import modelo.IMedico;
import modelo.MedicoFactory;
import personas.Medico;

/**
 * 
 * Prueba de la clase MedicoFactory
 *
 */

public class TestMedicoFactory {

	public TestMedicoFactory() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void TestCrearMedicoCirujano() {
		IMedico medico1,medico2,medico3,medico4;
		
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirugia","Permanente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirugia","Residente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico3=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirugia","Permanente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico4=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirugia","Residente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		
	}
	
	@Test
	public void TestCrearMedicoClinico() {
		IMedico medico1,medico2,medico3,medico4;
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Permanente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Residente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico3=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Permanente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico4=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Residente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
	}
	
	@Test
	public void TestCrearMedicoPediatra() {
		IMedico medico1,medico2,medico3,medico4;
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Permanente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Residente","Magister");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Permanente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Residente","Doctor");
		} catch (NoExisteEspecialidadException e) {
			Assert.fail("No deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExisteContratacionException");
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No deberia lanzar NoExistePosgradoException");
		}
	}
	
	@Test
	public void TestCrearOtraEspecialidad() {
		IMedico medico1,medico2,medico3,medico4;
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Ortopedia","Permanente","Magister");
			Assert.fail("Deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Ortopedia","Residente","Magister");
			Assert.fail("Deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico3=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Ortopedia","Permanente","Doctor");
			Assert.fail("Deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico4=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Ortopedia","Residente","Doctor");
			Assert.fail("Deberia lanzar NoExisteEspecialidadException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestCrearOtraContratacion() {
		IMedico medico1,medico2,medico3,medico4,medico5,medico6;
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Otros","Magister");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Otros","Doctor");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico3=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirujia","Otros","Magister");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico4=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirujia","Otros","Doctor");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico5=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Otros","Magister");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico6=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Otros","Doctor");
			Assert.fail("Deberia lanzar NoExisteContratacionException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestCrearOtroPosgrado() {
		IMedico medico1,medico2,medico3,medico4,medico5,medico6;
		try {
			medico1=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Permanente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico2=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Clinica","Residente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico3=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirujia","Permanente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico4=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Cirujia","Residente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico5=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Permanente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			medico6=MedicoFactory.getMedico("56728731","Juan","Miguel","Mar del plata","4155892","Calle 31","1234","Pediatria","Residente","Estudiante");
			Assert.fail("Deberia lanzar NoExistePosgradoException");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
