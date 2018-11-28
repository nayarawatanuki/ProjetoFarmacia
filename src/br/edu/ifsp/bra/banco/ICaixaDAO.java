package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Caixa;

public interface ICaixaDAO {
	Caixa getCaixa(int id);
	List<Caixa> getCaixa();
}
