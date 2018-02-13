import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOLivro {
	
	private ConexaoBD conexao;
	
	public DAOLivro() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarLivro(Livro l) {

		conexao.conectar();

		try {

			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into livro(nomeLivro, autorLivro, resumoLivro, editora, genero, anoPublicacao) values(?,?,?,?,?,?)");

			pst.setString(1, l.getNomeLivro());
			pst.setString(2, l.getAutorLivro());
			pst.setString(3, l.getResumoLivro());
			pst.setString(4, l.getEditora());
			pst.setString(5, l.getGenero());
			pst.setInt(6, l.getAnoPublicacao());

			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {

			conexao.desconectar();
		}
		
	}
	
	public Livro buscarLivro(String nome) {

		conexao.conectar();

		ResultSet resultado = conexao.executarSQL("select * from livro where nome like \'" + nome + "\'");
		Livro l = new Livro();
		
		try {
			resultado.next();

			String nomeLivro = resultado.getString("nome");
			String autorLivro = resultado.getString("autor");
			String resumoLivro = resultado.getString("resumo");
			String editoraLivro = resultado.getString("editora");
			String generoLivro = resultado.getString("genero");
			int anoPublicacaoLivro = resultado.getInt("ano_publicacao");
			
			l.setNomeLivro(nomeLivro);
			l.setAutorLivro(autorLivro);
			l.setResumoLivro(resumoLivro);
			l.setEditora(editoraLivro);
			l.setGenero(generoLivro);
			l.setAnoPublicacao(anoPublicacaoLivro);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return l;
	}
	
	public void excluirLivro(String email) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from livro where pessoa like \'" + email + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public void editarLivro(String nome, String autor, String resumo, String editora, String genero,
			int anoPublicacao) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update livro set nome = ?, autor = ?, resumo = ?, editora = ?, genero = ?, ano_publicacao = ? "
					+ "where nome like \'" + nome + "\'");
			stm.setString(1, nome);
			stm.setString(2, autor);
			stm.setString(3, resumo);
			stm.setString(4, editora);
			stm.setString(5, genero);
			stm.setInt(6, anoPublicacao);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
	
	public ArrayList<Livro> verTodos() {
		ArrayList<Livro> Livros = new ArrayList<>();
		
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from livro");
		
		try {
			while (resultado.next()) {
				String nomeLivro = resultado.getString("nome");
				String autorLivro = resultado.getString("autor");
				String resumoLivro = resultado.getString("resumo");
				String editoraLivro = resultado.getString("editora");
				String generoLivro = resultado.getString("data_nascimento");
				int anoPublicacaoLivro = resultado.getInt("ano_publicacao");
				
				Livros.add(new Livro(nomeLivro, autorLivro, resumoLivro, editoraLivro, generoLivro, anoPublicacaoLivro));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return Livros;
}

}
