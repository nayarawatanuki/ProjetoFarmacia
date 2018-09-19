package br.edu.ifsp.bra.modelo;

import java.util.Date;

public class Cliente extends Pessoa {
	private Date dataCadastro;

	public Cliente() {}
	public Cliente(int id, String nome, String cpf, Date dataNascimento, Date dataCadastro) {
		super(id, nome, cpf, dataNascimento);
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
