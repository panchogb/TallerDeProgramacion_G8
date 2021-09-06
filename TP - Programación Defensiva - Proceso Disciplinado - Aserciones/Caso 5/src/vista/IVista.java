package vista;

import negocio.Monitor;

public interface IVista {
	public void informar(String mensaje);
	public void setMonitor(Monitor monitor);
}
