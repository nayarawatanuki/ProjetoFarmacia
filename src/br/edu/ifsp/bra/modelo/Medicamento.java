package br.edu.ifsp.bra.modelo;

public class Medicamento {
	
	public static enum TipoMedicamento {
		NENHUM, PILULA, CAPSULA,  DRAGEA;
		
		public static TipoMedicamento getTipo(int tipo) {
			switch (tipo) {
			case 1:
				return PILULA;
			case 2:
				return CAPSULA;
			case 3:
				return DRAGEA;
			default:
				return NENHUM;
			}
		}
		
		public static int setTipo(TipoMedicamento tipo) {
			switch (tipo) {
			case PILULA:
				return 1;
			case CAPSULA:
				return 2;
			case DRAGEA:
				return 3;
			default:
				return 0;
			}
		}};

	
	private int id;
	private String codigo;
	private String descricao;
	private double preco;
	private int estoque;
	private TipoMedicamento tipo;
	
	public Medicamento() {};
	public Medicamento(int id,String codigo, String descricao, double preco, int estoque, TipoMedicamento tipo) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
		this.tipo = tipo;
	}
	public Medicamento(String codigo, String descricao, double preco, int estoque, TipoMedicamento tipo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
		this.tipo = tipo;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return this.getDescricao();
	}
	
}
