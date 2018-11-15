package br.edu.ifsp.bra.teste;

import br.edu.ifsp.bra.dominio.FuncionarioBLL;
import br.edu.ifsp.bra.modelo.Funcionario;

public class TestaFuncionarioBLL {
	public static void main(String[] args) {
		FuncionarioBLL bll = new FuncionarioBLL();
		Funcionario funcionario = bll.getFuncionario(1);

		System.out.println("Id: " + funcionario.getId());
		System.out.println("Usuario: " + funcionario.getUsuario());
		System.out.println("Tipo: " + funcionario.getTipo());
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("CPF: " + funcionario.getCpf());
		System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
	}
}
