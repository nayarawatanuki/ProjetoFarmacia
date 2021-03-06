package br.edu.ifsp.bra.modelo;

import java.sql.Date;

public class Cliente extends Pessoa {
	
	private static Cliente clienteAtual;
	public static Cliente getClienteAtual() {
		return Cliente.clienteAtual;
	}
	public static void setClienteAtual(Cliente clienteAtual) {
		Cliente.clienteAtual = clienteAtual;
	}
	private Date dataCadastro;
	
	public Cliente() {}
	public Cliente(String nome, String endereco, String telefone, String cpf, Date dataNascimento, Date dataCadastro) {
		super(nome, endereco, telefone, cpf, dataNascimento);
		this.dataCadastro = dataCadastro;
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
