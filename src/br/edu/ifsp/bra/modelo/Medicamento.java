package br.edu.ifsp.bra.modelo;

public class Medicamento {
	
	public static enum TipoMedicamento { NENHUM, MEDICAMENTO, GERAL; };
	
	private String codigo;
	private String descricao;
	private double preco;
	private int estoque;
	private TipoMedicamento tipo;
	
	public Medicamento() {};
	public Medicamento(String codigo, String descricao, double preco, int estoque, TipoMedicamento tipo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public TipoMedicamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}
}
