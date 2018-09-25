package br.edu.ifsp.bra.modelo;

import java.sql.Date;

public class Cliente extends Pessoa {
	
	private boolean isAtivo;
	private Date dataCadastro;
	
	public Cliente() {}
	public Cliente(String nome, String endereco, String telefone, String cpf, Date dataNascimento, boolean isAtivo, Date dataCadastro) {
		super(nome, endereco, telefone, cpf, dataNascimento);
		this.isAtivo = isAtivo;
		this.dataCadastro = dataCadastro;
	}
	public boolean isAtivo() {
		return isAtivo;
	}
	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return "[Cliente] " + this.getNome();
	}
}
