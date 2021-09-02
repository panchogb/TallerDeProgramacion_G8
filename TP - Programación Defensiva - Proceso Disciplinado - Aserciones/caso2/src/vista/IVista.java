package vista;

import negocio.Negocio;

public interface IVista {
	public void informar(String mensaje);
	public void setNegocio(Negocio negocio);
}
