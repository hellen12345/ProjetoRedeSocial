 public class Livro {
	 
	public String nomeLivro, autorLivro, resumoLivro, editora, genero;
	 
	public int anoPublicacao;
	
	public Livro() {}

	public Livro(String nomeLivro, String autorLivro, String resumoLivro, String editora, String genero,
			int anoPublicacao) {
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
		this.resumoLivro = resumoLivro;
		this.editora = editora;
		this.genero = genero;
		this.anoPublicacao = anoPublicacao;
	}

	public void curtirLivro() {
		
	}
	
	public void comentarLivro() {
		
	}
	
	public void compartilharLivro() {
		
	}
	
	public void avaliacaoLivro() {
		
	}
	
	public void abandoneiLivro() {
		
	}
	
	public void relendoLivro() {
		
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getResumoLivro() {
		return resumoLivro;
	}

	public void setResumoLivro(String resumoLivro) {
		this.resumoLivro = resumoLivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	 
	

}
