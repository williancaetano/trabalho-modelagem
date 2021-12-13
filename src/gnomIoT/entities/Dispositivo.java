package gnomIoT.entities;
public abstract class Dispositivo implements Cloneable{
	private String nome;
	private Boolean estado = false;
	private final TipoDispositivo TIPO;
	private final String MODELO;
	private final String MARCA;
	
	public Dispositivo(String _modelo, String _marca, TipoDispositivo _tipo) {
		MODELO = _modelo;
		TIPO = _tipo;
		MARCA = _marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public TipoDispositivo getTIPO() {
		return TIPO;
	}

	public String getMODELO() {
		return MODELO;
	}

	public String getMARCA() {
		return MARCA;
	}

	public void renomearDispositivo(String _nome) {
		setNome(_nome);
	}
	
	public void alterarEstado() {
		setEstado( getEstado() ? false : true );
	}
	
	public Dispositivo clone() throws CloneNotSupportedException
    {	
          return (Dispositivo)super.clone();
          
          
    }
	
	
}
