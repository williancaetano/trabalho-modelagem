package gnomIoT.entities;
import java.util.ArrayList;

public class Residencia {
	private String nome;
	private int codigo;
	private ArrayList<Perfil> perfis = new ArrayList<>();
	private ArrayList<Comodo> comodos = new ArrayList<>();
	private static int cont = 0;
	
	// o ideal é default e nao public
	public Residencia(String _nome, Usuario dono) {
		adicionarUsuario(dono, Cargo.DONO);
		nome = _nome;
		codigo = cont;
		cont++;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Perfil> getPerfis() {
		return perfis;
	}
	
	public ArrayList<Comodo> getComodos() {
		return comodos;
	}
	
	public Boolean adicionarUsuario(Usuario usuario, Cargo cargo) {
		
		if(residenciaPossuiUsuario(usuario)) {
			return false;
		}
		
		usuario.adicionarResidenciaAoUsuario(this);
		
		Perfil perfil = new Perfil(usuario,this,cargo);	
		
		if(cargo == Cargo.ADMINISTRADOR || cargo == Cargo.DONO) {
			for(Comodo c : comodos) {
				perfil.disponibilizarComodo(c);
			}
		}
		
		perfis.add(perfil);
		
		return true;
			
	}
	
	public Boolean residenciaPossuiUsuario(Usuario usuario) {
		for(Perfil p : perfis) {
			if(p.getUSUARIO() == usuario) {
				return true;
			}
		}
		return false;
	}
	
	public Perfil pegarPerfil(Usuario usuario) {
		for(Perfil p : perfis) {
			if(p.getUSUARIO() == usuario) {
				return p;
			}
		}
		return null;
	}
	
	public Comodo adicionarComodo(String nomeComodo) {
		
		Comodo comodo = new Comodo(nomeComodo, this);
		comodos.add(comodo);
		
		for(Perfil perfil : perfis) {
			if(perfil.getCargo() == Cargo.ADMINISTRADOR || perfil.getCargo() == Cargo.DONO) {
				perfil.disponibilizarComodo(comodo);
			}
		}
		
		return comodo;
	}
	
	public void removerComodo(Comodo comodo) {
		
	}
	
	public void moverDispositivo(Comodo origem, Comodo destino, Dispositivo dispositivo) {
		
	}
	
	public void removerUsuario(Usuario usuario) {
		
	}
	
	public void listarPerfis() {
		System.out.println("--- Perfis da residencia " + nome + " ---");
		for(Perfil perfil : perfis) {
			
			System.out.print(perfil.getUSUARIO().getNome());
			System.out.print(" " + perfil.getCargo() + " (");
			
			for(Comodo comodo : perfil.getComodos()) {
				System.out.print(comodo.getNome() + ", ");
			}
			
			System.out.println(")");
			
		}
		System.out.println();
	}
	
	public void listarComodos() {
		System.out.println("--- Comodos da residencia " + nome + " ---");
		for(Comodo comodo : comodos) {
			System.out.println(comodo.getNome());
		}
		System.out.println();
	}
	
	
}
