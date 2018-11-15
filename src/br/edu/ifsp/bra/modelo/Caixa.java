package br.edu.ifsp.bra.modelo;

public class Caixa {
	
	private int id;
	private String descricao;
	
	public Caixa() {};
	public Caixa(String descricao) {
		this.descricao = descricao;
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
