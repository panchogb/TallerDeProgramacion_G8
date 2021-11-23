package infraestructura;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import personas.Paciente;

import modelo.IMedico;

/**
 *
 * <br>
 * Clase que corresponde a una factura.
 *
 */
public class Factura implements Comparable, Serializable{
	
	private int nroFactura;
	private GregorianCalendar fecha;

    /**
     * @aggregation composite
     */
    private Paciente paciente;
	private double importeTotal=0;

    /**
     * @aggregation composite
     */
    private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	
	/**Constructor de factura
	 * <b> Pre: paciente debe ser distinto de null.</b>
	 * <b> Pre: nroFactura debe ser positivo.</b>
	 * <b> Post: se le asign� a la factura un n�mero, una fecha y un paciente.</b>
	 * @param nroFactura: Parametro de tipo entero.
	 * @param fecha: Parametro de tipo GregorianCalendar.
	 * @param paciente: Parametro de tipo Paciente.
	 */
	 public Factura(int nroFactura, GregorianCalendar fecha,Paciente paciente) {
		this.paciente=paciente;
		this.nroFactura = nroFactura;
		this.fecha = fecha;
	}

	/**Se le asigna una prestacion medica a la factura.
	 * <b> Pre: El medico debe ser distinto de null.</b>
	 * <b> Post: Se le agrega una prestacion medica a la factura, en base a los honorarios del medico.</b>
	 * @param medico: Parametro de tipo medico.
	 */
	public void asignarMedico(IMedico medico) {
		Iterator<Prestacion> it = this.prestaciones.iterator();
		int existe=0;
		while(it.hasNext()) {
			Prestacion prestacionActual = it.next();
			if((medico.getNombre()+" "+medico.getMatricula()).equals(prestacionActual.getPrestacion())) {
				existe=1;
				prestacionActual.setCantidad(prestacionActual.getCantidad() + 1);
				prestacionActual.setSubtotal(prestacionActual.getValor()*prestacionActual.getCantidad());
			}
				
		}
		if(existe==0) {
			Prestacion nueva = new Prestacion(medico.getNombre()+" "+medico.getMatricula(),medico.getHonorario()*1.2,1);  // Ponemos nombre y matricula por si hay dos medicos con el mismo nombre
			nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
			this.prestaciones.add(nueva);
			
		}
		this.importeTotal+=medico.getHonorario()*1.2;
	}
	 
	 /**Se le asigna una prestacion de tipo internacion a la factura.
	  * <b> Pre:La habitacion de ser distinto de null.</b>
	 * <b> Post: Se le agrega una prestacion de internacion a la factura, en base a los costos de la habitacion.</b>
	 * @param habitacion: Parametro de tipo habitacion.
	 */
	public void asignarHabitacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.getCostoAsignacion(),habitacion.getCantDias());
		 nueva.setSubtotal(habitacion.costoDeHabitacion(habitacion.getCantDias()));	
		 this.prestaciones.add(nueva);
		 this.importeTotal+=habitacion.costoDeHabitacion(habitacion.getCantDias());
			
		}

	 
	 
	public Paciente getPaciente() {
		return paciente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	public double getImporteTotal()
	{
		return importeTotal;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf =
				new SimpleDateFormat("EEEEE dd 'de' MMMMMMMMM 'de' yyyy");
		return "--Factura Nro: "+nroFactura +"--Fecha: "+sdf.format(fecha.getTime()) +"--Paciente: "+this.paciente.getNombre() +" "+this.paciente.getApellido();   // Hay que cambiar esto para que muestre bien la fecha
	 
	}
	
	 /**Se muestran en pantalla las prestaciones y el importe total correspondiente a la factura
	 * <b> Post: Se mostraron por pantalla las prestaciones y el importe total.</b>
	 */
	public void muestraFactura() {
		
		for (Prestacion prestaciones : this.prestaciones) 
		       System.out.println(prestaciones.toString());
		
		System.out.println("Importe Total: "+this.importeTotal);
		
	
	}

	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	@Override
	 /**Compara dos facturas, si las fechas son iguales, devuelve resta entre NumeroHistoria de factura actual con NumeroHistoria de factura de entrada. Caso contrario, devuelve entero positivo si la factura actual es posterior a factura de entrada, o entero negativo en caso contrario
	 * <b> Pre:o debe ser distinto de null.</b>
	 * @param o: Parametro de tipo objeto.
	 */
	public int compareTo(Object o) {
		
		Factura factura = (Factura) o; 
		int respuesta;
		
		if(this.fecha.compareTo(factura.fecha)!=0)
			respuesta = this.fecha.compareTo(factura.fecha);
		else {
			respuesta = this.paciente.getNumeroHistoria() - factura.paciente.getNumeroHistoria();
		}
			
		return respuesta;
	}
}
