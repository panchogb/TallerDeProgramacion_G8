package Modelo;

public class Mesa {
	private char uso;
	
	public void Mesa()
	{
		uso = 'L';
	}
	
	public void ocuparMesa()
	{
		assert uso == 'L' : "Mesa ocupada";
		
		uso = 'O';
	}
}
