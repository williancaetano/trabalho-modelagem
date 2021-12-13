package gnomIoT.entities;

public enum TipoDispositivo {
	LAMPADA(0), FECHADURA(1), TOMADA(2), ARCONDICIONADO(3);
	
	private int valor;
	
	private TipoDispositivo(int _valor) {
		valor = _valor;
	}
	
	public int getValor() {
		return valor;
	}
	
}
