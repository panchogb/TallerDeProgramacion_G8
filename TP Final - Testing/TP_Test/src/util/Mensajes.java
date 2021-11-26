package util;

public enum Mensajes {
	
	ERROR_ESPECIALIDAD("No existe especialidad"),ERROR_POSGRADO("No Existe Posgrado"),
	ERROR_CONTRATACION("No existe Contratacion");
	
	private String valor;

	private Mensajes(String valor)
	{
		this.valor = valor;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

}
