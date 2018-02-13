import java.sql.Date;
import java.util.Scanner;

public class Sistema {
	
	public static void menuUsuario(Usuario us, DAOUsuario dao) {
		System.out.println("Ol�, " + us.getNome());
	}
	
	public static void menu() {
		DAOUsuario dao = new DAOUsuario();
		Scanner s = new Scanner(System.in);
		
		int op = 100;
		
		while(op > 0) {
			System.out.println("1) Login\n"
					+ "2) Registrar\n"
					+ "0) Sair\n"
					+ "-> ");
			
			op = s.nextInt();
			
			if(op == 0) {
				System.out.println("Encerrando...");
				break;
			} else if(op == 1) {
				String email, senha;
				s.nextLine();
				email = s.nextLine();
				senha = s.nextLine();
				
				Usuario us = dao.buscarUsuario(email);
				
				if(us == null) {
					System.out.println("Usu�rio inv�lido.");
					continue;
				} else if(us.getSenha() != senha) {
					System.out.println("Usu�rio inv�lido.");
					continue;
				}
				menuUsuario(us, dao);
				
			} else if(op == 2) {
				String nome, email, senha, profissao;
				Date dataNascimento;
				int dia, mes, ano;
				
				s.nextLine();
				
				System.out.print("Nome: ");
				nome = s.nextLine();
				System.out.print("E-mail: ");
				email = s.nextLine();
				System.out.print("Senha: ");
				senha = s.nextLine();
				System.out.print("Profiss�o:");
				profissao = s.nextLine();
				System.out.println("Data de nascimento:");
				System.out.print("Dia: ");
				dia = s.nextInt();
				System.out.print("M�s: ");
				mes = s.nextInt();
				System.out.println("Ano:");
				ano = s.nextInt();
				
				try {
					dataNascimento = new Date(ano, mes, dia);
					
					Usuario us = new Usuario(nome, email, senha, profissao, dataNascimento);
					
					dao.criarUsuario(us);
					
					System.out.println("Usu�rio registrado.");
				}catch (Exception e) {
					System.out.println("Houve um erro! O usu�rio n�o p�de ser registrado.");
				}
				
			} else {
				System.out.println("Op��o inv�lida, tente de novo.");
				continue;
			}
		}
	}

	public static void main(String[] args) {
		menu();
	}

}
