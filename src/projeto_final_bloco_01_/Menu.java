package projeto_final_bloco_01_;

import java.util.Scanner;

import util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while (true) {
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND 
					+ "*********************************************");
			System.out.println("                                             ");
			System.out.println("                ESCOLA DA GEN                ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("       1- Criar cadastro                     ");
			System.out.println("       2- Listar pessoas cadastradas         ");
			System.out.println("       3- Buscar por CPF                     ");
			System.out.println("       4- Atualizar dados                    ");
			System.out.println("       5- Buscar cadastro                    ");
			System.out.println("       6- Apagar cadastro                    ");
			System.out.println("       7- Notas das provas                   ");
			System.out.println("       8- Boletim                            ");
			System.out.println("       9- Sair                               ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("Digite a opção desejada:                     ");
			System.out.println("                                             " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			// caso o usuario digite 8, o programa fecha
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Escola da Gen - Seu fututo começa aqui." + Cores.TEXT_RESET);
				sobre(); //chama o metodo sobre que mostra meus dados
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar cadastro\n\n");
				break;

			case 2:
				System.out.println("Listar pessoas cadastradas\n\n");
				break;

			case 3:
				System.out.println("Buscar por CPF\n\n");
				break;
				
			case 4:
				System.out.println("Atualizar dados\n\n");
				break;
			
			case 5:
				System.out.println("Buscar cadastro\n\n");
				break;
				
			case 6:
				System.out.println("Apagar cadastro\n\n");
				break;
				
			case 7:
				System.out.println("Notas das provas\n\n");
				break;
				
			case 8:
				System.out.println("Boletim do aluno" );
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +
						"\nOpção inválida!\n" + Cores.TEXT_RESET);
				break;

	       }

		}
	
	}
	
	
	public static void sobre () {
		System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND + 
				"****************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Eduarda Valmor - eduarda.bserrano@gmail.com");
		System.out.println("github.com/cadastro");
		System.out.println("****************************************************" + Cores.TEXT_RESET);
		
	}


}
