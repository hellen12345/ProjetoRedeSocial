 public class Livro {
	 
	public String nome_livro, autor_livro, resumo_livro, editora, genero;
	 
	public int ano_publicacao;
	
	public Livro() {}

	public Livro(String nome_livro, String autor_livro, String resumo_livro, String editora, String genero,
			int ano_publicacao) {
		this.nome_livro = nome_livro;
		this.autor_livro = autor_livro;
		this.resumo_livro = resumo_livro;
		this.editora = editora;
		this.genero = genero;
		this.ano_publicacao = ano_publicacao;
	}

	public void curtir_livro() {
		
	}
	
	public void comentar_livro() {
		
	}
	
	public void compartilhar_livro() {
		
	}
	
	public void avaliacao_livro() {
		
	}
	
	public void abandonei_livro() {
		
	}
	
	public void relendo_livro() {
		
	}

	public String getNome_livro() {
		return nome_livro;
	}

	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}

	public String getAutor_livro() {
		return autor_livro;
	}

	public void setAutor_livro(String autor_livro) {
		this.autor_livro = autor_livro;
	}

	public String getResumo_livro() {
		return resumo_livro;
	}

	public void setResumo_livro(String resumo_livro) {
		this.resumo_livro = resumo_livro;
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

	public int getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	 
	

}
