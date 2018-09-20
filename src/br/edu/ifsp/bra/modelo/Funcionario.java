package br.edu.ifsp.bra.modelo;

import java.util.Date;

public class Funcionario extends Pessoa {
	public static enum Tipo { NENHUM, ATENDENTE, GERENTE; };
	
	private String usuario;
	private String senha;
	private Tipo tipo;

	public Funcionario() {}
	public Funcionario(int id, String nome, String cpf, java.sql.Date dataNascimento,
			String usuario, String senha, Tipo tipo) {
		super(id, nome, cpf, dataNascimento);
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
