package Vista;

import Negocio.Negocio;

public interface IVista {
	void setNegocio(Negocio negocio);
	void mostrarMesas(String[] mesas);
	void mostrarProductos(String[] productos);
	void mostrarMensajeError(String mensaje);
}
