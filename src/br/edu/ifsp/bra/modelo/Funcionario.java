package br.edu.ifsp.bra.modelo;

import java.sql.Date;

public class Funcionario extends Pessoa {

	public enum TipoFuncionario {
		NENHUM, ATENDENTE, GERENTE;

		public TipoFuncionario getTipo(int tipo) {
			switch (tipo) {
			case 1:
				return TipoFuncionario.ATENDENTE;
			case 2:
				return TipoFuncionario.GERENTE;
			default:
				return TipoFuncionario.NENHUM;
			}
		}
	};

	private String usuario;
	private String senha;
	private TipoFuncionario tipo;

	public Funcionario() {}
	public Funcionario(String nome, String endereco, String telefone, String cpf, Date dataNascimento, String usuario, String senha, TipoFuncionario tipo) {
		super(nome, endereco, telefone, cpf, dataNascimento);
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}
	public boolean isAtendente() {
		return this.getTipo() == TipoFuncionario.GERENTE;
	}
	public boolean isGerente() {
		return this.getTipo() == TipoFuncionario.ATENDENTE;
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
	public TipoFuncionario getTipo() {
		return tipo;
	}
	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		if (this.isGerente()) return "[Gerente] " + this.getNome();
		if (this.isAtendente()) return "[Atendente] " + this.getNome();
		return "[Funcionário] " + this.getNome();
	}
}
