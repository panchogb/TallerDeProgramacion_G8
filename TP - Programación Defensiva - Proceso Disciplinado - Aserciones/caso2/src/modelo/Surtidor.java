package modelo;

import excepciones.CargaInvalidaException;
import excepciones.VacioException;

public class Surtidor {
	private float cantidad_Combustible;
	private float acumuladoManguera1;
	private float acumuladoManguera2;
	private float ultimaventaManguera1;
	private float ultimaventaManguera2;
	private boolean activo1,activo2;
	
	public Surtidor() {
		super();
	}
	
	public void InicializarSurtidor(float carga) throws CargaInvalidaException {
		this.cantidad_Combustible=0;
		cargarSurtidor(carga);
		this.acumuladoManguera1=0;
		this.acumuladoManguera2=0;
		this.ultimaventaManguera1=0;
		this.ultimaventaManguera2=0;
		this.activo1=false;
		this.activo2=true;
	}
	
	public void cargarSurtidor(float carga) throws CargaInvalidaException {
		float cant=this.cantidad_Combustible;
		if(carga <=0) {
			throw new CargaInvalidaException("La carga debe ser mayor o igual a 1 litro");
		}
		if(this.cantidad_Combustible+carga>2000) {
			throw new CargaInvalidaException("La carga excede la capacidad maxima del surtidor de 2000 litros");
		}
		this.cantidad_Combustible+=carga;
		assert cantidad_Combustible==cant+carga:"Fallo postcondicion";
	}
	
	public void activaManguera1() throws VacioException {
		this.ultimaventaManguera1=0; this.activo1=true;
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("El surtidor no tiene combustible. No se inicio la descarga.");
		}
		while(this.activo1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.acumuladoManguera1++;
			this.cantidad_Combustible--;
			this.ultimaventaManguera1++;
			if(this.cantidad_Combustible<=0) {
				desactivaManguera1();
			}
		}
	}

	public void activaManguera2() throws VacioException {
		this.ultimaventaManguera2=0; this.activo2=true;
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("El surtidor no tiene combustible. No se inicio la descarga.");
		}
		while(this.activo2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.acumuladoManguera2++;
			this.cantidad_Combustible--;
			this.ultimaventaManguera2++;
			if(this.cantidad_Combustible<=0) {
				desactivaManguera2();
			}
		}
	}
	
	public void desactivaManguera1() throws VacioException {
		this.activo1=false;
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("Se detuvo la descarga. El surtidor no tiene combustible");
		}
	}
	
	public void desactivaManguera2() throws VacioException {
		this.activo2=false;
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("Se detuvo la descarga. El surtidor no tiene combustible");
		}
	}
	
	
	public float getExistenciaDeposito() {
		return cantidad_Combustible;
	}

	public float getAcumuladoManguera1() {
		return acumuladoManguera1;
	}

	public float getAcumuladoManguera2() {
		return acumuladoManguera2;
	}

	public float getUltimaVentaMG1() {
		return ultimaventaManguera1;
	}

	public float getUltimaVentaMG2() {
		return ultimaventaManguera2;
	}
	
	
}
