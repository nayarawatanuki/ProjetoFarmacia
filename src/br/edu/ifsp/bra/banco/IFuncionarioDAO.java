package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Funcionario;

public interface IFuncionarioDAO {
	Funcionario getFuncionario(int id);
	Funcionario getFuncionario(String usuario, String senha);
	List<Funcionario> getTodosFuncionarios();
	int novoFuncionario(Funcionario funcionario);
	boolean modificaFuncionario(Funcionario funcionario);
}
