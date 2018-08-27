package br.edu.ifsp.bra.dominio;

import java.util.Date;

public abstract class Pessoa {
	private int id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	
	public Pessoa(int id, String nome, Date dataNascimento, String cpf) {
		this.setId(id);
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
