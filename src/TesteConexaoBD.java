import java.sql.Date;
import java.util.ArrayList;

public class TesteConexaoBD {

	public static void main(String[] args) {
		DAOUsuario conexao = new DAOUsuario();
		
		System.out.println("Criando pessoas...");
		conexao.criarUsuario(new Usuario("Hellen", "hellen@gmail.com", "123", "humanas eca", new Date(2001, 9, 17)));	
		conexao.criarUsuario(new Usuario("Rennan", "rennan@gmail.com", "123", "exatas é nois", new Date(2001, 5, 4)));
		System.out.println("-------------------------------------");
		
		System.out.println("Buscando uma pessoa...");
		Usuario resultadoPessoa = conexao.buscarUsuario("Hellen");
		System.out.println(resultadoPessoa.toString());
		System.out.println("-------------------------------------");
		
		System.out.println("Listando todas as pessoas do banco...");
		ArrayList<Usuario> resultadoUsuarios = conexao.verTodos();
		for (Usuario u : resultadoUsuarios) {
			System.out.println(u.toString());
		}
		System.out.println("-------------------------------------");
		
		System.out.println("Editando uma pessoa...");
		conexao.editarUsuario("Rennan Rocha", "rennan@gmail.com", "123", "exatas é nois", new Date(2001, 5, 4));
		
		resultadoUsuarios = conexao.verTodos();
		for (Usuario p : resultadoUsuarios) {
			System.out.println(p.toString());
		}
		
		System.out.println("-------------------------------------");
		
		System.out.println("Excluindo uma pessoa...");
		conexao.excluirUsuario("Hellen");
		
		resultadoUsuarios = conexao.verTodos();
		for (Usuario u : resultadoUsuarios) {
			System.out.println(u.toString());
		}
	}
	
}