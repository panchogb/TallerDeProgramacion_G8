package prueba;

import java.util.GregorianCalendar;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import personas.Paciente;

public class PruebaTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Paciente paciente=null;
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose", "Java", "MDP","2235673421", "San Juan 2140","Nino");
		       
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
		//TESTING FACTURA-------------------------------------------------------------------------------------------------------------------
        Factura fact1 = new Factura(0, new GregorianCalendar(2020,1,1), null);
        //(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad, String contratacion,String posgrado)
        IMedico medico = null;
        try {
			medico = MedicoFactory.getMedico("25457987", "Juan", "Carlos", "Balcarce", "411354", "Calle 10", "31425",
					"Cirujia",
					//"Pediatria",
					//"Clinica",
					
					"Permanente",
					//"Temporario",
					//"Residente",
					
					"Magister"
					//"Doctor"
					);
		} catch (NoExisteEspecialidadException | NoExisteContratacionException | NoExistePosgradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        fact1.asignarMedico(medico);

        System.out.println("Honorario: " + medico.getHonorario());
        System.out.println(fact1.getImporteTotal());
        
		//-----------------------------------------------------------------------------------------------------------------------------------
	}

}
