package projeto_final_bloco_01_;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import cadastro.model.Cadastro;
import cadastro.model.CadastroCelular;
import cadastro.model.CadastroTablet;
import cadastro.controller.CadastroController;
import util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		CadastroController cadastro = new CadastroController();
		
		Scanner leia = new Scanner(System.in);
		
		int codigo, sistemaOperarioca, tipo, opcao, chip, memoria;
		String marca, operadora;
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
			System.out.println("       6- Sair                               ");
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
			if (opcao == 6) {
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
				System.out.println("Digite a marca do aparelho: ");
				leia.skip("\\R?");
				marca = leia.nextLine();
				System.out.println("Digite o NÚMERO referente ao SIstema Operacional:"
						+ "\n1- IOS"
						+ "\n2- Android");
				sistemaOperarioca = leia.nextInt();
				System.out.println("Digite o preço do aparelho (R$): ");
				preco = leia.nextFloat();
				System.out.println("Digite o número referente a tipo de aparelho"
						+ "\n1- Celular"
						+ "\n2- Tablet");
				tipo = leia.nextInt();
				
				switch (tipo) {
				case 1 ->{
					System.out.println("Digite a operadora que tem parceria: ");
					leia.skip("\\R?");
					operadora = leia.nextLine();
					System.out.println("Quantos GB de memória: ");
					memoria = leia.nextInt();
					cadastro.cadastrar(new CadastroCelular(codigo, marca, sistemaOperarioca, preco, 
							tipo, operadora, memoria));
				}
				case 2 ->{
					System.out.println("O tablet com conexão com chip: "
							+ "\n1- Sim"
							+ "\n2- Não"
							+ "  ");
					chip = leia.nextInt();
					cadastro.cadastrar(new CadastroTablet(codigo, marca, sistemaOperarioca, preco, 
							tipo, chip));
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
					System.out.println("Digite o preço do aparelho (R$): ");
					preco = leia.nextFloat();
					System.out.println("Digite o número referente a tipo de aparelho"
							+ "\n1- Celular"
							+ "\n2- Tablet");
					tipo = leia.nextInt();
					
					switch (tipo) {
					case 1 ->{
						System.out.println("Digite a operadora que tem parceria: ");
						leia.skip("\\R?");
						operadora = leia.nextLine();
						System.out.println("Quantos GB de memória: ");
						memoria = leia.nextInt();
						cadastro.cadastrar(new CadastroCelular(codigo, marca, sistemaOperarioca, preco, 
								tipo, operadora, memoria));
						}
					case 2 ->{
						System.out.println("O tablet com conexão com chip: "
								+ "\n1- Sim"
								+ "\n2- Não"
								+ "  ");
						chip = leia.nextInt();
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
