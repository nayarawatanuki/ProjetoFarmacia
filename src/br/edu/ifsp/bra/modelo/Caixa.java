package br.edu.ifsp.bra.modelo;

import java.util.Date;


public class Caixa {
	
	public static enum StatusCaixa {
		NENHUM, ABERTO, FECHADO;
		
		public static StatusCaixa getStatus(int status) {
			switch (status) {
			case 1:
				return ABERTO;
			case 2:
				return FECHADO;
			default:
				return NENHUM;
			}
		}
		
		public static int setStatus(StatusCaixa status) {
			switch (status) {
			case ABERTO:
				return 1;
			case FECHADO:
				return 2;
			default:
				return 0;
			}
		}};
	
	private int id;
	private int atendenteId;
	private StatusCaixa status;
	private static double valor;
	private Date dataAbertura;
	private Date dataFechamento;
	
	public static Caixa caixaAtual;
	
	public Caixa() {};
	
	public Caixa(int atendenteId, StatusCaixa status, Date dataAbertura) {
		this.atendenteId = atendenteId;
		this.status = status;
		this.dataAbertura = dataAbertura;
	}
	
	public Caixa(int atendenteId, StatusCaixa status, Date dataAbertura, Date dataFechamento) {
		this.atendenteId = atendenteId;
		this.status = status;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}
	
	/*public boolean isAberto() {
		return this.getStatus() == StatusCaixa.ABERTO;
	}
	public boolean isFechado() {
		return this.getStatus() == StatusCaixa.FECHADO;
	}*/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAtendenteId() {
		return atendenteId;
	}
	
	public void setAtendenteId(int atendenteId) {
		this.atendenteId = atendenteId;
	}
	
	public StatusCaixa getStatus() {
		return status;
	}
	
	public void setStatus(StatusCaixa status) {
		this.status = status;
	}
	
	public static double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		Caixa.valor = valor;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public Date getDataFechamento() {
		return dataFechamento;
	}
	
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	@Override
	public String toString() {
		return "Caixa [getValor()=" + getValor() + "]";
	}
	
	

	
}
