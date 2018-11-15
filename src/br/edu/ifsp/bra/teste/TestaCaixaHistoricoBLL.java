package br.edu.ifsp.bra.teste;

import br.edu.ifsp.bra.dominio.CaixaHistoricoBLL;
import br.edu.ifsp.bra.modelo.CaixaHistorico;

public class TestaCaixaHistoricoBLL {
	public static void main(String[] args) {
		CaixaHistoricoBLL bll = new CaixaHistoricoBLL();
		CaixaHistorico historico = bll.getCaixaHistorico(1);
		
		System.out.println(historico);
	}
}
