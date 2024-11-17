package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import cadastro.model.Cadastro;
import cadastro.model.CadastroPC;
import cadastro.model.CadastroCelular;
import cadastro.model.CadastroTablet;
import cadastro.controller.CadastroController;
import util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		CadastroController cadastro = new CadastroController();
		
		Scanner leia = new Scanner(System.in);
		
		int codigo, sistemaOperarioca, tipo, opcao, chip, memoriaCel, memoriaPC, notePC;
		String marca, operadora, processador;
		float preco;
		
		System.out.println("\nProdutos Cadastrados\n");
		
		CadastroCelular cc1 = new CadastroCelular(123, "Iphone", 1, 899.90f, 1, "Claro", 64);
		cadastro.cadastrar(cc1);
		
		CadastroCelular cc2 = new CadastroCelular(456, "S4", 2, 699.90f, 1, "Claro", 64);
		cadastro.cadastrar(cc2);
		
		CadastroTablet cp1 = new CadastroTablet(789, "Ipad", 1, 999.90f, 2, 2);
		cadastro.cadastrar(cp1);
		
		CadastroTablet cp2 = new CadastroTablet(987, "Tablet", 2, 699.90f, 2, 1);
		cadastro.cadastrar(cp2);
		
		CadastroPC cpc1 = new CadastroPC(876, "Dell", 3, 789.99f, 3, "Linux,", 64, 1);
		cadastro.cadastrar(cpc1);
		
		Cadastro cpc2 = new CadastroPC(357, "LG", 3, 799.99f, 3, "Windows", 64, 2);
		cadastro.cadastrar(cpc2);
		
		while (true) {
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND 
					+ "******************************************************");
			System.out.println("                                             ");
			System.out.println("               CELLSHOP DA GEN               ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("       1- Cadastrar celular                  ");
			System.out.println("       2- Listar estoque                     ");
			System.out.println("       3- Buscar celular por código          ");
			System.out.println("       4- Atualizar cadastro de celular      ");
			System.out.println("       5- Apagar produto do estoque          ");
			System.out.println("       6- Cadastros do dia                   ");
			System.out.println("       7- Relatório de Estoque               ");
			System.out.println("       8- Sair                               ");
			System.out.println("*********************************************");
			System.out.println("Digite a opção desejada:                     ");
			System.out.println("                                             " + Cores.TEXT_RESET);
			
			try {
			opcao = leia.nextInt();
			
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros.");
				leia.nextLine();
				opcao = 0;
			}

			// caso o usuario digite 8, o programa fecha
			if (opcao == 8) {
				System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "  Cellshop da Gen - Seu eletrônico aqui :)  " + Cores.TEXT_RESET);
				sobre(); //chama o metodo sobre que mostra meus dados
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar cadastro de produto \n"
						+ "*****************************************");
				System.out.println("Digite o código do aparelho: ");
				codigo = leia.nextInt();
				if (cadastro.buscarNaCollection(codigo) != null) {
					System.out.println("Já existe um produto com esse código na nossa vitrine"
							+ "virtual. Tente novamente.");
					break;
				}
				System.out.println("Digite a marca do aparelho: ");
				leia.skip("\\R?");
				marca = leia.nextLine();
				System.out.println("Digite o NÚMERO referente ao SIstema Operacional:"
						+ "\n1- IOS"
						+ "\n2- Android"
						+ "\n3- PC");
				sistemaOperarioca = leia.nextInt();
				if(sistemaOperarioca < 1 || sistemaOperarioca > 3) {
					System.out.println("Opação inválida. Tente novamente");
					break;
				}
				do {
				System.out.println("Digite o preço do aparelho (R$): ");
				preco = leia.nextFloat();
				if(preco < 0) {
					System.out.println("O preço não pode ser negativo, tente novamente.");
					break;
				}
				} while(preco < 0);
				System.out.println("Digite o número referente a tipo de aparelho"
						+ "\n1- Celular"
						+ "\n2- Tablet"
						+ "\n3- PC");
				tipo = leia.nextInt();
				if (tipo < 1 || tipo > 3) {
					System.out.println("Opção inválida. Tente novamente.");
					break;
				}
				switch (tipo) {
				case 1 ->{
					System.out.println("Digite a operadora que tem parceria: ");
					leia.skip("\\R?");
					operadora = leia.nextLine();
					System.out.println("Quantos GB de memória: ");
					memoriaCel = leia.nextInt();
					cadastro.cadastrar(new CadastroCelular(codigo, marca, sistemaOperarioca, preco, 
							tipo, operadora, memoriaCel));
				}
				case 2 ->{
					System.out.println("O tablet com conexão com chip: "
							+ "\n1- Sim"
							+ "\n2- Não"
							+ "  ");
					chip = leia.nextInt();
					if (chip < 1 || chip > 2) {
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
					cadastro.cadastrar(new CadastroTablet(codigo, marca, sistemaOperarioca, preco, 
							tipo, chip));
				}
				case 3 ->{
					System.out.println("Escreva o processador da máquina: ");
					leia.skip("\\R?");
					processador = leia.nextLine();
					System.out.println("Memória: ");
					memoriaPC = leia.nextInt();
					System.out.println("A máquina é (digite o número correspondente)"
							+ "\n1- Desktop"
							+ "\n2- Notebook\n");
					notePC = leia.nextInt();
					if(memoriaPC < 1 || memoriaPC > 2) {
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
					cadastro.cadastrar(new CadastroPC(codigo, marca, sistemaOperarioca, preco, 
							tipo, processador, memoriaPC, notePC));
				}
				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar produtos cadastrados\n\n");
				cadastro.listarTodos();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar por código\n\n");
				
				System.out.println("Buscar produto por codigo");
				
				System.out.println("Digite o código: ");
				codigo = leia.nextInt();
				
				cadastro.procurarPorCodigo(codigo);
				
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar produto\n\n");
				System.out.println("Digite o código do produto: ");
				codigo = leia.nextInt();
				
				var buscaProd = cadastro.buscarNaCollection(codigo);
				
				if(buscaProd != null) {
					
					tipo = buscaProd.getTipo();
					System.out.println("Digite a marca: ");
					leia.skip("\\R?");
					marca = leia.nextLine();
					System.out.println("Digite o NÚMERO referente ao SIstema Operacional:"
							+ "\n1- IOS"
							+ "\n2- Android");
					sistemaOperarioca = leia.nextInt();
					if (sistemaOperarioca < 1 || sistemaOperarioca > 2) {
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
					System.out.println("Digite o preço do aparelho (R$): ");
					preco = leia.nextFloat();
					System.out.println("Digite o número referente a tipo de aparelho"
							+ "\n1- Celular"
							+ "\n2- Tablet"
							+ "\n3- PC");
					tipo = leia.nextInt();
					if(tipo < 1 || tipo > 3) {
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
					
					switch (tipo) {
					case 1 ->{
						System.out.println("Digite a operadora que tem parceria: ");
						leia.skip("\\R?");
						operadora = leia.nextLine();
						System.out.println("Quantos GB de memória: ");
						memoriaCel = leia.nextInt();
						cadastro.cadastrar(new CadastroCelular(codigo, marca, sistemaOperarioca, preco, 
								tipo, operadora, memoriaCel));
						}
					case 2 ->{
						System.out.println("O tablet com conexão com chip: "
								+ "\n1- Sim"
								+ "\n2- Não"
								+ "  ");
						chip = leia.nextInt();
						if(chip < 1 || chip > 2) {
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
						cadastro.cadastrar(new CadastroTablet(codigo, marca, sistemaOperarioca, preco, 
								tipo, chip));
					
						}
					}
				
				keyPress();
				break;
				}
				
			case 5: 
				System.out.println(Cores.TEXT_WHITE + "Apagar cadastro\n\n");
				
				System.out.println("Digite o código do produto: ");
				codigo = leia.nextInt();
				
				cadastro.deletar(codigo);
				
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Exportar cadastros do dia para um arquivo\n");
				String nomeArquivo;
				
				while (true) {
					System.out.println("Nome do arquivo, deve terminar com .txt (ex: nomeArquivos.txt): ");
					leia.skip("\\R:");
					nomeArquivo = leia.nextLine();
					
					if(nomeArquivo.endsWith(".txt")) {
						break;
					} else {
						System.out.println(Cores.TEXT_RED_BOLD + "O nome do arquivo deve terminar "
								+ "com .txt. Por favor, tente novamente." + Cores.TEXT_RESET);
					}
				}
				
				String caminhoArquivo = "./" + nomeArquivo;
				cadastro.cadastrosDia(caminhoArquivo);
				keyPress();
				break;
				
			case 8: 
				System.out.println("   Relatório de estoque   ");
			    cadastro.gerarRelatorioEstoque();
			    keyPress();
			    break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +
						"\nOpção inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;

	       }

		}
	
	}
	
	
	public static void sobre () {
		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + 
				"****************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Eduarda Valmor - eduarda.bserrano@gmail.com");
		System.out.println("github.com/cadastro");
		System.out.println("****************************************************");
		
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_WHITE_BOLD + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println(Cores.TEXT_RED_BOLD + "    Você pressionou uma tecla diferente     " + Cores.TEXT_RESET);
		}
	}


}
