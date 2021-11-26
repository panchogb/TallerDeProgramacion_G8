package testCajaNegra;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Test;

import infraestructura.Factura;
import infraestructura.Prestacion;
import modelo.BDdePacientes;
import modelo.Clinica;
import modelo.IMedico;
import personas.Mayor;
import personas.Medico;
import personas.Nino;
import personas.Paciente;

/**
 * 
 * Prueba de la clase Clinica
 *
 */
public class TestClinica {

	private Clinica clinica;
	private BDdePacientes pacientes;
	private Paciente paciente;
	public TestClinica() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUpNulo() {
		clinica=Clinica.getInstance();	}
	
	public void setUpVacio() {
		clinica=Clinica.getInstance();
		pacientes=new BDdePacientes();
		clinica.setPacientes(pacientes);
	}
	
	public void setUpNoVacio() {
		clinica=Clinica.getInstance();
		paciente=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		pacientes=new BDdePacientes();
		pacientes.altaDePaciente(paciente);
		clinica.setPacientes(pacientes);
	}
	
	@Test
	public void TestIngresoPacienteListaNoVacia() {
		setUpNoVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140"); //Paciente en lista
		clinica.ingresoPaciente(paciente1);
		if(clinica.getPacientes().buscarPaciente(paciente1)) {
			System.out.println("El paciente esta en la lista de pacientes");
		}else {
			System.out.println("El paciente no esta en la lista de pacientes");
		}
		Paciente paciente2=new Mayor("41822123", "Ximena", "ConX", "MDP", "2235673421", "San Juan 2140"); //Paciente no en lista
		clinica.ingresoPaciente(paciente2);
		if(clinica.getPacientes().buscarPaciente(paciente2)) {
			System.out.println("El paciente esta en la lista de pacientes");
		}else {
			System.out.println("El paciente no esta en la lista de pacientes");
		}
	}
	
	@Test
	public void TestIngresoPacienteListaVacia() {
		setUpVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.ingresoPaciente(paciente1);
		if(clinica.getPacientes().buscarPaciente(paciente1)) {
			System.out.println("El paciente esta en la lista de pacientes");
		}else {
			System.out.println("El paciente no esta en la lista de pacientes");
		}
	}
	
	@Test
	public void TestIngresoPacienteListaNula() {
		setUpNulo();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.ingresoPaciente(paciente1);
		if(clinica.getPacientes().buscarPaciente(paciente1)) {
			System.out.println("El paciente esta en la lista de pacientes");
		}else {
			System.out.println("El paciente no esta en la lista de pacientes");
		}
	}
	
	@Test
	public void TestDerivarPacienteListaNoVacia() {
		setUpNoVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.derivarPaciente(paciente1);
		if(paciente1==clinica.getSalaEspera().getPaciente()) {
			System.out.println("Se agrego el paciente a la sala de espera");
		}
		if(clinica.getPatio().contains(paciente1)) {
			System.out.println("Se agrego el paciente al patio");
		}
	}
	
	@Test
	public void TestDerivarPacienteListaVacia() {
		setUpVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.derivarPaciente(paciente1);
		if(paciente1==clinica.getSalaEspera().getPaciente()) {
			System.out.println("Se agrego el paciente a la sala de espera");
		}
		if(clinica.getPatio().contains(paciente1)) {
			System.out.println("Se agrego el paciente al patio");
		}
	}
	
	@Test
	public void TestDerivarPacienteListaNula() {
		setUpNulo();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.derivarPaciente(paciente1);
		if(paciente1==clinica.getSalaEspera().getPaciente()) {
			System.out.println("Se agrego el paciente a la sala de espera");
		}
		if(clinica.getPatio().contains(paciente1)) {
			System.out.println("Se agrego el paciente al patio");
		}
	}
	
	@Test
	public void TestAtenderPacienteListaNoVacia() {
		setUpNoVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.atenderPaciente(paciente1);
		if(clinica.getListaAtencion().contains(paciente1)) {
			System.out.println("Se agrego el paciente a la lista de atencion");
		}else {
			System.out.println("No se agrego el paciente a la lista de atencion");
		}
	}
	
	@Test
	public void TestAtenderPacienteListaVacia() {
		setUpVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140"); 
		clinica.atenderPaciente(paciente1);
		if(clinica.getListaAtencion().contains(paciente1)) {
			System.out.println("Se agrego el paciente a la lista de atencion");
		}else {
			System.out.println("No se agrego el paciente a la lista de atencion");
		}
	}
	
