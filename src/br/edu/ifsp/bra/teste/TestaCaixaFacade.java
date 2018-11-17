package br.edu.ifsp.bra.teste;

import java.util.Arrays;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.dominio.FuncionarioBLL;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.dominio.PedidoBLL;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.Medicamento;

public class TestaCaixaFacade {
	private static CaixaBLL caixaBLL = new CaixaBLL();
	private static FuncionarioBLL funcionarioBLL = new FuncionarioBLL();
	private static MedicamentoBLL medicamentoBLL = new MedicamentoBLL();
	private static PedidoBLL pedidoBLL = new PedidoBLL();
	
	public static void main(String[] args) {
		Caixa caixa = caixaBLL.getCaixa(1);
		Funcionario funcionario = funcionarioBLL.getFuncionario(1);

		Medicamento m1 = medicamentoBLL.getMedicamento(1);
		//Medicamento m2 = medicamentoBLL.getMedicamento(2);
		//Medicamento m3 = medicamentoBLL.getMedicamento(3);
		
		System.out.println(caixa);
		System.out.println(funcionario);
		
		CaixaFacade facade = new CaixaFacade(caixa, funcionario, 1000.0);
		
		System.out.println(facade);
		
		facade.novoPedido();
		System.out.println("Produtos: " + Arrays.toString(facade.getPedidoAtual().getItens().toArray()));

		facade.adicionaMedicamento(m1, 7);
		//facade.adicionaMedicamento(m2, 9);
		//facade.adicionaMedicamento(m3, 35);
		System.out.println("Produtos: " + Arrays.toString(facade.getPedidoAtual().getItens().toArray()));
		
		System.out.println("ID Pedido: " + facade.efetuaVenda());
	}
}
