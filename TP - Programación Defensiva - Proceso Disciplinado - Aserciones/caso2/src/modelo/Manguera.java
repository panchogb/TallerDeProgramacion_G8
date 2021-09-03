package modelo;

import excepciones.VacioException;

/**
 * 
 * Esta clase representa las mangueras del surtidor
 *
 */

public class Manguera extends Thread {
	private int num;
	private Surtidor surtidor;
	private boolean activo;
	
	
	public Manguera(int num, Surtidor surtidor) {
		super();
		this.num = num;
		this.surtidor = surtidor;
	}

	
	public void run() {
		activar();
	}
	
	/**
	 * Este metodo se encarga de activar la manguera
	 */
	public synchronized void activar(){
		activo=false;
	while(activo) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	activo=true;
	while(activo) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.surtidor.cantidad_Combustible--;
		if(num==1) {
			this.surtidor.acumuladoManguera1++;
			this.surtidor.ultimaventaManguera1++;
		}
		if(num==2) {
			this.surtidor.acumuladoManguera2++;
			this.surtidor.ultimaventaManguera2++;
		}
		if(this.surtidor.cantidad_Combustible<=0) {
			desactivar();
		}
	}
	activo=false;
	}
	
	/**
	 * Este metodo se encarga de descativar la manguera
	 */
	public void desactivar() {
		this.activo=false;
		this.interrupt();
	}
}
