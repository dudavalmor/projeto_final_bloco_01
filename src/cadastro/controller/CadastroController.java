package cadastro.controller;

import java.util.ArrayList;

import cadastro.model.Cadastro;
import cadastro.model.CadastroPC;
import cadastro.model.CadastroCelular;
import cadastro.model.CadastroTablet;
import cadastro.repository.CadastroRepository;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroController implements CadastroRepository{
	
	private ArrayList<Cadastro> listaProdutos = new ArrayList<Cadastro>();
	int numero = 0;
	
	@Override
	public void procurarPorCodigo(int codigo) {
		var pod = buscarNaCollection(codigo);
		
		if(pod != null) 
			pod.visualizar();
		else
			System.out.println("O produto com o código " + codigo + " não foi encontrado");
	}

	@Override
	public void listarTodos() {
		if(listaProdutos.isEmpty()) {
			System.out.println("Não há nenhum produto cadastrado no estoque.");
		} else {
			for(var prod : listaProdutos) {
				prod.visualizar();
			}
		  }
	}

	@Override
	public void cadastrar(Cadastro cadastro) {
		//Verificar existencia 
		if(buscarNaCollection(cadastro.getCodigo()) != null) {
			System.out.println("Não podemos cadastrar o produto na vitrine.");
			System.out.println("\nJá temos esse produto cadastrado na vitrine virtual.");
			return;
		}
		//cadastra na vitrine se não houver um ja cadastrado
		listaProdutos.add(cadastro);
		System.out.println("O produto com o código " + cadastro.getCodigo() + " foi adicionado na "
				+ "nossa vitrine virtual.");
		registrarLog("Cadastrado produto: " + cadastro.toString());
	}

	@Override
	public void atualizar(Cadastro cadastro) {
		var buscaProd = buscarNaCollection(cadastro.getCodigo());
		
		if(buscaProd != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProd), cadastro);
			System.out.println("\nO produto de código " + cadastro.getCodigo() + "foi atualizado"
					+ "com sucesso");
			registrarLog("Atualizado produto: " + cadastro.toString());
			
		} else 
			System.out.println("\nO produto de código " + cadastro.getCodigo() + "não foi encontrado.");
	}

	@Override
	public void deletar(int codigo) {
		var prod = buscarNaCollection(codigo);
		
		if(prod != null) {
			if(listaProdutos.remove(prod) == true)
				System.out.println("\nO produto de código " + codigo + " foi deletado.");
			registrarLog("Deletado produto com código: " + codigo);
		} else 
			System.out.println("\nO produto de código " + codigo + " não foi encontrado.");
	}
	
	public Cadastro buscarNaCollection(int codigo) {
		for(var pod : listaProdutos) {
			if(pod.getCodigo() == codigo) {
				return pod;
			}
		}
		
		return null;
	}
	
	public void cadastrosDia(String caminhoArquivo){
		try(FileWriter escreva = new FileWriter (caminhoArquivo)){
			if(listaProdutos.isEmpty()) {
				escreva.write("Nenhum produto cadastrado");
			} else {
				System.out.println("   Cadastros do dia   ");
				for (var prod : listaProdutos) {
					escreva.write(prod.toString() + "\n\n");
				}
			}
			System.out.println("Produtos exportados para o arquivo: " + caminhoArquivo);
		} catch (IOException e) {
			System.out.println("Erro ao exportar os arquivos" + e.getMessage());
		}
	}
	
	public void registrarLog(String acao) {
		try(FileWriter escreva = new FileWriter("log.txt", true)){ //true para anexar o arquivo
			escreva.write(acao + " - " + java.time.LocalDate.now() + "\n");
		} catch (IOException e ) {
			System.out.println("Erro ao registrar o log: " + e.getMessage());
		}
	}
	
	public void gerarRelatorioEstoque () {
		int totalProdutos = listaProdutos.size();
		double valorTotal = listaProdutos.stream().mapToDouble(Cadastro::getPreco).sum(); 
		
		long totalCelulares = listaProdutos.stream().filter(p -> p instanceof CadastroCelular).count();
	    long totalTablets = listaProdutos.stream().filter(p -> p instanceof CadastroTablet).count();
	    long totalPCs = listaProdutos.stream().filter(p -> p instanceof CadastroPC).count();
	    
	    System.out.println("\n=== RELATÓRIO DO ESTOQUE ===");
	    System.out.println("Total de produtos: " + totalProdutos);
	    System.out.println("Valor total do estoque: R$ " + valorTotal);
	    System.out.println("Celulares: " + totalCelulares);
	    System.out.println("Tablets: " + totalTablets);
	    System.out.println("PCs: " + totalPCs);
	}

}
	
