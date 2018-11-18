package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.CaixaHistoricoDAO;
import br.edu.ifsp.bra.modelo.CaixaHistorico;

public class CaixaHistoricoBLL {
	
	CaixaHistoricoDAO dao = new CaixaHistoricoDAO();
	
	public CaixaHistorico getCaixaHistorico(int id) {
		return dao.getCaixaHistorico(id);
	}

	public List<CaixaHistorico> getTodosCaixaHistoricos() {
		return dao.getCaixaHistorico();
	}

	public int novoCaixaHistorico(CaixaHistorico historico) {
		return dao.novoCaixaHistorico(historico);
	}

	public boolean modificaCaixaHistorico(CaixaHistorico historico) {
		return dao.modificaCaixaHistorico(historico);
	}
}
