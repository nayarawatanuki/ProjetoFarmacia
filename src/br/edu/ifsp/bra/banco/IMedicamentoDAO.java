package br.edu.ifsp.bra.banco;

import java.util.Set;

import br.edu.ifsp.bra.modelo.Medicamento;

public interface IMedicamentoDAO {
	Medicamento getMedicamento(String codigo);
	Medicamento getMedicamento(int id);
	public Set<Medicamento> getTodosMedicamento();
	Set<Medicamento> getEstoque(int filtro);
	boolean adicionar(Medicamento med);
	boolean modificar(Medicamento med);
	boolean remover(int med);
}
