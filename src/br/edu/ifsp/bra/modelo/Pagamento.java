package br.edu.ifsp.bra.modelo;

import java.util.Date;

public class Pagamento {
	
	private double valorDesconto;
	private double valorTotal;
	private double valorFinal;
	private double valorPago;
	private Date data;
	
	
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorFinal() {
		return this.valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = this.valorTotal - this.valorDesconto;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
