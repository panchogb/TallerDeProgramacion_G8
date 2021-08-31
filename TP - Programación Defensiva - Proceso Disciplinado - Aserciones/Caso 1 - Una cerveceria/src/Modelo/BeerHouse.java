package Modelo;

public class BeerHouse {
	private Mesa[] mesas;
	
	public void abrirLocal(int cantMesas)
	{
		CondicionMesas(cantMesas);
		
		mesas = new Mesa[cantMesas];
		
		for (int i = 0; i < cantMesas; i++)
		{
			mesas[i] = new Mesa();
		}
	}
	public Mesa ocuparMesa(int nroMesa)
	{
		CondicionMesas(nroMesa);
		
		mesas[nroMesa].ocuparMesa();		
		return mesas[nroMesa];
	}
	public float cerrarMesa(int nroMesa)
	{
		return 0f;
	}
	
	private void CondicionMesas(int cantMesas)
	{
		assert cantMesas >= 1 : "cantidad menor a 1";
	}
}
