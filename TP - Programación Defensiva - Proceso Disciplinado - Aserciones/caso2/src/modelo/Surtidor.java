package modelo;

import excepciones.CargaInvalidaException;
import excepciones.VacioException;

/**
 * 
 * Esta clase representa el surtidor
 *
 */
public class Surtidor{
	protected float cantidad_Combustible;
	protected float acumuladoManguera1;
	protected float acumuladoManguera2;
	protected float ultimaventaManguera1;
	protected float ultimaventaManguera2;
	protected boolean activo1,activo2;
	private Manguera manguera1=new Manguera(1, this),manguera2=new Manguera(2, this);
	
	public Surtidor() {
		super();
	}
	
	/**
	 * 
	 * @param carga
	 * @throws CargaInvalidaException
	 * Este metodo permite inicializar el surtidor con la carga ingresada
	 * 
	 */
	
	public void InicializarSurtidor(float carga) throws CargaInvalidaException{
		this.cantidad_Combustible=0;
		cargarSurtidor(carga);
		this.acumuladoManguera1=0;
		this.acumuladoManguera2=0;
		this.ultimaventaManguera1=0;
		this.ultimaventaManguera2=0;
		this.activo1=false;
		this.activo2=true;
	}
	
	/**
	 * 
	 * @param carga
	 * @throws CargaInvalidaException
	 * Este metodo permite cargar el surtidor con la carga ingresada
	 * pre: la carga no puede ser negativa o nula (>=1)
	 * pre: la cantidad de combustible del surtidor no puede exceder los 2000 litros (carga+combustible<=2000)
	 * post:Se adhiere la carga al combustible que el surtidor tenia previamente
	 */
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
	
	/**
	 * 
	 * @throws VacioException
	 * Estos metodos permite activar la manguera 1/2 para descargar combustible a razon de un litro (1) por segundo
	 * pre:El surtidor debe tener combustible(>=1)
	 * post:Si se acaba el combustible, se detiene la descarga y se informa la cantidad acumulada y la ultima venta
	 */
	public void activaManguera1() throws VacioException {
		manguera1.start();
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("Se detuvo la descarga. El surtidor no tiene combustible");
		}
	}

	public void activaManguera2() throws VacioException {
		manguera2.start();
		if(this.cantidad_Combustible<=0) {
			throw new VacioException("Se detuvo la descarga. El surtidor no tiene combustible");
		}
	}
	
	/**
	 * 
	 * @throws VacioException
	 * Estos metodos detiene la descarga de combustible de la manguera
	 * post:Se detiene la descarga de combustible y se informa la cantidad acumulada de la manguera y la ultima venta
	 */
	public void desactivaManguera1() throws VacioException {
		manguera1.desactivar();
	}
	
	public void desactivaManguera2() throws VacioException {
		manguera2.desactivar();
	}
	
	/**
	 * Estos metodos retornan cantidad de combustible en el deposito del surtidor, las cantidad acumuladas por las mangueras 1 y 2, y las ultimas ventas de las mangueras 1 y 2, respectivamente
	 * @return
	 */
	
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
