package modelo;

import java.util.Random;

import excepciones.NoEnteroException;
import excepciones.NumeroInvalidoException;
import excepciones.NoInicializadoException;

/**
 * 
 * Esta clase representa el juego
 *
 */

public class Juego {
	private int numero;
	private int cantIntentos;
	private String estado="Perdió";
	
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Este metodo inicializa el juego
	 * post:Genera un numero aleatorio entre 0 y 100 y lo guarda(numero)
	 * post:Pone en 0 la cantidad de intentos(cantIntentos)
	 */
	public void InicializarJuego() {
		Random rand=new Random();
		this.numero=rand.nextInt(101);
		this.cantIntentos=0;
		this.estado="";
	}
	
	/**
	 * 
	 * @param numero
	 * @throws NoEnteroException
	 * @throws NumeroInvalidoException
	 * @throws NoInicializadoException
	 * Este metodo permite probar si el nuevo ingresado es el correcto, mayor o menor
	 * pre: el juego debe estar inicializado
	 * pre: el numero ingresado debe ser un entero
	 * pre: el numero ingresado debe estar entre 0 y 100
	 * post: se debe incrementar el numero de intentos en 1(cantIntentos+1)
	 * post: se debe establecer el estado segun si el numero ingresado es igual, menor o mayor al del juego, y segun si la cantidad de intentos es 10(cantIntentos==10)
	 */
	public void Probar(float numero) throws NoEnteroException, NumeroInvalidoException, NoInicializadoException {
		if(this.estado.equalsIgnoreCase("Perdió")||this.estado.equalsIgnoreCase("Acertó")) {
			throw new NoInicializadoException("Debe iniciar un juego nuevo");
		}
		if(numero % 1!=0) {
			throw new NoEnteroException("El numero debe ser un entero.");
		}
		int intento=(int) numero;
		if(intento<0||intento>100) {
			throw new NumeroInvalidoException("El numero debe estar entre 0 y 100.");
		}
		int intentos=this.cantIntentos;
		this.cantIntentos++;
		assert this.cantIntentos==intentos+1:"Fallo postcondicion";
		if(intento==this.numero) {
			this.estado="Acertó";
		}else {
			if(this.cantIntentos==10) {
				this.estado="Perdió";
			}else {
				if(intento<this.numero) {
					this.estado="Bajo";
				}else {
					this.estado="Alto";
				}
			}
		}
		
	}
	/**
	 * 
	 * @return
	 * Estos metodos devuelven la cantidad de intentos y el estado respectivamente
	 */
	public int traerIntentos() {
		return cantIntentos;
	}
	public String traerEstado() {
		return estado;
	}
	
	
}
