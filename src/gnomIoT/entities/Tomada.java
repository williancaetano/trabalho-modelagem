package gnomIoT.entities;

public class Tomada extends Dispositivo{
	
	public Tomada(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.TOMADA);
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (Tomada)super.clone();
    }
	
}
