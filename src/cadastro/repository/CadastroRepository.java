package cadastro.repository;

import cadastro.model.Cadastro;

public abstract class CadastroRepository {
    
    public abstract void procurarPorCodigo(int codigo);
    
    public abstract void listarTodos();
    
    public abstract void cadastrar(Cadastro cadastro);
    
    public abstract void atualizar(Cadastro cadastro);
    
    public abstract void deletar(Cadastro cadastro);
}
