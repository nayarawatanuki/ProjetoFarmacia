package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Caixa;

public interface ICaixaDAO {
	
	public Caixa getCaixa(int id);
	public List<Caixa> getCaixa(); 
}
