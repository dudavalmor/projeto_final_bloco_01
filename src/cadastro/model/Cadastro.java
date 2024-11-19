package cadastro.model;

public abstract class Cadastro {
	
	private int codigo;
	private String marca;
	private int sistemaOperarioca;
	private float preco;
	private int tipo;
	public Cadastro(int codigo, String marca, int sistemaOperarioca, float preco, int tipo) {
		this.codigo = codigo;
		this.marca = marca;
		this.sistemaOperarioca = sistemaOperarioca;
		this.preco = preco;
		this.tipo = tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getSistemaOperarioca() {
		return sistemaOperarioca;
	}
	public void setSistemaOperarioca(int sistemaOperarioca) {
		this.sistemaOperarioca = sistemaOperarioca;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void visualizar() {
	System.out.println("**********************************"
			+ "\n  Dados de cadastro de produto"
			+ "\n**********************************");
	System.out.println("- Código do aparelho: " + this.codigo);
	System.out.println("- Marca do aparelho: " + this.marca);
	System.out.println("- Sistema Operacional"
			+ "\n1- IOS"
			+ "\n2- Android"
			+ "n3- Windows"
			+ "n4- Linux"
			+ "\nSistema do aparelho: " + this.sistemaOperarioca);
	System.out.println("Preço (R$): " + this.preco);
	System.out.println("Tipo: "
			+ "\n1- Celular"
			+ "\n2- Tablet"
			+ "\n3- PC"
			+ "\nTipo do Aparelho: " + this.tipo);
		
	}
}