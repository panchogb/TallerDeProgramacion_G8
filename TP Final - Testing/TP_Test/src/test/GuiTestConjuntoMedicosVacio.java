package test;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modelo.BDdeMedicos;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import util.Mensajes;






public class GuiTestConjuntoMedicosVacio
{
	Robot robot;
	Controlador controlador;
	FalsoOptionPane op = new FalsoOptionPane();

	public GuiTestConjuntoMedicosVacio()
	{
		try
		{
			robot = new Robot();
		} catch (AWTException e)
		{
		}
	}

	@Before
	public void setUp()
	{
		Clinica.getInstance().setMedicos(new BDdeMedicos());
		controlador = new Controlador();
		controlador.setOptionpane(op);
		
	}

	@After
	public void tearDown() 
	{
		controlador.getVista().setVisible(false);
	}



	@Test
	public void testOk() 
	{
		
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "nombreTextField");
		TestUtils.clickComponent(nombre,robot);
		TestUtils.tipeaTexto("Luis", robot);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "apellidoTextField");
		TestUtils.clickComponent(apellido,robot);
		TestUtils.tipeaTexto("Montini", robot);
		JTextField dni = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "dniTextField");
		TestUtils.clickComponent(dni,robot);
		TestUtils.tipeaTexto("25900987", robot);
		JTextField ciudad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "ciudadTextField");
		TestUtils.clickComponent(ciudad,robot);
		TestUtils.tipeaTexto("MDP", robot);
		JTextField domicilio = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "domicilioTextField");
		TestUtils.clickComponent(domicilio,robot);
		TestUtils.tipeaTexto("Independencia", robot);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "telefonoTextField");
		TestUtils.clickComponent(telefono,robot);
		TestUtils.tipeaTexto("2234565", robot);
		JTextField matricula = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "matriculaTextField");
		TestUtils.clickComponent(matricula,robot);
		TestUtils.tipeaTexto("1111", robot);
		JTextField especialidad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "especialidadTextField");
		TestUtils.clickComponent(especialidad,robot);
		TestUtils.tipeaTexto("Cirujia", robot);
		JTextField posgrado = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "posgradoTextField");
		TestUtils.clickComponent(posgrado,robot);
		TestUtils.tipeaTexto("Magister", robot);
		JTextField contratacion = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "contratacionTextField");
		TestUtils.clickComponent(contratacion,robot);
		TestUtils.tipeaTexto("Permanente", robot);
		JButton AgregarMedico = (JButton) TestUtils.getComponentForName(controlador.getVista(), "btnAgregarMedico");
		TestUtils.clickComponent(AgregarMedico,robot);
		robot.delay(200);
		Assert.assertTrue("Deberia tener solo un medico",Clinica.getInstance().getMedicos().getMedicosBD().size() == 1);
		Assert.assertEquals("Debrian coincidir las matricula con la ingresada","1111",Clinica.getInstance().getMedicos().getMedicosBD().iterator().next().getMatricula());
	}

	@Test
	public void NoExisteEspecialidadTest() {
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "nombreTextField");
		TestUtils.clickComponent(nombre,robot);
		TestUtils.tipeaTexto("Luis", robot);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "apellidoTextField");
		TestUtils.clickComponent(apellido,robot);
		TestUtils.tipeaTexto("Montini", robot);
		JTextField dni = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "dniTextField");
		TestUtils.clickComponent(dni,robot);
		TestUtils.tipeaTexto("25900987", robot);
		JTextField ciudad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "ciudadTextField");
		TestUtils.clickComponent(ciudad,robot);
		TestUtils.tipeaTexto("MDP", robot);
		JTextField domicilio = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "domicilioTextField");
		TestUtils.clickComponent(domicilio,robot);
		TestUtils.tipeaTexto("Independencia", robot);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "telefonoTextField");
		TestUtils.clickComponent(telefono,robot);
		TestUtils.tipeaTexto("2234565", robot);
		JTextField matricula = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "matriculaTextField");
		TestUtils.clickComponent(matricula,robot);
		TestUtils.tipeaTexto("1111", robot);
		JTextField especialidad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "especialidadTextField");
		TestUtils.clickComponent(especialidad,robot);
		TestUtils.tipeaTexto("Pediatra", robot);
		JTextField posgrado = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "posgradoTextField");
		TestUtils.clickComponent(posgrado,robot);
		TestUtils.tipeaTexto("Magister", robot);
		JTextField contratacion = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "contratacionTextField");
		TestUtils.clickComponent(contratacion,robot);
		TestUtils.tipeaTexto("Permanente", robot);
		JButton AgregarMedico = (JButton) TestUtils.getComponentForName(controlador.getVista(), "btnAgregarMedico");
		TestUtils.clickComponent(AgregarMedico,robot);
		robot.delay(200);
		Assert.assertTrue("Deberia estar vacio",Clinica.getInstance().getMedicos().getMedicosBD().isEmpty());
		Assert.assertEquals("Deberia decir: "+Mensajes.ERROR_ESPECIALIDAD.getValor()+": Pediatra", Mensajes.ERROR_ESPECIALIDAD.getValor()+": Pediatra", op.getMensaje());
	}

	@Test
	public void NoExistePosgradoTest() {
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "nombreTextField");
		TestUtils.clickComponent(nombre,robot);
		TestUtils.tipeaTexto("Luis", robot);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "apellidoTextField");
		TestUtils.clickComponent(apellido,robot);
		TestUtils.tipeaTexto("Montini", robot);
		JTextField dni = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "dniTextField");
		TestUtils.clickComponent(dni,robot);
		TestUtils.tipeaTexto("25900987", robot);
		JTextField ciudad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "ciudadTextField");
		TestUtils.clickComponent(ciudad,robot);
		TestUtils.tipeaTexto("MDP", robot);
		JTextField domicilio = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "domicilioTextField");
		TestUtils.clickComponent(domicilio,robot);
		TestUtils.tipeaTexto("Independencia", robot);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "telefonoTextField");
		TestUtils.clickComponent(telefono,robot);
		TestUtils.tipeaTexto("2234565", robot);
		JTextField matricula = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "matriculaTextField");
		TestUtils.clickComponent(matricula,robot);
		TestUtils.tipeaTexto("1111", robot);
		JTextField especialidad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "especialidadTextField");
		TestUtils.clickComponent(especialidad,robot);
		TestUtils.tipeaTexto("Cirujia", robot);
		JTextField posgrado = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "posgradoTextField");
		TestUtils.clickComponent(posgrado,robot);
		TestUtils.tipeaTexto("Magisterado", robot);
		JTextField contratacion = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "contratacionTextField");
		TestUtils.clickComponent(contratacion,robot);
		TestUtils.tipeaTexto("Permanente", robot);
		JButton AgregarMedico = (JButton) TestUtils.getComponentForName(controlador.getVista(), "btnAgregarMedico");
		TestUtils.clickComponent(AgregarMedico,robot);
		robot.delay(200);
		Assert.assertTrue("Deberia estar vacio",Clinica.getInstance().getMedicos().getMedicosBD().isEmpty());
		Assert.assertEquals("Deberia decir: "+Mensajes.ERROR_POSGRADO.getValor()+": Magisterado", Mensajes.ERROR_POSGRADO.getValor()+": Magisterado", op.getMensaje());
	}

	@Test
	public void NoExisteContratacionTest() {
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "nombreTextField");
		TestUtils.clickComponent(nombre,robot);
		TestUtils.tipeaTexto("Luis", robot);
		JTextField apellido = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "apellidoTextField");
		TestUtils.clickComponent(apellido,robot);
		TestUtils.tipeaTexto("Montini", robot);
		JTextField dni = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "dniTextField");
		TestUtils.clickComponent(dni,robot);
		TestUtils.tipeaTexto("25900987", robot);
		JTextField ciudad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "ciudadTextField");
		TestUtils.clickComponent(ciudad,robot);
		TestUtils.tipeaTexto("MDP", robot);
		JTextField domicilio = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "domicilioTextField");
		TestUtils.clickComponent(domicilio,robot);
		TestUtils.tipeaTexto("Independencia", robot);
		JTextField telefono = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "telefonoTextField");
		TestUtils.clickComponent(telefono,robot);
		TestUtils.tipeaTexto("2234565", robot);
		JTextField matricula = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "matriculaTextField");
		TestUtils.clickComponent(matricula,robot);
		TestUtils.tipeaTexto("1111", robot);
		JTextField especialidad = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "especialidadTextField");
		TestUtils.clickComponent(especialidad,robot);
		TestUtils.tipeaTexto("Cirujia", robot);
		JTextField posgrado = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "posgradoTextField");
		TestUtils.clickComponent(posgrado,robot);
		TestUtils.tipeaTexto("Magister", robot);
		JTextField contratacion = (JTextField) TestUtils.getComponentForName(controlador.getVista(), "contratacionTextField");
		TestUtils.clickComponent(contratacion,robot);
		TestUtils.tipeaTexto("Residencial", robot);
		JButton AgregarMedico = (JButton) TestUtils.getComponentForName(controlador.getVista(), "btnAgregarMedico");
		TestUtils.clickComponent(AgregarMedico,robot);
		robot.delay(200);
		Assert.assertTrue("Deberia estar vacio",Clinica.getInstance().getMedicos().getMedicosBD().isEmpty());
		Assert.assertEquals("Deberia decir: "+Mensajes.ERROR_CONTRATACION.getValor()+": Residencial", Mensajes.ERROR_CONTRATACION.getValor()+": Residencial", op.getMensaje());
	}





}