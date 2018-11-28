package br.edu.ifsp.bra.banco;

import java.util.List;

import br.edu.ifsp.bra.modelo.CaixaHistorico;

public interface ICaixaHistoricoDAO {
	CaixaHistorico getCaixaHistorico(int id);
	List<CaixaHistorico> getCaixaHistorico();
	int novoCaixaHistorico(CaixaHistorico caixa);
	boolean modificaCaixaHistorico(CaixaHistorico caixa);
}
