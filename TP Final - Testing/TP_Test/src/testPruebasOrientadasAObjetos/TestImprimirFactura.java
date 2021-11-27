package testPruebasOrientadasAObjetos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import infraestructura.Factura;
import modelo.BDdePacientes;
import modelo.Clinica;
import personas.Medico;
import personas.Nino;
import personas.Paciente;

public class TestImprimirFactura {
	private Paciente paciente;
	
	@Before
	public void setUpNoVacio() {
		paciente=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		BDdePacientes pacientes = new BDdePacientes();
		pacientes.altaDePaciente(paciente);
		Clinica.getInstance().setPacientes(pacientes);
	}
	
	@Test
	public void TestReporteMedicoFacturaNoVacio() {
		
		Medico medico=new Medico("17823456" ,"Luis" , "Sanchez","Mar del Plata" ,"463-1234","Garay 3402" ,"1111","Cirujano");
		GregorianCalendar fecha1,fecha2,fecha3;
		fecha1=new GregorianCalendar(03,10,2019);
		fecha2=new GregorianCalendar(04,06,2020);
		fecha3=new GregorianCalendar(10,11,2022);
		Factura factura=new Factura(1,fecha2,paciente);
		factura.asignarMedico(medico);
		ArrayList<Factura>facturas=new ArrayList<Factura>();
		facturas.add(factura);
		Clinica.getInstance().setFacturas(facturas);
		Clinica.getInstance().reporteMedico(medico, fecha1, fecha3);//Tiene que mostrar una factura con el medico Juan Jose Java
		
	}
	
	@After
	public void tearDown() {
		paciente=null;
	}
}
