package gnomIoT.entities;
import java.util.ArrayList;

public class Comodo {
	private String nome;
	private ArrayList<Dispositivo> dispositivos = new ArrayList<>();
	private final Residencia RESIDENCIA;
	
	Comodo(String _nome, Residencia _residencia) {
		nome = _nome;
		RESIDENCIA = _residencia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}
	
	public void removerDispositivo(Dispositivo dispositivo) {
		dispositivos.remove(dispositivo);
	}
}
