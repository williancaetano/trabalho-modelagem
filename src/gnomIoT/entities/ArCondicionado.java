package gnomIoT.entities;
public class ArCondicionado extends Dispositivo{
	private final int MAX_TEMP = 35;
	private final int MIN_TEMP = 15;
	private int temperatura = 20;
	
	public ArCondicionado(String _modelo, String _marca) {
		super(_modelo, _marca, TipoDispositivo.ARCONDICIONADO);
	}
	
	@Override
    public Dispositivo clone() throws CloneNotSupportedException
    {
          return (ArCondicionado)super.clone();
    }
	
	@Override
	public void alterarEstado() {
		if (!this.getEstado()) {
			this.setTemperatura(20);
		}
		setEstado(!this.getEstado());
	}
	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public void alterarTemperatura(int temperatura) {
		setTemperatura(temperatura);
		//return getTemperatura();
	}
	public int getMin() {
		return MIN_TEMP;
	}
	public int getMax() {
		return MAX_TEMP;
	}
}

/*
 * GnomIoT sistema = new GnomIoT();
 * Usuario zezim = new Usuario(Ze, ze.brabo@gmail.com, 999999999, coxinha123); 
 * Residencia casinha = new Residencia("Casa do seu ze", zezim);
 * Residencia casinha_braba = new Residencia("Casinha do jorjao", jorge);
 * Dono dono;
 * public Residencia(String nome, Usuario user) {
 * 	this.nome = nome
 * 	this.dono = new Dono(user);
 * }
 * 
 * sistema.addUsuario(zezim, jorge, casinha_braba);
 * addUsuario {
 * 	casinha_braba.insere(zezim)
 * }
 * 
 * insere {
 * 	listaUsuariosPadrao.add(new UsuarioPadrao(zezim));
 * }
 * casinha.getComodo("Sala").getDispositivo("Ar condicionadaoBoladao").alterarEstado();
 * 
 * */
