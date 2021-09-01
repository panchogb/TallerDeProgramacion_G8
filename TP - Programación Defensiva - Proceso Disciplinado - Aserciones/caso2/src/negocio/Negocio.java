package negocio;

import modelo.Surtidor;

public class Negocio {
	private Surtidor surtidor;
	
	public void inicializaSurtidor(float carga) {
		this.surtidor=new Surtidor();
		surtidor.InicializarSurtidor(carga);
	}
	public void cargaSurtidor(float carga) {
		this.surtidor.cargarSurtidor(carga);
	}
	public void activaManguera1() {
		this.surtidor.activaManguera1();
	}
	public void activaManguera2() {
		this.surtidor.activaManguera2();
	}
	public void desactivaManguera1() {
		this.surtidor.desactivaManguera1();
	}
	public void desactivaManguera2() {
		this.surtidor.desactivaManguera2();
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
