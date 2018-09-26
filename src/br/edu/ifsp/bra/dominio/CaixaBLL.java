package br.edu.ifsp.bra.dominio;

import java.sql.Date;
import java.util.Calendar;

import br.edu.ifsp.bra.banco.PedidoDAO;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.StatusPedido;

public class CaixaBLL {

	private static PedidoDAO pedidoDAO = new PedidoDAO();

	private static Pedido pedidoAtual;
	private static Funcionario funcionarioAtual;
	private static boolean isAberto;

	public void abrirCaixa(Funcionario f) {
		if (CaixaBLL.isAberto() && CaixaBLL.getFuncionarioAtual() != null) {
			throw new RuntimeException("O caixa não pode ser aberto pois já está aberto"); // CaixaAbertoException
		}

		CaixaBLL.funcionarioAtual = f;
		CaixaBLL.isAberto = true;
	}

	public void fecharCaixa(Funcionario f) {
		if (CaixaBLL.getPedidoAtual() != null) {
			throw new RuntimeException("O caixa não pode ser fechado pois um pedido está aberto"); // PedidoAbertoException
		}

		CaixaBLL.funcionarioAtual = null;
		CaixaBLL.isAberto = false;
	}

	public void adicionaMedicamento(Medicamento m, int quantidade) {
		CaixaBLL.getPedidoAtual().adicionaItem(new ItemPedido(CaixaBLL.getPedidoAtual().getId(), m.getId(), quantidade, m.getPreco()));
	}

	public void novoPedido() {
		if (CaixaBLL.getPedidoAtual() != null) {
			throw new RuntimeException("Um pedido ainda está em aberto"); // PedidoAbertoException
		}

		CaixaBLL.pedidoAtual = new Pedido();
		CaixaBLL.getPedidoAtual().setCaixaId(1);
		CaixaBLL.getPedidoAtual().setData(new Date(Calendar.getInstance().getTime().getTime()));
		CaixaBLL.getPedidoAtual().setStatus(StatusPedido.ABERTO);
		
		// Retornando o último id
		// CaixaBLL.getPedidoAtual().setId(pedidoDAO.adicionar(CaixaBLL.getPedidoAtual()));
	}

	public void efetuaVenda() {
		this.alteraStatus(StatusPedido.FECHADO);
	}

	public void cancelaVenda() {
		if (CaixaBLL.getPedidoAtual() == null) {
			throw new RuntimeException("Não existe nenhum pedido em aberto para cancelar"); // PedidoInvalidoException
		}

		this.alteraStatus(StatusPedido.CANCELADO);
		CaixaBLL.pedidoAtual = null;
	}
	
	public void geraNotaFiscal() {
		// Gerando nota fiscal
	}
	
	private void alteraStatus(StatusPedido status) {
		if (CaixaBLL.getPedidoAtual() != null) {
			throw new RuntimeException("Um pedido ainda está em aberto"); // PedidoAbertoException
		}
		if (CaixaBLL.getPedidoAtual().getStatus() == status) {
			throw new RuntimeException("O status continua sendo o mesmo"); // PedidoStatusException
		}

		CaixaBLL.getPedidoAtual().setStatus(status);
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
