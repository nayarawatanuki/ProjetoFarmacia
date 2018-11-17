package br.edu.ifsp.bra.dominio;

import java.util.List;

import br.edu.ifsp.bra.banco.CartaoDAO;
import br.edu.ifsp.bra.modelo.Cartao;

public class CartaoBLL {

	CartaoDAO dao = new CartaoDAO();
	
	public Cartao getPagamento(int id) {
		return dao.getPagamento(id);
	}
	
	public List<Cartao> getTodosPagamentos() {
		return dao.getTodosPagamentos();
	}
	
	public int novoPagamento(Cartao pagamento) {
		return dao.novoPagamento(pagamento);
	}
}
