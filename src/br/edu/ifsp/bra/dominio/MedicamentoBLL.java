package br.edu.ifsp.bra.dominio;

import java.util.Set;

import br.edu.ifsp.bra.banco.MedicamentoDAO;
import br.edu.ifsp.bra.modelo.Medicamento;

public class MedicamentoBLL {
	MedicamentoDAO mdDAO = new MedicamentoDAO();
	
	public Medicamento getMedicamento(int id) {
		return mdDAO.getMedicamento(id);
	}
	
	public Set<Medicamento> getTodosMedicamento() {
		return mdDAO.getTodosMedicamento();
	}
	
	public Set<Medicamento> getEstoque(int filtro) {
		return mdDAO.getEstoque(filtro);
	}
	
	public boolean adicionar(Medicamento med) {
		return mdDAO.adicionar(med);
	}
	
	public boolean modificar(Medicamento med) {
		return mdDAO.modificar(med);
	}
	
	public boolean remover(int med) {
		
		return mdDAO.remover(med);
	}
}
