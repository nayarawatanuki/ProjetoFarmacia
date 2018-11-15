package br.edu.ifsp.bra.modelo;

import java.sql.Date;

public class CaixaHistorico {
	private int id;
	private int caixaId;
	private int atendenteId;
	private double valorAbertura;
	private double valorFechamento;
	private Date dataAbertura;
	private Date dataFechamento;

	public CaixaHistorico() {}
	public CaixaHistorico(int caixaId, int atendenteId, double valorAbertura, double valorFechamento, Date dataAbertura, Date dataFechamento) {
		this.caixaId = caixaId;
		this.atendenteId = atendenteId;
		this.valorAbertura = valorAbertura;
		this.valorFechamento = valorFechamento;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCaixaId() {
		return caixaId;
	}

	public void setCaixaId(int caixaId) {
		this.caixaId = caixaId;
	}

	public int getAtendenteId() {
		return atendenteId;
	}

	public void setAtendenteId(int atendenteId) {
		this.atendenteId = atendenteId;
	}

	public double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(double valorFechamento) {
		this.valorFechamento = valorFechamento;
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

	public boolean isAberto() {
		return this.valorFechamento == 0 && this.dataFechamento == null;
	}

	@Override
	public String toString() {
		return String.format("[HISTORICO #%d] Caixa: %d, Atendente: %d, Valor Abertura: %.2f, Valor Fechamento: %.2f, Data Abertura: %s, Data Fechamento: %s (%s)",
				this.getId(),
				this.getCaixaId(),
				this.getAtendenteId(),
				this.getValorAbertura(),
				this.getValorFechamento(),
				this.getDataAbertura(),
				this.getDataFechamento(),
				this.isAberto() ? "ABERTO" : "FECHADO");
	}
}
