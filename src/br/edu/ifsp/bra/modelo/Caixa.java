package br.edu.ifsp.bra.modelo;

public class Caixa {
	
	private static Caixa caixaAtual;
	private static double valorAbertura;
	private int id;
	private String descricao;
	
	public Caixa() {};
	public Caixa(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static Caixa getCaixaAtual() {
		return caixaAtual;
	}
	
	public static void setCaixaAtual(Caixa caixaAtual) {
		Caixa.caixaAtual = caixaAtual;
	}
	
	public static double getValorAbertura() {
		return valorAbertura;
	}
	
	public static void setValorAbertura(double valorAbertura) {
		Caixa.valorAbertura = valorAbertura;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}
