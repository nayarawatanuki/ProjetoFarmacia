package br.edu.ifsp.bra.teste;

import java.util.Arrays;

import br.edu.ifsp.bra.dominio.CaixaBLL;
import br.edu.ifsp.bra.dominio.CaixaFacade;
import br.edu.ifsp.bra.dominio.ClienteBLL;
import br.edu.ifsp.bra.dominio.FuncionarioBLL;
import br.edu.ifsp.bra.dominio.MedicamentoBLL;
import br.edu.ifsp.bra.dominio.PedidoBLL;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.Cliente;
import br.edu.ifsp.bra.modelo.Dinheiro;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pagamento.TipoPagamento;
import br.edu.ifsp.bra.modelo.Pedido;

public class TestaCaixaFacade {
	private static CaixaBLL caixaBLL = new CaixaBLL();
	private static ClienteBLL clienteBLL = new ClienteBLL();
	private static FuncionarioBLL funcionarioBLL = new FuncionarioBLL();
	private static MedicamentoBLL medicamentoBLL = new MedicamentoBLL();
	private static PedidoBLL pedidoBLL = new PedidoBLL();

	public static void main(String[] args) {
		Caixa caixa = caixaBLL.getCaixa(1);
		Cliente cliente = clienteBLL.getCliente(1);
		Funcionario funcionario = funcionarioBLL.getFuncionario(1);

		Medicamento m1 = medicamentoBLL.getMedicamento(1);

		System.out.println(caixa);
		System.out.println(funcionario);

		CaixaFacade facade = new CaixaFacade(caixa, funcionario, 1000.0);

		System.out.println(facade);

		facade.novoPedido();
		System.out.println("Produtos: " + Arrays.toString(Pedido.getPedidoAtual().getItens().toArray()));

		facade.adicionaMedicamento(m1, 7);
		System.out.println("Produtos: " + Arrays.toString(Pedido.getPedidoAtual().getItens().toArray()));

		int pedidoId = facade.efetuaVenda();
		Pagamento pagamento = new Dinheiro(
				cliente.getId(),
				pedidoId,
				Pedido.getPedidoAtual().getTotal(),
				TipoPagamento.DINHEIRO,
				1000);

		System.out.println("Desconto: " + pagamento.getTotalDesconto());
		
		System.out.println("ID Pedido: " + pedidoId);
		System.out.println("ID Pagamento: " + facade.realizaPagamento(pagamento));
	}
}
