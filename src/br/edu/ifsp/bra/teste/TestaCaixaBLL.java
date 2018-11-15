package br.edu.ifsp.bra.teste;

import java.util.Arrays;
import java.util.List;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.modelo.Caixa;

public class TestaCaixaBLL {
	public static void main(String[] args) {
		CaixaBLL bll = new CaixaBLL();
		List<Caixa> caixas = bll.getTodosCaixas();
		
		System.out.println(Arrays.toString(caixas.toArray()));
	}
}
