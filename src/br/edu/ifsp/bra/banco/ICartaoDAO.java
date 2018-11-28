package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.Cartao;

public interface ICartaoDAO {
	Cartao getPagamento(int id);
	List<Cartao> getTodosPagamentos();
	int novoPagamento(Cartao cartao);
}
