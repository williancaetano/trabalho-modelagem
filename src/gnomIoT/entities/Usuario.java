package gnomIoT.entities;
import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private ArrayList<Residencia> residencias = new ArrayList<>();
	
	// o ideal é ser default e não public
	public Usuario(String _nome, String _email, String _telefone, String _senha) {
		nome = _nome;
		email = _email;
		telefone = _telefone;
		senha = _senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Residencia> getResidencias() {
		return residencias;
	}
	
	public void trocarSenha(String antigaSenha, String novaSenha) {
		
	}
	
	void adicionarResidenciaAoUsuario(Residencia residencia) {
		if(usuarioEstaNaResidencia(residencia)) {
			System.out.println("O usuario não pôde ser adicionado a residência pois já está nela.");
			return;
		}
		
		residencias.add(residencia);
	}
	
	public Boolean usuarioEstaNaResidencia(Residencia residencia) {
		for(Residencia r : residencias) {
			if(r == residencia) 
				return true;
		}
		
		return false;
	}
	
	public void excluirResidencia(Residencia residencia) {
		
	}
	
}
