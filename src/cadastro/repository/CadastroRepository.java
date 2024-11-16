package cadastro.repository;

import cadastro.model.Cadastro;

public interface CadastroRepository {
	
	public void procurarPorCodigo(int codigo);
	public void listarTodos();
	public void cadastrar(Cadastro cadastro);
	public void atualizar(Cadastro cadastro);
	public void deletar(int codigo);
	
	

}