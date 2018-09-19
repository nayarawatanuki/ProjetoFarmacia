package br.edu.ifsp.bra.modelo;

public class Produto {
	public static enum tipoProduto { NENHUM, MEDICAMENTO, GERAL; };
	
	private String codigoBarra;
	private String descricao;
	private double preco;
	private int estoque;
	private int tipo;
	private double desconto;
	
	public Produto() {};
	public Produto(String codigoBarra, String descricao, double preco, int estoque, tipoProduto tipo, double desconto) {
		super();
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
		this.tipo = tipo;
		this.desconto = desconto;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
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
	public tipoProduto getTipo() {
		return tipo;
	}
	public void setTipo(tipoProduto tipo) {
		this.tipo = tipo;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	
}
