package br.edu.ifsp.bra.dominio;

import java.util.Date;

public class Cliente extends Pessoa {
	private Date dataCadastro;
	
	public Cliente(int id, String nome, Date dataNascimento, String cpf, Date dataCadastro) {
		super(id, nome, dataNascimento, cpf);
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
