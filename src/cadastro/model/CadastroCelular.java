package cadastro.model;

public class CadastroCelular extends Cadastro{
	
	private String operadora;
	private int memoria;
	
	public CadastroCelular(int codigo, String marca, int sistemaOperarioca, float preco, 
			int tipo, String operadora, int memoria) {
		super(codigo, marca, sistemaOperarioca, preco, tipo);
		this.operadora = operadora;
		this.memoria = memoria;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Qual a operadora que tem parceria: " + this.operadora);
		System.out.println("GB de memória: " + this.memoria);
	}

}
