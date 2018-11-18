package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.DinheiroDAO;
import br.edu.ifsp.bra.modelo.Dinheiro;

public class DinheiroBLL {

	DinheiroDAO dao = new DinheiroDAO();
	
	public Dinheiro getPagamento(int id) {
		return dao.getPagamento(id);
	}
	
	public List<Dinheiro> getTodosPagamentos() {
		return dao.getTodosPagamentos();
	}
	
	public int novoPagamento(Dinheiro pagamento) {
		return dao.novoPagamento(pagamento);
	}
}
