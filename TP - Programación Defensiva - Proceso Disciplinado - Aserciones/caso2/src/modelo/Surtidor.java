package modelo;


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
	
	public void InicializarSurtidor(float carga) {
		this.cantidad_Combustible=0;
		cargarSurtidor(carga);
		this.acumuladoManguera1=0;
		this.acumuladoManguera2=0;
		this.ultimaventaManguera1=0;
		this.ultimaventaManguera2=0;
		this.activo1=false;
		this.activo2=true;
	}
	
	public void cargarSurtidor(float carga) {
		float cant=this.cantidad_Combustible;
		verificar(carga);
		this.cantidad_Combustible+=carga;
		assert cantidad_Combustible==cant+carga:"Fallo postcondicion";
	}
	
	public void activaManguera1() {
		this.ultimaventaManguera1=0; this.activo1=true;
		while(this.activo1 && this.cantidad_Combustible>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.acumuladoManguera1++;
			this.cantidad_Combustible--;
			this.ultimaventaManguera1++;
		}
	}

	public void activaManguera2() {
		this.ultimaventaManguera2=0; this.activo2=true;
		while(this.activo2 && this.cantidad_Combustible>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.acumuladoManguera2++;
			this.cantidad_Combustible--;
			this.ultimaventaManguera2++;
		}
	}
	
	public void desactivaManguera1() {
		this.activo1=false;
	}
	
	public void desactivaManguera2() {
		this.activo2=false;
	}
	
	public void verificar(float carga) {
		float cant=this.cantidad_Combustible;
		assert carga>=1:"ERROR: carga < 1";
		assert carga+cant>2000:"ERROR: carga total > 2000";
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
