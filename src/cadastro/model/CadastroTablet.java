package cadastro.model;

public class CadastroTablet extends Cadastro{
	
	private int chip;
	public CadastroTablet(int codigo, String marca, int sistemaOperarioca, float preco, 
			int tipo, int chip) {
		super(codigo, marca, sistemaOperarioca, preco, tipo);
		this.chip = chip;
	}
	public int getChip() {
		return chip;
	}
	public void setChip(int chip) {
		this.chip = chip;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Aceita chip? "
				+ "\n1- Sim"
				+ "\n2- Não" + this.chip);
	}

}
