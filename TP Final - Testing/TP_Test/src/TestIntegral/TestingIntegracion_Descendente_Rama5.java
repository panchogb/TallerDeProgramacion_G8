package TestIntegral;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.Prestacion;
import modelo.BDdeMedicos;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import personas.Paciente;

public class TestingIntegracion_Descendente_Rama5 {

	private Paciente paciente1;
	private Paciente paciente2;
	
	private IMedico medico;
	
	private Factura factura1;

	private ArrayList<Prestacion> prestaciones;
	
	@Before
	public void setUp()
	{
			
		prestaciones = new ArrayList();
		
		paciente1=null;
		paciente2=null;
		
		try {
			medico = MedicoFactory.getMedico("24512331", "Pepe", "Ortigoza", "Mar del plata", "4451354","Calle 15", "13524", "Clinica", "Permanente", "Doctor");
		} catch (NoExisteEspecialidadException | NoExisteContratacionException | NoExistePosgradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			paciente1 = PacienteFactory.getPaciente("32345391", "Roberto", "Perez", "Mar del plata", "47312123", "Calle 14", "Joven");
			paciente2 = PacienteFactory.getPaciente("12345392", "Juan", "Salto", "Mar del plata", "47544123", "Calle 13", "Mayor");
			
		} catch (NoExisteRangoEtarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		factura1 = new Factura(0, new GregorianCalendar(2021,11,25), paciente1);

		prestaciones.add(new Prestacion("remedio A", 1000, 2));
		prestaciones.add(new Prestacion("remedio B", 1500, 1));
		
		factura1.setPrestaciones(prestaciones);
		factura1.asignarMedico(medico);
		
		Clinica.getInstance().ingresoPaciente(paciente1);
		Clinica.getInstance().ingresoPaciente(paciente2);
		
		Clinica.getInstance().atenderPaciente(paciente1);
		
		Clinica.getInstance().egreso(paciente1, factura1);
	}

	@After
	public void tearDown() 
	{
	}
	
	@Test
	public void Test()
	{
		Factura factura = Clinica.getInstance().getFacturas().iterator().next();
		
		Assert.assertEquals(factura, factura1);		

		Assert.assertEquals(factura.getPaciente(), paciente1);
		
		Assert.assertEquals(factura.getPrestaciones(), prestaciones);
	}
	
}
