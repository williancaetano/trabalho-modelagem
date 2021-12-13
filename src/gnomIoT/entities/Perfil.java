package gnomIoT.entities;
import java.util.ArrayList;

public class Perfil {
	private final Usuario USUARIO;
	private final Residencia RESIDENCIA;
	private Cargo cargo = Cargo.USUARIO_PADRAO;
	private ArrayList<Comodo> comodos = new ArrayList<>();
	
	Perfil(Usuario _usuario, Residencia _residencia) {
		USUARIO = _usuario;
		RESIDENCIA = _residencia;
	}
	
	Perfil(Usuario _usuario, Residencia _residencia, Cargo _cargo) {
		USUARIO = _usuario;
		RESIDENCIA = _residencia;
		cargo = _cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Comodo> getComodos() {
		return comodos;
	}

	public void setComodos(ArrayList<Comodo> comodos) {
		this.comodos = comodos;
	}

	public Usuario getUSUARIO() {
		return USUARIO;
	}

	public Residencia getRESIDENCIA() {
		return RESIDENCIA;
	}
	
	public void mudarCargo(Cargo novoCargo) {
		setCargo(novoCargo);
	}
	
	public void ocultarComodo(Comodo comodo) {
		// fazer
	}
	
	public void disponibilizarComodo(Comodo comodo) {
		comodos.add(comodo);
	}
	
}
