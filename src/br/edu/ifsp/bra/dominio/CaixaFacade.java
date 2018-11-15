package br.edu.ifsp.bra.dominio;

import java.sql.Date;
import java.util.Calendar;

import br.edu.ifsp.bra.banco.PedidoDAO;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.StatusPedido;

public class CaixaFacade {

	private PedidoDAO pedidoDAO = new PedidoDAO();

	private static Pedido pedidoAtual;
	private static Funcionario funcionarioAtual;
	private static boolean isAberto;

	public void abrirCaixa(Funcionario f) {
		if (CaixaFacade.isAberto() && CaixaFacade.getFuncionarioAtual() != null) {
			throw new RuntimeException("O caixa n�o pode ser aberto pois j� est� aberto"); // CaixaAbertoException
		}

		CaixaFacade.funcionarioAtual = f;
		CaixaFacade.isAberto = true;
	}

	public void fecharCaixa(Funcionario f) {
		if (!f.isGerente()) {
			throw new RuntimeException("O caixa pode ser fechado apenas por um gerente");	// TipoFuncionarioException
		}
		if (CaixaFacade.getPedidoAtual() != null) {
			throw new RuntimeException("O caixa n�o pode ser fechado pois um pedido est� aberto"); // PedidoAbertoException
		}

		CaixaFacade.funcionarioAtual = null;
		CaixaFacade.isAberto = false;
	}

	public void adicionaMedicamento(Medicamento m, int quantidade) {
		CaixaFacade.getPedidoAtual().adicionaItem(new ItemPedido(CaixaFacade.getPedidoAtual().getId(), m.getId(), quantidade, m.getPreco()));
	}

	public void novoPedido() {
		if (CaixaFacade.getPedidoAtual() != null) {
			throw new RuntimeException("Um pedido ainda est� em aberto"); // PedidoAbertoException
		}

		CaixaFacade.pedidoAtual = new Pedido();
		CaixaFacade.getPedidoAtual().setCaixaId(1);
		CaixaFacade.getPedidoAtual().setData(new Date(Calendar.getInstance().getTime().getTime()));
		CaixaFacade.getPedidoAtual().setStatus(StatusPedido.ABERTO);
		
		// Retornando o �ltimo id
		// CaixaBLL.getPedidoAtual().setId(pedidoDAO.adicionar(CaixaBLL.getPedidoAtual()));
	}

	public void efetuaVenda() {
		this.alteraStatus(StatusPedido.FECHADO);
	}

	public void cancelaVenda() {
		if (CaixaFacade.getPedidoAtual() == null) {
			throw new RuntimeException("N�o existe nenhum pedido em aberto para cancelar"); // PedidoInvalidoException
		}

		this.alteraStatus(StatusPedido.CANCELADO);
		CaixaFacade.pedidoAtual = null;
	}
	
	public void concedeDesconto(Pagamento p, double desconto, Funcionario f) {
		if (!f.isGerente()) {
			throw new RuntimeException("O desconto pode ser concedidos apenas por um gerente");	// TipoFuncionarioException
		}
		if (CaixaFacade.getPedidoAtual() == null) {
			throw new RuntimeException("N�o existe nenhum pedido em aberto para conceder desconto"); // PedidoInvalidoException
		}
		
		// Concedendo desconto
		p.setDesconto(desconto);
	}
	
	public void geraNotaFiscal() {
		// Gerando nota fiscal
	}
	
	private void alteraStatus(StatusPedido status) {
		if (CaixaFacade.getPedidoAtual() != null) {
			throw new RuntimeException("Um pedido ainda est� em aberto"); // PedidoAbertoException
		}
		if (CaixaFacade.getPedidoAtual().getStatus() == status) {
			throw new RuntimeException("O status continua sendo o mesmo"); // PedidoStatusException
		}

		CaixaFacade.getPedidoAtual().setStatus(status);
		// Modificando o status do pedido
		// CaixaBLL.pedidoDAO.modificar(CaixaBLL.getPedidoAtual());
	}
	
	public static Pedido getPedidoAtual() {
		return pedidoAtual;
	}

	public static Funcionario getFuncionarioAtual() {
		return funcionarioAtual;
	}

	public static boolean isAberto() {
		return isAberto;
	}
}
