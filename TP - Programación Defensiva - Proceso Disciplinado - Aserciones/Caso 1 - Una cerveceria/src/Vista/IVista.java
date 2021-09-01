package Vista;

import Negocio.Negocio;

public interface IVista {
	void setNegocio(Negocio negocio);
	void mostrarMesas(String[] mesas);
	void mostrarMensajeError(String mensaje);
}
