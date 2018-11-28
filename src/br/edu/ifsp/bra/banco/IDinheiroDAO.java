package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Dinheiro;

public interface IDinheiroDAO {
	Dinheiro getPagamento(int id);
	List<Dinheiro> getTodosPagamentos();
	int novoPagamento(Dinheiro dinheiro);
}
