package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.FuncionarioDAO;
import br.edu.ifsp.bra.modelo.Funcionario;

public class FuncionarioBLL {

	public Funcionario getFuncionario(int id) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.getFuncionario(id);
	}

	public Set<Funcionario> getTodosFuncionarios() {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.getTodosFuncionarios();
	}

	public boolean novoFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.novoFuncionario(funcionario);
	}

	public boolean modificaFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.modificaFuncionario(funcionario);
	}
}
