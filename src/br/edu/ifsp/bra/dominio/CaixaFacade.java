package br.edu.ifsp.bra.dominio;

import java.sql.Date;

import br.edu.ifsp.bra.farmacia.FrmNotaFiscal;
import br.edu.ifsp.bra.modelo.Caixa;
import br.edu.ifsp.bra.modelo.CaixaHistorico;
import br.edu.ifsp.bra.modelo.Cartao;
import br.edu.ifsp.bra.modelo.Dinheiro;
import br.edu.ifsp.bra.modelo.Funcionario;
import br.edu.ifsp.bra.modelo.ItemPedido;
import br.edu.ifsp.bra.modelo.Medicamento;
import br.edu.ifsp.bra.modelo.Pagamento;
import br.edu.ifsp.bra.modelo.Pedido;
import br.edu.ifsp.bra.modelo.Pedido.StatusPedido;

public class CaixaFacade {

	private static double totalCaixa;
	private CaixaHistorico historico;
	private PedidoBLL pedidoBLL = new PedidoBLL();
	private CartaoBLL cartaoBLL = new CartaoBLL();
	private DinheiroBLL dinheiroBLL = new DinheiroBLL();
	private CaixaHistoricoBLL historicoBLL = new CaixaHistoricoBLL();
	
	public CaixaFacade() {}
	public CaixaFacade(Caixa c, Funcionario f, double valorAbertura) {
		this.abrir(c, f, valorAbertura, new Date(System.currentTimeMillis()));
	}
	
	public void abrir(Caixa c, Funcionario f, double valorAbertura, Date dataAbertura) {
		CaixaFacade.totalCaixa = valorAbertura;
		this.historico = new CaixaHistorico();
		this.historico.setCaixaId(c.getId());
		this.historico.setAtendenteId(f.getId());
		this.historico.setValorAbertura(valorAbertura);
		this.historico.setDataAbertura(dataAbertura);
		this.historico.setId(this.historicoBLL.novoCaixaHistorico(this.historico));
	}

	public void fechar(Funcionario f) {
		if (!f.isGerente()) {
			throw new RuntimeException("O caixa pode ser fechado apenas por um gerente");	// TipoFuncionarioException
		}
		if (CaixaFacade.getPedidoAtual() != null) {
			throw new RuntimeException("O caixa n�o pode ser fechado pois um pedido est� aberto"); // PedidoAbertoException
		}

		this.historico.setValorFechamento(CaixaFacade.totalCaixa);
		this.historico.setDataFechamento(new Date(System.currentTimeMillis()));
		this.historicoBLL.modificaCaixaHistorico(this.historico);
	}
	
	public void novoPedido() {
		if (CaixaFacade.getPedidoAtual() != null) {
			throw new RuntimeException("Um pedido ainda est� em aberto"); // PedidoAbertoException
		}

		Pedido.setPedidoAtual(new Pedido());
		CaixaFacade.getPedidoAtual().setCaixaId(1);
		CaixaFacade.getPedidoAtual().setData(new Date(System.currentTimeMillis()));
		CaixaFacade.setPedidoStatus(StatusPedido.ABERTO);
	}

	public void adicionaMedicamento(Medicamento m, int quantidade) {
		Pedido.getPedidoAtual().adicionaItem(new ItemPedido(m, quantidade));
	}

	public int efetuaVenda() {
		CaixaFacade.setPedidoStatus(StatusPedido.FECHADO);
		return this.pedidoBLL.adicionar(CaixaFacade.getPedidoAtual());
	}
	
	public int realizaPagamento(Pagamento p) {
		Pedido.setPedidoAtual(null);
		switch (p.getTipo()) {
		case DINHEIRO:
			return this.dinheiroBLL.novoPagamento((Dinheiro)p);
		case CREDITO:
			return this.cartaoBLL.novoPagamento((Cartao)p);
		case DEBITO:
			return this.cartaoBLL.novoPagamento((Cartao)p);
		default:
			return -1;
		}
	}

	public void cancelaVenda() {
		if (Pedido.getPedidoAtual() == null) {
			throw new RuntimeException("N�o existe nenhum pedido em aberto para cancelar"); // PedidoInvalidoException
		}

		Pedido.setPedidoAtual(null);
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
	
	public void geraNotaFiscal(Pagamento pagamento) {

		new FrmNotaFiscal(pagamento);
	}
	
	private static void setPedidoStatus(StatusPedido status) {
		if (Pedido.getPedidoAtual().getStatus() == status) {
			throw new RuntimeException("O status continua sendo o mesmo"); // PedidoStatusException
		}

		Pedido.getPedidoAtual().setStatus(status);
	}
	
	public static Pedido getPedidoAtual() {
		return Pedido.getPedidoAtual();
	}

	@Override
	public String toString() {
		return String.format("%d Caixa %d - %d - %.2f - %.2f - %s - %s",
				this.historico.getId(),
				this.historico.getCaixaId(),
				this.historico.getAtendenteId(),
				this.historico.getValorAbertura(),
				this.historico.getValorFechamento(),
				this.historico.getDataAbertura(),
				this.historico.getDataFechamento());
	}
}
