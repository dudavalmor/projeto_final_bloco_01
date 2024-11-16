package cadastro.controller;

import java.util.ArrayList;

import cadastro.model.Cadastro;
import cadastro.repository.CadastroRepository;

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
		for (var prod : listaProdutos) {
			prod.visualizar();
		}
	}

	@Override
	public void cadastrar(Cadastro cadastro) {
		listaProdutos.add(cadastro);
		System.out.println("O produto de código " + cadastro.getCodigo() + " foi cadastrado.");
	}

	@Override
	public void atualizar(Cadastro cadastro) {
		var buscaProd = buscarNaCollection(cadastro.getCodigo());
		
		if(buscaProd != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProd), cadastro);
			System.out.println("\nO produto de código " + cadastro.getCodigo() + "foi atualizado"
					+ "com sucesso");
		} else 
			System.out.println("\nO produto de código " + cadastro.getCodigo() + "não foi encontrado.");
	}

	@Override
	public void deletar(int codigo) {
		var prod = buscarNaCollection(codigo);
		
		if(prod != null) {
			if(listaProdutos.remove(prod) == true)
				System.out.println("\nO produto de código " + codigo + " foi deletado.");
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
	
}
