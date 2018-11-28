package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.CaixaDAO;
import br.edu.ifsp.bra.banco.ICaixaDAO;
import br.edu.ifsp.bra.modelo.Caixa;

public class CaixaBLL {
	ICaixaDAO dao = new CaixaDAO();

	public Caixa getCaixa(int id) {
		return dao.getCaixa(id);
	}

	public List<Caixa> getTodosCaixas() {
		return dao.getCaixa();
	}
}