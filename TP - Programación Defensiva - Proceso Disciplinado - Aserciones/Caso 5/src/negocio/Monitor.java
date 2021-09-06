package negocio;

import excepciones.NoEnteroException;
import excepciones.NumeroInvalidoException;
import modelo.Juego;
import excepciones.NoInicializadoException;
import vista.IVista;

/**
 * 
 * Este metodo representa el monitor del juego
 *
 */
public class Monitor {
	private Juego juego;
	private IVista vista;
	
	public Monitor(IVista vista) {
		this.juego=new Juego();
		this.vista=vista;
		this.vista.setMonitor(this);
	}
	/**
	 * Este metodo le informa a la capa de modelo que debe inicializar el juego
	 */
	public void inicializarJuego() {
		this.juego.InicializarJuego();
	}
	
	/**
	 * 
	 * @param numero
	 * Este metodo le informa a la capa de modelo que debe probar el numero ingresado
	 * post: Debe informarle a la capa UI los mensajes devueltos por la capa juego
	 */
	public void probarNumero(float numero) {
		try {
			this.juego.Probar(numero);
		} catch (NoInicializadoException e) {
			this.vista.informar(e.getMessage());	
		} catch (NoEnteroException e) {
			this.vista.informar(e.getMessage());
		} catch (NumeroInvalidoException e) {
			this.vista.informar(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 * Estos metodos devuelven la cantidad de intentos y el estado del juego traidas desde la capa de modelo
	 */
	public int traerIntentos() {
		return this.juego.traerIntentos();
	}
	public String traerEstado() {
		return this.juego.traerEstado();
	}
	
}
