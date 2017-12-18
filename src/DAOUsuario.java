import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DAOUsuario {
	
	private ConexaoBD conexao;
	
	public DAOUsuario() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarUsuario(Usuario u) {

		conexao.conectar();

		try {

			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into usuario(nome, email, senha, profissao, data_nascimento) values(?,?,?,?,?)");

			pst.setString(1, u.getNome());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getSenha());
			pst.setString(4, u.getProfissao());
			pst.setDate(5, u.getData_nascimento());

			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {

			conexao.desconectar();
		}
		
	}
	
	public Usuario buscarUsuario(String email) {

		conexao.conectar();

		ResultSet resultado = conexao.executarSQL("select * from usuario where email like \'" + email + "\'");
		Usuario u = new Usuario();
		
		try {
			resultado.next();

			String nomeUsuario = resultado.getString("nome");
			String emailUsuario = resultado.getString("email");
			String senhaUsuario = resultado.getString("senha");
			String profissaoUsuario = resultado.getString("profissao");
			Date data_nascimentoUsuario = resultado.getDate("data_nascimento");
			
			u.setNome(nomeUsuario);
			u.setEmail(emailUsuario);
			u.setSenha(senhaUsuario);
			u.setProfissao(profissaoUsuario);
			u.setData_nascimento(data_nascimentoUsuario);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return u;
	}
	
	public void excluirUsuario(String email) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from usuario where email like \'" + email + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public void editarUsuario(String nome, String email, String senha, String profissao, Date data_nascimento) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update usuario set nome = ?, email = ?, senha = ?, profissao = ?, data_nascimento = ? "
					+ "where email like \'" + email + "\'");
			stm.setString(1, nome);
			stm.setString(2, email);
			stm.setString(3, senha);
			stm.setString(4, profissao);
			stm.setDate(5, data_nascimento);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
	
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from usuario");
		
		try {
			while (resultado.next()) {
				String nomeUsuario = resultado.getString("nome");
				String emailUsuario = resultado.getString("email");
				String senhaUsuario = resultado.getString("senha");
				String profissaoUsuario = resultado.getString("profissao");
				Date data_nascimentoUsuario = resultado.getDate("data_nascimento");
				
				usuarios.add(new Usuario(nomeUsuario, emailUsuario, senhaUsuario, profissaoUsuario, data_nascimentoUsuario));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return usuarios;
}

}
