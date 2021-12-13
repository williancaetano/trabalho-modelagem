package gnomIoT.entities;

public class Lampada extends Dispositivo{
	
	public Lampada(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.LAMPADA);
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (Lampada)super.clone();
    }
}
