package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.FuncionarioDAO;
import br.edu.ifsp.bra.modelo.Funcionario;

public class FuncionarioBLL {
	
	FuncionarioDAO dao = new FuncionarioDAO();
	
	public Funcionario getFuncionario(int id) {
		return dao.getFuncionario(id);
	}

	public Set<Funcionario> getTodosFuncionarios() {
		return dao.getTodosFuncionarios();
	}

	public boolean novoFuncionario(Funcionario funcionario) {
		return dao.novoFuncionario(funcionario);
	}

	public boolean modificaFuncionario(Funcionario funcionario) {
		return dao.modificaFuncionario(funcionario);
	}
}
