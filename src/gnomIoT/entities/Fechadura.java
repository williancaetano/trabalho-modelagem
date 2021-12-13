package gnomIoT.entities;

public class Fechadura extends Dispositivo{
	
	public Fechadura(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.FECHADURA);
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (Fechadura)super.clone();
    }
}
