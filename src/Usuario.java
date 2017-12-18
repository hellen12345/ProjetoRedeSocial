import java.sql.Date;
import java.util.ArrayList;

public class Usuario {
	
	private String nome, email, senha, profissao;
	    private Date data_nascimento;
	    private ArrayList<Usuario> amigos = new ArrayList<Usuario>();
	    
	    public Usuario() {}
	    
	    public Usuario(String nome, String email, String senha, String profissao, Date data_nascimento) {
	    	this.nome = nome;
	    	this.email = email;
	    	this.senha = senha;
	    	this.profissao = profissao;
	    	this.data_nascimento = data_nascimento;
	    }
	    
	    private void adicionarAmigo(Usuario amigos){
	       this.amigos.add(amigos);
	       System.out.println("Amigo adicionado!");
	    }
	    
	    private void desfazerAmigo(Usuario amigo){
	    	this.amigos.remove(amigos);
	    	System.out.println(amigo.nome + "foi removido.");
	    }

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getProfissao() {
			return profissao;
		}

		public void setProfissao(String profissao) {
			this.profissao = profissao;
		}

		public Date getData_nascimento() {
			return data_nascimento;
		}

		public void setData_nascimento(Date data_nascimento) {
			this.data_nascimento = data_nascimento;
		}

		public ArrayList<Usuario> getAmigos() {
			return amigos;
		}

		public void setAmigos(ArrayList<Usuario> amigos) {
			this.amigos = amigos;
		}
}