	@Test
	public void TestAtenderPacienteListaNula() {
		setUpNulo();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.atenderPaciente(paciente1);
		if(clinica.getListaAtencion().contains(paciente1)) {
			System.out.println("Se agrego el paciente a la lista de atencion");
		}else {
			System.out.println("No se agrego el paciente a la lista de atencion");
		}
	}	
	
	@Test
	public void TestEgresoListaNoVacia() {
		setUpNoVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.atenderPaciente(paciente1);
		GregorianCalendar fecha=new GregorianCalendar(12,19,21);
		Factura factura1=new Factura(1,fecha,paciente1);
		Prestacion prestacion1 =new Prestacion("Prestacion", 1, 1);
		ArrayList lista=new ArrayList<Prestacion>(); lista.add(prestacion1); factura1.setPrestaciones(lista);
		clinica.egreso(paciente1, factura1); //Paciente en lista,Factura con prestaciones
		Paciente paciente2=new Mayor("41822123", "Ximena", "ConX", "MDP","2235673421", "San Juan 2140");
		clinica.egreso(paciente2, factura1); //Paciente no en lista, factura con prestaciones
		clinica.atenderPaciente(paciente2);
		Factura factura2=new Factura(1,fecha,paciente2);
		clinica.egreso(paciente2, factura2);//Paciente en lista, factura sin prestaciones
	}

	@Test
	public void TestEgresoListaVacia() {
		setUpVacio();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.atenderPaciente(paciente1);
		GregorianCalendar fecha=new GregorianCalendar(12,19,21);
		Factura factura1=new Factura(1,fecha,paciente1);
		clinica.egreso(paciente1, factura1); //Factura sin prestaciones, paciente no en lista
	}

	@Test
	public void TestEgresoListaNula() {
		setUpNulo();
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		clinica.atenderPaciente(paciente1);
		GregorianCalendar fecha=new GregorianCalendar(12,19,21);
		Factura factura1=new Factura(1,fecha,paciente1);
		clinica.egreso(paciente1, factura1); //Factura sin prestaciones, paciente no en lista
	}
	
	@Test
	public void TestReporteMedicoFacturaNoVacio() {
		setUpNoVacio();
		Prestacion prestacion1=new Prestacion("Luis 1111",1,1);
		Medico medico1=new Medico("17823456" ,"Luis" , "Sanchez","Mar del Plata" ,"463-1234","Garay 3402" ,"1111","Cirujano");
		GregorianCalendar fecha1,fecha2; fecha1=new GregorianCalendar(03,10,2020);fecha2=new GregorianCalendar(10,11,2020);
		Paciente paciente1=new Nino("42432211", "Juan Jose", "Java", "MDP", "2235673421", "San Juan 2140");
		GregorianCalendar fecha=new GregorianCalendar(07,10,2020);
		Factura factura1=new Factura(1,fecha,paciente1);
		ArrayList lista=new ArrayList<Prestacion>(); lista.add(prestacion1); factura1.setPrestaciones(lista);
		ArrayList listaF=new ArrayList<Factura>(); listaF.add(factura1);clinica.setFacturas(listaF);
		clinica.reporteMedico(medico1, fecha1, fecha2); //Medico en prestacion
		Medico medico2=new Medico("17823456" ,"Marcos" ,"Sanchez","Mar del Plata" ,"463-1234", "Garay 3402" ,"2222","Cirujano");
		clinica.reporteMedico(medico2, fecha1, fecha2); //Medico no en prestacion
		GregorianCalendar fecha3=new GregorianCalendar(12,10,2021);GregorianCalendar fecha4=new GregorianCalendar(05,03,2021);
		clinica.reporteMedico(medico1, fecha3, fecha4);
	}
	
	@Test
	public void TestReporteMedicoFacturaVacia() {
		setUpNoVacio();
		Prestacion prestacion1=new Prestacion("Luis 1111",1,1);
		Medico medico1=new Medico("17823456" ,"Luis" , "Sanchez","Mar del Plata" ,"463-1234","Garay 3402" ,"1111","Cirujano");
		GregorianCalendar fecha1,fecha2; fecha1=new GregorianCalendar(03,10,2020);fecha2=new GregorianCalendar(10,11,2020);
		clinica.reporteMedico(medico1, fecha1, fecha2); //Factura vacia
	}
		
	
	@After
	public void limpiar() {
		clinica=null;
		pacientes=null;
		paciente=null;
	}
}
