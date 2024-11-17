package cadastro.model;

public class CadastroPC extends Cadastro{
	
	private String processador;
	private int memoria;
	private int opcao;
	
	public CadastroPC(int codigo, String marca, int sistemaOperarioca, float preco, int tipo,
			String processador, int memoria, int opcao) {
		super(codigo, marca, sistemaOperarioca, preco, tipo);
		this.processador = processador;
		this.memoria = memoria;
		this.opcao = opcao;
		
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Processador: " + this.processador);
		System.out.println("Memória: " + this.memoria);
		System.out.println("Tipo de máquina: " + this.opcao);
	}

}
