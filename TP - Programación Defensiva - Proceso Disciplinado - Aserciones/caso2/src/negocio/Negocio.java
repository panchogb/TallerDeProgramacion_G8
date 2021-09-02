package negocio;

import excepciones.CargaInvalidaException;
import excepciones.VacioException;
import modelo.Surtidor;
import vista.IVista;
import vista.Interfaz;

public class Negocio {
	private Surtidor surtidor;
	private IVista vista;
	
	public Negocio(Interfaz interfaz) {
		super();
		this.surtidor = new Surtidor();
		this.vista = interfaz;
		this.vista.setNegocio(this);
	}
	public void inicializaSurtidor(float carga) {
		this.surtidor=new Surtidor();
		try {
			surtidor.InicializarSurtidor(carga);
		} catch (CargaInvalidaException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public void cargaSurtidor(float carga) {
		try {
			this.surtidor.cargarSurtidor(carga);
		} catch (CargaInvalidaException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public void activaManguera1() {
		try {
			this.vista.informar("Se activo la manguera 1");
			this.surtidor.activaManguera1();
		} catch (VacioException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public void activaManguera2() {
		try {
			this.vista.informar("Se activo la manguera 2");
			this.surtidor.activaManguera2();
		} catch (VacioException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public void desactivaManguera1() {
		try {
			this.surtidor.desactivaManguera1();
		} catch (VacioException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public void desactivaManguera2() {
		try {
			this.surtidor.desactivaManguera2();
		} catch (VacioException e) {
			// TODO Auto-generated catch block
			this.vista.informar(e.getMessage());
		}
	}
	public float getExistenciaDeposito() {
		return this.surtidor.getExistenciaDeposito();
	}

	public float getAcumuladoManguera1() {
		return this.surtidor.getAcumuladoManguera1();
	}

	public float getAcumuladoManguera2() {
		return this.surtidor.getAcumuladoManguera2();
	}

	public float getUltimaVentaMG1() {
		return this.surtidor.getUltimaVentaMG1();
	}

	public float getUltimaVentaMG2() {
		return this.surtidor.getUltimaVentaMG2();
	}
}
